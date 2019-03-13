<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../jspf/SearchbarHeader.jspf"%>
<script>
	$(function(){
		$('.fa-star').on('click',function(){ //별점 기능 추가!
			var index = $('.fa-star').index(this);
			if(index==4){
				$('.start-coment').html(" 5.0");
				$('.fa-star').addClass('fas');
			}else if(index==3){
				$('.start-coment').html(" 4.0"); //emp:far ocu:fas
				if($('.fa-star').eq(3).hasClass('fas')){
					$('.fa-star').eq(4).removeClass('fas');
					$('.fa-star').eq(4).addClass('far');
				}
				else if($('.fa-star').eq(3).hasClass('far')){
					for(n=0;n<=3;n++){
						$('.fa-star').eq(n).removeClass('far');
						$('.fa-star').eq(n).addClass('fas');
						}
				}
			}else if(index==2){
				$('.start-coment').html(" 3.0");
				if($('.fa-star').eq(3).hasClass('fas')){
					for(n=3;n<=4;n++){
					$('.fa-star').eq(n).removeClass('fas');
					$('.fa-star').eq(n).addClass('far');
					}
				}
				else if($('.fa-star').eq(3).hasClass('far')){
					for(n=0;n<=2;n++){
						$('.fa-star').eq(n).removeClass('far');
						$('.fa-star').eq(n).addClass('fas');
						}
				}
			}else if(index==1){
				$('.start-coment').html(" 2.0");
				if($('.fa-star').eq(2).hasClass('fas')){
					for(n=2;n<=4;n++){
					$('.fa-star').eq(n).removeClass('fas');
					$('.fa-star').eq(n).addClass('far');
					}
				}
				else if($('.fa-star').eq(2).hasClass('far')){
					for(n=0;n<=1;n++){
						$('.fa-star').eq(n).removeClass('far');
						$('.fa-star').eq(n).addClass('fas');
						}
				}
			}else{
				$('.start-coment').html(" 1.0");
				if($('.fa-star').eq(1).hasClass('fas')){
					for(n=1;n<=4;n++){
					$('.fa-star').eq(n).removeClass('fas');
					$('.fa-star').eq(n).addClass('far');
					}
				}
			}
		});

		var mHeightVal = $('.media-head').innerHeight();
		var heightVal = $('.fnt-size-ins-content').innerHeight();
		$('.show-less-btn').on('click',function(){
			var txt = $('.show-less-btn').text();
			if(txt=='SHOW LESS'){
				$('.instructor-content').animate({height:'28%'});
				$('.media-head').animate({height:'28%'});
				$('.show-less-btn').text('SHOW MORE');
			}else if(txt=='SHOW MORE'){
				$('.instructor-content').animate({height:heightVal});
				$('.media-head').animate({height:mHeightVal});
				$('.show-less-btn').text('SHOW LESS');
			}
			
		});
	});
</script>
<title>123</title>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-8" id="left"> <!-- left -->
			<div class="embed-responsive embed-responsive-16by9"><!-- 동영상 출력 -->
				<iframe class="embed-responsive-item" src="#"></iframe> <!-- https://www.youtube.com/embed/l49aooJqlwA -->
			</div> <!-- 동영상 출력 -->
			<div class="media-head">
				<div class="media-title fnt-size-head"><b>Acting_01</b></div>
				<div class="container">
					<div class="media-details row">
						<div class="col-sm-9 views">733,481 views</div>
						<div class="col-sm-3">
							<div class="star-edit">
								<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i>
								<span class="start-coment"> 5.0</span>
							</div>
						</div>
					</div>
				</div><div style="border:0.2px solid lightgray; margin-top:5px; margin-bottom:5px"></div>
				<div class="row editor">
					<div class="col-sm-2">
						<img src="img/profile.jpg" class="ins-avatar rounded-circle"/>
					</div>
					<div class="col-sm-8">
						<div class="ins-content"><b class="fnt-size-title instructor">Christian Heilmann</b><br/><span class="fnt-size-content ins-date">Published on 10 Oct 2012</span>
						</div>
						<div class="instructor-content"><p class="fnt-size-ins-content">The iconic Beegie Adair Trio performs the jazz classic "Autumn Leaves," written by Joseph Kosma (English lyric by Johnny Mercer) - live at the Nashville Jazz Workshop in Nashville, TN.
