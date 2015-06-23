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
 * The base model interface for the EventDetail service. Represents a row in the &quot;flaskevents_EventDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rumbasolutions.flask.model.impl.EventDetailModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rumbasolutions.flask.model.impl.EventDetailImpl}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventDetail
 * @see com.rumbasolutions.flask.model.impl.EventDetailImpl
 * @see com.rumbasolutions.flask.model.impl.EventDetailModelImpl
 * @generated
 */
public interface EventDetailModel extends BaseModel<EventDetail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a event detail model instance should use the {@link EventDetail} interface instead.
	 */

	/**
	 * Returns the primary key of this event detail.
	 *
	 * @return the primary key of this event detail
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this event detail.
	 *
	 * @param primaryKey the primary key of this event detail
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the event detail ID of this event detail.
	 *
	 * @return the event detail ID of this event detail
	 */
	public long getEventDetailId();

	/**
	 * Sets the event detail ID of this event detail.
	 *
	 * @param eventDetailId the event detail ID of this event detail
	 */
	public void setEventDetailId(long eventDetailId);

	/**
	 * Returns the company ID of this event detail.
	 *
	 * @return the company ID of this event detail
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this event detail.
	 *
	 * @param companyId the company ID of this event detail
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this event detail.
	 *
	 * @return the user ID of this event detail
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this event detail.
	 *
	 * @param userId the user ID of this event detail
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this event detail.
	 *
	 * @return the user uuid of this event detail
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this event detail.
	 *
	 * @param userUuid the user uuid of this event detail
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the created date of this event detail.
	 *
	 * @return the created date of this event detail
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this event detail.
	 *
	 * @param createdDate the created date of this event detail
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the modified date of this event detail.
	 *
	 * @return the modified date of this event detail
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this event detail.
	 *
	 * @param modifiedDate the modified date of this event detail
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the event ID of this event detail.
	 *
	 * @return the event ID of this event detail
	 */
	public long getEventId();

	/**
	 * Sets the event ID of this event detail.
	 *
	 * @param eventId the event ID of this event detail
	 */
	public void setEventId(long eventId);

	/**
	 * Returns the info type ID of this event detail.
	 *
	 * @return the info type ID of this event detail
	 */
	public long getInfoTypeId();

	/**
	 * Sets the info type ID of this event detail.
	 *
	 * @param infoTypeId the info type ID of this event detail
	 */
	public void setInfoTypeId(long infoTypeId);

	/**
	 * Returns the info type name of this event detail.
	 *
	 * @return the info type name of this event detail
	 */
	@AutoEscape
	public String getInfoTypeName();

	/**
	 * Sets the info type name of this event detail.
	 *
	 * @param infoTypeName the info type name of this event detail
	 */
	public void setInfoTypeName(String infoTypeName);

	/**
	 * Returns the info type category ID of this event detail.
	 *
	 * @return the info type category ID of this event detail
	 */
	public long getInfoTypeCategoryId();

	/**
	 * Sets the info type category ID of this event detail.
	 *
	 * @param infoTypeCategoryId the info type category ID of this event detail
	 */
	public void setInfoTypeCategoryId(long infoTypeCategoryId);

	/**
	 * Returns the info type category name of this event detail.
	 *
	 * @return the info type category name of this event detail
	 */
	@AutoEscape
	public String getInfoTypeCategoryName();

	/**
	 * Sets the info type category name of this event detail.
	 *
	 * @param infoTypeCategoryName the info type category name of this event detail
	 */
	public void setInfoTypeCategoryName(String infoTypeCategoryName);

	/**
	 * Returns the info title of this event detail.
	 *
	 * @return the info title of this event detail
	 */
	@AutoEscape
	public String getInfoTitle();

	/**
	 * Sets the info title of this event detail.
	 *
	 * @param infoTitle the info title of this event detail
	 */
	public void setInfoTitle(String infoTitle);

	/**
	 * Returns the info desc of this event detail.
	 *
	 * @return the info desc of this event detail
	 */
	@AutoEscape
	public String getInfoDesc();

	/**
	 * Sets the info desc of this event detail.
	 *
	 * @param infoDesc the info desc of this event detail
	 */
	public void setInfoDesc(String infoDesc);

	/**
	 * Returns the addr line1 of this event detail.
	 *
	 * @return the addr line1 of this event detail
	 */
	@AutoEscape
	public String getAddrLine1();

	/**
	 * Sets the addr line1 of this event detail.
	 *
	 * @param addrLine1 the addr line1 of this event detail
	 */
	public void setAddrLine1(String addrLine1);

	/**
	 * Returns the addr line2 of this event detail.
	 *
	 * @return the addr line2 of this event detail
	 */
	@AutoEscape
	public String getAddrLine2();

	/**
	 * Sets the addr line2 of this event detail.
	 *
	 * @param addrLine2 the addr line2 of this event detail
	 */
	public void setAddrLine2(String addrLine2);

	/**
	 * Returns the city of this event detail.
	 *
	 * @return the city of this event detail
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this event detail.
	 *
	 * @param city the city of this event detail
	 */
	public void setCity(String city);

	/**
	 * Returns the zip code of this event detail.
	 *
	 * @return the zip code of this event detail
	 */
	@AutoEscape
	public String getZipCode();

	/**
	 * Sets the zip code of this event detail.
	 *
	 * @param zipCode the zip code of this event detail
	 */
	public void setZipCode(String zipCode);

	/**
	 * Returns the state ID of this event detail.
	 *
	 * @return the state ID of this event detail
	 */
	public long getStateId();

	/**
	 * Sets the state ID of this event detail.
	 *
	 * @param stateId the state ID of this event detail
	 */
	public void setStateId(long stateId);

	/**
	 * Returns the state name of this event detail.
	 *
	 * @return the state name of this event detail
	 */
	@AutoEscape
	public String getStateName();

	/**
	 * Sets the state name of this event detail.
	 *
	 * @param stateName the state name of this event detail
	 */
	public void setStateName(String stateName);

	/**
	 * Returns the country ID of this event detail.
	 *
	 * @return the country ID of this event detail
	 */
	public long getCountryId();

	/**
	 * Sets the country ID of this event detail.
	 *
	 * @param countryId the country ID of this event detail
	 */
	public void setCountryId(long countryId);

	/**
	 * Returns the country name of this event detail.
	 *
	 * @return the country name of this event detail
	 */
	@AutoEscape
	public String getCountryName();

	/**
	 * Sets the country name of this event detail.
	 *
	 * @param countryName the country name of this event detail
	 */
	public void setCountryName(String countryName);

	/**
	 * Returns the latitude of this event detail.
	 *
	 * @return the latitude of this event detail
	 */
	@AutoEscape
	public String getLatitude();

	/**
	 * Sets the latitude of this event detail.
	 *
	 * @param latitude the latitude of this event detail
	 */
	public void setLatitude(String latitude);

	/**
	 * Returns the longitude of this event detail.
	 *
	 * @return the longitude of this event detail
	 */
	@AutoEscape
	public String getLongitude();

	/**
	 * Sets the longitude of this event detail.
	 *
	 * @param longitude the longitude of this event detail
	 */
	public void setLongitude(String longitude);

	/**
	 * Returns the phone of this event detail.
	 *
	 * @return the phone of this event detail
	 */
	@AutoEscape
	public String getPhone();

	/**
	 * Sets the phone of this event detail.
	 *
	 * @param phone the phone of this event detail
	 */
	public void setPhone(String phone);

	/**
	 * Returns the website of this event detail.
	 *
	 * @return the website of this event detail
	 */
	@AutoEscape
	public String getWebsite();

	/**
	 * Sets the website of this event detail.
	 *
	 * @param website the website of this event detail
	 */
	public void setWebsite(String website);

	/**
	 * Returns the cost of this event detail.
	 *
	 * @return the cost of this event detail
	 */
	public double getCost();

	/**
	 * Sets the cost of this event detail.
	 *
	 * @param cost the cost of this event detail
	 */
	public void setCost(double cost);

	/**
	 * Returns the hours of operation of this event detail.
	 *
	 * @return the hours of operation of this event detail
	 */
	@AutoEscape
	public String getHoursOfOperation();

	/**
	 * Sets the hours of operation of this event detail.
	 *
	 * @param hoursOfOperation the hours of operation of this event detail
	 */
	public void setHoursOfOperation(String hoursOfOperation);

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
	public int compareTo(com.rumbasolutions.flask.model.EventDetail eventDetail);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.rumbasolutions.flask.model.EventDetail> toCacheModel();

	@Override
	public com.rumbasolutions.flask.model.EventDetail toEscapedModel();

	@Override
	public com.rumbasolutions.flask.model.EventDetail toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}