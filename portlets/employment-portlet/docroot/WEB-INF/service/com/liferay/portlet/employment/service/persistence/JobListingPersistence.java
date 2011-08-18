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

package com.liferay.portlet.employment.service.persistence;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.portlet.employment.model.JobListing;

/**
 * The persistence interface for the job listing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Calvin Keum
 * @see JobListingPersistenceImpl
 * @see JobListingUtil
 * @generated
 */
public interface JobListingPersistence extends BasePersistence<JobListing> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobListingUtil} to access the job listing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the job listing in the entity cache if it is enabled.
	*
	* @param jobListing the job listing to cache
	*/
	public void cacheResult(
		com.liferay.portlet.employment.model.JobListing jobListing);

	/**
	* Caches the job listings in the entity cache if it is enabled.
	*
	* @param jobListings the job listings to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portlet.employment.model.JobListing> jobListings);

	/**
	* Creates a new job listing with the primary key. Does not add the job listing to the database.
	*
	* @param jobListingId the primary key for the new job listing
	* @return the new job listing
	*/
	public com.liferay.portlet.employment.model.JobListing create(
		long jobListingId);

	/**
	* Removes the job listing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobListingId the primary key of the job listing to remove
	* @return the job listing that was removed
	* @throws com.liferay.portlet.employment.NoSuchJobListingException if a job listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.employment.model.JobListing remove(
		long jobListingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.employment.NoSuchJobListingException;

	public com.liferay.portlet.employment.model.JobListing updateImpl(
		com.liferay.portlet.employment.model.JobListing jobListing,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the job listing with the primary key or throws a {@link com.liferay.portlet.employment.NoSuchJobListingException} if it could not be found.
	*
	* @param jobListingId the primary key of the job listing to find
	* @return the job listing
	* @throws com.liferay.portlet.employment.NoSuchJobListingException if a job listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.employment.model.JobListing findByPrimaryKey(
		long jobListingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.employment.NoSuchJobListingException;

	/**
	* Finds the job listing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jobListingId the primary key of the job listing to find
	* @return the job listing, or <code>null</code> if a job listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.employment.model.JobListing fetchByPrimaryKey(
		long jobListingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the job listings where groupId = &#63;.
	*
	* @param groupId the group ID to search with
	* @return the matching job listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.employment.model.JobListing> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the job listings where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID to search with
	* @param start the lower bound of the range of job listings to return
	* @param end the upper bound of the range of job listings to return (not inclusive)
	* @return the range of matching job listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.employment.model.JobListing> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the job listings where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID to search with
	* @param start the lower bound of the range of job listings to return
	* @param end the upper bound of the range of job listings to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching job listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.employment.model.JobListing> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first job listing in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching job listing
	* @throws com.liferay.portlet.employment.NoSuchJobListingException if a matching job listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.employment.model.JobListing findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.employment.NoSuchJobListingException;

	/**
	* Finds the last job listing in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching job listing
	* @throws com.liferay.portlet.employment.NoSuchJobListingException if a matching job listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.employment.model.JobListing findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.employment.NoSuchJobListingException;

	/**
	* Finds the job listings before and after the current job listing in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param jobListingId the primary key of the current job listing
	* @param groupId the group ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next job listing
	* @throws com.liferay.portlet.employment.NoSuchJobListingException if a job listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.employment.model.JobListing[] findByGroupId_PrevAndNext(
		long jobListingId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.employment.NoSuchJobListingException;

	/**
	* Finds all the job listings.
	*
	* @return the job listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.employment.model.JobListing> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the job listings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of job listings to return
	* @param end the upper bound of the range of job listings to return (not inclusive)
	* @return the range of job listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.employment.model.JobListing> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the job listings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of job listings to return
	* @param end the upper bound of the range of job listings to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of job listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.employment.model.JobListing> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the job listings where groupId = &#63; from the database.
	*
	* @param groupId the group ID to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the job listings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the job listings where groupId = &#63;.
	*
	* @param groupId the group ID to search with
	* @return the number of matching job listings
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the job listings.
	*
	* @return the number of job listings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public JobListing remove(JobListing jobListing) throws SystemException;
}