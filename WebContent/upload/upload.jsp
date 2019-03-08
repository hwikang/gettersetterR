<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Setter Upload Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<style>
	.border{border:1px solid white !important}
	.list-group{width:90%}
	.list-group-item{border:1px solid white; border-bottom:1px solid lightgray;}
	body{margin-Top:50px; font-size:0.9em; font-family: 'Montserrat', sans-serif;}
	#nameTag{width:100%; height:100px; margin-bottom:10px} /* 화면상단 */
		#nameTag>a>img{width:300px; height:100px;} /* 로고사이즈 */
		#nameTag>ul>li{padding:0px; text-align:center}
	#myInfo img{width:50px; height:50px;}
	.nav-link{color:black;}
	.nav-link:hover{font-weight:bolder;}
		
	#editProfile{width:100%; background:#eee; padding-top:10px; display:none} /* 강사소개 */
		#profileName{margin:7px 0px 20px 0px} /* 강사소개 name */
		#editProfile>input[type=checkbox]{margin:7px 2px 20px 10px;} /* 강사소개 subject 체크박스 */
		#profileTxt{width:80%; height:140px; margin:7px 0px;} /* 강사소개 TextArea */
		#editProfile button{position:relative; top:-18px} /* 강사소개 '완료'버튼 */
	#listTitle{border-bottom:1px solid #ddd; margin:40px 0px; padding-top:5px} /* 강의리스트 라벨 */
	#listTitle>img{width:140px; height:30px}
	
	#load{float:left; height:400px; text-align:center}/* 업로드 */
	#load>a>img{position:relative; margin:auto} /* 업로드 이미지 */
	#load>a:nth-child(2)>img{margin:20px 0px 0px 0px} /* 클릭 유도 이미지 */
	
	ul, li{margin:0px; padding:0px}
	#list{float:left; margin:auto}
	#list>ul>li>div>div:first-child, #list>ul>li>div>a>img {float:left} /* 강의리스트>강의이미지,제목,목차 */
	#list>ul>li>div>div{position:relative; left:20px; margin:auto} /* 강의리스트>제목, 목차 */
	#list>ul>li>div>div:nth-child(2){width:100%; height:30px; font-size:1.2em;} /* 강의리스트>제목 */
	#list>ul>li>div>div:nth-child(3){width:45%; float:left;}
	#list>ul>li>div>div:nth-child(4){width:10%; float:left; text-align:left}
	#list>ul>li>div>div>button{position:relative; left:-14px; top:7px} /* 강의리스트 '더보기'버튼 */
	#list>ul>li>div>a>img{width:180px; height:140px; margin:auto} /* 강의리스트 썸네일 */
	/* #list>ul>li>div>img{position:absolute; width:40px; height:40px; left:170px; top:110px} /* 강의리스트 썸네일 '플레이' 이미지 */
	
	/* upload 모달 */
	.proFrm{position:relative; width:100%; height:300px; border:1px solid #eee}
	#proImgUpload{position: absolute; left:-9999px;}
	
	.proImg{width:50%; cursor:pointer; border:0px solid white; position:relative; top:130px}
	#proImgBtn{width:100px;	height:30px; line-height:1; margin-top:5px; cursor:pointer; font-size:0.8em;}
	
	/* content2 */
	#content2{font-size:1.3em ;}
	#content2>div>img{width:140px; height:29px; margin:0px 10px; opacity:0.8;}
	#content2>div{padding:10px 0px;}
	#graph{text-align:center}
	#graph>img{position:relative; width:50%; text-align:center}
	
	/* 회사정보 */
	#footer>div{width:100%; height:100px; float:right;}
		#myAcorn img{
		width:20px;
		height:20px;
	}
