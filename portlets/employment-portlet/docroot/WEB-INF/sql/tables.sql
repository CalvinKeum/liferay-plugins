create table Employment_Application (
	applicationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	headerTitle VARCHAR(75) null,
	headerDescription STRING null,
	jobListingId LONG
);

create table Employment_JobListing (
	jobListingId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	description STRING null,
	emailAddress VARCHAR(75) null
);