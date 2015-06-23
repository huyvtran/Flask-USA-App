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

package com.rumbasolutions.flask.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the VenueImage service. Represents a row in the &quot;flaskevents_VenueImage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rumbasolutions.flask.model.impl.VenueImageModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rumbasolutions.flask.model.impl.VenueImageImpl}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueImage
 * @see com.rumbasolutions.flask.model.impl.VenueImageImpl
 * @see com.rumbasolutions.flask.model.impl.VenueImageModelImpl
 * @generated
 */
public interface VenueImageModel extends BaseModel<VenueImage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a venue image model instance should use the {@link VenueImage} interface instead.
	 */

	/**
	 * Returns the primary key of this venue image.
	 *
	 * @return the primary key of this venue image
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this venue image.
	 *
	 * @param primaryKey the primary key of this venue image
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the venue image ID of this venue image.
	 *
	 * @return the venue image ID of this venue image
	 */
	public long getVenueImageId();

	/**
	 * Sets the venue image ID of this venue image.
	 *
	 * @param venueImageId the venue image ID of this venue image
	 */
	public void setVenueImageId(long venueImageId);

	/**
	 * Returns the company ID of this venue image.
	 *
	 * @return the company ID of this venue image
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this venue image.
	 *
	 * @param companyId the company ID of this venue image
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this venue image.
	 *
	 * @return the user ID of this venue image
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this venue image.
	 *
	 * @param userId the user ID of this venue image
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this venue image.
	 *
	 * @return the user uuid of this venue image
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this venue image.
	 *
	 * @param userUuid the user uuid of this venue image
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the created date of this venue image.
	 *
	 * @return the created date of this venue image
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this venue image.
	 *
	 * @param createdDate the created date of this venue image
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the modified date of this venue image.
	 *
	 * @return the modified date of this venue image
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this venue image.
	 *
	 * @param modifiedDate the modified date of this venue image
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the title of this venue image.
	 *
	 * @return the title of this venue image
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this venue image.
	 *
	 * @param title the title of this venue image
	 */
	public void setTitle(String title);

	/**
	 * Returns the venue image path of this venue image.
	 *
	 * @return the venue image path of this venue image
	 */
	@AutoEscape
	public String getVenueImagePath();

	/**
	 * Sets the venue image path of this venue image.
	 *
	 * @param venueImagePath the venue image path of this venue image
	 */
	public void setVenueImagePath(String venueImagePath);

	/**
	 * Returns the venue ID of this venue image.
	 *
	 * @return the venue ID of this venue image
	 */
	public long getVenueId();

	/**
	 * Sets the venue ID of this venue image.
	 *
	 * @param venueId the venue ID of this venue image
	 */
	public void setVenueId(long venueId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.rumbasolutions.flask.model.VenueImage venueImage);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.rumbasolutions.flask.model.VenueImage> toCacheModel();

	@Override
	public com.rumbasolutions.flask.model.VenueImage toEscapedModel();

	@Override
	public com.rumbasolutions.flask.model.VenueImage toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}