<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="Keywords" content="best"/>
<meta name="Description" content="best"/> 
<!-- bootstrap - css -->
<link href="../../BJUI/themes/css/bootstrap.css" rel="stylesheet">
<!-- core - css -->
<link href="../../BJUI/themes/blue/core.css" id="bjui-link-theme" rel="stylesheet">
<!-- plug - css -->
<link href="../../BJUI/plugins/kindeditor_4.1.10/themes/default/default.css" rel="stylesheet">
<link href="../../BJUI/plugins/colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">
<link href="../../BJUI/plugins/niceValidator/jquery.validator.css" rel="stylesheet">
<link href="../../BJUI/plugins/bootstrapSelect/bootstrap-select.css" rel="stylesheet">
<link href="../../BJUI/themes/css/FA/css/font-awesome.min.css" rel="stylesheet">
<!-- jquery -->
  <link href="../../jsp/customer/css/bootstrap.min.css" rel="stylesheet">
    <link href="./../jsp/customer/css/font-awesome.min.css" rel="stylesheet">
    <link href="./../jsp/customer/css/prettyPhoto.css" rel="stylesheet">
    <link href="./../jsp/customer/css/price-range.css" rel="stylesheet">
    <link href="./../jsp/customer/css/animate.css" rel="stylesheet">
	<link href="./../jsp/customer/css/main.css" rel="stylesheet">
	<link href="./../jsp/customer/css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    <style type="text/css">
    	.label{font-size:14px;}
    </style>
</head>
<body>
	<header id="header"><!--header-->
			<div class="header-middle"><!--header-middle-->
			<div class="container2">
				<img src="./../jsp/customer/images/home/logo.jpg">
			</div>
		</div><!--/header-middle-->
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="http://www.best-sport.com/" class="active">首頁</a></li>
								<li class="dropdown"><a href="#">倉庫查询<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
									
                                    </ul>
                                </li> 
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->
	<section>
				<div class="container">
	
			<div style="top:0; bottom:0; padding:10px; width:100%; overflow:auto;">  
            <table data-toggle="datagrid" class="table table-bordered" id="A11"
        data-options="{
            gridTitle:'IE8 慎用，反应迟钝',
            width:'100%',
            height:'100%',
            dataUrl:'',
            showLinenumber:true,
            editType:'inline'
        }"
        >
        <thead>
        <tr>
        <th colspan="${fn:length(sizes)+6}" align="center">
          <form id="pagerForm" data-toggle="ajaxsearch" action="/customer/query.html" method="post">
             <label>入貨種類:</label>
            <select name="importType" data-toggle="selectpicker" style="width: 75%">
                <c:forEach items="${items}" var="item" varStatus="i" >
                              <option value="${item. typeName}">${item. typeName}</option>
                            </c:forEach>
            </select>&nbsp;
            &nbsp;
            <button type="submit" class="btn btn-default" data-icon="search"><i class="fa fa-search"></i> 查詢</button>&nbsp;
        </form>
        </th>
        </tr>
        	<c:if test="${not empty importType }">
            <tr>
                <th colspan="${fn:length(sizes)+6}" align="center">${importType}</th>
            </tr>
            </c:if>
            <tr>
                <th rowspan="2"  >產品編號</th>
                <th rowspan="2"  >產品名稱</th>
                <th colspan="${fn:length(sizes)} " align="center">尺碼</th>
                <th rowspan="2" >產品數量</th>
            </tr>

            <tr>
            <c:forEach items="${sizes}" var="size">
            	  <th >${size }</th>
            </c:forEach>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${facetList}" var="facet" varStatus="i">
        <tr>
        	 <td >${facet.prodNo}</td>
        	 <td >${facet.importName}</td>
        	   <c:forEach items="${sizes}" var="size">
        	   		<c:choose>
        	   		<c:when test="${ not empty facet.sizes[size] }">
        	   			<td>${facet.sizes[size].count}</td>
        	   		</c:when>
        	   		<c:otherwise>
        	   			<td>--</td>
        	   		</c:otherwise>
        	   		</c:choose>
            </c:forEach>
			<td >${facet.total }</td>
			</tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>
</section>
	<footer id="footer" style="margin-top: 100px">
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright © 2015 </p>
				</div>
			</div>
		</div>
		
	</footer><!--/Footer-->


  
    <script src="../../jsp/customer/js/jquery.js"></script>
	<script src="../../jsp/customer/js/bootstrap.min.js"></script>
	<script src="../../jsp/customer/js/jquery.scrollUp.min.js"></script>
	<script src="../../jsp/customer/js/price-range.js"></script>
    <script src="../../jsp/customer/js/jquery.prettyPhoto.js"></script>
    <script src="../../jsp/customer/js/main.js"></script>

</body>
</html>

