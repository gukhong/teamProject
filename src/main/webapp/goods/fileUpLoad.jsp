<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="domain.goods.GoodsDAO"%>
<%@page import="domain.goods.dto.GoodsDTO"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//MultipartRequest 객체생성(request, 저장경로, 최대파일크기, 인코딩방식) <- request처럼 사용하기위한 과정
	
	String saveDirectory = application.getRealPath("/upload");// upload/big폴더의 경로 받기
	out.print(saveDirectory);
	int maxPostSize = 1024*1000;//최대사이즈
	

	//1. MultipartRequest 객체 생성
	MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8");
	
	//2. 새로운 파일명 생성 ex)dami.jpg ---> 현재날짜시간.jpg
	//보낸 파일명 fileName변수에 할당
	String fileName = mr.getFilesystemName("photo");//input name
	//파일 확장자 가지고 오기 exe변수에 다시 할당
	String exe = fileName.substring(fileName.lastIndexOf("."));
	//현재 날짜를 새로운 파일의 이름으로 하려한다. 
	String now = new SimpleDateFormat("yyyyMMdd_Hmss")
			.format(new Date());
	String newfileName = now + exe;
	
	//3.파일 이름을 변경하기 위해 사용 File.separator 파일경로 구분자 (ex /,\, 등)
	File oldFile = new File(saveDirectory+File.separator+fileName);
	File newFile = new File(saveDirectory+File.separator+newfileName);
	oldFile.renameTo(newFile); //파일이름이 같아지면 하나만 생성됨
	
	//4. 다른 input값 받기
	String writer = mr.getParameter("writer");
	String title = mr.getParameter("title");
	
	//5.DTO작성하기
	GoodsDTO dto = new GoodsDTO(); //dto작업후 작동
	/* dto.setTitle(title);
	dto.setWriter(writer);
	dto.setOfile(fileName);
	dto.setSfile(newfileName); */
	
	//6.DAO insert method호출
	GoodsDAO dao = new GoodsDAO(); //dao작업후 작동
	/* int result = dao.insert(dto);
	if(result==1){
		out.print("result : " + result);
	} */ 
%>