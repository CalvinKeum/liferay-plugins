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

package com.liferay.portlet.employment.model;

/**
 * <p>
 * This class is a wrapper for {@link JobListing}.
 * </p>
 *
 * @author    Calvin Keum
 * @see       JobListing
 * @generated
 */
public class JobListingWrapper implements JobListing {
	public JobListingWrapper(JobListing jobListing) {
		_jobListing = jobListing;
	}

	public Class<?> getModelClass() {
		return JobListing.class;
	}

	public String getModelClassName() {
		return JobListing.class.getName();
	}

	/**
	* Gets the primary key of this job listing.
	*
	* @return the primary key of this job listing
	*/
	public long getPrimaryKey() {
		return _jobListing.getPrimaryKey();
	}

	/**
	* Sets the primary key of this job listing
	*
	* @param primaryKey the primary key of this job listing
	*/
	public void setPrimaryKey(long primaryKey) {
		_jobListing.setPrimaryKey(primaryKey);
	}

	/**
	* Gets the job listing ID of this job listing.
	*
	* @return the job listing ID of this job listing
	*/
	public long getJobListingId() {
		return _jobListing.getJobListingId();
	}

	/**
	* Sets the job listing ID of this job listing.
	*
	* @param jobListingId the job listing ID of this job listing
	*/
	public void setJobListingId(long jobListingId) {
		_jobListing.setJobListingId(jobListingId);
	}

	/**
	* Gets the group ID of this job listing.
	*
	* @return the group ID of this job listing
	*/
	public long getGroupId() {
		return _jobListing.getGroupId();
	}

	/**
	* Sets the group ID of this job listing.
	*
	* @param groupId the group ID of this job listing
	*/
	public void setGroupId(long groupId) {
		_jobListing.setGroupId(groupId);
	}

	/**
	* Gets the company ID of this job listing.
	*
	* @return the company ID of this job listing
	*/
	public long getCompanyId() {
		return _jobListing.getCompanyId();
	}

	/**
	* Sets the company ID of this job listing.
	*
	* @param companyId the company ID of this job listing
	*/
	public void setCompanyId(long companyId) {
		_jobListing.setCompanyId(companyId);
	}

	/**
	* Gets the user ID of this job listing.
	*
	* @return the user ID of this job listing
	*/
	public long getUserId() {
		return _jobListing.getUserId();
	}

	/**
	* Sets the user ID of this job listing.
	*
	* @param userId the user ID of this job listing
	*/
	public void setUserId(long userId) {
		_jobListing.setUserId(userId);
	}

	/**
	* Gets the user uuid of this job listing.
	*
	* @return the user uuid of this job listing
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobListing.getUserUuid();
	}

	/**
	* Sets the user uuid of this job listing.
	*
	* @param userUuid the user uuid of this job listing
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_jobListing.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this job listing.
	*
	* @return the user name of this job listing
	*/
	public java.lang.String getUserName() {
		return _jobListing.getUserName();
	}

	/**
	* Sets the user name of this job listing.
	*
	* @param userName the user name of this job listing
	*/
	public void setUserName(java.lang.String userName) {
		_jobListing.setUserName(userName);
	}

	/**
	* Gets the create date of this job listing.
	*
	* @return the create date of this job listing
	*/
	public java.util.Date getCreateDate() {
		return _jobListing.getCreateDate();
	}

	/**
	* Sets the create date of this job listing.
	*
	* @param createDate the create date of this job listing
	*/
	public void setCreateDate(java.util.Date createDate) {
		_jobListing.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this job listing.
	*
	* @return the modified date of this job listing
	*/
	public java.util.Date getModifiedDate() {
		return _jobListing.getModifiedDate();
	}

	/**
	* Sets the modified date of this job listing.
	*
	* @param modifiedDate the modified date of this job listing
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_jobListing.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the title of this job listing.
	*
	* @return the title of this job listing
	*/
	public java.lang.String getTitle() {
		return _jobListing.getTitle();
	}

	/**
	* Sets the title of this job listing.
	*
	* @param title the title of this job listing
	*/
	public void setTitle(java.lang.String title) {
		_jobListing.setTitle(title);
	}

	/**
	* Gets the description of this job listing.
	*
	* @return the description of this job listing
	*/
	public java.lang.String getDescription() {
		return _jobListing.getDescription();
	}

	/**
	* Sets the description of this job listing.
	*
	* @param description the description of this job listing
	*/
	public void setDescription(java.lang.String description) {
		_jobListing.setDescription(description);
	}

	/**
	* Gets the email address of this job listing.
	*
	* @return the email address of this job listing
	*/
	public java.lang.String getEmailAddress() {
		return _jobListing.getEmailAddress();
	}

	/**
	* Sets the email address of this job listing.
	*
	* @param emailAddress the email address of this job listing
	*/
	public void setEmailAddress(java.lang.String emailAddress) {
		_jobListing.setEmailAddress(emailAddress);
	}

	public boolean isNew() {
		return _jobListing.isNew();
	}

	public void setNew(boolean n) {
		_jobListing.setNew(n);
	}

	public boolean isCachedModel() {
		return _jobListing.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_jobListing.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _jobListing.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_jobListing.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _jobListing.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_jobListing.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _jobListing.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_jobListing.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JobListingWrapper((JobListing)_jobListing.clone());
	}

	public int compareTo(
		com.liferay.portlet.employment.model.JobListing jobListing) {
		return _jobListing.compareTo(jobListing);
	}

	@Override
	public int hashCode() {
		return _jobListing.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.portlet.employment.model.JobListing> toCacheModel() {
		return _jobListing.toCacheModel();
	}

	public com.liferay.portlet.employment.model.JobListing toEscapedModel() {
		return new JobListingWrapper(_jobListing.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _jobListing.toString();
	}

	public java.lang.String toXmlString() {
		return _jobListing.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobListing.persist();
	}

	public JobListing getWrappedJobListing() {
		return _jobListing;
	}

	public void resetOriginalValues() {
		_jobListing.resetOriginalValues();
	}

	private JobListing _jobListing;
}