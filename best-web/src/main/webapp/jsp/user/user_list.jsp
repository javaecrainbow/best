<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/user/list.html" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
           <label>用戶名：</label><input type="text" id="username" value="" name="username" class="form-control" size="10">&nbsp;
            <label>角色:</label>
            <select name="role" data-toggle="selectpicker">
           	     <option value="">全部</option>
                 <option value="高級管理員">高級管理員</option>
                 <option value="管理員">管理員</option>
                 <option value="普通員工">普通員工</option>
            </select>&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div class="pull-right">
 				<div class="btn-group">
                    <button type="button" class="btn-default dropdown-toggle" data-toggle="dropdown" data-icon="copy">复选框-批量操作<span class="caret"></span></button>
                    <ul class="dropdown-menu right" role="menu">
                    <!-- 
                        <li><a href="book1.xlsx" data-toggle="doimport" data-confirm-msg="确定要导出信息吗？">导出<span style="color: green;">全部</span></a></li>
                        <li><a href="book1.xlsx" data-toggle="doimportchecked" data-confirm-msg="确定要导出选中项吗？" data-idname="expids" data-group="ids">导出<span style="color: red;">选中</span></a></li>
                         -->
                        <li class="divider"></li>
                        <li><a href="/user/delete.html" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-idname="delids" data-group="ids">删除选中</a></li>
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
                <th data-order-field="username">用戶名</th>
                <th data-order-field="role">角色</th>
                <th data-order-field="updateTime">添加時間</th>
                <th data-order-field="updaterName">添加人</th>
                <th width="26"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
                <th width="100">操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user" varStatus="i" >
          <tr data-id="${i.count}">
                <td><c:out value="${user.username }"></c:out></td>
                <td><c:out value="${user.role}"></c:out></td>
                <td><fmt:formatDate value="${user.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                <td><c:out value="${user.updaterName}"></c:out></td>
                <td><input type="checkbox" name="ids" data-toggle="icheck" value="${user.id}"></td>
                <td>
                    <a href="/user/edit/${user.id }.html" class="btn btn-green" data-toggle="navtab" data-id="form" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="编辑-${user.username}">编辑</a>
                    <a href="/user/delete.html?delids=${user.id }" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除该行信息吗？">删</a>
                </td>
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
        <span>&nbsp;条，共 ${totalPage } 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${totalPage }" data-page-size="30" data-page-current="1">
    </div>
</div>