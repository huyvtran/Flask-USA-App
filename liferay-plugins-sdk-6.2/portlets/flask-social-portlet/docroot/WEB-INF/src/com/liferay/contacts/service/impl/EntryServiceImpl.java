/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */

package com.liferay.contacts.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.liferay.contacts.model.Entry;
import com.liferay.contacts.model.FlaskRecipients;
import com.liferay.contacts.service.FlaskMessagesServiceUtil;
import com.liferay.contacts.service.base.EntryServiceBaseImpl;
import com.liferay.contacts.service.persistence.FlaskRecipientsUtil;
import com.liferay.contacts.util.ContactsUtil;
import com.liferay.contacts.util.PortletKeys;
import com.liferay.contacts.util.SocialRelationConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.notifications.NotificationEvent;
import com.liferay.portal.kernel.notifications.NotificationEventFactoryUtil;
import com.liferay.portal.kernel.notifications.UserNotificationManagerUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserNotificationDeliveryConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portlet.social.NoSuchRelationException;
import com.liferay.portlet.social.model.SocialRelation;
import com.liferay.portlet.social.model.SocialRequest;
import com.liferay.portlet.social.model.SocialRequestConstants;
import com.liferay.portlet.social.service.SocialRelationLocalServiceUtil;
import com.liferay.portlet.social.service.SocialRequestLocalServiceUtil;

/**
 * @author Bruno Farache
 */
public class EntryServiceImpl extends EntryServiceBaseImpl {
	long socialRequestId;
	public JSONArray searchUsersAndContacts(
			long companyId, String keywords, int start, int end, ServiceContext serviceContext)
		throws PortalException, SystemException {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		long userId = getUserId();
		List<BaseModel<?>> contacts = entryLocalService.searchUsersAndContacts(
			companyId, userId, keywords, start, end);

		for (BaseModel<?> contact : contacts) {
			JSONObject jsonObject = null;
			if (contact instanceof User) {
				if(((User) contact).getContact().getUserId() == serviceContext.getUserId()){
					continue;
				}
				jsonObject = ContactsUtil.getUserJSONObject(
					userId, (User)contact);
				jsonObject.put("portraitId", ((User) contact).getPortraitId());
			}
			else {
				jsonObject = ContactsUtil.getEntryJSONObject((Entry)contact);
				jsonObject.put("portraitId", ((User) contact).getPortraitId());
			}
			jsonArray.put(jsonObject);
		}
		return jsonArray;
	}

	public List<SocialRequest> getRequestsToConfirm(ServiceContext serviceContext)throws PortalException, SystemException {
		
		 int requestCount = SocialRequestLocalServiceUtil.getReceiverUserRequestsCount(serviceContext.getUserId());
		  List<SocialRequest> requests = SocialRequestLocalServiceUtil.getReceiverUserRequests(serviceContext.getUserId(), SocialRequestConstants.STATUS_PENDING, 0, requestCount);
		  
		  return requests;
	}
	
	public SocialRequest deleteRequest(long receiverUserId, ServiceContext serviceContext)throws Exception {
			SocialRequest sRequest = null;
			int cnt = SocialRequestLocalServiceUtil.getReceiverUserRequestsCount(serviceContext.getUserId());
			List<SocialRequest> request = SocialRequestLocalServiceUtil.getReceiverUserRequests(serviceContext.getUserId(), 3, 0, cnt);
			for(SocialRequest socialRequest: request ){
				if(socialRequest.getUserId() == receiverUserId){
					socialRequestId = socialRequest.getRequestId();
					sRequest = SocialRequestLocalServiceUtil.getSocialRequest(socialRequestId);
					sendNotificationEvent(sRequest);
					//SocialRequestLocalServiceUtil.updateRequest(socialRequestId, 1, themeDisplay);
					SocialRequestLocalServiceUtil.deleteRequest(socialRequestId);
				}
			}
			return sRequest;
	}
	
	public JSONArray getRequestingUsers(long companyId, String keywords, ServiceContext serviceContext)
			throws PortalException, SystemException{
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		long userId = getUserId();
		int cnt = entryLocalService.searchUsersAndContactsCount(companyId, userId, keywords);
		List<BaseModel<?>> contacts = entryLocalService.searchUsersAndContacts(
			companyId, userId, keywords, 0, cnt);
		int requestCount = SocialRequestLocalServiceUtil.getReceiverUserRequestsCount(serviceContext.getUserId());
		  List<SocialRequest> requests = SocialRequestLocalServiceUtil.getReceiverUserRequests(serviceContext.getUserId(), SocialRequestConstants.STATUS_PENDING, 0, requestCount);
		for (BaseModel<?> contact : contacts) {
			JSONObject jsonObject = null;
			for(SocialRequest req: requests){
				if(req.getUserId() == ((User) contact).getContact().getUserId()){
					if (contact instanceof User) {
						jsonObject = ContactsUtil.getUserJSONObject(
							userId, (User)contact);
						jsonObject.put("portraitId", ((User) contact).getPortraitId());
					}
					else {
						jsonObject = ContactsUtil.getEntryJSONObject((Entry)contact);
						jsonObject.put("portraitId", ((User) contact).getPortraitId());
					}
					jsonArray.put(jsonObject);
				}
			}
		}
		return jsonArray;
	}
	
