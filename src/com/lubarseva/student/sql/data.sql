USE university;
set names 'utf8';

insert into student (fullName, faculty, date, sex)
values ('������ ����', '��������������', '1989-03-03','1');
insert into student (fullName, faculty, date, sex)
values ('������� ���������', '��������������', '1989-09-03','1');
insert into student (fullName, faculty, date, sex)
values ('������ ����', '����������', '1991-09-03','1');
insert into student (fullName, faculty, date, sex)
values ('�������� ����', '����������', '1994-09-03','0');

insert into subject (subj)
values ('����������');
insert into subject (subj)
values ('�����');
insert into subject (subj)
values ('����������');

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



