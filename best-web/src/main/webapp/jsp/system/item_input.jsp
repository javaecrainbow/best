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
    <form action="/item/add.html" id="j_custom_form" data-toggle="validate" data-alertmsg="false">
            <input type="hidden" name="id" value="${item.id }"/>

        <table class="table table-condensed table-hover" width="100%">
        <input type="hidden" name="id" value="${item.id }"/>
            <tbody>
              <tr>
                    <td>
                        <label for="j_custom_fname" class="control-label x95">產品種類名稱：</label>
                        <input type="text" name="typeName" id="typeName" data-rule="required" size="30" value="${item.typeName}">
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