package com.liferay.portlet.employment;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.employment.service.JobListingLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author Calvin Keum
 */
public class EmploymentListPortlet extends MVCPortlet {

	public EmploymentListPortlet()
		throws SystemException{

		JobListingLocalServiceUtil.createHeaders();
	}

	public void setHeaders(
			ActionRequest request, ActionResponse response)
		throws Exception {

		String headerTitle = ParamUtil.getString(request, "headerTitle");
		String headerDescription = ParamUtil.getString(
			request, "headerDescription");

		JobListingLocalServiceUtil.addHeaders(headerTitle, headerDescription);
	}

}