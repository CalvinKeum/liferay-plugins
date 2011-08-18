<%--
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
--%>
<%@ include file="/html/init.jsp" %>

<%
ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
long scopeGroupId = themeDisplay.getScopeGroupId();
%>

<liferay-portlet:actionURL name="addJobListing" var="addJobListingURL" />

<form method="post" name="<portlet:namespace />fm"  action="<%=addJobListingURL%>">
	<aui:fieldset>
		<aui:input label="Job Title" name="title" type="text" />

		<aui:field-wrapper label="Job Description">
			<liferay-ui:input-editor name="description" editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" />
		</aui:field-wrapper>

		<aui:input label="Email Resumes To" name="emailAddress" type="text" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" name="Add Job" />
	</aui:button-row>
</form><hr/><br/>

<div class="left">
	<p>Job Listings:</p>
</div>

<aui:layout>
	<aui:column id="jobListing-dynamic-content">
		<liferay-ui:search-container
			delta="10"
			emptyResultsMessage="No Job Listings">

			<liferay-ui:search-container-results
				results="<%= JobListingLocalServiceUtil.getJobListingByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
				total="<%= JobListingLocalServiceUtil.getJobListingCountByGroupId(scopeGroupId) %>" 
				/>

				<liferay-ui:search-container-row

				className="com.liferay.portlet.employment.model.JobListing"
				keyProperty="jobListingId" modelVar="jobListing">

				<liferay-ui:search-container-column-text name="Job Title"
					property="title" 
				/>

				<liferay-ui:search-container-column-jsp align="right"
					path="/html/admin/jobListing_actions.jsp" 
				/>
				</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</aui:column>
</aui:layout>

<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.default";
%>