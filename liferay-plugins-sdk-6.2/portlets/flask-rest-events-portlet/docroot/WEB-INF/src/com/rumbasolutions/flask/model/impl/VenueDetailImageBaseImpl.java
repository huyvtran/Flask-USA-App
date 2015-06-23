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

package com.rumbasolutions.flask.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.rumbasolutions.flask.model.VenueDetailImage;
import com.rumbasolutions.flask.service.VenueDetailImageLocalServiceUtil;

/**
 * The extended model base implementation for the VenueDetailImage service. Represents a row in the &quot;flaskevents_VenueDetailImage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VenueDetailImageImpl}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueDetailImageImpl
 * @see com.rumbasolutions.flask.model.VenueDetailImage
 * @generated
 */
public abstract class VenueDetailImageBaseImpl extends VenueDetailImageModelImpl
	implements VenueDetailImage {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a venue detail image model instance should use the {@link VenueDetailImage} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VenueDetailImageLocalServiceUtil.addVenueDetailImage(this);
		}
		else {
			VenueDetailImageLocalServiceUtil.updateVenueDetailImage(this);
		}
	}
}