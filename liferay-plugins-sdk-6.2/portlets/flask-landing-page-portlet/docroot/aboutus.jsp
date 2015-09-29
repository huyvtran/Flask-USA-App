<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title> Flask AboutUs</title>
    <link href="css/bootstrap.css" rel="stylesheet" />
    <link href="css/site.css" rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet" />
    <link href="css/font-awesome.min.css" rel="stylesheet" />
<link rel="shortcut icon" type="image/png" href="/FlaskTheme-theme/images/favicon.ico"/>

</head>
<script type="text/javascript" src="js/jquery-2.1.4.js" > </script>
<script type="text/javascript" src="js/main.js" > </script>
<style>
.container {
    padding: 2em 0em 0 !important;
}

.btn-flask {
	padding: 5px 20px;
	font: normal 16px/1 "Coda", Helvetica, sans-serif;
	background: #231F20;
	color: #fff;
	font-size: 20px;
	margin-top: 10px;
	text-shadow: none;
	background-image: -ms-linear-gradient(top, #656262 0%, #231F20 100%);
	background-image: -moz-linear-gradient(top, #656262 0%, #231F20 100%);
	background-image: -o-linear-gradient(top, #656262 0%, #231F20 100%);
	background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #656262),color-stop(1, #231F20));
	background-image: -webkit-linear-gradient(top, #656262 0%, #231F20 100%);
	background-image: linear-gradient(to bottom, #656262 0%, #231F20 100%);
}

.btn-flask:hover {
	color: #ff9900;
	background: #231F20;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
	background-image: -ms-linear-gradient(top, #656262 0%, #231F20 100%);
	background-image: -moz-linear-gradient(top, #656262 0%, #231F20 100%);
	background-image: -o-linear-gradient(top, #656262 0%, #231F20 100%);
	background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #656262),color-stop(1, #231F20));
	background-image: -webkit-linear-gradient(top, #656262 0%, #231F20 100%);
	background-image: linear-gradient(to bottom, #656262 0%, #231F20 100%);
}

.btn-flask:focus {
	color: #ff9900;
	background: #231F20;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
	background-image: -ms-linear-gradient(top, #656262 0%, #231F20 100%);
	background-image: -moz-linear-gradient(top, #656262 0%, #231F20 100%);
	background-image: -o-linear-gradient(top, #656262 0%, #231F20 100%);
	background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #656262),color-stop(1, #231F20));
	background-image: -webkit-linear-gradient(top, #656262 0%, #231F20 100%);
	background-image: linear-gradient(to bottom, #656262 0%, #231F20 100%);
}

</style>
    <body class="thumbnail">
        <div class="container">
            <div class="col-lg-12">
                <div class="col-lg-1"></div>
                <div class="col-lg-10">
                    <br/>
                    <nav class="navbar">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                                <a class="navbar-brand" href="/web/flask/flaskus">
                                    <img class="img-responsive" src="Images/flasklogo.png" style="height: 37px;width: 150px; margin-top: -18px" />
                                </a>
                            </div>
                            <a href="/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_58_struts_action=%2Flogin%2Flogin">
                        	 <button class="btn btn-flask logIn" style="margin-left: 62%;">Sign In <i class="fa fa-lock" ></i></button>
	                         </a>
	                         <a href="/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_58_struts_action=%2Flogin%2Flogin">
	                        	 <button class="btn btn-flask myFlask" style="margin-left: 62%;">My Flask </button>
	                         </a>
                        </div><!--/.container-fluid -->
                    </nav>
                    <div class="container">
                        <br />
                        <div class="row row2">
	                        <div class="col-sm-9">
	                            <div class="row text-justify jumbotron">
	                                <h2 class="flasktext">We've funneled a lot of top shelf information into Flask</h2>
	                            </div>
	                        </div>
	                        <div class="col-sm-9">
	                            <blockquote>
	                                <p>
	                                    Organize tailgates and parties by setting up an account, inviting people to the event via the Flask app, requesting and accepting Venmo payments, and pinning your location to make it easy for your invitees to find you. In the Tailgate event you set up, you can share all kinds of vital details like the drinks and food you'll be serving, and other important details like the food and drinks you'll be serving.
	                                </p>
	                            </blockquote>
	                            <blockquote>
	                                <p>
	                                    Download event details onto your phone by using the "Flask It" button, so you'll have access to the information even when your signal drops inside the venue.
	                                    Skim the data while you're in a new town to find what you're looking for
	                                </p>
	                            </blockquote>
	
	                            <blockquote>
	                                <p>
	                                    We will promote certain businesses that pertain to the day, time, and the event you're going to point you in the right direction.
	                                </p>
	                            </blockquote>
	                        </div>
                        </div>
                        <hr>
		                <div class="row">
			                <div class="col-sm-2" style="padding-left: 35px;">
					            <h4>Learn More</h4>
					              <a href="/web/flask/flaskus" class="links">Home</a><br>
					              <a href="/flask-landing-page-portlet/features.jsp" class="links">Features</a><br>
					              <a href="#" class="links">Security</a><br>
				            </div>
				            <div class="col-sm-2">
					            <h4>Company</h4>
					              <a href="/flask-landing-page-portlet/aboutus.jsp" class="links">About Us</a><br>
					              <a href="#" class="links">Our Team</a><br>
					              <a href="#" class="links">Developer</a><br>
				            </div>
				            <div class="col-sm-2">
					            <h4>Community</h4>
					              <a href="/flask-landing-page-portlet/contactus.jsp" class="links">Contact Us</a><br>
					              <a href="#" class="links">Help Center</a><br>
					              <a href="#" class="links">Blog</a><br>
				            </div>
				            <div class="col-sm-2">
					            <h4>Terms</h4>
					              <a href="#" class="links">Legal</a><br>
					              <a href="#" class="links">Privacy</a><br>
				            </div>
			           </div><br>
                    </div>
                </div>
                <div class="col-lg-1"></div>
            </div>
        </div>
    </body>
</html>
