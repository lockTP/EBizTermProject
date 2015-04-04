<%-- 
    Document   : login
    Created on : Nov 8, 2014, 3:34:38 PM
    Author     : linxiaohui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome to PittTrade!</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="css/customize.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/login.css">      
        <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>       
        <script src="js/bootstrap.min.js"></script>
        <script src="js/validateChecker.js"></script>
        <script src="js/jquery.js"></script>
    </head>
    <body>
        <div class="navbar">
            <div class="container">
                <div class="navbar-header">

                    <div class="header-logo-container navbar-brand">
                        <h1>PittTrade</h1>
                    </div>

                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <div class="navbar-collapse collapse pull-right">
                        <ul class="nav navbar-nav pull-right">
                            
                        </ul>
                    </div>

                </div>
            </div>
        </div>
        <section class="section-first" id="section-first">
            <div class="container">
                <div class="head_text col-md-12">
                    <h1>
                        Online second-hand goods trading platform for Pitt.
                    </h1>

                    <h2 class="col-sm-10 col-sm-push-1">
                        PittTrade offers Pitt students a simple way to sell their idle items by posting online.
                    </h2>
                </div>

                <div id="forms_container" class="form_cont col-lg-4 col-sm-4 col-xs-12 pull-right">
                    <form class="dark_form" method="POST" action="LoginServlet" novalidate>
                        <legend class="clearfix">
                            <div class="pull-left">
                                <span class="glyphicon glyphicon-lock"></span> Enter PittTrade
                            </div>
                        </legend>


                        <fieldset class="register-form-fields">
                            <div class="input">
                                <input type="text" id="email" name="username" class="form-control" placeholder="Username" autocapitalize="off">
                            </div>
                            <div class="input" data-showpassword="">
                                <input type="password" name="password" class="form-control" placeholder="Password">
                            </div>
                        </fieldset>

                        <fieldset>
                            <button id="submit" type="submit" class="fbtn blue">
                                <span class="txt">LOG IN</span>
                            </button>
                        </fieldset>
                    </form>
                    <form class="dark_form">
                        <legend class="clearfix">
                            <div class="pull-left">
                                <span class="glyphicon glyphicon-user"></span> Don't have an account?
                            </div>
                        </legend>
                        <fieldset>
                            <button type="button" class="fbtn blue" data-toggle="modal" data-target="#sigup">
                                <span class="txt">SIGN UP</span>
                            </button>
                        </fieldset>
                    </form>

                </div>

                <div id="video" class="col-sm-7">
                    <div id="placeholder">
                        <div id="play_btn" class="play_btn"></div>
                    </div>
                    <div id="video_placeholder_mobile"></div>
                </div>
            </div>
        </section>
        
        <!--
        <div class="container-fluid">
            <div class="row row-main">
                <div class="col-sm-4 col-sm-offset-4">
                    <div class="panel panel-default" >
                        <div class="panel-heading">Login</div>
                        <div class="panel-body">


                            <form class="form-horizontal ng-pristine ng-valid" role="form" method="POST" action="LoginServlet">
                                <div class="form-group">
                                    <label for="username" class="col-sm-offset-1  col-sm-3 control-label">Username</label>
                                    <div class="col-sm-6">
                                        <input type="text" id="email" name="username" class="form-control" placeholder="Username" autocapitalize="off">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-sm-offset-1 col-sm-3 control-label">Password</label>
                                    <div class="col-sm-6">
                                        <input type="password" name="password" class="form-control" placeholder="Password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-6">
                                        <div class="signup text-left">Don't have an account?  <a href="#" data-toggle="modal" data-target="#sigup">Sign up</a></div>
                                    </div>
                                    <div class="col-sm-3">
                                        <button type="submit" class="btn btn-primary"><i class="fa fa-sign-in"></i>&nbsp;Sign In</button>
                                    </div>

                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        -->
        
        <!-- madal  (sign up)
        ======================================================================-->
        <div class="modal fade" id="sigup" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="myModalLabel">Sign Up</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal ng-pristine ng-valid" role="form" method="POST" action="RegServlet">
                            <div class="form-group">
                                <label for="email" class="col-sm-4 control-label">Name</label>
                                <div class="col-sm-6">
                                    <input type="name" id="name" name="username" class="form-control" placeholder="Name" autocapitalize="off">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-sm-4 control-label">Email</label>
                                <div class="col-sm-6">
                                    <input type="email" id="email" name="email" class="form-control" placeholder="Email" autocapitalize="off">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="gender" class="col-sm-4 control-label">Gender</label>
                                <div class="col-sm-6">
                                    <label class="radio-inline">
                                        <input type="radio" name="gender" id="inlineRadio1" value="male" checked>Male 
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="gender" id="inlineRadio1" value="female">Female   
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-sm-4 control-label">Password</label>
                                <div class="col-sm-6">
                                    <input type="password" name="password" class="form-control" placeholder="Password">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="re_password" class="col-sm-4 control-label">Confirm Password</label>
                                <div class="col-sm-6">
                                    <input type="re_password" id="email" name="re_password" class="form-control" placeholder="Password" autocapitalize="off">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="user_detial" class="col-sm-4 control-label">Detail</label>
                                <div class="col-sm-6">
                                    <textarea class="form-control" name="detail" placeholder="Enter your detail information!" rows="7"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-6">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="remember"> I agree to the Terms of Service.
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-5 col-sm-3">
                                    <button type="submit" class="btn btn-primary btn-block"><i class="fa fa-sign-in"></i>Sign Up</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
         <!-- modal end-->

    </body>
</html>
