create table jun28_member(
	m_id varchar2(15 char) primary key,
	m_pw varchar2(20 char) not null,
	m_name varchar2(10 char) not null,
	m_phone varchar2(12 char)not null,
	m_birth date not null, 
	m_img varchar2(200 char) not null
)
drop table jun28_member
select * from JUN28_MEMBER
select m_id,m_pw from jun28_member where m_id='dhwpfhr'