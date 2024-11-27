## To run with Docker-Compose:
- run `docker-compose up` command
- run PG Admin on: http://localhost:5050
- configure new server:
    - name: postgres-local-docker
    - connection:
        - host name: pg-docker
        - port: 5432
        - maintenance: bookstore
        - username: postgres
        - password: 1234567

## Add data to test book controller
```
create table tb_author (uuid uuid not null, name varchar(255) not null unique, primary key (uuid));
create table tb_book (publisher_id uuid, uuid uuid not null, title varchar(255) not null unique, primary key (uuid));
create table tb_book_author (author_id uuid not null, book_id uuid not null, primary key (author_id, book_id));
create table tb_publisher (uuid uuid not null, name varchar(255) not null unique, primary key (uuid));
create table tb_review (book_id uuid unique, uuid uuid not null, comment varchar(255) not null, primary key (uuid));

alter table if exists tb_book add constraint FKnirnq5sunln2aixln0wfrlx1o foreign key (publisher_id) references tb_publisher;
alter table if exists tb_book_author add constraint FKbo2nc1syneieprfficcl25yvq foreign key (author_id) references tb_author;
alter table if exists tb_book_author add constraint FK3w593lyk61mg3qgo60se015v4 foreign key (book_id) references tb_book;
alter table if exists tb_review add constraint FKp5tb2jvweeb394ipb13b1my8v foreign key (book_id) references tb_book;

insert into tb_publisher values(gen_random_uuid(), 'ALTA BOOKS');
insert into tb_publisher values(gen_random_uuid(), 'PEARSON');

insert into tb_author values(gen_random_uuid(), 'ERIC EVANS');
insert into tb_author values(gen_random_uuid(), 'PAUL DEITEL');
insert into tb_author values(gen_random_uuid(), 'HARVEY DEITEL');
```