</style>
<script>
	$(function(){
		/* 강사소개 버튼 */
		$("#editProfileButton").click(function(){
			$("#editProfile").css("display","block");
			$("#editProfileButton").css("display","none");
		});
		
		/* 강사소개 'teaching subject' 첫번째 체크박스 */
		$("#Bodybuild").css("margin","0px 2px 0px 0px");
		
		/* 강사소개(완료) 버튼 */
		$("#editProfile button").click(function(){
			$("#editProfile").css("display","none");
			$("#editProfileButton").css("display","block");
		});
		
		/* 강의 리스트 */
		$("#list>ul>li>div").css("width","100%").css("height","150px")
		 .css("float","left");
		
		/* 두번째 컨텐츠 */
		$("#content2").css("width","100%").css("float","right").css("border-top","1px solid lightgray")
		 .css("margin","15px 0px 0px 0px");
		
		$("#content2>div:nth-child(2)").css("position","relative").css("left","20px");
		
		/* upload 모달 */
		var readURL = function(input) { //프로필 이미지 input 경로 변경
	        if (input.files && input.files[0]) {
	            var reader = new FileReader();
	            reader.onload = function (e) {
	                $('.avatar').attr('src', e.target.result);
	            }
	            reader.readAsDataURL(input.files[0]);
	        }
	    }
		$(".file-upload").on('change', function(){
	        readURL(this);
	    });
		
		$('.proImg').on('click', function() {
	        $('#proImgUpload').click();
	    });
		
		/* if(localStorage.getItem("id")==none){
			$("#myInfo>a>img").attr("src","../img/profile.jpg");
		}else{
			$("#myInfo>a>img").attr("src",localStorage.getItem("id"));
		} */
		
		$(document).on("click","#logOut",function(){
			localStorage.setItem("loginMode","guest");

	
		});		
	});
</script>
</head>
<body>
<nav class="navbar">
	<div id="nameTag" class="row">
		<a href="main.html" class="col-4 p-0"><img src="../img/logo.jpg"></a> <!-- 로고 -->
		<div class="col-1 col-xl-3 p-0"></div>		
		<ul class="nav justify-content-end col-12 col-md-6 col-xl-4 p-0 row align-items-center"> 
			<li class="nav-item col-2"><a href="main.html" class="nav-link">getter</a></li>
			<li class="nav-item col-2"><a href="main_setter.html" class="nav-link">setter</a></li>
			<li class="nav-item col-2"><a href="#" class="nav-link" data-toggle="modal" data-target="#uploadModal">upload</a></li> 
			<li id="myAcorn" class="d-flex" >
						<img src="../img/acorn.png" class="p-0"/>
						<p class="p-0"></p>
					</li>		
			<li id="myInfo" class="nav-item col-2">
				<a href="#" class="nav-link" data-toggle="popover" 
				data-placement="left" data-title="My Info" 
				data-popover-content="#myInfoPopover"><img src="../img/profile.jpg" class="rounded-circle" id="profile"></a>
			</li>
		</ul>
	
	</div>
</nav><br/><br/>

<!-- myinfo popover -->
<div id="myInfoPopover" style="display:none" >
	<ul class="nav row">
		<li class="nav-item col-12"><a href="my_profile_html" class="nav-link">My Profile</a>
		<li class="nav-item col-12"><a href="main.html"  class="nav-link" id="logOut">LogOut</a>
		<li class="nav-item col-12"><a href="payment.html"  class="nav-link" id="buyAcorn">Buy Acorn</a>
		<li class="nav-item col-12" ><a href="main.html" class="nav-link getterMode">Getter Mode</a>
	</ul>
</div>


