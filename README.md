jdk17 // ORACLE (ver11) // Tomcat (ver9) //
라이브러리 (gson, jstl, lombok, ojdbc6, cos)
프로젝트명 : NO12

오라클 계정{
ID : NO12
PW : NO1234
}
create user NO12
identified by NO1234;
grant connect, resource to NO12;

패키징
java
	config
		- CharConfig				//한글깨짐 방지
		- DBConnection			//커넥션(생성자로 만듬)
		- ForbiddenUrlConfig		//jsp강제 입력방지(마지막에 구현)
	controller
		- GoodsController			//상품 컨트롤러
		- UserController			//회원 컨트롤러
		- ReviewController			//댓글 컨트롤러(우선순위 마지막)
        - BbsController
	service
		- GoodsService				//상품 서비스
		- UserService				//회원 서비스
		- ReviewService				//댓글 서비스(우선순위 마지막)
        - BbbsService	
	domain
		- goods
			- dto
				- GoodsDTO
			- GoodsDAO
		- user
			- dto
				- UserDTO
				- LoginReqDTO
				- JoinReqDTO
				- EditReqDTO
			- UserDAO
		- review
			- dto
				- ReviewDTO
			 - ReviewDAO
        - bbs
            - dto
                - BbsDTO
            BbsDAO
	utile
		- Script

오라클 테이블

회원테이블 // user_seq								// 시퀀스
create table user_info (
  idx number not null,								//회원 등록번호(시퀀스 넘버)
  userid varchar2(200) primary key,				//아이디
  userpass varchar2(200) not null,					//비밀번호
  username varchar2(200) not null,					//회원 이름
  registerdate date default sysdate not null		//회원가입일(기본-시스템 시간)
);

create sequence user_seq
increment by 1
start with 1
minvalue 1
nomaxvalue
nocycle
nocache
;

상품테이블 
create table book_info (								
  code varchar2(200),									//상품코드(이름_타입_발간(년도)) <- 사진 등록시 사용
  bookname varchar2(100),							//책이름
  booktype varchar2(50) not null,					//책타입(요리,소설,it, ... 등)
  bookprice number not null,						//책가격
  publisher varchar2(100)not null,					//출판사(예-한빛)
  author varchar2(100),								//작가(작가미상으로 null허용)
  stack number,											//재고
  publicationdate date,								//발간일
  registerdate date default sysdate not null,		//상품 등록일(기본-시스템 시간)
  smallcontent varchar2(200),						//간량한 설명
  detailcontent clob									//상세설명(summerNote)
);

질문게시판 테이블
create table bbs(
bbsid number primary key, 							//등록번호
bbstitle varchar2(50 byte), 							//제목
userid varchar2(20 byte), 							//사용자 아이디
bbsdate date  default sysdate not null, 			// 등록일
bbscontent varchar2(2048 byte), 					//내용
bbsavailable number									//삭제참조값
);
