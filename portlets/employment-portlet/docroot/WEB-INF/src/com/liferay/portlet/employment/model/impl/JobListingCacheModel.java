/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.employment.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.portlet.employment.model.JobListing;

import java.util.Date;

/**
 * The cache model class for representing JobListing in entity cache.
 *
 * @author Calvin Keum
 * @see JobListing
 * @generated
 */
public class JobListingCacheModel implements CacheModel<JobListing> {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{jobListingId=");
		sb.append(jobListingId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append("}");

		return sb.toString();
	}

	public JobListing toEntityModel() {
		JobListingImpl jobListingImpl = new JobListingImpl();

		jobListingImpl.setJobListingId(jobListingId);
		jobListingImpl.setGroupId(groupId);
		jobListingImpl.setCompanyId(companyId);
		jobListingImpl.setUserId(userId);

		if (userName == null) {
			jobListingImpl.setUserName(StringPool.BLANK);
		}
		else {
			jobListingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			jobListingImpl.setCreateDate(null);
		}
		else {
			jobListingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jobListingImpl.setModifiedDate(null);
		}
		else {
			jobListingImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			jobListingImpl.setTitle(StringPool.BLANK);
		}
		else {
			jobListingImpl.setTitle(title);
		}

		if (description == null) {
			jobListingImpl.setDescription(StringPool.BLANK);
		}
		else {
			jobListingImpl.setDescription(description);
		}

		if (emailAddress == null) {
			jobListingImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			jobListingImpl.setEmailAddress(emailAddress);
		}

		jobListingImpl.resetOriginalValues();

		return jobListingImpl;
	}

	public long jobListingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public String emailAddress;
}