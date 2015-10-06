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

package com.liferay.contacts.model.impl;

import com.liferay.contacts.model.FlaskRecipients;
import com.liferay.contacts.service.FlaskRecipientsLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the FlaskRecipients service. Represents a row in the &quot;Contacts_FlaskRecipients&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FlaskRecipientsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskRecipientsImpl
 * @see com.liferay.contacts.model.FlaskRecipients
 * @generated
 */
public abstract class FlaskRecipientsBaseImpl extends FlaskRecipientsModelImpl
	implements FlaskRecipients {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a flask recipients model instance should use the {@link FlaskRecipients} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FlaskRecipientsLocalServiceUtil.addFlaskRecipients(this);
		}
		else {
			FlaskRecipientsLocalServiceUtil.updateFlaskRecipients(this);
		}
	}
}