	public void blockUser(long blockUserId, ServiceContext serviceContext)throws PortalException, SystemException{
		  long userId1 = serviceContext.getUserId();
		  SocialRelation socialRelation = SocialRelationLocalServiceUtil.getRelation(userId1, blockUserId, SocialRelationConstants.TYPE_BI_CONNECTION);
		  SocialRelationLocalServiceUtil.deleteRelation(socialRelation);
		  SocialRelationLocalServiceUtil.addRelation(userId1, blockUserId, SocialRelationConstants.TYPE_UNI_ENEMY);
	}
		 
	public void unblockUser(long unblockUserId, ServiceContext serviceContext)throws PortalException, SystemException{
		  long userId1 = serviceContext.getUserId();
		  SocialRelation socialRelation = SocialRelationLocalServiceUtil.getRelation(userId1, unblockUserId, SocialRelationConstants.TYPE_UNI_ENEMY);
		  SocialRelationLocalServiceUtil.deleteRelation(socialRelation);
	}
	
	public int getUsersAndContactsCount(long companyId, String keywords, ServiceContext serviceContext)throws PortalException, SystemException {
		return entryLocalService.searchUsersAndContactsCount(companyId, serviceContext.getUserId(), keywords);
	}
	
	
	public JSONArray searchMyFriends(long companyId, String keywords, ServiceContext serviceContext)
			  throws PortalException, SystemException{
			  JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
			  JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			  boolean flag = false;
			  long userId = getUserId();
			  int cnt1 = entryLocalService.searchUsersAndContactsCount(companyId, userId, keywords);
				List<BaseModel<?>> contacts = entryLocalService.searchUsersAndContacts(
					companyId, userId, keywords, 0, cnt1);
			  int cnt = SocialRelationLocalServiceUtil.getRelationsCount(userId, SocialRelationConstants.TYPE_BI_CONNECTION);
			  List<SocialRelation> relation = SocialRelationLocalServiceUtil.getRelations(userId, SocialRelationConstants.TYPE_BI_CONNECTION, 0, cnt);
			  for(SocialRelation relObj: relation){
				  List<FlaskRecipients> flaskRecipients = new ArrayList<FlaskRecipients>();
				  int count = 0;
				  String dateTime ="";
				  if(keywords != ""){
					  for (BaseModel<?> contact : contacts) {
						  flaskRecipients = FlaskRecipientsUtil.findByUserIdSenderId(serviceContext.getUserId(), ((User) contact).getUserId());
						  if(relObj.getUserId2() == ((User) contact).getContact().getUserId()){
								if (contact instanceof User) {
									jsonObject = ContactsUtil.getUserJSONObject(
										userId, (User)contact);
									jsonObject.put("portraitId", ((User) contact).getPortraitId());
								}
								else {
									jsonObject = ContactsUtil.getEntryJSONObject((Entry)contact);
									jsonObject.put("portraitId", ((User) contact).getPortraitId());
								}
							}
					  }
				  }else{
					  flaskRecipients = FlaskRecipientsUtil.findByUserIdSenderId(serviceContext.getUserId(), getUserById(relObj.getUserId2(), serviceContext).getUserId());
					  for(FlaskRecipients recp: flaskRecipients){
							if(!recp.getRead()){
								count++;
							}
						}
					  if(flaskRecipients.isEmpty()){
						  flaskRecipients = FlaskRecipientsUtil.findByUserIdSenderId(getUserById(relObj.getUserId2(), serviceContext).getUserId(), serviceContext.getUserId());  
					  }
					  if(!flaskRecipients.isEmpty()){
						  JSONArray messages = FlaskMessagesServiceUtil.getAllMyFlaskMessages(getUserById(relObj.getUserId2(), serviceContext).getUserId(), serviceContext);						  
						  for(int n = 0; n < 1; n++)
						  {
							  flag = false;
						      JSONObject object = messages.getJSONObject(n);
						      dateTime = object.getString("dateTime"); 
						  }
					  	  }else {
					  		  flag = true;
					  	  }
					  User user2 = getUserById(relObj.getUserId2(), serviceContext);
					   jsonObject = ContactsUtil.getUserJSONObject( userId, user2);
					   jsonObject.put("portraitId", getUserById(relObj.getUserId2(), serviceContext).getPortraitId());
				  }
				  if(flag){
					  jsonObject.put("lastMessageDateTime", "0000-00-00 00:00:00:0");
				  }else{
					  jsonObject.put("lastMessageDateTime", dateTime);
				  }
				   jsonObject.put("unreadMessageCount", count);
				   jsonArray.put(jsonObject);
			  }
			  return jsonArray;
	}
	
