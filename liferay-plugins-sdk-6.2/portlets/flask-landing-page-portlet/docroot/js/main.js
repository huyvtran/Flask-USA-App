var signedIn;
$(document).ready(function(){
	$(".navbar-inner").hide();
	$("#sign-in").hide();
	$(".row1").show();
	$(".row2").hide();
	$(".row3").hide();
	$(".row4").hide();
	if(Liferay.ThemeDisplay.isSignedIn()){
		$(".logIn").hide();
		$(".myFlask").show();
	}else{
		$(".logIn").show();
		$(".myFlask").hide();
	}
	
	$("#home").click(function(){
		$(".row1").show();
		$(".row2").hide();
		$(".row3").hide();
		$(".row4").hide();
	});
	$("#aboutus").click(function(){
		$(".row1").hide();
		$(".row2").show();
		$(".row3").hide();
		$(".row4").hide();
	});
	$("#features").click(function(){
		$(".row1").hide();
		$(".row2").hide();
		$(".row3").show();
		$(".row4").hide();
	});
	$("#contactus").click(function(){
		$(".row1").hide();
		$(".row2").hide();
		$(".row3").hide();
		$(".row4").show();
	});
});