create table public.tblusers(
 id serial primary key,
 name varchar(30) not null,
 username varchar(30)not null,
 email varchar(50) not null,
 password varchar(50) not null
);

create table public.tblroles(
id serial primary key,
name varchar(50) not null,
userid int ,
foreign key(userid) references public.tblusers(id)
);
create  table public.userroles(
id serial primary key,
userid int ,
roleid int,
foreign key(userid)
references public.tblusers(id),
foreign key (roleid)
references public.tblroles(id)

);

create table public.tblrolepermisions(
id serial primary key,
roleid int ,
permistion varchar(50) not null,
foreign key(roleid)
references public.roles(id)
);

create table public.tblorganizations(
id serial primary key,
name varchar(100) not null,
description varchar(200),
address varchar(400)
)
create table public.tblbraches(
id serial primary key,
name varchar(50),
description varchar(200),
organizationid int
foreign key(organizationid) references public.tblorganizations(id)
);

create table public.tbldepartments(
id  serial primary key,
name varchar(50) not null,
description varchar(200),
branchid int,
foreign key(branchid) references public.tblbraches(id)
);
create table public.staffs(
id serial primary key,
firstname varchar(50) not null,
middlename varchar(50) ,
lastname varchar(50) not null,
departimentid int,
organizationId int,
salary bigint ,
address varchar(400),
birthdate date,
age int
type int not null,
gender int not null,
foreign key(departimentid) references public.tbldepartments(id),
foreign key(organizationId) references public.tblorganizations(id)
);

create table public.tblstandards(
id serial primary key,
name varchar (50) notnull,
);
create table public.tblclasses(
id serial primary key,
name varchar (50) not null,
standardid int ,
foreign key(standardid) references  public.tblstandards(id)
);

create table public.tblstudents(
id serial primary key,
firstname varchar(50) not null,
middlename varchar(50) ,
lastname varchar(50) not null,
address varchar(400),
organizationId int,
gender int not null,
birthdate date,
age int
currentstandardid int,
currentclassId int,
foreign key(currentstandardid) references  public.tblstandards(id),
foreign key(currentclassId) references  public.tblclasses(id),
foreign key(organizationId) references public.tblorganizations(id)

)

create table public.tblsubjects(
id serial primary key,
name varchar (50) not null,
description varchar(200),
)

create table tblstaffsubjects(