	@Override
	public  User getUserById(long userId, ServiceContext serviceContext)
	{
		User user=null;
		try{
			user = UserLocalServiceUtil.getUser(userId);
		}catch(PortalException  ex){
			ex.printStackTrace();
		}catch(SystemException ex){
			ex.printStackTrace();
		}
		return user;
	}
	
	public void addSocialRelation(long receiverUserId, ServiceContext serviceContext)
		throws Exception {
			int cnt = SocialRequestLocalServiceUtil.getReceiverUserRequestsCount(serviceContext.getUserId());
			List<SocialRequest> request = SocialRequestLocalServiceUtil.getReceiverUserRequests(serviceContext.getUserId(), 3, 0, cnt);
			for(SocialRequest socialRequest: request ){
				SocialRequest sRequest;
				if(socialRequest.getUserId() == receiverUserId){
					socialRequestId = socialRequest.getRequestId();
					sRequest = SocialRequestLocalServiceUtil.getSocialRequest(socialRequestId);
					sendNotificationEvent(sRequest);
					//SocialRequestLocalServiceUtil.updateRequest(socialRequestId, 1, themeDisplay);
					SocialRequestLocalServiceUtil.deleteRequest(socialRequestId);
				}
			}
			SocialRelationLocalServiceUtil.addRelation(serviceContext.getUserId(), receiverUserId, SocialRelationConstants.TYPE_BI_CONNECTION);
	}

	public void requestSocialRelation(long receiverUserId, ServiceContext serviceContext)throws Exception {
			SocialRequest socialRequest = SocialRequestLocalServiceUtil.addRequest(serviceContext.getUserId(), 0, User.class.getName(),serviceContext.getUserId(),
					SocialRelationConstants.TYPE_BI_CONNECTION, "", receiverUserId);
			sendNotificationEvent(socialRequest);
			String senderName = UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName();
			FlaskMessagesServiceUtil.sendPush(receiverUserId, "Flask Friend Request", "You have a friend request from "+senderName, "Friend_Request", socialRequest.getModelAttributes());
	}
	
	public int getRequestsCount(ServiceContext serviceContext)throws PortalException, SystemException{
		return SocialRequestLocalServiceUtil.getReceiverUserRequestsCount(serviceContext.getUserId(), 3);
	}
	
	protected void sendNotificationEvent(SocialRequest socialRequest)
			throws Exception {

			if (UserNotificationManagerUtil.isDeliver(
					socialRequest.getReceiverUserId(), PortletKeys.CONTACTS_CENTER,
					0, SocialRelationConstants.SOCIAL_RELATION_REQUEST,
					UserNotificationDeliveryConstants.TYPE_WEBSITE)) {

				JSONObject notificationEventJSONObject =
					JSONFactoryUtil.createJSONObject();

				notificationEventJSONObject.put("actionRequired", true);
				notificationEventJSONObject.put(
					"classPK", socialRequest.getRequestId());
				notificationEventJSONObject.put(
					"userId", socialRequest.getUserId());

				NotificationEvent notificationEvent =
					NotificationEventFactoryUtil.createNotificationEvent(
						System.currentTimeMillis(), PortletKeys.CONTACTS_CENTER,
						notificationEventJSONObject);

				notificationEvent.setDeliveryRequired(0);

				UserNotificationEventLocalServiceUtil.addUserNotificationEvent(
					socialRequest.getReceiverUserId(), notificationEvent);
			}
		}
	public void deleteSocialRelation(long receiverUserId, ServiceContext serviceContext)
		throws Exception {

		int type = SocialRelationConstants.TYPE_BI_CONNECTION;
			try {
				SocialRelationLocalServiceUtil.deleteRelation(
					serviceContext.getUserId(), receiverUserId, type);
			}
			catch (NoSuchRelationException nsre) {
			}
	}

	protected long[] getUserIds(HttpServletRequest request) {
		long[] userIds;

		long userId = ParamUtil.getLong(request, "userId", 0);

		if (userId > 0) {
			userIds = new long[] {userId};
		}
		else {
			userIds = StringUtil.split(
				ParamUtil.getString(request, "userIds"), 0L);
		}

		return userIds;
	}
}