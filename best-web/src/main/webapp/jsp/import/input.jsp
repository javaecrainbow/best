<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
function pic_upload_success(file, data) {
    var json = $.parseJSON(data)
    
    $(this).bjuiajax('ajaxDone', json)
    if (json[BJUI.keys.statusCode] == BJUI.statusCode.ok) {
        $('#j_custom_pic').val(json.filename).trigger('validate')
        $('#j_custom_span_pic').html('<img src="'+ json.filename +'" width="100" />')
    }
}
function do_OK(json, $form) {
    console.log(json)
    console.log($form)
}
$(function(){
	$("select").each(function(){
		$temp=$(this);
		if($temp.attr("data_show")===undefined){
			return;
		}
		$temp.children().each(function(){
		if($(this).val()==$temp.attr("data_show")){
			$(this).attr("selected","selected");
		}
		});
	});
	
});
</script>
<div class="bjui-pageContent">
    <form action="/import/import.html"" id="j_custom_form"  method="post" data-toggle="validate" data-alertmsg="false">
        <table class="table table-condensed table-hover" width="100%">
        <input type="hidden" name="id" value="${import.id }"/>
        <input type="hidden" name="oriProdNo" id="oriProdNo" value="${import.prodNo }">
            <tbody>
              <tr>
                    <td>
                        <label for="j_custom_fname" class="control-label x85">入貨單號：</label>
                        <input type="text" name="importNo" id="importNo" data-rule="required;integer;length[5]" size="30" value="${import.importNo }">
                    </td>
                </tr>
                 <tr>
                    <td>
                        <label for="j_custom_fname" class="control-label x85">產品編號：</label>
                         <input type="text" name="importProdId" id="importProdId" data-rule="required;num_and_leters;length[9]" size="30" value="${import.importProdId }" data-toggle="lookup" data-url="/import/lookup/list_prod_name.html" data-group="" data-width="600" data-height="400">
                         <input type="hidden" name="oriProdId" id="oriProdId" value="${import.importProdId }">
                         
                    </td>
                </tr>
                  <tr>
                    <td>
                        <label for="j_custom_fname" class="control-label x85">產品名稱：</label>
                        <input type="text" name="importName" id="importName" data-rule="required" size="30" value="${import.importName }">
                    </td>
                </tr>
                 <tr>
                    <td>
                        <label for="j_custom_fname" class="control-label x85">產品種類：</label>
                        <select name="importType" id="importType" data-toggle="selectpicker" data-rule="required" data-width="300" data_show="${import.importType }">
                            <c:forEach items="${items}" var="item" varStatus="i" >
                              <option value="${item. typeName}">${item. typeName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                 <td>
                        <label for="j_custom_birthday" class="control-label x85">入貨日期：</label>
                        <input type="text" name="importDate" id="importDate" data-toggle="datepicker" data-rule="required;date" size="30" value="${import.strImportDate }">
                    </td>
                </tr>
                
              <tr>
                    <td>
                        <label for="j_custom_sale" class="control-label x85">入貨尺碼：</label>
                        <select name="importSize" id="importSize" data-toggle="selectpicker" data-rule="required" data-width="300" data_show="${import.importSize }">
                            <c:forEach items="${sizes}" var="size" varStatus="i" >
                              <option value="${size}">${size}</option>
                            </c:forEach>
                        </select>
                      <input type="hidden" name="oriImportSize" id="oriImportSize" value="${import.importSize }">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="j_custom_fname" class="control-label x85">數量：</label>
                        <input type="text" name="nums" id="nums" data-rule="required;integer" size="30" value="${import.nums }">
                      <input type="hidden" name="oriNums" id="oriNums"  size="30" value="${import.nums }">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="j_custom_note" class="control-label x85">備註：</label>
                        <textarea name="remark" id="j_custom_note" data-toggle="autoheight" cols="60" rows="5" value="${import.remark }"></textarea>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">取消</button></li>
        <li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
    </ul>
</div>