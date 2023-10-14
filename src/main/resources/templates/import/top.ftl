<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" th:href="@{/static/img/favicon.ico}" type="image/x-icon">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/zui/1.10.0/css/zui.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/zui/1.10.0/lib/jquery/jquery.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/zui/1.10.0/js/zui.min.js"></script>
    <title>MyBlogAdmin</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <!-- Header -->
            <div class="navbar-header">
                <!-- Toggle buttons on mobile devices -->
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse-example">
                    <span class="sr-only">Toggle</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- Brand name or logo -->
                <a class="navbar-brand" href="/">Main Page</a>
            </div>
            <!-- Navigation items -->
            <div class="collapse navbar-collapse navbar-collapse-example">
                <!-- General navigation items -->
                <ul class="nav navbar-nav">
                    <li><a href="/Ica269">Basic Data</a></li>
                    <!-- Dropdowns in navigation -->
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">User Management <b class="caret"></b></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="/Ica269/user/list">User List</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Article Management <b class="caret"></b></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="/Ica269/article/list">Article List</a></li>
                        </ul>
                    </li>
                    <li><a href="/Ica269/link">Link</a></li>
                    <li><a href="/Ica269/ad">AD</a></li>
                </ul>
            </div><!-- END .navbar-collapse -->
        </div>
    </nav>