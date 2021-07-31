

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
create  table public.tbluserroles(
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
name varchar(50) not null,
foreign key(roleid)
references public.tblroles(id)
);