<!-- 첫번째 콘텐츠 -->
<div id="content" >
	<!-- profile -->
	
	<br/>
	<input type="button" id="editProfileButton" value="edit profile" class="btn btn-primary btn-sm" style="position:relative; left:10px">
	<div id="editProfile" class="container-fluid">
		<form action="<%=request.getContextPath()%>/upload/introUpdate.do" method="post" enctype="multipart/form-data">
			<b>Intro Video</b><br/>
			<input type="file" id="introVideo" name="filename"/><br/>
			<b>Name</b><br/>
			<input type="text" id="profileName" name="userid" readonly value="${vo.userid }" maxlength="20"><br/>
			<b>Teaching Subject</b><br/>
			<c:forTokens var="ts" items="Acting,Art,Bodybuild,Climbing,Dancing,Economy,History,Philosophy,Soccer" delims=",">
				<input type="checkbox" id="${ts }" name="interest" value="${ts }"
					<c:forTokens var="ss" items="${vo.interestStr }" delims="/">
						<c:if test="${ts==ss}">
							checked
						</c:if>
					</c:forTokens>
				/>${ts }
			</c:forTokens><br/>
			<b>Your Profile</b><br/>
			<textarea id="profileTxt" name="description" maxlength="500" >${vo.description}</textarea>
			<input type="submit" class="btn btn-primary btn-sm" value="done"/>	
		</form>
	</div>
	
	<!-- 'lessons' 라벨 -->
	<div id="listTitle">
		<img src="../img/lessons.jpg">
	</div>
	
	<!-- 업로드 -->
	<div class="row">
		<div id="load" class="col-lg-7 row">
			<a href="#" class="col-sm-12 justify-content-center"><img src="../img/upload2.jpg" data-toggle="modal" data-target="#uploadModal"></a>
		</div>
		<!-- 강의 리스트 -->
		<div id="list" class="col-lg-5">
			<ul class="list-group">
				<li class="list-group-item">
					<div>
						<a href="contentOp_01.html"><img src="../img/actingThumb1.jpg"></a>
						<div><b>Class for Action</b></div>
						<div>
							<div><a href="#">ch1. intro</a></div>
							<div><a href="#">ch2. Action plan</a></div>
							<div><a href="#">ch3. Action plan(2)</a></div>
							<div><a href="#">ch4. split</a></div>
						</div>
						<div>
							<div>01:03</div>
							<div>10:34</div>
							<div>12:45</div>
							<div>09:13</div>
							<a href="contentOp_01.html"><button class="btn btn-sm btn-primary">more</button></a>
						</div>
						
					</div>
				</li>
				<li class="list-group-item">
					<div>
						<a href="contentOp_02.html"><img src="../img/actingThumb2.jpg"></a>
						<div><b>About Speech</b></div>
						<div>
							<div><a href="#">chap1. orientation</a></div>
							<div><a href="#">chap2. pronunciation</a></div>
							<div><a href="#">chap3. facial stretches</a></div>
							<div><a href="#">chap4. shoulder stretches</a></div>
						</div>
						<div>
							<div>01:58</div>
							<div>21:03</div>
							<div>15:23</div>
							<div>14:34</div>
							<a href="contentOp_02.html"><button class="btn btn-sm btn-primary">more</button></a>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
</div>
<!-- 얿로드 모달 -->
<div id="uploadModal" class="modal fade">
	<div class="modal-dialog">	
		<form action="<%=request.getContextPath()%>/upload/contentWrite.do" method="post" enctype="multipart/form-data">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">New Video</h4>
				<button class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<div class="text-center proFrm">
				<img src="../img/click.jpg" class=" proImg img-thumbnail img-fluid file-upload avatar" alt="avatar"/>
				<input type="file" name="filename"id="proImgUpload"class="text-enter center-block file-upload hidden"/>
				</div>
				<hr/>
				<div class="input-group" style="width:100%">
					<select class="custom-select" name="interest">
					  <option selected>Please select a subject</option>
					  <c:forTokens var="contentSubject" items="Acting,Art,Bodybuild,Climbing,Dancing,Economy,History,Philosophy,Soccer" delims=",">
						  <option value="${contentSubject }">${contentSubject }</option>
					  </c:forTokens>
					</select>
				</div>    
				<div> <!-- 제목 -->
					<br/><b>Title</b>
					<br/><input type="text" maxlength="50" name="title"style="width:100%">
				</div>
				<div> <!-- 설명 -->
					<br/><b>Description</b>
					<br/><textarea maxlength="1000" name="description" style="width:100%"></textarea>
				</div>
			</div>
			<div class="modal-footer">
				<div><!-- 완료버튼 -->
					<button class="close" data-dismiss="modal" style="height:40px">close</button>
					<input type="submit" class="close" value="Publishing" style="border:0;outline:0;background-color:white;height:40px"/>
				</div>				
			</div>		
		</div>
		</form>
	</div>
</div>
<!-- 두번째 컨텐츠 -->
<div id="content2" class="row">
	<div class="col-lg-4"><img src="../img/achievement.jpg"></div>
	<div class="col-lg-4"></div>
	<div class="col-lg-4"></div>
</div>
<div id="graph"><br/><img src="../img/graph.jpg"></div>


</body>
<%@ include file="/jspf/footer.jspf" %>
</html>