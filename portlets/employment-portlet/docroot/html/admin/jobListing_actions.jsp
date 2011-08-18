<%@include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

JobListing jobListing = (JobListing) row.getObject();

long groupId = jobListing.getGroupId();

String name = JobListing.class.getName();

long jobListingId = jobListing.getJobListingId();
%>

<liferay-ui:icon-menu>
		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage"
				value="/html/admin/edit_jobListing.jsp" />
			<portlet:param name="jobListingId"
				value="<%= String.valueOf(jobListingId) %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

		<portlet:actionURL name="deleteJobListing" var="deleteURL">
			<portlet:param name="jobListingId"
				value="<%= String.valueOf(jobListingId) %>" />
		</portlet:actionURL>

		<liferay-ui:icon image="delete" url="<%= deleteURL.toString() %>" />
</liferay-ui:icon-menu>