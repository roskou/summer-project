drop database if exists tasksDB;
create database tasksDB character set latin1 collate latin1_spanish_ci;
use tasksDB;

create table if not exists STATUS(
                                     id bigint AUTO_INCREMENT,
                                     name varchar(50),
                                     description varchar (100),
                                     PRIMARY KEY(id)
);

create table if not exists USERS(
                                    id bigint AUTO_INCREMENT,
                                    name varchar(50),
                                    lastname varchar (50),
                                    email varchar (50),
                                    PRIMARY KEY(id)
);
create table if not exists tasks(
                                    id bigint AUTO_INCREMENT,
                                    user_id bigint,
                                    status_id bigint,
                                    title varchar(50),
                                    description varchar(50),
                                    date timestamp,
                                    PRIMARY KEY(id),
                                    FOREIGN KEY (user_id) REFERENCES users(id),
                                    FOREIGN KEY (status_id) REFERENCES status(id)
);

INSERT INTO STATUS VALUES(DEFAULT,"Delivered","Tarea entregada a cliente"),(DEFAULT,"In Process", "Tarea en fase de producción"),(DEFAULT,"Testing", "Fase de pruebas previa a la entrega"),(DEFAULT,"Idea", "Tarea sólo expuesta como idea");
INSERT INTO USERS VALUES(DEFAULT,"Oscar","Orellana","oorellana@gmail.com"),(DEFAULT,"Adrian","Hitos","hiitos80@gmail.com");
INSERT INTO TASKS VALUES(DEFAULT,1,1,"Entrega proyecto summer","Hibernacle, java, cli...","2020-09-01 00:00:01"),(DEFAULT,2,1,"Entrega proyecto summer","Hibernacle, java, cli...","2020-09-01 00:00:01"),(DEFAULT,2,3,"Entrega DDBB","Enfocado principalmente a DDBB","2020-09-01 00:00:01");
