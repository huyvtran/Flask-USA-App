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

package com.rumbasolutions.flask.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rumbasolutions.flask.NoSuchInfoTypeCategoryException;
import com.rumbasolutions.flask.model.InfoTypeCategory;
import com.rumbasolutions.flask.model.impl.InfoTypeCategoryImpl;
import com.rumbasolutions.flask.model.impl.InfoTypeCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the info type category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see InfoTypeCategoryPersistence
 * @see InfoTypeCategoryUtil
 * @generated
 */
public class InfoTypeCategoryPersistenceImpl extends BasePersistenceImpl<InfoTypeCategory>
	implements InfoTypeCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InfoTypeCategoryUtil} to access the info type category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InfoTypeCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InfoTypeCategoryModelImpl.ENTITY_CACHE_ENABLED,
			InfoTypeCategoryModelImpl.FINDER_CACHE_ENABLED,
			InfoTypeCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InfoTypeCategoryModelImpl.ENTITY_CACHE_ENABLED,
			InfoTypeCategoryModelImpl.FINDER_CACHE_ENABLED,
			InfoTypeCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InfoTypeCategoryModelImpl.ENTITY_CACHE_ENABLED,
			InfoTypeCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public InfoTypeCategoryPersistenceImpl() {
		setModelClass(InfoTypeCategory.class);
	}

	/**
	 * Caches the info type category in the entity cache if it is enabled.
	 *
	 * @param infoTypeCategory the info type category
	 */
	@Override
	public void cacheResult(InfoTypeCategory infoTypeCategory) {
		EntityCacheUtil.putResult(InfoTypeCategoryModelImpl.ENTITY_CACHE_ENABLED,
			InfoTypeCategoryImpl.class, infoTypeCategory.getPrimaryKey(),
			infoTypeCategory);

		infoTypeCategory.resetOriginalValues();
	}

	/**
	 * Caches the info type categories in the entity cache if it is enabled.
	 *
	 * @param infoTypeCategories the info type categories
	 */
	@Override
	public void cacheResult(List<InfoTypeCategory> infoTypeCategories) {
		for (InfoTypeCategory infoTypeCategory : infoTypeCategories) {
			if (EntityCacheUtil.getResult(
						InfoTypeCategoryModelImpl.ENTITY_CACHE_ENABLED,
						InfoTypeCategoryImpl.class,
						infoTypeCategory.getPrimaryKey()) == null) {
				cacheResult(infoTypeCategory);
			}
			else {
				infoTypeCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all info type categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InfoTypeCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InfoTypeCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the info type category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InfoTypeCategory infoTypeCategory) {
		EntityCacheUtil.removeResult(InfoTypeCategoryModelImpl.ENTITY_CACHE_ENABLED,
			InfoTypeCategoryImpl.class, infoTypeCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<InfoTypeCategory> infoTypeCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (InfoTypeCategory infoTypeCategory : infoTypeCategories) {
			EntityCacheUtil.removeResult(InfoTypeCategoryModelImpl.ENTITY_CACHE_ENABLED,
				InfoTypeCategoryImpl.class, infoTypeCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new info type category with the primary key. Does not add the info type category to the database.
	 *
	 * @param infoTypeCategoryId the primary key for the new info type category
	 * @return the new info type category
	 */
	@Override
	public InfoTypeCategory create(long infoTypeCategoryId) {
		InfoTypeCategory infoTypeCategory = new InfoTypeCategoryImpl();

		infoTypeCategory.setNew(true);
		infoTypeCategory.setPrimaryKey(infoTypeCategoryId);

		return infoTypeCategory;
	}

	/**
	 * Removes the info type category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param infoTypeCategoryId the primary key of the info type category
	 * @return the info type category that was removed
	 * @throws com.rumbasolutions.flask.NoSuchInfoTypeCategoryException if a info type category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InfoTypeCategory remove(long infoTypeCategoryId)
		throws NoSuchInfoTypeCategoryException, SystemException {
		return remove((Serializable)infoTypeCategoryId);
	}

	/**
	 * Removes the info type category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the info type category
	 * @return the info type category that was removed
	 * @throws com.rumbasolutions.flask.NoSuchInfoTypeCategoryException if a info type category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InfoTypeCategory remove(Serializable primaryKey)
		throws NoSuchInfoTypeCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			InfoTypeCategory infoTypeCategory = (InfoTypeCategory)session.get(InfoTypeCategoryImpl.class,
					primaryKey);

			if (infoTypeCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInfoTypeCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(infoTypeCategory);
		}
		catch (NoSuchInfoTypeCategoryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected InfoTypeCategory removeImpl(InfoTypeCategory infoTypeCategory)
		throws SystemException {
		infoTypeCategory = toUnwrappedModel(infoTypeCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(infoTypeCategory)) {
				infoTypeCategory = (InfoTypeCategory)session.get(InfoTypeCategoryImpl.class,
						infoTypeCategory.getPrimaryKeyObj());
			}

			if (infoTypeCategory != null) {
				session.delete(infoTypeCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (infoTypeCategory != null) {
			clearCache(infoTypeCategory);
		}

		return infoTypeCategory;
	}

	@Override
	public InfoTypeCategory updateImpl(
		com.rumbasolutions.flask.model.InfoTypeCategory infoTypeCategory)
		throws SystemException {
		infoTypeCategory = toUnwrappedModel(infoTypeCategory);

		boolean isNew = infoTypeCategory.isNew();

		Session session = null;

		try {
			session = openSession();

			if (infoTypeCategory.isNew()) {
				session.save(infoTypeCategory);

				infoTypeCategory.setNew(false);
			}
			else {
				session.merge(infoTypeCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(InfoTypeCategoryModelImpl.ENTITY_CACHE_ENABLED,
			InfoTypeCategoryImpl.class, infoTypeCategory.getPrimaryKey(),
			infoTypeCategory);

		return infoTypeCategory;
	}

	protected InfoTypeCategory toUnwrappedModel(
		InfoTypeCategory infoTypeCategory) {
		if (infoTypeCategory instanceof InfoTypeCategoryImpl) {
			return infoTypeCategory;
		}

		InfoTypeCategoryImpl infoTypeCategoryImpl = new InfoTypeCategoryImpl();

		infoTypeCategoryImpl.setNew(infoTypeCategory.isNew());
		infoTypeCategoryImpl.setPrimaryKey(infoTypeCategory.getPrimaryKey());

		infoTypeCategoryImpl.setInfoTypeCategoryId(infoTypeCategory.getInfoTypeCategoryId());
		infoTypeCategoryImpl.setInfoTypeCategoryName(infoTypeCategory.getInfoTypeCategoryName());
		infoTypeCategoryImpl.setDisplayTemplate(infoTypeCategory.getDisplayTemplate());
		infoTypeCategoryImpl.setInfoTypeId(infoTypeCategory.getInfoTypeId());

		return infoTypeCategoryImpl;
	}

	/**
	 * Returns the info type category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the info type category
	 * @return the info type category
	 * @throws com.rumbasolutions.flask.NoSuchInfoTypeCategoryException if a info type category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InfoTypeCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInfoTypeCategoryException, SystemException {
		InfoTypeCategory infoTypeCategory = fetchByPrimaryKey(primaryKey);

		if (infoTypeCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInfoTypeCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return infoTypeCategory;
	}

	/**
	 * Returns the info type category with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchInfoTypeCategoryException} if it could not be found.
	 *
	 * @param infoTypeCategoryId the primary key of the info type category
	 * @return the info type category
	 * @throws com.rumbasolutions.flask.NoSuchInfoTypeCategoryException if a info type category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InfoTypeCategory findByPrimaryKey(long infoTypeCategoryId)
		throws NoSuchInfoTypeCategoryException, SystemException {
		return findByPrimaryKey((Serializable)infoTypeCategoryId);
	}

	/**
	 * Returns the info type category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the info type category
	 * @return the info type category, or <code>null</code> if a info type category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InfoTypeCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		InfoTypeCategory infoTypeCategory = (InfoTypeCategory)EntityCacheUtil.getResult(InfoTypeCategoryModelImpl.ENTITY_CACHE_ENABLED,
				InfoTypeCategoryImpl.class, primaryKey);

		if (infoTypeCategory == _nullInfoTypeCategory) {
			return null;
		}

		if (infoTypeCategory == null) {
			Session session = null;

			try {
				session = openSession();

				infoTypeCategory = (InfoTypeCategory)session.get(InfoTypeCategoryImpl.class,
						primaryKey);

				if (infoTypeCategory != null) {
					cacheResult(infoTypeCategory);
				}
				else {
					EntityCacheUtil.putResult(InfoTypeCategoryModelImpl.ENTITY_CACHE_ENABLED,
						InfoTypeCategoryImpl.class, primaryKey,
						_nullInfoTypeCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(InfoTypeCategoryModelImpl.ENTITY_CACHE_ENABLED,
					InfoTypeCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return infoTypeCategory;
	}

	/**
	 * Returns the info type category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param infoTypeCategoryId the primary key of the info type category
	 * @return the info type category, or <code>null</code> if a info type category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InfoTypeCategory fetchByPrimaryKey(long infoTypeCategoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)infoTypeCategoryId);
	}

	/**
	 * Returns all the info type categories.
	 *
	 * @return the info type categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InfoTypeCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the info type categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InfoTypeCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of info type categories
	 * @param end the upper bound of the range of info type categories (not inclusive)
	 * @return the range of info type categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InfoTypeCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the info type categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InfoTypeCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of info type categories
	 * @param end the upper bound of the range of info type categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of info type categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InfoTypeCategory> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<InfoTypeCategory> list = (List<InfoTypeCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INFOTYPECATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INFOTYPECATEGORY;

				if (pagination) {
					sql = sql.concat(InfoTypeCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<InfoTypeCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<InfoTypeCategory>(list);
				}
				else {
					list = (List<InfoTypeCategory>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the info type categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (InfoTypeCategory infoTypeCategory : findAll()) {
			remove(infoTypeCategory);
		}
	}

	/**
	 * Returns the number of info type categories.
	 *
	 * @return the number of info type categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_INFOTYPECATEGORY);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the info type category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.InfoTypeCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<InfoTypeCategory>> listenersList = new ArrayList<ModelListener<InfoTypeCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<InfoTypeCategory>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(InfoTypeCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_INFOTYPECATEGORY = "SELECT infoTypeCategory FROM InfoTypeCategory infoTypeCategory";
	private static final String _SQL_COUNT_INFOTYPECATEGORY = "SELECT COUNT(infoTypeCategory) FROM InfoTypeCategory infoTypeCategory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "infoTypeCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No InfoTypeCategory exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InfoTypeCategoryPersistenceImpl.class);
	private static InfoTypeCategory _nullInfoTypeCategory = new InfoTypeCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<InfoTypeCategory> toCacheModel() {
				return _nullInfoTypeCategoryCacheModel;
			}
		};

	private static CacheModel<InfoTypeCategory> _nullInfoTypeCategoryCacheModel = new CacheModel<InfoTypeCategory>() {
			@Override
			public InfoTypeCategory toEntityModel() {
				return _nullInfoTypeCategory;
			}
		};
}