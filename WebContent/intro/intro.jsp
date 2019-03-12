<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Instructor Introduction</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script type="" src="intro.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<link rel="stylesheet" href="intro.css" type="text/css"/>
</head>
<%@include file="/jspf/header.jspf" %>
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
		</div><br/>
		<h2>Instructor name <span style="font-weight:bold;font-size:0.7em;margin-right:10px;float:right;"> @zbass</span></h2><hr/>
		<br/><h4>Instructor Introduction Content</h4><br/>
		<p>
		There was a rumor that Idya would be located near Starbucks. How different is the location of stores at Idiyah and Starbucks? Read the relevant articles, analyze and visualize Idiyah and Starbucks stores in a similar way to the articles, familiarize yourself with Python, Pandas, ggplot, Numpy, and Folium.
Will changes in real estate prices be reflected in apartment prices from 2013 to 2018. Analyze the data in the public data portal using the reshape functions such as melt, concat, pivot, and transpose of Pandas. Then, summarize and analyze the data through groupby, pivot_table, info, describe, value_counts, etc.
There are many city parks all over the country. What kind of park is there in my neighborhood? Visualize what parks are distributed by region via the Volium.
How do you leverage the data in the public data portal? And what kind of data does the public data portal have? The goal is to become familiar with Python and multiple data analytics libraries, dealing with different types of data through public data.
		</p>
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

	</div>
</div>
</body>
<%@ include file="/jspf/footer.jspf" %>
</html>