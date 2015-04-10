<%-- 
    Document   : post
    Created on : Apr 10, 2015, 1:18:29 PM
    Author     : Weichuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="<c:url value="/assets/css/customize.css" />" >
        <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/login.css"/>">      
        <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>       
        <script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/assets/js/validateChecker.js"/>"></script>
        <script src="<c:url value="/assets/js/jquery.js"/>"></script>
    </head>
    <body>
            <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <div class="navbar-brand">
                    Job Hunter
                </div>
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
                    <span class="sr-only">Toggle Navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <a class="navbar-brand" href="#"></a>
            </div>

            <div class="collapse navbar-collapse" id="navbar-collapse">
                <ul class="nav navbar-nav">
                    <!-- Server Dropdown -->
                </ul>

                <!-- User Dropdown -->
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="">Post</a></li>
                    <li><a href="">Search</a></li>
                    <li class="active"><a href="profile.jsp">Profile</a></li>
                    <li><a href="">Log out</a></li>
                </ul>

            </div>
        </div>
    </nav>
        
      <div class="container-fluid">
        <div class="row-main">
            <div class="col-sm-6 col-sm-offset-3">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="glyphicon glyphicon-user"></span>
                        Post a Job
                    </div>
                    <div class="panel-body">
                        <form method="post" action="postJob.html" commandName="job"  class="form-horizontal" role="form">
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Title:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="title" path="title" class="form-control" value="${sessionScope.title}" placeholder="${sessionScope.title}"  >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Description: </label>
                                <div class="col-sm-6">
                                    <input type="text" name="description" path="description" class="form-control" value="${sessionScope.description}" placeholder="${sessionScope.description}" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Requirement:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="requirement" path="requirement" class="form-control" value="${sessionScope.requirement}" placeholder="${sessionScope.requirement}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Requirement:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="requirement" path="requirement" class="form-control" value="${sessionScope.requirement}" placeholder="${sessionScope.requirement}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Company Name:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="cName" path="cName" class="form-control" value="${sessionScope.cName}" placeholder="${sessionScope.cName}">
                                </div>
                            </div> 
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Company Type:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="cType" path="cType" class="form-control" value="${sessionScope.cType}" placeholder="${sessionScope.cType}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Company Industry:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="cIndustry" path="cIndustry" class="form-control" value="${sessionScope.cIndustry}" placeholder="${sessionScope.cIndustry}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Website:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="website" path="website" class="form-control" value="${sessionScope.website}" placeholder="${sessionScope.website}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Location:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="location" path="location" class="form-control" value="${sessionScope.location}" placeholder="${sessionScope.location}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Company Description:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="cDescription" path="cDescription" class="form-control" value="${sessionScope.cDescription}" placeholder="${sessionScope.cDescription}">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-3 col-sm-offset-4">
                                    <button id="btn_1" class="btn btn-primary btn-block" type="submit" name="update" value="update">Post</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
        
    </body>
</html>
