package org.apache.jsp.jsp.import_;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class input_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function pic_upload_success(file, data) {\r\n");
      out.write("    var json = $.parseJSON(data)\r\n");
      out.write("    \r\n");
      out.write("    $(this).bjuiajax('ajaxDone', json)\r\n");
      out.write("    if (json[BJUI.keys.statusCode] == BJUI.statusCode.ok) {\r\n");
      out.write("        $('#j_custom_pic').val(json.filename).trigger('validate')\r\n");
      out.write("        $('#j_custom_span_pic').html('<img src=\"'+ json.filename +'\" width=\"100\" />')\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("function do_OK(json, $form) {\r\n");
      out.write("    console.log(json)\r\n");
      out.write("    console.log($form)\r\n");
      out.write("}\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$(\"select\").each(function(){\r\n");
      out.write("\t\t$temp=$(this);\r\n");
      out.write("\t\tif($temp.attr(\"data_show\")===undefined){\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$temp.children().each(function(){\r\n");
      out.write("\t\tif($(this).val()==$temp.attr(\"data_show\")){\r\n");
      out.write("\t\t\t$(this).attr(\"selected\",\"selected\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<div class=\"bjui-pageContent\">\r\n");
      out.write("    <form action=\"/import/import.html\"\" id=\"j_custom_form\"  method=\"post\" data-toggle=\"validate\" data-alertmsg=\"false\">\r\n");
      out.write("        <table class=\"table table-condensed table-hover\" width=\"100%\">\r\n");
      out.write("        <input type=\"hidden\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${import.id }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("        <input type=\"hidden\" name=\"oriProdNo\" id=\"oriProdNo\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${import.prodNo }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("            <tbody>\r\n");
      out.write("              <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <label for=\"j_custom_fname\" class=\"control-label x85\">入貨單號：</label>\r\n");
      out.write("                        <input type=\"text\" name=\"importNo\" id=\"importNo\" data-rule=\"required;integer;length[5]\" size=\"30\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${import.importNo }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                 <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <label for=\"j_custom_fname\" class=\"control-label x85\">產品編號：</label>\r\n");
      out.write("                         <input type=\"text\" name=\"importProdId\" id=\"importProdId\" data-rule=\"required;num_and_leters;length[9]\" size=\"30\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${import.importProdId }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" data-toggle=\"lookup\" data-url=\"/import/lookup/list_prod_name.html\" data-group=\"\" data-width=\"600\" data-height=\"400\">\r\n");
      out.write("                         <input type=\"hidden\" name=\"oriProdId\" id=\"oriProdId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${import.importProdId }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                         \r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <label for=\"j_custom_fname\" class=\"control-label x85\">產品名稱：</label>\r\n");
      out.write("                        <input type=\"text\" name=\"importName\" id=\"importName\" data-rule=\"required\" size=\"30\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${import.importName }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                 <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <label for=\"j_custom_fname\" class=\"control-label x85\">產品種類：</label>\r\n");
      out.write("                        <select name=\"importType\" id=\"importType\" data-toggle=\"selectpicker\" data-rule=\"required\" data-width=\"300\" data_show=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${import.importType }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                        </select>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                 <td>\r\n");
      out.write("                        <label for=\"j_custom_birthday\" class=\"control-label x85\">入貨日期：</label>\r\n");
      out.write("                        <input type=\"text\" name=\"importDate\" id=\"importDate\" data-toggle=\"datepicker\" data-rule=\"required;date\" size=\"30\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${import.strImportDate }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                \r\n");
      out.write("              <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <label for=\"j_custom_sale\" class=\"control-label x85\">入貨尺碼：</label>\r\n");
      out.write("                        <select name=\"importSize\" id=\"importSize\" data-toggle=\"selectpicker\" data-rule=\"required\" data-width=\"300\" data_show=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${import.importSize }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                        </select>\r\n");
      out.write("                      <input type=\"hidden\" name=\"oriImportSize\" id=\"oriImportSize\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${import.importSize }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <label for=\"j_custom_fname\" class=\"control-label x85\">數量：</label>\r\n");
      out.write("                        <input type=\"text\" name=\"nums\" id=\"nums\" data-rule=\"required;integer\" size=\"30\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${import.nums }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                      <input type=\"hidden\" name=\"oriNums\" id=\"oriNums\"  size=\"30\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${import.nums }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <label for=\"j_custom_note\" class=\"control-label x85\">備註：</label>\r\n");
      out.write("                        <textarea name=\"remark\" id=\"j_custom_note\" data-toggle=\"autoheight\" cols=\"60\" rows=\"5\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${import.remark }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></textarea>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"bjui-pageFooter\">\r\n");
      out.write("    <ul>\r\n");
      out.write("        <li><button type=\"button\" class=\"btn-close\" data-icon=\"close\">取消</button></li>\r\n");
      out.write("        <li><button type=\"submit\" class=\"btn-default\" data-icon=\"save\">保存</button></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</div>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${items}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("item");
    _jspx_th_c_forEach_0.setVarStatus("i");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                              <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item. typeName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item. typeName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\r\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sizes}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("size");
    _jspx_th_c_forEach_1.setVarStatus("i");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                              <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\r\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}
