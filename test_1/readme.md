
## Spring 4 + MyBatis 3 + MariaDB 기반 게시판 ##
본 샘플은  Spring 5(4) + MyBatis 3 + MariaDB (Maven) 기반으로  게시판 샘플임.
2021-05-04 생성확인함.

###  board  ###
- http://127.0.0.1:8080/boardList
- List: 검색, 제목을 한 줄로 표시 ==> 페이징을 공통으로 
- Form: 필수입력, 수정/저장 서비스 하나로
- Read: 스크립트 실행 방지


### 개발 환경 ### 
    Programming Language - Java 1.8
    IDE - Eclipse Version: 2021-03 (4.19.0)
    DB - MariaDB  context-database.xml
       : DB Connection Pool HikariCP
    Framework - MyBatis, Spring (4.1.2.RELEASE -> 5.1.0.RELEASE)
    Build Tool - Maven
    
### 로그 ###
	Exclude Commons Logging in favor of SLF4j
	log4j2.xml
		로그의 편리한 처리를 위하여 손을 보았으며 DB SQL 문의 경우 처리를 원할하게 변경함.
	 
### DB ###
DB 의 경우 접속 정보를 알맞게 변경한다.
src > main > webapp > WEB_INF > spring > context-database.xml (알맞게 변경)

먼저 다음과 같은 테이블을 생성해야 한다.
 
    CREATE TABLE TBL_BOARD (
      BGNO INT(11),								-- 게시판 그룹번호
      BRDNO int(11) NOT NULL AUTO_INCREMENT,	-- 글 번호
      BRDTITLE varchar(255),						-- 글 제목
      BRDWRITER varchar(20),						-- 작성자
      BRDMEMO   varchar(4000),					-- 글 내용
      BRDDATE	datetime,							-- 작성일자
      BRDHIT INT,									-- 조회수
      BRDDELETEFLAG CHAR(1),						-- 삭제 여부
      PRIMARY KEY (BRDNO)
    ) ;

### 나머지 설정 ###
	\board\src\main\webapp\spring 폴더에 있는 context-*.xml에서 설정추가
	
### 실행 ###
	http://127.0.0.1:8080
	http://127.0.0.1:8080/boardList





