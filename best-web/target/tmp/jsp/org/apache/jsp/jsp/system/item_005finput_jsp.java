package org.apache.jsp.jsp.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class item_005finput_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      out.write("    <form action=\"/item/add.html\" id=\"j_custom_form\" data-toggle=\"validate\" data-alertmsg=\"false\">\r\n");
      out.write("            <input type=\"hidden\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.id }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("\r\n");
      out.write("        <table class=\"table table-condensed table-hover\" width=\"100%\">\r\n");
      out.write("        <input type=\"hidden\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.id }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("            <tbody>\r\n");
      out.write("              <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <label for=\"j_custom_fname\" class=\"control-label x95\">產品種類名稱：</label>\r\n");
      out.write("                        <input type=\"text\" name=\"typeName\" id=\"typeName\" data-rule=\"required\" size=\"30\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.typeName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
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
}
