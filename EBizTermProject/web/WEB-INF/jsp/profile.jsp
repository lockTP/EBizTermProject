<%-- 
    Document   : profile
    Created on : Apr 6, 2015, 08:41:23 PM
    Author     : linxiaohui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<!DOCTYPE html>
<jsp:useBean id="userdao" scope="page" class="dao.UserDAO"/>
<html>
    <head>
        <title>Profile Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="<c:url value="/assets/css/customize.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css"/>">
        <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
        <script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
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
                    <li><a href="post.html">Post</a></li>
                    <li><a href="search.html" >Search</a></li>
                    <li class="active"><a>Profile</a></li>
                    <li><a href="crawler.html">Crawler</a></li>
                    <li><a href="login.html">Log out</a></li>
                </ul>

            </div>
        </div>
    </nav>

    <div class="container-fluid">
        <div class="row-main" style="padding-top:8%">
            <div class="col-sm-6 col-sm-offset-3">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="glyphicon glyphicon-user"></span>
                        Basic Information
                    </div>
                    <div class="panel-body">
                        <form method="post" action="update.html" commandName="user"  class="form-horizontal" role="form">
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Username:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="name" path="name" class="form-control" value="${sessionScope.name}" placeholder="${sessionScope.name}"  >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">E-mail: </label>
                                <div class="col-sm-6">
                                    <input type="text" name="email" path="email" class="form-control" value="${sessionScope.email}" placeholder="${sessionScope.email}" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Password:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="password" path="password" class="form-control" value="${sessionScope.password}" placeholder="${sessionScope.password}">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-3 col-sm-offset-4">
                                    <button id="btn_1" class="btn btn-primary btn-block" type="submit" name="update" value="update">Update</button>
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

