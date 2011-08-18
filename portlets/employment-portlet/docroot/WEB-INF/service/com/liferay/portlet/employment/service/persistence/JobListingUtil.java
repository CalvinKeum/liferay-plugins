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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.employment.model.JobListing;

import java.util.List;

/**
 * The persistence utility for the job listing service. This utility wraps {@link JobListingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Calvin Keum
 * @see JobListingPersistence
 * @see JobListingPersistenceImpl
 * @generated
 */
public class JobListingUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(JobListing jobListing) {
		getPersistence().clearCache(jobListing);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<JobListing> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JobListing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JobListing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static JobListing remove(JobListing jobListing)
		throws SystemException {
		return getPersistence().remove(jobListing);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static JobListing update(JobListing jobListing, boolean merge)
		throws SystemException {
		return getPersistence().update(jobListing, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static JobListing update(JobListing jobListing, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(jobListing, merge, serviceContext);
	}

	/**
	* Caches the job listing in the entity cache if it is enabled.
	*
	* @param jobListing the job listing to cache
	*/
	public static void cacheResult(
		com.liferay.portlet.employment.model.JobListing jobListing) {
		getPersistence().cacheResult(jobListing);
	}

	/**
	* Caches the job listings in the entity cache if it is enabled.
	*
	* @param jobListings the job listings to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portlet.employment.model.JobListing> jobListings) {
		getPersistence().cacheResult(jobListings);
	}

	/**
	* Creates a new job listing with the primary key. Does not add the job listing to the database.
	*
	* @param jobListingId the primary key for the new job listing
	* @return the new job listing
	*/
	public static com.liferay.portlet.employment.model.JobListing create(
		long jobListingId) {
		return getPersistence().create(jobListingId);
	}

	/**
	* Removes the job listing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobListingId the primary key of the job listing to remove
	* @return the job listing that was removed
	* @throws com.liferay.portlet.employment.NoSuchJobListingException if a job listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.employment.model.JobListing remove(
		long jobListingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.employment.NoSuchJobListingException {
		return getPersistence().remove(jobListingId);
	}

	public static com.liferay.portlet.employment.model.JobListing updateImpl(
		com.liferay.portlet.employment.model.JobListing jobListing,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(jobListing, merge);
	}

	/**
	* Finds the job listing with the primary key or throws a {@link com.liferay.portlet.employment.NoSuchJobListingException} if it could not be found.
	*
	* @param jobListingId the primary key of the job listing to find
	* @return the job listing
	* @throws com.liferay.portlet.employment.NoSuchJobListingException if a job listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.employment.model.JobListing findByPrimaryKey(
		long jobListingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.employment.NoSuchJobListingException {
		return getPersistence().findByPrimaryKey(jobListingId);
	}

	/**
	* Finds the job listing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jobListingId the primary key of the job listing to find
	* @return the job listing, or <code>null</code> if a job listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.employment.model.JobListing fetchByPrimaryKey(
		long jobListingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(jobListingId);
	}

	/**
	* Finds all the job listings where groupId = &#63;.
	*
	* @param groupId the group ID to search with
	* @return the matching job listings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.employment.model.JobListing> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<com.liferay.portlet.employment.model.JobListing> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.liferay.portlet.employment.model.JobListing> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

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
	public static com.liferay.portlet.employment.model.JobListing findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.employment.NoSuchJobListingException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

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
	public static com.liferay.portlet.employment.model.JobListing findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.employment.NoSuchJobListingException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

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
	public static com.liferay.portlet.employment.model.JobListing[] findByGroupId_PrevAndNext(
		long jobListingId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.employment.NoSuchJobListingException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(jobListingId, groupId,
			orderByComparator);
	}

	/**
	* Finds all the job listings.
	*
	* @return the job listings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.employment.model.JobListing> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.portlet.employment.model.JobListing> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.portlet.employment.model.JobListing> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the job listings where groupId = &#63; from the database.
	*
	* @param groupId the group ID to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the job listings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the job listings where groupId = &#63;.
	*
	* @param groupId the group ID to search with
	* @return the number of matching job listings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Counts all the job listings.
	*
	* @return the number of job listings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static JobListingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (JobListingPersistence)PortletBeanLocatorUtil.locate(com.liferay.portlet.employment.service.ClpSerializer.getServletContextName(),
					JobListingPersistence.class.getName());

			ReferenceRegistry.registerReference(JobListingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(JobListingPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(JobListingUtil.class, "_persistence");
	}

	private static JobListingPersistence _persistence;
}