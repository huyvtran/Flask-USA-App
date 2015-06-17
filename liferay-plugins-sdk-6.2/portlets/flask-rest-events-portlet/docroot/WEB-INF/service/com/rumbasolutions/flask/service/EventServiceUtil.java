/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rumbasolutions.flask.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Event. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.EventServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Ashutosh Rai
 * @see EventService
 * @see com.rumbasolutions.flask.service.base.EventServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.EventServiceImpl
 * @generated
 */
public class EventServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.EventServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.rumbasolutions.flask.model.Event> getAllEvents(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getAllEvents(serviceContext);
	}

	public static com.rumbasolutions.flask.model.Event addEvent(
		java.lang.String eventName, java.lang.String description,
		java.lang.String eventDate, java.lang.String startTime,
		java.lang.String endTime, long eventTypeId, long venueId,
		java.lang.String eventImagePath,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addEvent(eventName, description, eventDate, startTime,
			endTime, eventTypeId, venueId, eventImagePath, serviceContext);
	}

	public static com.rumbasolutions.flask.model.Event updateEvent(
		long eventId, java.lang.String eventName, java.lang.String description,
		java.lang.String eventDate, java.lang.String startTime,
		java.lang.String endTime, long eventTypeId, long venueId,
		java.lang.String eventImagePath,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateEvent(eventId, eventName, description, eventDate,
			startTime, endTime, eventTypeId, venueId, eventImagePath,
			serviceContext);
	}

	public static void deleteEvent(long eventId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteEvent(eventId, serviceContext);
	}

	public static void deleteEvents(java.lang.String eventIds,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteEvents(eventIds, serviceContext);
	}

	public static com.rumbasolutions.flask.model.EventDetail addEventDetail(
		long eventId, long infoTypeId, long infoTypeCategoryId,
		java.lang.String infoTitle, java.lang.String infoDesc,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String zipCode, java.lang.String city, long stateId,
		long countryId, java.lang.String lattitude, java.lang.String longitude,
		java.lang.String phone, java.lang.String website,
		java.lang.Double cost, java.lang.String hoursOfOperation,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addEventDetail(eventId, infoTypeId, infoTypeCategoryId,
			infoTitle, infoDesc, addrLine1, addrLine2, zipCode, city, stateId,
			countryId, lattitude, longitude, phone, website, cost,
			hoursOfOperation, serviceContext);
	}

	public static com.rumbasolutions.flask.model.EventDetail updateEventDetail(
		long eventDetailId, long infoTypeId, long infoTypeCategoryId,
		java.lang.String infoTitle, java.lang.String infoDesc,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String zipCode, java.lang.String city, long stateId,
		long countryId, java.lang.String lattitude, java.lang.String longitude,
		java.lang.String phone, java.lang.String website,
		java.lang.Double cost, java.lang.String hoursOfOperation,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateEventDetail(eventDetailId, infoTypeId,
			infoTypeCategoryId, infoTitle, infoDesc, addrLine1, addrLine2,
			zipCode, city, stateId, countryId, lattitude, longitude, phone,
			website, cost, hoursOfOperation, serviceContext);
	}

	public static com.rumbasolutions.flask.model.EventDetail getEventDetail(
		long eventDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getEventDetail(eventDetailId, serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.EventDetail> getEventDetails(
		long eventId, com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getEventDetails(eventId, serviceContext);
	}

	public static void deleteEventDetail(long eventDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteEventDetail(eventDetailId, serviceContext);
	}

	public static void deleteAllEventDetails(long eventId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteAllEventDetails(eventId, serviceContext);
	}

	public static com.rumbasolutions.flask.model.EventDetailImage addEventDetailImage(
		long EventDetailId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imagePath,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addEventDetailImage(EventDetailId, imageTitle, imageDesc,
			imagePath, serviceContext);
	}

	public static com.rumbasolutions.flask.model.EventDetailImage updateEventDetailImage(
		long EventDetailImageId, long EventDetailId,
		java.lang.String imageTitle, java.lang.String imageDesc,
		java.lang.String imagePath,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateEventDetailImage(EventDetailImageId, EventDetailId,
			imageTitle, imageDesc, imagePath, serviceContext);
	}

	public static com.rumbasolutions.flask.model.EventDetailImage getEventDetailImage(
		long eventDetailImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .getEventDetailImage(eventDetailImageId, serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.EventDetailImage> getEventDetailImages(
		long eventDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getEventDetailImages(eventDetailId, serviceContext);
	}

	public static void deleteEventDetailImage(long eventDetailImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteEventDetailImage(eventDetailImageId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static EventService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EventService.class.getName());

			if (invokableService instanceof EventService) {
				_service = (EventService)invokableService;
			}
			else {
				_service = new EventServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(EventServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EventService service) {
	}

	private static EventService _service;
}