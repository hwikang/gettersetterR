/**
 * 
 */

/*팝오버 실행*/
 $(function(){
	$("#clickLogo").on("click", function(){		
		location.href="main.html"
	});			

	var pro=localStorage.getItem("profile");
	$(".avatar").attr('src', pro);

	/*팝오버 실행*/

	  $('#myInfo').popover({
		  html : true,
		  content: function(){
			  return $("#myInfoPopover").html();
		  },
		  title : "My Info"		  
	  });
});
