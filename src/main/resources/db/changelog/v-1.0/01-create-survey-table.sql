create table survey (
                       id int not null auto_increment,
                       title varchar(50) not null,
                       begin_date date not null,
                       end_date date not null,
                       activity bool,
                       primary key (id)
) engine=InnoDB

GO

