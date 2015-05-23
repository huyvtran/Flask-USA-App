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
 * The base model interface for the FlaskAdmin service. Represents a row in the &quot;flaskusers_FlaskAdmin&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rumbasolutions.flask.model.impl.FlaskAdminModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rumbasolutions.flask.model.impl.FlaskAdminImpl}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see FlaskAdmin
 * @see com.rumbasolutions.flask.model.impl.FlaskAdminImpl
 * @see com.rumbasolutions.flask.model.impl.FlaskAdminModelImpl
 * @generated
 */
public interface FlaskAdminModel extends BaseModel<FlaskAdmin> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a flask admin model instance should use the {@link FlaskAdmin} interface instead.
	 */

	/**
	 * Returns the primary key of this flask admin.
	 *
	 * @return the primary key of this flask admin
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this flask admin.
	 *
	 * @param primaryKey the primary key of this flask admin
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the user ID of this flask admin.
	 *
	 * @return the user ID of this flask admin
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this flask admin.
	 *
	 * @param userId the user ID of this flask admin
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this flask admin.
	 *
	 * @return the user uuid of this flask admin
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this flask admin.
	 *
	 * @param userUuid the user uuid of this flask admin
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the role ID of this flask admin.
	 *
	 * @return the role ID of this flask admin
	 */
	public long getRoleId();

	/**
	 * Sets the role ID of this flask admin.
	 *
	 * @param roleId the role ID of this flask admin
	 */
	public void setRoleId(long roleId);

	/**
	 * Returns the first name of this flask admin.
	 *
	 * @return the first name of this flask admin
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this flask admin.
	 *
	 * @param firstName the first name of this flask admin
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the middle name of this flask admin.
	 *
	 * @return the middle name of this flask admin
	 */
	@AutoEscape
	public String getMiddleName();

	/**
	 * Sets the middle name of this flask admin.
	 *
	 * @param middleName the middle name of this flask admin
	 */
	public void setMiddleName(String middleName);

	/**
	 * Returns the last name of this flask admin.
	 *
	 * @return the last name of this flask admin
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this flask admin.
	 *
	 * @param lastName the last name of this flask admin
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the screen name of this flask admin.
	 *
	 * @return the screen name of this flask admin
	 */
	@AutoEscape
	public String getScreenName();

	/**
	 * Sets the screen name of this flask admin.
	 *
	 * @param screenName the screen name of this flask admin
	 */
	public void setScreenName(String screenName);

	/**
	 * Returns the email of this flask admin.
	 *
	 * @return the email of this flask admin
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this flask admin.
	 *
	 * @param email the email of this flask admin
	 */
	public void setEmail(String email);

	/**
	 * Returns the d o b of this flask admin.
	 *
	 * @return the d o b of this flask admin
	 */
	public Date getDOB();

	/**
	 * Sets the d o b of this flask admin.
	 *
	 * @param DOB the d o b of this flask admin
	 */
	public void setDOB(Date DOB);

	/**
	 * Returns the is male of this flask admin.
	 *
	 * @return the is male of this flask admin
	 */
	public Boolean getIsMale();

	/**
	 * Sets the is male of this flask admin.
	 *
	 * @param isMale the is male of this flask admin
	 */
	public void setIsMale(Boolean isMale);

	/**
	 * Returns the street name of this flask admin.
	 *
	 * @return the street name of this flask admin
	 */
	@AutoEscape
	public String getStreetName();

	/**
	 * Sets the street name of this flask admin.
	 *
	 * @param streetName the street name of this flask admin
	 */
	public void setStreetName(String streetName);

	/**
	 * Returns the apt no of this flask admin.
	 *
	 * @return the apt no of this flask admin
	 */
	@AutoEscape
	public String getAptNo();

	/**
	 * Sets the apt no of this flask admin.
	 *
	 * @param aptNo the apt no of this flask admin
	 */
	public void setAptNo(String aptNo);

	/**
	 * Returns the area code of this flask admin.
	 *
	 * @return the area code of this flask admin
	 */
	@AutoEscape
	public String getAreaCode();

	/**
	 * Sets the area code of this flask admin.
	 *
	 * @param areaCode the area code of this flask admin
	 */
	public void setAreaCode(String areaCode);

	/**
	 * Returns the city of this flask admin.
	 *
	 * @return the city of this flask admin
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this flask admin.
	 *
	 * @param city the city of this flask admin
	 */
	public void setCity(String city);

	/**
	 * Returns the state ID of this flask admin.
	 *
	 * @return the state ID of this flask admin
	 */
	public long getStateId();

	/**
	 * Sets the state ID of this flask admin.
	 *
	 * @param stateId the state ID of this flask admin
	 */
	public void setStateId(long stateId);

	/**
	 * Returns the state name of this flask admin.
	 *
	 * @return the state name of this flask admin
	 */
	@AutoEscape
	public String getStateName();

	/**
	 * Sets the state name of this flask admin.
	 *
	 * @param stateName the state name of this flask admin
	 */
	public void setStateName(String stateName);

	/**
	 * Returns the country ID of this flask admin.
	 *
	 * @return the country ID of this flask admin
	 */
	public long getCountryId();

	/**
	 * Sets the country ID of this flask admin.
	 *
	 * @param countryId the country ID of this flask admin
	 */
	public void setCountryId(long countryId);

	/**
	 * Returns the country name of this flask admin.
	 *
	 * @return the country name of this flask admin
	 */
	@AutoEscape
	public String getCountryName();

	/**
	 * Sets the country name of this flask admin.
	 *
	 * @param countryName the country name of this flask admin
	 */
	public void setCountryName(String countryName);

	/**
	 * Returns the mobile number of this flask admin.
	 *
	 * @return the mobile number of this flask admin
	 */
	@AutoEscape
	public String getMobileNumber();

	/**
	 * Sets the mobile number of this flask admin.
	 *
	 * @param mobileNumber the mobile number of this flask admin
	 */
	public void setMobileNumber(String mobileNumber);

	/**
	 * Returns the portrait u r l of this flask admin.
	 *
	 * @return the portrait u r l of this flask admin
	 */
	@AutoEscape
	public String getPortraitURL();

	/**
	 * Sets the portrait u r l of this flask admin.
	 *
	 * @param portraitURL the portrait u r l of this flask admin
	 */
	public void setPortraitURL(String portraitURL);

	/**
	 * Returns the user interests of this flask admin.
	 *
	 * @return the user interests of this flask admin
	 */
	@AutoEscape
	public String getUserInterests();

	/**
	 * Sets the user interests of this flask admin.
	 *
	 * @param userInterests the user interests of this flask admin
	 */
	public void setUserInterests(String userInterests);

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
	public int compareTo(com.rumbasolutions.flask.model.FlaskAdmin flaskAdmin);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.rumbasolutions.flask.model.FlaskAdmin> toCacheModel();

	@Override
	public com.rumbasolutions.flask.model.FlaskAdmin toEscapedModel();

	@Override
	public com.rumbasolutions.flask.model.FlaskAdmin toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}