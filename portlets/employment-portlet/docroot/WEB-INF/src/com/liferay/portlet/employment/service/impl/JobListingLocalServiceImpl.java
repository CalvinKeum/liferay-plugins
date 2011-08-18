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

package com.liferay.portlet.employment.service.impl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portlet.employment.model.JobListing;
import com.liferay.portlet.employment.service.base.JobListingLocalServiceBaseImpl;

/**
 * @author Calvin Keum
 */
public class JobListingLocalServiceImpl extends JobListingLocalServiceBaseImpl {
	
	public void addHeaders(
			String headerTitle, String headerDescription)
		throws SystemException {

		JobListing jobListing = jobListingPersistence.fetchByPrimaryKey(0);
		
		jobListing.setTitle(headerTitle);
		jobListing.setDescription(headerDescription);
		
		jobListingPersistence.update(jobListing, false);
	}
	
	public JobListing addJobListing(
			String title, String description, String emailAddress, long userId,
			long groupId, long companyId)
		throws SystemException, PortalException {

		long jobListingId = CounterLocalServiceUtil.increment(
			JobListing.class.getName());

		JobListing jobListing = jobListingPersistence.create(jobListingId);

		jobListing.setTitle(title);
		jobListing.setDescription(description);
		jobListing.setEmailAddress(emailAddress);
		jobListing.setGroupId(groupId);
		jobListing.setCompanyId(companyId);

		jobListingPersistence.update(jobListing, false);

		return jobListing;
	}

	public void createHeaders() throws SystemException{
	
		jobListingPersistence.create(0);
	}
	
	public void deleteJobListing(JobListing jobListing)
		throws SystemException, PortalException {

		resourceLocalService.deleteResource(
			jobListing.getCompanyId(), JobListing.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, jobListing.getPrimaryKey());

		super.deleteJobListing(jobListing);
	}

	public void deletJobListing(long jobListingId)
		throws PortalException, SystemException {

		JobListing jobListing = getJobListing(jobListingId);

		deleteJobListing(jobListing);
	}

	public String getEmailAddressCharCode(long jobListingId)
		throws SystemException, PortalException {

		JobListing jobListing = getJobListing(jobListingId);

		String email = jobListing.getEmailAddress();

		StringBuilder sb = new StringBuilder();

		sb.append("javascript:location.href='mailto:'+String.fromCharCode(");

		int index = 0;

		for (; index < email.length() - 1; index++) {
			sb.append(email.codePointAt(index) + ",");
		}

		sb.append(email.codePointAt(index));
		sb.append(")+'?'");

		return sb.toString();
	}

	public List<JobListing> getJobListingByGroupId(long groupId)
		throws SystemException {

		return jobListingPersistence.findByGroupId(groupId);
	}

	public List<JobListing> getJobListingByGroupId(
			long groupId, int start, int end)
		throws SystemException {

		JobTitleComparator orderByJobTitle = new JobTitleComparator(true);

		return jobListingPersistence.findByGroupId(
			groupId, start, end, orderByJobTitle);
	}

	public int getJobListingCountByGroupId(long groupId)
			throws SystemException {

		return jobListingPersistence.countByGroupId(groupId);
	}

}