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

package com.liferay.portlet.employment.service;

/**
 * <p>
 * This class is a wrapper for {@link JobListingLocalService}.
 * </p>
 *
 * @author    Calvin Keum
 * @see       JobListingLocalService
 * @generated
 */
public class JobListingLocalServiceWrapper implements JobListingLocalService {
	public JobListingLocalServiceWrapper(
		JobListingLocalService jobListingLocalService) {
		_jobListingLocalService = jobListingLocalService;
	}

	/**
	* Adds the job listing to the database. Also notifies the appropriate model listeners.
	*
	* @param jobListing the job listing
	* @return the job listing that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.employment.model.JobListing addJobListing(
		com.liferay.portlet.employment.model.JobListing jobListing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobListingLocalService.addJobListing(jobListing);
	}

	/**
	* Creates a new job listing with the primary key. Does not add the job listing to the database.
	*
	* @param jobListingId the primary key for the new job listing
	* @return the new job listing
	*/
	public com.liferay.portlet.employment.model.JobListing createJobListing(
		long jobListingId) {
		return _jobListingLocalService.createJobListing(jobListingId);
	}

	/**
	* Deletes the job listing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobListingId the primary key of the job listing
	* @throws PortalException if a job listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteJobListing(long jobListingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_jobListingLocalService.deleteJobListing(jobListingId);
	}

	/**
	* Deletes the job listing from the database. Also notifies the appropriate model listeners.
	*
	* @param jobListing the job listing
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	public void deleteJobListing(
		com.liferay.portlet.employment.model.JobListing jobListing)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_jobListingLocalService.deleteJobListing(jobListing);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobListingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _jobListingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobListingLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobListingLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the job listing with the primary key.
	*
	* @param jobListingId the primary key of the job listing
	* @return the job listing
	* @throws PortalException if a job listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.employment.model.JobListing getJobListing(
		long jobListingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobListingLocalService.getJobListing(jobListingId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobListingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the job listings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of job listings
	* @param end the upper bound of the range of job listings (not inclusive)
	* @return the range of job listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.employment.model.JobListing> getJobListings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobListingLocalService.getJobListings(start, end);
	}

	/**
	* Returns the number of job listings.
	*
	* @return the number of job listings
	* @throws SystemException if a system exception occurred
	*/
	public int getJobListingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobListingLocalService.getJobListingsCount();
	}

	/**
	* Updates the job listing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jobListing the job listing
	* @return the job listing that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.employment.model.JobListing updateJobListing(
		com.liferay.portlet.employment.model.JobListing jobListing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobListingLocalService.updateJobListing(jobListing);
	}

	/**
	* Updates the job listing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jobListing the job listing
	* @param merge whether to merge the job listing with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the job listing that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.employment.model.JobListing updateJobListing(
		com.liferay.portlet.employment.model.JobListing jobListing,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobListingLocalService.updateJobListing(jobListing, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _jobListingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_jobListingLocalService.setBeanIdentifier(beanIdentifier);
	}

	public void addHeaders(java.lang.String headerTitle,
		java.lang.String headerDescription)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobListingLocalService.addHeaders(headerTitle, headerDescription);
	}

	public com.liferay.portlet.employment.model.JobListing addJobListing(
		java.lang.String title, java.lang.String description,
		java.lang.String emailAddress, long userId, long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobListingLocalService.addJobListing(title, description,
			emailAddress, userId, groupId, companyId);
	}

	public void createHeaders()
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobListingLocalService.createHeaders();
	}

	public void deletJobListing(long jobListingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_jobListingLocalService.deletJobListing(jobListingId);
	}

	public java.lang.String getEmailAddressCharCode(long jobListingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobListingLocalService.getEmailAddressCharCode(jobListingId);
	}

	public java.util.List<com.liferay.portlet.employment.model.JobListing> getJobListingByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobListingLocalService.getJobListingByGroupId(groupId);
	}

	public java.util.List<com.liferay.portlet.employment.model.JobListing> getJobListingByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobListingLocalService.getJobListingByGroupId(groupId, start,
			end);
	}

	public int getJobListingCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobListingLocalService.getJobListingCountByGroupId(groupId);
	}

	public JobListingLocalService getWrappedJobListingLocalService() {
		return _jobListingLocalService;
	}

	public void setWrappedJobListingLocalService(
		JobListingLocalService jobListingLocalService) {
		_jobListingLocalService = jobListingLocalService;
	}

	private JobListingLocalService _jobListingLocalService;
}