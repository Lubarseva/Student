use university

set names 'utf8';

insert into student (fullName, faculty, date, sex)
values ('Иванов Иван', 'Математические', '1989-03-03',true);
insert into student (fullName, faculty, date, sex)
values ('Петров Петя', 'Математический', '1989-09-03',true);
insert into student (fullName, faculty, date, sex)
values ('Сидоров Вася', 'Физический', '1991-09-03',true);
insert into student (fullName, faculty, date, sex)
values ('Петрушкина Юля', 'Физический', '1994-09-03',false);

insert into subject (subj)
values ('Математика');
insert into subject (subj)
values ('Химия');
insert into subject (subj)
values ('Английский');

insert into test (subjectId, studentId, mark)
values ('1','2','9');
insert into test (subjectId, studentId, mark)
values ('1','1','3');
insert into test (subjectId, studentId, mark)
values ('2','3','8');
insert into test (subjectId, studentId, mark)
values ('2','4','3');
insert into test (subjectId, studentId, mark)
values ('3','2','9');
