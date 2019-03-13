<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../jspf/SearchbarHeader.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Instructor Introduction</title>

<script type="" src="intro.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<link rel="stylesheet" href="intro.css" type="text/css"/>
</head>
<body>
<div class="container-fluid">
	<ul class="nav">
		<li class="nav-item">
			<a class="nav-link nav-link-pri active" href="#cou">Course Introduction</a>
		</li>
		<li class="nav-item">
			<a class="nav-link nav-link-pri" href="#cur">Curriculum</a>
		</li>
		<li class="nav-item">
			<a class="nav-link nav-link-pri" href="#eva">Instructor Evaluation</a>
		</li>
	</ul>
	<div style="border:0.5px solid #eee;position:absolute;margin-left:-15px;width:100%"></div>
	<div style="width:50%; margin:30px auto 0 auto;">
		<div class="embed-responsive embed-responsive-16by9" id="cou">
			<iframe class="embed-responsive-item" src=""></iframe>			
		</div><br/> <!-- 해당 INTRO 의 VO 는 = introVO 로 부르면됨!! -->
		<h2>Instructor name <span style="font-weight:bold;font-size:0.7em;margin-right:10px;float:right;"> ${introVO.userid}</span></h2><hr/>
		<br/><h4>Instructor Introduction Content</h4><br/>
		<p>${introVO.description}</p>
		<br/><h4>instructor career</h4><br/>
		<ul>
			<li>Bivaripublica, Server Developer</li>
			<li>bluenight, CTO (2016-2017)</li>
			<li>Data Square, CEO / Developer / Joint Establishment (2011-2016)</li>
			<li>Like the handsome lion, the operating / teacher / founding member (2014-2016)</li>
			<li>IT Instructors such as Ajou University, KT&G, etc. (2014-2016)</li>
			<li>MERSMAP Development (Five million net visitors)</li>
			<li>IEEE Best-Poster Award for International Studies</li>
			<li>Microsoft Korea Cloud Competition Silver Award</li>
			<li>Korea Talent Award</li>
		</ul>
		<h4 id="cur">Curriculum</h4><hr/>
		<div>
		<ul>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
		</ul>
		</div>		
		<h4 id="eva">Instructor Evaluation</h4><hr/>
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-2">
				<span style="font-size:4em;font-weight:bold">4.6</span><br/>
				 <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i>
			</div>
			<div class="col-sm-5">
				<progress value="100" max="100"></progress>
				<progress value="80" max="100"></progress>
				<progress value="60" max="100"></progress>
				<progress value="40" max="100"></progress>
				<progress value="20" max="100"></progress>
			</div>
			<div class="col-sm-3">
				 <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <span style="margin-left:10px"> 100%</span><br/>
				 <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="far fa-star"></i> <span style="margin-left:10px"> 100%</span><br/>
				 <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="far fa-star"></i> <i class="far fa-star"></i> <span style="margin-left:10px"> 100%</span><br/>
				 <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="far fa-star"></i> <i class="far fa-star"></i> <i class="far fa-star"></i> <span style="margin-left:10px"> 100%</span><br/>
				 <i class="fas fa-star"></i> <i class="far fa-star"></i> <i class="far fa-star"></i> <i class="far fa-star"></i> <i class="far fa-star"></i> <span style="margin-left:10px"> 100%</span><br/>
			</div>
			<div class="col-sm-1"></div>
		</div>
		
		<!-- 댓글 --> 
		<h4 id="review">Review</h4><hr/>
		<div class="row">			
			<form method="get" action="replyWrite.do" class="col-12">
				<c:forEach var="vo" items="${list}">
					<div class="col-12 row">
						<p class="col-2">${vo.commenter }</p>
						<p class="col-6">${vo.commentContent }</p>
						<p class="col-2">${vo.commentDate}</p>
						<span class="col-2"><i class="fas fa-star"></i></span>
					</div>
				</c:forEach>
				<div class="col-12 row">
					<p class="col-2">${userid }</p>
					<input class="col-6" type="text" name="commentContent"/>
					<input class="col-2" type="submit"/>
					<span class="col-2"><i class="fas fa-star"></i></span><br/>
					<input type="hidden" name="star" value="3.0"/>
					<input type="hidden" name="commenter" value="${userid}"/>
					<input type="hidden" name="introNo" value="${introVO.introNo}"/>				
				</div>
			</form>
				
		</div>
		
	</div>
</div>
</body>
<%@ include file="/jspf/footer.jspf" %>
</html>