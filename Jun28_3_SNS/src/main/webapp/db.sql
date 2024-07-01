create table jun28_member(
	m_id varchar2(15 char) primary key,
	m_pw varchar2(20 char) not null,
	m_name varchar2(10 char) not null,
	m_phone varchar2(12 char)not null,
	m_birth date not null, 
	m_img varchar2(200 char) not null
)

drop table jun28_member
select m_id, m_name, m_phone, m_birth, m_img  from JUN28_MEMBER where m_id='123'
select m_id,m_pw from jun28_member where m_id='dhwpfhr'
select * from jun28_member

create table jun28_post(
	p_no number (10) primary key,
	p_id varchar2 (15 char) not null,
	p_post varchar2 (200 char) not null,
	p_date timestamp not null
)

create sequence jun28_post_seq;
drop sequence jun28_post_seq;
drop table jun28_post


select * from JUN28_POST
insert into jun28_post values(jun28_post_seq.nextval,'1','abc',now())	

