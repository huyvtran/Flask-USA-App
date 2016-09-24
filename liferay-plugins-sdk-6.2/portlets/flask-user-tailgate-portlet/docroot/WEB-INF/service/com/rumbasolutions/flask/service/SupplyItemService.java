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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for SupplyItem. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SupplyItemServiceUtil
 * @see com.rumbasolutions.flask.service.base.SupplyItemServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.SupplyItemServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SupplyItemService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SupplyItemServiceUtil} to access the supply item remote service. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.SupplyItemServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public com.rumbasolutions.flask.model.SupplyItem addSupplyItem(
		java.lang.String supplyItemName, long supplyListId,
		com.liferay.portal.service.ServiceContext serviceContext);

	public java.util.List<com.rumbasolutions.flask.model.SupplyItem> addSupplyItems(
		java.lang.String[] supplyItemNames, long supplyListId,
		com.liferay.portal.service.ServiceContext serviceContext);

	public com.rumbasolutions.flask.model.SupplyItem updateSupplyItem(
		long supplyItemId, java.lang.String supplyItemName, long supplyListId,
		com.liferay.portal.service.ServiceContext serviceContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.rumbasolutions.flask.model.SupplyItem getSupplyItem(
		long supplyItemId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.rumbasolutions.flask.model.SupplyItem> getAllSupplyItems(
		com.liferay.portal.service.ServiceContext serviceContext);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.rumbasolutions.flask.model.SupplyItem> getItemsByListId(
		long supplyListId);

	public void deleteSupplyItem(long supplyItemId,
		com.liferay.portal.service.ServiceContext serviceContext);

	public void deleteItemsByListId(long supplyListId,
		com.liferay.portal.service.ServiceContext serviceContext);
}