Beegie Adair -piano, Roger Spencer - bass, and Chris Brown - drums. 

For more on the Trio's monthly performances in the Jazz Cave, or for information on any of our performances and classes, visit http://www.nashvillejazz.org. 

To follow Beegie Adair online, go to www.beegieadair.com.

Subscribe to our youtube channel for our jazz video of the week!</p>
						</div>
						<button class="btn-default show-less-btn">SHOW LESS</button>
					</div>
					<div class="col-sm-2">
						<button class="like-btn">I LIKE IT!</button>
					</div>
				</div>
			</div><hr/>
			
			<div class=panTop><b class="fnt-size-head">Course content</b></div>
			<div class="panel-group" id="accordion1">
        <div class="panel panel-default">
          <div class="panel-heading">
            <div class="panel-title">
              <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1" href="#accordion1_1">Acting_01_A</a>
            </div>
          </div>
          <div id="accordion1_1" class="panel-collapse collapse in">
            <div class="panel-body">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim minim veniam quis nostrud exercitation dolore magna ullamco.</p>
              <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco sed eiusmod tempor ut labore et dolore.</p>
            </div>
          </div>
        </div>
        <div class="panel panel-default">
          <div class="panel-heading">
            <div class="panel-title">
              <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion1" href="#accordion1_2">Acting_01_B</a>
            </div>
          </div>
          <div id="accordion1_2" class="panel-collapse collapse">
            <div class="panel-body">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim minim veniam quis nostrud exercitation dolore magna ullamco.</p>
              <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco sed eiusmod tempor ut labore et dolore.</p>
            </div>
          </div>
        </div>
        <div class="panel panel-default">
          <div class="panel-heading">
            <div class="panel-title">
              <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion1" href="#accordion1_3">Acting_01_C</a>
            </div>
          </div>
          <div id="accordion1_3" class="panel-collapse collapse">
            <div class="panel-body">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim minim veniam quis nostrud exercitation dolore magna ullamco.</p>
              <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco sed eiusmod tempor ut labore et dolore.</p>
            </div>
          </div>
        </div>
      </div><hr/>
		<div class="comment-pane">
			<div class="row">
				<div class="col-sm-1">
					<img src="img/profile.jpg" class="com-avatar rounded-circle"/>
				</div>
				<div class="cols-sm-11">
					<form>
						<textarea class="wri-comment"rows="1" cols="90" placeholder="Add a public comment..." ></textarea><br/>
						<div class="wri-btn" style="display:none">
							<input type="reset" class="reset-btn" value="CANCEL"></input>
							<input type="submit" class="submit-btn btn btn-outline-primary" value="COMMENT"></input>
						</div>
					</form>
					<div class="comment-box">
					
					</div>
				</div>
			</div>
		</div>
			
			
			
		</div><!-- left -->
		<div class="col-sm-4"> <!-- right -->
			<div id="next"><b class="fnt-size-title">Up Next</b></div>
			<div class="media"> <!-- media (1) -->
				<div class="media-left">
					<img class="media-object thumbnail-img" src="img/actingThumb2.jpg"/>
				</div>
				<div class="media-body">
					<div class="media-heading">
						<b class="fnt-size-title">Acting_02_A</b>
					</div>
						<span class="fnt-size-content">Instructor : GYEOUNGHO, JI</span><br/>
						<span class="fnt-size-content"><i class="fas fa-users fa-xs"></i> 3,658</span>
				</div>
			</div> <!-- media(1) -->
			<div class="media"> <!-- media (2) -->
				<div class="media-left">
					<img class="media-object thumbnail-img" src="img/actingThumb3.jpg"/>
				</div>
				<div class="media-body">
					<div class="media-heading">
						<b class="fnt-size-title">Acting_03_A</b>
					</div>
						<span class="fnt-size-content">Instructor : GYEOUNGHO, JI</span><br/>
						<span class="fnt-size-content"><i class="fas fa-users fa-xs"></i> 3,658</span>
				</div>
			</div> <!-- media(2) -->
		</div><!-- right -->
	</div> <!-- container-fluid->row -->
</div> <!-- container-fluid -->
</body>
<%@ include file="../jspf/footer.jspf"%>