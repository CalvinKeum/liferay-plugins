package com.liferay.portlet.employment;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.employment.model.JobListing;
import com.liferay.portlet.employment.model.impl.JobListingImpl;
import com.liferay.portlet.employment.service.JobListingLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author Calvin Keum
 */
public class EmploymentPortlet extends MVCPortlet {

	public void addJobListing(ActionRequest request, ActionResponse response)
		throws Exception {

		String jobTitle = ParamUtil.getString(request, "title");
		String jobDescription = ParamUtil.getString(request, "description");
		String emailAddress = ParamUtil.getString(request, "emailAddress");

		if (validateJobListing(jobTitle, jobDescription, emailAddress)) {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

			long groupId = themeDisplay.getScopeGroupId();
			long companyId = themeDisplay.getCompanyId();
			long userId = themeDisplay.getUserId();

			JobListingLocalServiceUtil.addJobListing(
				jobTitle, jobDescription, emailAddress, userId, groupId,
				companyId);
		}
		else {
			response.setRenderParameter("jspPage", "/html/admin/view.jsp");
		}
	}

	public void deleteJobListing(ActionRequest request,
			ActionResponse response) throws Exception {

		long jobListingId = ParamUtil.getLong(request, "jobListingId");

		JobListingLocalServiceUtil.deleteJobListing(jobListingId);
	}
	
	private JobListing jobListingFromRequest(PortletRequest request) {

		JobListingImpl jobListing = new JobListingImpl();

		jobListing.setJobListingId(ParamUtil.getLong(request,"jobListingId"));
		jobListing.setTitle(ParamUtil.getString(request, "title"));
		jobListing.setDescription(ParamUtil.getString(request, "description"));

		return jobListing;
	}

	public void updateJobListing(
			ActionRequest request, ActionResponse response)
		throws Exception {
		
		long jobListingId = ParamUtil.getLong(request, "jobListingId");
		String jobTitle = ParamUtil.getString(request, "title");
		String jobDescription = ParamUtil.getString(request, "description");
		String emailAddress = ParamUtil.getString(request, "emailAddress");
		
		System.out.println("INSIDE");
		System.out.println("jobListingId: " + jobListingId);
		System.out.println("title: " + jobTitle);
		System.out.println("description: " + jobDescription);
		System.out.println("emailAddress: " + emailAddress);
		//FIND out why its not updating... probably empty inputs...
		
		if (validateJobListing(jobTitle, jobDescription, emailAddress)) {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

			long groupId = themeDisplay.getScopeGroupId();
			long userId = themeDisplay.getUserId();
			long companyId = themeDisplay.getCompanyId();
			
			System.out.println("jobListingId:" + jobListingId);
			if (jobListingId == 0) {
				// add
				System.out.println("ADDING NEW");
				

					JobListingLocalServiceUtil.addJobListing(
						jobTitle, jobDescription, emailAddress, userId, groupId,
						companyId);
				}
			else {
				// update
				System.out.println("UPDATING EXISTING");
					System.out.println("jobListingId:" + jobListingId);
					JobListing jobListing = 
						JobListingLocalServiceUtil.getJobListing(jobListingId);

					jobListing.setTitle(jobTitle);
					jobListing.setDescription(jobDescription);
					jobListing.setEmailAddress(emailAddress);
					jobListing.setUserId(userId);
					jobListing.setGroupId(groupId);
					jobListing.setCompanyId(companyId);
					JobListingLocalServiceUtil.updateJobListing(jobListing);
				}
		}
		else {
			response.setRenderParameter("jspPage", "/html/admin/view.jsp");
		}
	}
	
	public static boolean validateJobListing(
		String jobTitle, String jobDescription, String emailAddress) {

		if (Validator.isNull(jobTitle)) {
			return false;
		}

		if (Validator.isNull(jobDescription)) {
			return false;
		}

		if (Validator.isNull(emailAddress)) {
			return false;
		}

		return true;
	}

}