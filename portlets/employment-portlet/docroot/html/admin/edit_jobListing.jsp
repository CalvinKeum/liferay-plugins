<%@include file="/html/init.jsp" %>

<%
JobListing jobListing = null;

long jobListingId = ParamUtil.getLong(request, "jobListingId");

String content = StringPool.BLANK;

if (jobListingId > 0) {
	jobListing = JobListingLocalServiceUtil.getJobListing(jobListingId);
	content = jobListing.getDescription();
}
%>

<portlet:actionURL name="updateJobListing" var="updateJobListingURL" />

<aui:form action="<%= updateJobListingURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="jobListingId" value="<%= jobListingId %>" />

		<aui:input label="Job Title" name="title" type="text" value="<%= jobListing.getTitle() %>" />

		<aui:field-wrapper label="Job Description">
			<liferay-ui:input-editor name="description" editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" />
		</aui:field-wrapper>

		<aui:input label="Email Resumes To:" name="emailAddress" type="text" value="<%= jobListing.getEmailAddress() %>" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" name="Save" />

		<input type=button value="Cancel" onClick="javascript:window.history.go(-1)">
	</aui:button-row>
</aui:form>

<aui:script>
	function <portlet:namespace />initEditor() {
		return "<%= UnicodeFormatter.toString(content) %>";
	}
</aui:script>

<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.default";
%>