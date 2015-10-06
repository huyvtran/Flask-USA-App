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

package com.liferay.contacts.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FlaskMessagesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskMessagesLocalService
 * @generated
 */
public class FlaskMessagesLocalServiceWrapper
	implements FlaskMessagesLocalService,
		ServiceWrapper<FlaskMessagesLocalService> {
	public FlaskMessagesLocalServiceWrapper(
		FlaskMessagesLocalService flaskMessagesLocalService) {
		_flaskMessagesLocalService = flaskMessagesLocalService;
	}

	/**
	* Adds the flask messages to the database. Also notifies the appropriate model listeners.
	*
	* @param flaskMessages the flask messages
	* @return the flask messages that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.FlaskMessages addFlaskMessages(
		com.liferay.contacts.model.FlaskMessages flaskMessages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskMessagesLocalService.addFlaskMessages(flaskMessages);
	}

	/**
	* Creates a new flask messages with the primary key. Does not add the flask messages to the database.
	*
	* @param messageId the primary key for the new flask messages
	* @return the new flask messages
	*/
	@Override
	public com.liferay.contacts.model.FlaskMessages createFlaskMessages(
		long messageId) {
		return _flaskMessagesLocalService.createFlaskMessages(messageId);
	}

	/**
	* Deletes the flask messages with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the flask messages
	* @return the flask messages that was removed
	* @throws PortalException if a flask messages with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.FlaskMessages deleteFlaskMessages(
		long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskMessagesLocalService.deleteFlaskMessages(messageId);
	}

	/**
	* Deletes the flask messages from the database. Also notifies the appropriate model listeners.
	*
	* @param flaskMessages the flask messages
	* @return the flask messages that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.FlaskMessages deleteFlaskMessages(
		com.liferay.contacts.model.FlaskMessages flaskMessages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskMessagesLocalService.deleteFlaskMessages(flaskMessages);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _flaskMessagesLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskMessagesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskMessagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskMessagesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskMessagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskMessagesLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskMessagesLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskMessagesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.contacts.model.FlaskMessages fetchFlaskMessages(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskMessagesLocalService.fetchFlaskMessages(messageId);
	}

	/**
	* Returns the flask messages with the primary key.
	*
	* @param messageId the primary key of the flask messages
	* @return the flask messages
	* @throws PortalException if a flask messages with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.FlaskMessages getFlaskMessages(
		long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskMessagesLocalService.getFlaskMessages(messageId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskMessagesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the flask messageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskMessagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask messageses
	* @param end the upper bound of the range of flask messageses (not inclusive)
	* @return the range of flask messageses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.contacts.model.FlaskMessages> getFlaskMessageses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskMessagesLocalService.getFlaskMessageses(start, end);
	}

	/**
	* Returns the number of flask messageses.
	*
	* @return the number of flask messageses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFlaskMessagesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskMessagesLocalService.getFlaskMessagesesCount();
	}

	/**
	* Updates the flask messages in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param flaskMessages the flask messages
	* @return the flask messages that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.FlaskMessages updateFlaskMessages(
		com.liferay.contacts.model.FlaskMessages flaskMessages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskMessagesLocalService.updateFlaskMessages(flaskMessages);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _flaskMessagesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_flaskMessagesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _flaskMessagesLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FlaskMessagesLocalService getWrappedFlaskMessagesLocalService() {
		return _flaskMessagesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFlaskMessagesLocalService(
		FlaskMessagesLocalService flaskMessagesLocalService) {
		_flaskMessagesLocalService = flaskMessagesLocalService;
	}

	@Override
	public FlaskMessagesLocalService getWrappedService() {
		return _flaskMessagesLocalService;
	}

	@Override
	public void setWrappedService(
		FlaskMessagesLocalService flaskMessagesLocalService) {
		_flaskMessagesLocalService = flaskMessagesLocalService;
	}

	private FlaskMessagesLocalService _flaskMessagesLocalService;
}