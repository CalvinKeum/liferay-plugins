<%
	/*
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
%>

<%@include file="/html/init.jsp" %>

<%
ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
long scopeGroupId = themeDisplay.getScopeGroupId();
JobListing intro = JobListingLocalServiceUtil.getJobListing(0);
%>

<h1 class="header-title">
	<%= intro.getTitle() %>
</h1>
	
<div class="header-description">
	<%= intro.getDescription() %>
</div>

<ul class="header-job-listings">

<%
List<JobListing> jobListings = JobListingLocalServiceUtil.getJobListingByGroupId(scopeGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
for (JobListing jobListing : jobListings) {
	String anchor = "#" + jobListing.getJobListingId();
	%>

	<li>
		<span><a href="<%= anchor %>"><%= jobListing.getTitle() %></a></span>
	</li>

	<%
}
%>

</ul>

<aui:layout id="employmentlist-dynamic-content">
	<liferay-ui:search-container
		delta="10"
		emptyResultsMessage="No Job Listings"
	>
		<liferay-ui:search-container-results
			results="<%= JobListingLocalServiceUtil.getJobListingByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
			total="<%= JobListingLocalServiceUtil.getJobListingCountByGroupId(scopeGroupId) %>"
		/>
			<liferay-ui:search-container-row
				className="com.liferay.portlet.employment.model.JobListing"
				keyProperty="jobListingId"
				modelVar="jobListing"
			>
				<liferay-ui:search-container-column-text>
					<div>
						<a name="<%= jobListing.getJobListingId() %>"></a>
						<h2 class="job-title"><%= jobListing.getTitle() %></h2>

						<p><%= jobListing.getDescription() %></p>
						<p class="job-email-address">Please send your resume to <a href="<%= JobListingLocalServiceUtil.getEmailAddressCharCode(jobListing.getJobListingId()) %>"><%= jobListing.getEmailAddress() %></a> to apply.</p>
					</div>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:layout>