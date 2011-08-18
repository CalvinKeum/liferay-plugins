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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.employment.NoSuchJobListingException;
import com.liferay.portlet.employment.model.JobListing;
import com.liferay.portlet.employment.model.impl.JobListingImpl;
import com.liferay.portlet.employment.model.impl.JobListingModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the job listing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Calvin Keum
 * @see JobListingPersistence
 * @see JobListingUtil
 * @generated
 */
public class JobListingPersistenceImpl extends BasePersistenceImpl<JobListing>
	implements JobListingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JobListingUtil} to access the job listing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JobListingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(JobListingModelImpl.ENTITY_CACHE_ENABLED,
			JobListingModelImpl.FINDER_CACHE_ENABLED, JobListingImpl.class,
			FINDER_CLASS_NAME_LIST, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(JobListingModelImpl.ENTITY_CACHE_ENABLED,
			JobListingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(JobListingModelImpl.ENTITY_CACHE_ENABLED,
			JobListingModelImpl.FINDER_CACHE_ENABLED, JobListingImpl.class,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JobListingModelImpl.ENTITY_CACHE_ENABLED,
			JobListingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the job listing in the entity cache if it is enabled.
	 *
	 * @param jobListing the job listing to cache
	 */
	public void cacheResult(JobListing jobListing) {
		EntityCacheUtil.putResult(JobListingModelImpl.ENTITY_CACHE_ENABLED,
			JobListingImpl.class, jobListing.getPrimaryKey(), jobListing);

		jobListing.resetOriginalValues();
	}

	/**
	 * Caches the job listings in the entity cache if it is enabled.
	 *
	 * @param jobListings the job listings to cache
	 */
	public void cacheResult(List<JobListing> jobListings) {
		for (JobListing jobListing : jobListings) {
			if (EntityCacheUtil.getResult(
						JobListingModelImpl.ENTITY_CACHE_ENABLED,
						JobListingImpl.class, jobListing.getPrimaryKey(), this) == null) {
				cacheResult(jobListing);
			}
		}
	}

	/**
	 * Clears the cache for all job listings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JobListingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JobListingImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the job listing.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JobListing jobListing) {
		EntityCacheUtil.removeResult(JobListingModelImpl.ENTITY_CACHE_ENABLED,
			JobListingImpl.class, jobListing.getPrimaryKey());
	}

	/**
	 * Creates a new job listing with the primary key. Does not add the job listing to the database.
	 *
	 * @param jobListingId the primary key for the new job listing
	 * @return the new job listing
	 */
	public JobListing create(long jobListingId) {
		JobListing jobListing = new JobListingImpl();

		jobListing.setNew(true);
		jobListing.setPrimaryKey(jobListingId);

		return jobListing;
	}

	/**
	 * Removes the job listing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job listing to remove
	 * @return the job listing that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a job listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobListing remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the job listing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobListingId the primary key of the job listing to remove
	 * @return the job listing that was removed
	 * @throws com.liferay.portlet.employment.NoSuchJobListingException if a job listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JobListing remove(long jobListingId)
		throws NoSuchJobListingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			JobListing jobListing = (JobListing)session.get(JobListingImpl.class,
					Long.valueOf(jobListingId));

			if (jobListing == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + jobListingId);
				}

				throw new NoSuchJobListingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					jobListingId);
			}

			return jobListingPersistence.remove(jobListing);
		}
		catch (NoSuchJobListingException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Removes the job listing from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobListing the job listing to remove
	 * @return the job listing that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobListing remove(JobListing jobListing) throws SystemException {
		return super.remove(jobListing);
	}

	@Override
	protected JobListing removeImpl(JobListing jobListing)
		throws SystemException {
		jobListing = toUnwrappedModel(jobListing);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, jobListing);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(JobListingModelImpl.ENTITY_CACHE_ENABLED,
			JobListingImpl.class, jobListing.getPrimaryKey());

		return jobListing;
	}

	@Override
	public JobListing updateImpl(
		com.liferay.portlet.employment.model.JobListing jobListing,
		boolean merge) throws SystemException {
		jobListing = toUnwrappedModel(jobListing);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, jobListing, merge);

			jobListing.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(JobListingModelImpl.ENTITY_CACHE_ENABLED,
			JobListingImpl.class, jobListing.getPrimaryKey(), jobListing);

		return jobListing;
	}

	protected JobListing toUnwrappedModel(JobListing jobListing) {
		if (jobListing instanceof JobListingImpl) {
			return jobListing;
		}

		JobListingImpl jobListingImpl = new JobListingImpl();

		jobListingImpl.setNew(jobListing.isNew());
		jobListingImpl.setPrimaryKey(jobListing.getPrimaryKey());

		jobListingImpl.setJobListingId(jobListing.getJobListingId());
		jobListingImpl.setGroupId(jobListing.getGroupId());
		jobListingImpl.setCompanyId(jobListing.getCompanyId());
		jobListingImpl.setUserId(jobListing.getUserId());
		jobListingImpl.setUserName(jobListing.getUserName());
		jobListingImpl.setCreateDate(jobListing.getCreateDate());
		jobListingImpl.setModifiedDate(jobListing.getModifiedDate());
		jobListingImpl.setTitle(jobListing.getTitle());
		jobListingImpl.setDescription(jobListing.getDescription());
		jobListingImpl.setEmailAddress(jobListing.getEmailAddress());

		return jobListingImpl;
	}

	/**
	 * Finds the job listing with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the job listing to find
	 * @return the job listing
	 * @throws com.liferay.portal.NoSuchModelException if a job listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobListing findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the job listing with the primary key or throws a {@link com.liferay.portlet.employment.NoSuchJobListingException} if it could not be found.
	 *
	 * @param jobListingId the primary key of the job listing to find
	 * @return the job listing
	 * @throws com.liferay.portlet.employment.NoSuchJobListingException if a job listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JobListing findByPrimaryKey(long jobListingId)
		throws NoSuchJobListingException, SystemException {
		JobListing jobListing = fetchByPrimaryKey(jobListingId);

		if (jobListing == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + jobListingId);
			}

			throw new NoSuchJobListingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				jobListingId);
		}

		return jobListing;
	}

	/**
	 * Finds the job listing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job listing to find
	 * @return the job listing, or <code>null</code> if a job listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobListing fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the job listing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobListingId the primary key of the job listing to find
	 * @return the job listing, or <code>null</code> if a job listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JobListing fetchByPrimaryKey(long jobListingId)
		throws SystemException {
		JobListing jobListing = (JobListing)EntityCacheUtil.getResult(JobListingModelImpl.ENTITY_CACHE_ENABLED,
				JobListingImpl.class, jobListingId, this);

		if (jobListing == _nullJobListing) {
			return null;
		}

		if (jobListing == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				jobListing = (JobListing)session.get(JobListingImpl.class,
						Long.valueOf(jobListingId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (jobListing != null) {
					cacheResult(jobListing);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(JobListingModelImpl.ENTITY_CACHE_ENABLED,
						JobListingImpl.class, jobListingId, _nullJobListing);
				}

				closeSession(session);
			}
		}

		return jobListing;
	}

	/**
	 * Finds all the job listings where groupId = &#63;.
	 *
	 * @param groupId the group ID to search with
	 * @return the matching job listings
	 * @throws SystemException if a system exception occurred
	 */
	public List<JobListing> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<JobListing> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
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
	public List<JobListing> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<JobListing> list = (List<JobListing>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_JOBLISTING_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<JobListing>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public JobListing findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchJobListingException, SystemException {
		List<JobListing> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchJobListingException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public JobListing findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchJobListingException, SystemException {
		int count = countByGroupId(groupId);

		List<JobListing> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchJobListingException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public JobListing[] findByGroupId_PrevAndNext(long jobListingId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchJobListingException, SystemException {
		JobListing jobListing = findByPrimaryKey(jobListingId);

		Session session = null;

		try {
			session = openSession();

			JobListing[] array = new JobListingImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, jobListing, groupId,
					orderByComparator, true);

			array[1] = jobListing;

			array[2] = getByGroupId_PrevAndNext(session, jobListing, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobListing getByGroupId_PrevAndNext(Session session,
		JobListing jobListing, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOBLISTING_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(jobListing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JobListing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the job listings.
	 *
	 * @return the job listings
	 * @throws SystemException if a system exception occurred
	 */
	public List<JobListing> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<JobListing> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<JobListing> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<JobListing> list = (List<JobListing>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JOBLISTING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JOBLISTING;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<JobListing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<JobListing>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the job listings where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (JobListing jobListing : findByGroupId(groupId)) {
			jobListingPersistence.remove(jobListing);
		}
	}

	/**
	 * Removes all the job listings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (JobListing jobListing : findAll()) {
			jobListingPersistence.remove(jobListing);
		}
	}

	/**
	 * Counts all the job listings where groupId = &#63;.
	 *
	 * @param groupId the group ID to search with
	 * @return the number of matching job listings
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOBLISTING_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the job listings.
	 *
	 * @return the number of job listings
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_JOBLISTING);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the job listing persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.portlet.employment.model.JobListing")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<JobListing>> listenersList = new ArrayList<ModelListener<JobListing>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<JobListing>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(JobListingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = JobListingPersistence.class)
	protected JobListingPersistence jobListingPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_JOBLISTING = "SELECT jobListing FROM JobListing jobListing";
	private static final String _SQL_SELECT_JOBLISTING_WHERE = "SELECT jobListing FROM JobListing jobListing WHERE ";
	private static final String _SQL_COUNT_JOBLISTING = "SELECT COUNT(jobListing) FROM JobListing jobListing";
	private static final String _SQL_COUNT_JOBLISTING_WHERE = "SELECT COUNT(jobListing) FROM JobListing jobListing WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "jobListing.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jobListing.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JobListing exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JobListing exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JobListingPersistenceImpl.class);
	private static JobListing _nullJobListing = new JobListingImpl() {
			public Object clone() {
				return this;
			}

			public CacheModel<JobListing> toCacheModel() {
				return _nullJobListingCacheModel;
			}
		};

	private static CacheModel<JobListing> _nullJobListingCacheModel = new CacheModel<JobListing>() {
			public JobListing toEntityModel() {
				return _nullJobListing;
			}
		};
}