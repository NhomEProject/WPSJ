use master
go
create database Lab2
go
use Lab2
go
create table [Login]
(
	[user] varchar(50) primary key not null,
	[pass] varchar(50) not null
)
create table [product]
(
	id int identity primary key not null,
	name Nvarchar(100) not null,
	amout int not null,
	price float not null,
	[user] varchar(50),
	constraint FK_User foreign key ([user]) references [Login]([user])
)