<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script>
	$(function(){
		$("#setID").on("click",function(){
			//회원가입 폼에 아이디 셋팅   window.open()하는 창은 부모창 opener.documetn.getElementById("")는 자식창으로 부모창의 변수를 불러온다.
			opener.document.getElementById("userid").value = $("#chkId").text(); //signup.jsp 의 밸류값변경
			opener.document.getElementById("idChkStatus").value = "Y";
			//현재창 닫기
			self.close(); //window.close();   
		});
	});
	function check(){
		if($("#userid").text()==""){
			$("#usable").text("You need double-check")
		}
		var userid= $("#userid").val();
		var regId = /^[a-zA-z]{1}\w{6,11}$/;
		var regidResult = regid.test(userid);	
		if(regidResult){
			$("#usable").text(userid);
		}
		
	}
</script>
</head>
<body>
	<div class="container">
	
		
		<hr/>
		Insert ID and Push double-check Button.<br/>
		<form method="post" action="<%=request.getContextPath()%>/signup/idCheck.do" onsubmit="check()"><!--  여기서 커맨드 다시 여기 -->
			ID: <input type="text" name="userid" id="userid"/>
			    <input type="submit" value="Double-Check" id="doublechk" style="background:#0056B3;color:white;border-style:outset;font-size:15px;cursor:pointer"/> <!-- 서브밋버튼 -->
		</form>
		<hr/>
		<c:if test="${cnt>0}"><!-- 사용 불가능한 아이디 일때 -->
		<div id=unusable><span style="color:blue" id="chkId">${userid}</span> has already been Taken.</div>
			
		</c:if>
		
		<c:if test="${cnt<=0}"><!-- 사용 가능한 아이디 일때 -->
			<div id=usable><span style="color:blue" id="chkId">${userid}</span> is Usable ID</div>
			<input type="button" value="USE THIS ID" id="setID" style="background:#0056B3;color:white;border-style:outset;font-size:15px;cursor:pointer"/>
		</c:if>
		
		<c:if test="${userid==''}"><!-- 아이디 입력 없을때 -->
			"Insert ID Please"
		</c:if>
		<hr/>
	</div>
</body>
</html>
