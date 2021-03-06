<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>board3</title>
<script>
function fn_formSubmit(){
	var form1 = document.form1;
	
	if (form1.brdwriter.value=="") {
		alert("작성자를 입력해주세요.");
		form1.brdwriter.focus();
		return;
	}
	if (form1.brdtitle.value=="") {
		alert("글 제목을 입력해주세요.");
		form1.brdtitle.focus();
		return;
	}
	if (form1.brdmemo.value=="") {
		alert("글 내용을 입력해주세요.");
		form1.brdmemo.focus();
		return;
	}
	document.form1.submit();	
} 
</script>
</head>
<body>
	<form name="form1" action="board3Save" method="post">
		<table border="1" style="width:600px">
			<caption>게시판</caption>
			<colgroup>
				<col width='15%' />
				<col width='*%' />
			</colgroup>
			<tbody>
				<tr>
					<td>작성자</td> 
					<td><input type="text" name="brdwriter" size="20" maxlength="20" value="<c:out value="${boardInfo.brdwriter}"/>"></td> 
				</tr>
				<tr>
					<td>제목</td> 
					<td><input type="text" name="brdtitle" size="70" maxlength="250" value="<c:out value="${boardInfo.brdtitle}"/>"></td> 
				</tr>
				<tr>
					<td>내용</td> 
					<td><textarea name="brdmemo" rows="5" cols="60"><c:out value="${boardInfo.brdmemo}"/></textarea></td> 
				</tr>
			</tbody>
		</table>    
		<input type="hidden" name="brdno" value="<c:out value="${boardInfo.brdno}"/>">
		<a href="#" onclick="history.back(-1)">돌아가기</a> 
		<a href="#" onclick="fn_formSubmit()">저장</a>
	</form>	
</body>
</html>
