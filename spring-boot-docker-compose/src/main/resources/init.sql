if not exists (select * from sysobjects where name='BLOG' and xtype='U')
create table BLOG
(
	slug varchar(50) primary key,
	title nvarchar(255),
	body nvarchar(max),
	updatedAt datetime2 not null
);
