<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
<link href="../../BJUI/themes/css/style.css" rel="stylesheet">
<link href="../../BJUI/themes/blue/core.css" id="bjui-link-theme" rel="stylesheet">
<!-- plug - css -->
<link href="../../BJUI/plugins/kindeditor_4.1.10/themes/default/default.css" rel="stylesheet">
<link href="../../BJUI/plugins/colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">
<link href="../../BJUI/plugins/niceValidator/jquery.validator.css" rel="stylesheet">
<link href="../../BJUI/plugins/bootstrapSelect/bootstrap-select.css" rel="stylesheet">
<link href="../../BJUI/themes/css/FA/css/font-awesome.min.css" rel="stylesheet">
<!-- jquery -->

</head>
<body>
<div class="bjui-pageContent">
<div class="bjui-searchBar">
  
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
        <th colspan="${fn:length(sizes)+4}" align="center">
          <form id="pagerForm" data-toggle="ajaxsearch" action="/customer/query.html" method="post">
             <label>入貨種類:</label>
            <select name="importType" data-toggle="selectpicker">
                <c:forEach items="${items}" var="item" varStatus="i" >
                              <option value="${item. typeName}">${item. typeName}</option>
                            </c:forEach>
            </select>&nbsp;
            &nbsp;
            <button type="submit" class="btn btn-default" data-icon="search"><i class="fa fa-search"></i> 查询</button>&nbsp;
        </div>
        </form>
        </th>
        </tr>
        
            <tr>
                <th colspan="${fn:length(sizes)+4}" align="center">产品类型</th>
            </tr>
            <tr>
                <th rowspan="2"  >产品名称</th>
                <th colspan="${fn:length(sizes)} " align="center">size</th>
                <th rowspan="2" >产品数量</th>
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
</body>
</html>

