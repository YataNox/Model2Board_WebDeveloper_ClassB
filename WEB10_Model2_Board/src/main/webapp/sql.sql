create table board(
	num number(5) primary key,
	pass varchar2(30), -- 게시물 수정 삭제를 위한 비밀번호
	name varchar2(30),
	email varchar2(30),
	title varchar2(50),
	content varchar2(1000),
	readcount number(4) default 0,
	writedate date default sysdate
);

create sequence board_seq start with 1 increment by 1;

insert into board(num, name, email, pass, title, content)
values(board_seq.nextVal, 'hong', 'abc@naver.com', '1234', '첫방문입니다.', '반갑습니다. 앞으로 많은 격려와 지도편달 부탁드립니다.');

insert into board(num, name, email, pass, title, content)
values(board_seq.nextVal, 'somi', 'addd@naver.com', '1234', '게시판 개설', '축하드립니다. 무궁한 발전을 기원할게요.');

insert into board(num, name, email, pass, title, content)
values(board_seq.nextVal, 'light', 'bnbn@naverc.om', '1234', '돼지골마을', '돼지 삼겹살이 맛있습니다.');

insert into board(num, name, email, pass, title, content)
values(board_seq.nextVal, 'hana', 'hana@daum.net', '1234', '2021년 겨울', '몹시 추울 것 같아요... 다들 건강 유의하세요.');

insert into board(num, name, email, pass, title, content)
values(board_seq.nextVal, 'hana', 'hana@daum.net', '1234', '코로나바이러스', '사회적 거리두기 2단계.... 백신접종 등등등');

select * from BOARD;