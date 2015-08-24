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

package com.rumbasolutions.flask.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.rumbasolutions.flask.model.InvitationInfo;
import com.rumbasolutions.flask.service.InvitationInfoLocalService;
import com.rumbasolutions.flask.service.persistence.InvitationInfoPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the invitation info local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rumbasolutions.flask.service.impl.InvitationInfoLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.impl.InvitationInfoLocalServiceImpl
 * @see com.rumbasolutions.flask.service.InvitationInfoLocalServiceUtil
 * @generated
 */
public abstract class InvitationInfoLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements InvitationInfoLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rumbasolutions.flask.service.InvitationInfoLocalServiceUtil} to access the invitation info local service.
	 */

	/**
	 * Adds the invitation info to the database. Also notifies the appropriate model listeners.
	 *
	 * @param invitationInfo the invitation info
	 * @return the invitation info that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public InvitationInfo addInvitationInfo(InvitationInfo invitationInfo)
		throws SystemException {
		invitationInfo.setNew(true);

		return invitationInfoPersistence.update(invitationInfo);
	}

	/**
	 * Creates a new invitation info with the primary key. Does not add the invitation info to the database.
	 *
	 * @param inviationId the primary key for the new invitation info
	 * @return the new invitation info
	 */
	@Override
	public InvitationInfo createInvitationInfo(long inviationId) {
		return invitationInfoPersistence.create(inviationId);
	}

	/**
	 * Deletes the invitation info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param inviationId the primary key of the invitation info
	 * @return the invitation info that was removed
	 * @throws PortalException if a invitation info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public InvitationInfo deleteInvitationInfo(long inviationId)
		throws PortalException, SystemException {
		return invitationInfoPersistence.remove(inviationId);
	}

	/**
	 * Deletes the invitation info from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invitationInfo the invitation info
	 * @return the invitation info that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public InvitationInfo deleteInvitationInfo(InvitationInfo invitationInfo)
		throws SystemException {
		return invitationInfoPersistence.remove(invitationInfo);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(InvitationInfo.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return invitationInfoPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InvitationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return invitationInfoPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InvitationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return invitationInfoPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return invitationInfoPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return invitationInfoPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public InvitationInfo fetchInvitationInfo(long inviationId)
		throws SystemException {
		return invitationInfoPersistence.fetchByPrimaryKey(inviationId);
	}

	/**
	 * Returns the invitation info with the primary key.
	 *
	 * @param inviationId the primary key of the invitation info
	 * @return the invitation info
	 * @throws PortalException if a invitation info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationInfo getInvitationInfo(long inviationId)
		throws PortalException, SystemException {
		return invitationInfoPersistence.findByPrimaryKey(inviationId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return invitationInfoPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the invitation infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InvitationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of invitation infos
	 * @param end the upper bound of the range of invitation infos (not inclusive)
	 * @return the range of invitation infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InvitationInfo> getInvitationInfos(int start, int end)
		throws SystemException {
		return invitationInfoPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of invitation infos.
	 *
	 * @return the number of invitation infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getInvitationInfosCount() throws SystemException {
		return invitationInfoPersistence.countAll();
	}

	/**
	 * Updates the invitation info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param invitationInfo the invitation info
	 * @return the invitation info that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public InvitationInfo updateInvitationInfo(InvitationInfo invitationInfo)
		throws SystemException {
		return invitationInfoPersistence.update(invitationInfo);
	}

	/**
	 * Returns the invitation info local service.
	 *
	 * @return the invitation info local service
	 */
	public com.rumbasolutions.flask.service.InvitationInfoLocalService getInvitationInfoLocalService() {
		return invitationInfoLocalService;
	}

	/**
	 * Sets the invitation info local service.
	 *
	 * @param invitationInfoLocalService the invitation info local service
	 */
	public void setInvitationInfoLocalService(
		com.rumbasolutions.flask.service.InvitationInfoLocalService invitationInfoLocalService) {
		this.invitationInfoLocalService = invitationInfoLocalService;
	}

	/**
	 * Returns the invitation info remote service.
	 *
	 * @return the invitation info remote service
	 */
	public com.rumbasolutions.flask.service.InvitationInfoService getInvitationInfoService() {
		return invitationInfoService;
	}

	/**
	 * Sets the invitation info remote service.
	 *
	 * @param invitationInfoService the invitation info remote service
	 */
	public void setInvitationInfoService(
		com.rumbasolutions.flask.service.InvitationInfoService invitationInfoService) {
		this.invitationInfoService = invitationInfoService;
	}

	/**
	 * Returns the invitation info persistence.
	 *
	 * @return the invitation info persistence
	 */
	public InvitationInfoPersistence getInvitationInfoPersistence() {
		return invitationInfoPersistence;
	}

	/**
	 * Sets the invitation info persistence.
	 *
	 * @param invitationInfoPersistence the invitation info persistence
	 */
	public void setInvitationInfoPersistence(
		InvitationInfoPersistence invitationInfoPersistence) {
		this.invitationInfoPersistence = invitationInfoPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.rumbasolutions.flask.model.InvitationInfo",
			invitationInfoLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.rumbasolutions.flask.model.InvitationInfo");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return InvitationInfo.class;
	}

	protected String getModelClassName() {
		return InvitationInfo.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = invitationInfoPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rumbasolutions.flask.service.InvitationInfoLocalService.class)
	protected com.rumbasolutions.flask.service.InvitationInfoLocalService invitationInfoLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.InvitationInfoService.class)
	protected com.rumbasolutions.flask.service.InvitationInfoService invitationInfoService;
	@BeanReference(type = InvitationInfoPersistence.class)
	protected InvitationInfoPersistence invitationInfoPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private InvitationInfoLocalServiceClpInvoker _clpInvoker = new InvitationInfoLocalServiceClpInvoker();
}