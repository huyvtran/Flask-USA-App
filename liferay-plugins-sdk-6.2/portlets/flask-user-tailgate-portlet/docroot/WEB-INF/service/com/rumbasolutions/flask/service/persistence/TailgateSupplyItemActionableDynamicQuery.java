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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.rumbasolutions.flask.model.TailgateSupplyItem;
import com.rumbasolutions.flask.service.TailgateSupplyItemLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class TailgateSupplyItemActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public TailgateSupplyItemActionableDynamicQuery() throws SystemException {
		setBaseLocalService(TailgateSupplyItemLocalServiceUtil.getService());
		setClass(TailgateSupplyItem.class);

		setClassLoader(com.rumbasolutions.flask.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("tailgateSupplyItemId");
	}
}