<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/import/lookup/list.html" method="post">
        <input type="hidden" name="pageCurrent" value="1">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <div class="bjui-searchBar">
            <label>產品編號：</label><input type="text" id="importProdId" name="importProdId" class="form-control" size="10">&nbsp;
            <label>產品名稱：</label><input type="text" id="importName" name="importName" class="form-control" size="10">&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查詢</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查詢</a></li>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table data-toggle="tablefixed" data-width="100%">
        <thead>
            <tr>
                <th>產品編號</th>
                <th>產品名稱</th>
                <th>產品類型</th>
                <th>產品尺碼</th>
                <th>產品數量</th>
                <th width="74">操作</th>
            </tr>
        </thead>
        <tbody>
        
        <c:forEach items="${products}" var="product" varStatus="i" >
                <td><c:out value="${product.prodNo }"></c:out></td>
               <td><c:out value="${product.prodName}"></c:out></td>
               <td><c:out value="${product.prodType}"></c:out></td>
               <td><c:out value="${product.prodSize}"></c:out></td>
               <td><c:out value="${product.nums}"></c:out></td>
                <td>
                    <a href="javascript:;" data-toggle="lookupback" data-args="{prodNo:'${product.id }',exportProdId:'${product.prodNo }',exportName:'${product.prodName }',exportType:'${product.prodType }',exportSize:'${product.prodSize }',nums:'${product.nums }'}" class="btn btn-blue" title="選擇本項" data-icon="check">選擇</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="bjui-pageFooter">
    <div class="pages">
        <span>每頁&nbsp;</span>
        <div class="selectPagesize">
            <select data-toggle="selectpicker" data-toggle-change="changepagesize">
                 <option value="10">10</option>
                <option value="30">30</option>
                <option value="60">60</option>
            </select>
        </div>
        <span>&nbsp;條，共 ${totalPage } 條</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${totalPage }" data-page-size="30" data-page-current="1">
    </div>
</div>
