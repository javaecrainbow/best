<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/export/list.html" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
           <label>出貨單號：</label><input type="text" id="exportNo" value="" name="exportNo" class="form-control" size="10">&nbsp;
          <label> 產品編號：</label><input type="text" id="exportProdId" value="" name="exportProdId" class="form-control" size="10">&nbsp;
           <label>產品名稱：</label><input type="text" id="exportName" value="" name="exportName" class="form-control" size="10">&nbsp;
           <label>產品種類:</label>
            <select name="exportType" data-toggle="selectpicker">
               <option value="">全部</option>
                <c:forEach items="${items}" var="item" varStatus="i" >
                              <option value="${item. typeName}">${item. typeName}</option>
                            </c:forEach>
            </select>&nbsp;
            
            <label>出貨尺碼:</label>
            <select name="exportSize" data-toggle="selectpicker">
                  <option value="">全部</option>
                  <c:forEach items="${sizes}" var="size" varStatus="i" >
                              <option value="${size}">${size}</option>
                            </c:forEach>
            </select>&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div class="pull-right">
                <div class="btn-group">
                    <button type="button" class="btn-default dropdown-toggle" data-toggle="dropdown" data-icon="copy">复选框-批量操作<span class="caret"></span></button>
                    <ul class="dropdown-menu right" role="menu">
                    <!-- 
                        <li><a href="book1.xlsx" data-toggle="doexport" data-confirm-msg="确定要导出信息吗？">导出<span style="color: green;">全部</span></a></li>
                        <li><a href="book1.xlsx" data-toggle="doexportchecked" data-confirm-msg="确定要导出选中项吗？" data-idname="expids" data-group="ids">导出<span style="color: red;">选中</span></a></li>
                         -->
                        <li class="divider"></li>
                        <li><a href="/export/delete.html" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-idname="delids" data-group="ids">删除选中</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
            <tr>
                <th data-order-field="export_no">出貨單號</th>
                <th data-order-field="export_prod_id">產品編號</th>
               <th data-order-field="export_name">產品名稱</th>
                <th data-order-field="export_type">產品種類</th>
                <th data-order-field="export_date">出貨日期</th>
                <th data-order-field="export_size">出貨尺碼</th>
                 <th data-order-field="nums">數量</th>
                 <th>出貨人員</th>
                <th data-order-field="updateTime">出貨時間</th>
                <th>備註</th>
                 <c:if test="${not empty loginInfo && loginInfo.isAdmin() }">
                <th width="26"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
                <th width="100">操作</th>
               	</c:if>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${exports}" var="export" varStatus="i" >
          <tr data-id="${i.count}">
                <td><c:out value="${export.exportNo }"></c:out></td>
                 <td><c:out value="${export.exportProdId }"></c:out></td>
                 <td><c:out value="${export.exportName}"></c:out></td>
                <td><c:out value="${export.exportType}"></c:out></td>
                <td><fmt:formatDate value="${export.exportDate}" pattern="yyyy-MM-dd" /></td>
                <td><c:out value="${export.exportSize}"></c:out></td>
                <td><c:out value="${export.nums }"></c:out></td>
                <td><c:out value="${export.updaterName}"></c:out></td>
                <td>
               <c:choose>
                 	<c:when test="${empty export.updateTime}">
                 	  2015-01-01 12:00:00
                 	</c:when>
                 	<c:otherwise>
                 	<fmt:formatDate value="${export.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                 	</c:otherwise>
                 	</c:choose>
                 </td>
                <td><c:out value="${export.remark}"></c:out></td>
                 <c:if test="${not empty loginInfo && loginInfo.isAdmin() }">
                <td><input type="checkbox" name="ids" data-toggle="icheck" value="${export.id}"></td>
                <td>
                    <a href="/export/edit/${export.id }.html" class="btn btn-green" data-toggle="navtab" data-id="form" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="编辑-${export.exportNo }">编辑</a>
                    <a href="/export/delete.html?delids=${export.id }" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除该行信息吗？">删</a>
                </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="bjui-pageFooter">
    <div class="pages">
        <span>每页&nbsp;</span>
        <div class="selectPagesize">
            <select data-toggle="selectpicker" data-toggle-change="changepagesize">
                <option value="10">10</option>
                <option value="30">30</option>
                <option value="60">60</option>
            </select>
        </div>
        <span>&nbsp;条，共 ${totalPage }  条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${totalPage }" data-page-size="30" data-page-current="1">
    </div>
</div>