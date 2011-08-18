<%@include file="/html/init.jsp" %>

<%
JobListing app = JobListingLocalServiceUtil.getJobListing(0);
String content = app.getDescription();
%>

<liferay-portlet:actionURL name="setHeaders" var="headerURL" />

<portlet:actionURL name="updateJobListing" var="updateJobListingURL" />

<aui:form action="<%= headerURL %>" method="POST" name="<portlet:namespace />fm">
	<aui:fieldset>
		<aui:input label="Header Title" name="headerTitle" type="text" value="<%= app.getTitle() %>" />

		<aui:field-wrapper label="Header Description">
			<liferay-ui:input-editor name="headerDescription" editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" />
		</aui:field-wrapper>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" name="Save" />
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