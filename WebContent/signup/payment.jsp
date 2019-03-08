<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Yeontec Jeong</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<link rel="stylesheet" href="main.css"/>
<style>
	body{font-size:0.9em; margin:8px 8px}
	#nameTag{width:100%}
	#nameTag>a>img{width:300px; height:100px}/* logo */
	#myInfo img{width:50px; height:50px;}
	.nav-link{color:black; font-family: 'Montserrat', sans-serif;}
	.nav-link:hover{font-weight:bolder;}
	
	#acorn{width:100%; height:430px; background:#eee; padding:20px 20px}
	#purchase{width:100%; background:lightgray; padding:10px 0px; font-family: 'Montserrat', sans-serif;}
	#purchase>div:first-child{margin-left:20px;}
	#purchase>div>b>input[type=radio]{margin:3px 3px 3px 20px}
	#purchase>div>b>input[type=radio]:nth-child(6){display:none}
	#acornTxt{width:50px; margin-left:20px}
	#preview{position:relative; margin:0px auto; left:10px; color:white}
	
	#payment{font-family: 'Montserrat', sans-serif;}
	#payment>b>input[type="radio"]{margin:13px 3px 3px 20px}
	
	#total{width:420px; background:white; height:140px; margin:20px 0px 10px 10px;}
	#total>div:first-child{border-bottom:1px solid lightgray; padding:5px 10px 0px 10px}
	#total>div:nth-child(2){text-align:center}
	#buyAcorn{font-size:40px; width:150px; height:50px; line-height:50px; margin-top:20px; border:none; text-align:center;}
	#buyBtn{height:40px; position:relative; left:10px; top:120px}
	
	#myAcorn img{
		width:20px;
		height:20px;
	}
</style>
<script>
	
	$(function(){
	/* 	$("#acornTxt").on("click focus",function(){
			$("#purchase>div>input[type=radio]:nth-child(6)").first().trigger("click");
		}); */
		$("#purchase>div>b>input[type=radio]:first-child").click(function(){
			$("#preview").html("5acorns x 3dollor = 15dollors");
			$("#buyAcorn").html("$15");
		});
		$("#purchase>div>b>input[type=radio]:nth-child(2)").click(function(){
			$("#preview").html("10acorns x 3dollor = 30dollors");
			$("#buyAcorn").html("$30");
		});
		$("#purchase>div>b>input[type=radio]:nth-child(3)").click(function(){
			$("#preview").html("30acorns x 3dollor = 90dollors");
			$("#buyAcorn").html("$90");
		});
		$("#purchase>div>b>input[type=radio]:nth-child(4)").click(function(){
			$("#preview").html("50acorns x 3dollor = 150dollors");
			$("#buyAcorn").html("$150");
		});
		$("#purchase>div>b>input[type=radio]:nth-child(5)").click(function(){
			$("#preview").html("100acorns x 3dollor = 300dollors");
			$("#buyAcorn").html("$300");
		});
		$("#acornTxt").keyup(function(){
			var num = $("#acornTxt").val();
			$("#preview").html(num+"acorns x 3dollor = "+num*3+"dollors");
			$("#buyAcorn").val("$"+num*3);
			
			var reg = /[0-9]{1,5}/;
			var result = reg.test(num);
			if (!result){
				$("#acornTxt").val('');
				//$("#total>div:nth-child(2)").html("<input type=label name='buyAcron' id='buyAcorn' value='0'>");
			}
			
			
		});
		//아콘숫자
		var myAcornNum =0;
		$("#buyBtn").on("click",function(){			
			var t1 = $("#acornNum").text();
			var t2 = t1.substring(1);
			myAcornNum += parseInt(t2); 
			localStorage.setItem("acornNum",myAcornNum);
			$("#myAcorn p").html(localStorage.getItem("acornNum"));
		});
	});	

</script>
</head>
<body class="container-fluid">

	<nav class="nav bar">
	<div id="nameTag" class="row">
		<a href="index.jsp" class="col-4 p-0"><img src="../img/logo.jpg"></a> <!-- 로고 -->
		<div class="col-4 p-0"></div>
		<ul class="nav justify-content-end col-4 p-0 row align-items-center">  
			<li id="myAcorn" class="d-flex" >
						<img src="../img/acorn.png" class="p-0"/>
						<p class="p-0"></p>
					</li>	
			<li id="myInfo" class="nav-item col-xs-6">
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
		<li class="nav-item col-12"><a href="my_profile.html" class="nav-link">My Profile</a>
		<li class="nav-item col-12"><a href="main.html"  class="nav-link">LogOut</a>
		<li class="nav-item col-12" ><a href="main.html" class="nav-link getterMode">Getter Mode</a>
	</ul>
</div>

	
		<div class="row">
			<div class="col-xl-2"></div>
			<div class="col-xl-8">
				<div id="acorn" class="container"> 
					<div><h3><b>Purchase</b></h3></div>
					<div id="purchase">
						<div><h4><b>acorn</b></h4></div>
						<div><b>
							<input type="radio" name="acorn" clicked>5acorns
							<input type="radio" name="acorn">10acorns
							<input type="radio" name="acorn">30acorns
							<input type="radio" name="acorn">50acorns
							<input type="radio" name="acorn">100acorns
							
							<input type="text" maxlength="5" name="acorn" id="acornTxt" value=0> acorns  
							<label id="preview">5acorns x 3dollor = 15dollors</label>
						</b></div>
					</div>
					<div>
						<hr/>
						<div><h5><b>payment</b></h5></div>
						<div id="payment"><b>
							<input type="radio" name="payment" checked> Credit Card
							<input type="radio" name="payment"> Phone
							<input type="radio" name="payment"> kakao Bank
							<input type="radio" name="payment"> Toss
						</b></div>
					</div>
					<form method="get" action="paymentOk.do" >
						<div class="row">
							<div id="total" class="col-lg-6">
								<div><h5>TOTAL</h5></div>
								<div><input type="label" id="buyAcorn" name="buyAcorn" value="$15"/></div>
							</div>
							<!--  <a href="paymentOk.html" class="btn btn-primary col-lg-1 btn-sm" id="buyBtn">BUY</a>-->
							<input type="submit" value="BUY" class="btn btn-primary col-lg-1 btn-sm" id="buyBtn"/>
						</div>
					</form>	
					
				</div>
			</div>
			<div class="col-xl-2"></div>
		</div>

	
	
</body>
<!-- 회사 정보 -->
<%@ include file="/jspf/footer.jspf" %>

</html>