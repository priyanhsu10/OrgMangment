
create table public.tblorganizations(
id serial primary key,
name varchar(100) not null,
description varchar(200),
address varchar(400)
);

create table public.tblbraches(
id serial primary key,
name varchar(50),
description varchar(200),
organizationid int,
foreign key(organizationid) references public.tblorganizations(id)
);
create table public.tblsubjects(
id serial primary key,
name varchar (50) not null,
description varchar(200)
);
create table public.tblstandards(
id serial primary key,
name varchar (50) not null
);
create table public.tblclasses(
id serial primary key,
name varchar (50) not null,
standardid int ,
foreign key(standardid) references  public.tblstandards(id)
);
create table public.tbldepartments(
id  serial primary key,
name varchar(50) not null,
description varchar(200),
branchid int,
organizationid int,
foreign key(organizationid) references public.tblorganizations(id),
foreign key(branchid) references public.tblbraches(id)
);
create table public.tblstaffs(
id serial primary key,
firstname varchar(50) not null,
middlename varchar(50) ,
lastname varchar(50) not null,
departmentid int,
organizationId int,
salary bigint ,
address varchar(400),
birthdate date not null,
age int,
type int ,
gender int not null,
foreign key(departmentid) references public.tbldepartments(id),
foreign key(organizationId) references public.tblorganizations(id)
);

create table public.tblstudents(
id serial primary key,
firstname varchar(50) not null,
middlename varchar(50) ,
lastname varchar(50) not null,
address varchar(400),
organizationId int,
gender int,
birthdate date not null,
age int,
currentstandardid int,
currentclassId int,
foreign key(currentstandardid) references  public.tblstandards(id),
foreign key(currentclassId) references  public.tblclasses(id),
foreign key(organizationId) references public.tblorganizations(id)
);

create table public.lnkstaffsubjects(
id serial primary key,
staffid int,
subjectid int,
foreign key(staffid) references public.tblstaffs(id),
foreign key(subjectid) references public.tblsubjects
);
create table public.lnkstandardsubject(
id serial primary key,
standardid int,
subjectid int,
foreign key(standardid) references public.tblstandards(id),
foreign key(subjectid) references public.tblsubjects(id)
)

