create table author_tb(
    id UUID NOT NULL,
    name varchar(80) not null,
    age integer not null,
    email varchar(80) not null unique,
    neighborhood varchar(80) not null,
    street varchar(80) not null,
    number varchar(80) not null,
    totalLoanedBooks INTEGER not null,
    PRIMARY KEY(id)
);

create table book_tb(
    id UUID not null,
    name varchar(80) not null,
    category varchar(30) not null,
    quantity integer not null,
    publishedYear date not null,
    value decimal(10,2) not null,
    available BOOLEAN not null,
    PRIMARY KEY (id)
);

create table book_author(
    book_id UUID not null,
    author_id UUID not null,
    primary key (book_id, author_id),
    foreign key (book_id) references book_tb(id),
    foreign key (author_id) references author_tb(id)
);

create table client_tb(
    id UUID not null,
    name varchar(80) not null,
    neighborhood varchar(80) not null,
    street varchar(80) not null,
    number varchar(80) not null,
    phoneNumber varchar(80) not null,
    balance decimal(10,2) not null,
    totalLoanedBooks INTEGER not null,
    totalFines decimal(10,2) not null,
    activeStatus BOOLEAN not null,
    registrationDate date not null,
    primary key (id)
);

create table bookloan_tb(
    id UUID not null,
    loanDate date not null,
    returnDate date not null,
    totalValue decimal(10,2) not null,
    client_id UUID not null,
    book_id UUID not null,
    primary key (id),
    foreign key (client_id) references client_tb(id),
    foreign key (book_id) references book_tb(id)
);