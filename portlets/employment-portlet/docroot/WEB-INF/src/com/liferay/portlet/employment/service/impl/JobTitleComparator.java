package com.liferay.portlet.employment.service.impl;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.employment.model.JobListing;

/**
 * @author liferay
 */
public class JobTitleComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "title ASC";

	public static String ORDER_BY_DESC = "title DESC";

	public static String[] ORDER_BY_FIELDS = {"title"};

	public JobTitleComparator() {
		this(false);
	}

	public JobTitleComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		JobListing job1 = (JobListing)obj1;
		JobListing job2 = (JobListing)obj2;

		int value = job1.getTitle().toLowerCase().compareTo(
			job2.getTitle().toLowerCase());

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}