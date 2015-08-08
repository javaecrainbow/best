<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
            <tr>
                <th data-order-field="import_no">產品種類編號</th>
               <th data-order-field="import_prod_id">產品種類名稱</th>
                <th width="26"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
                <th width="100">操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${items}" var="item" varStatus="i" >
          <tr data-id="${i.count}">
                <td><c:out value="${item.id }"></c:out></td>
                <td><c:out value="${item.typeName }"></c:out></td>
                <td><input type="checkbox" name="ids" data-toggle="icheck" value="${item.id}"></td>
                <td>
                    <a href="/item/edit/${item.id }.html" class="btn btn-green" data-toggle="navtab" data-id="form" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="编辑-${item.typeName}">编辑</a>
                    <a href="/item/delete.html?delids=${item.id }" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除该行信息吗？">删</a>
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
<script>
function pageCallback(){
	alert("call back");
}
</script>