package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script src=\"BJUI/js/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("<script src=\"BJUI/js/jquery.cookie.js\"></script>\r\n");
      out.write("<script src=\"js/sha256.js\"></script>\r\n");
      out.write("<link href=\"BJUI/themes/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("* {font-family: \"Verdana\", \"Tahoma\", \"Lucida Grande\", \"Microsoft YaHei\", \"Hiragino Sans GB\", sans-serif;}\r\n");
      out.write("body {\r\n");
      out.write("    background: url(images/1.jpg) no-repeat center center fixed;\r\n");
      out.write("    -webkit-background-size: cover;\r\n");
      out.write("    -moz-background-size: cover;\r\n");
      out.write("    -o-background-size: cover;\r\n");
      out.write("    background-size: cover;\r\n");
      out.write("}\r\n");
      out.write("a:link {color: #285e8e;}\r\n");
      out.write(".main_box {\r\n");
      out.write("    position: absolute; top:50%; left:50%; margin-top:-260px; margin-left: -300px; padding: 30px; width:600px; height:460px;\r\n");
      out.write("    background: #FAFAFA; background: rgba(255,255,255,0.5); border: 1px #DDD solid;\r\n");
      out.write("    border-radius: 5px;\r\n");
      out.write("    -webkit-box-shadow: 1px 5px 8px #888888; -moz-box-shadow: 1px 5px 8px #888888; box-shadow: 1px 5px 8px #888888;\r\n");
      out.write("}\r\n");
      out.write(".main_box .setting {position: absolute; top: 5px; right: 10px; width: 10px; height: 10px;}\r\n");
      out.write(".main_box .setting a {color: #FF6600;}\r\n");
      out.write(".main_box .setting a:hover {color: #555;}\r\n");
      out.write(".login_logo {margin-bottom: 20px; height: 45px; text-align: center;}\r\n");
      out.write(".login_logo img {height: 45px;}\r\n");
      out.write(".login_msg {text-align: center; font-size: 16px;}\r\n");
      out.write(".login_form {padding-top: 20px; font-size: 16px;}\r\n");
      out.write(".login_box .form-control {display: inline-block; *display: inline; zoom: 1; width: auto; font-size: 18px;}\r\n");
      out.write(".login_box .form-control.x319 {width: 319px;}\r\n");
      out.write(".login_box .form-control.x164 {width: 164px;}\r\n");
      out.write(".login_box .form-group {margin-bottom: 20px;}\r\n");
      out.write(".login_box .form-group label.t {width: 120px; text-align: right; cursor: pointer;}\r\n");
      out.write(".login_box .form-group.space {padding-top: 15px; border-top: 1px #FFF dotted;}\r\n");
      out.write(".login_box .form-group img {margin-top: 1px; height: 32px; vertical-align: top;}\r\n");
      out.write(".login_box .m {cursor: pointer;}\r\n");
      out.write(".bottom {text-align: center; font-size: 12px;}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var COOKIE_NAME = 'sys__username';\r\n");
      out.write("$(function() {\r\n");
      out.write("    //choose_bg();\r\n");
      out.write("\t//changeCode();\r\n");
      out.write("\tif ($.cookie(COOKIE_NAME)){\r\n");
      out.write("\t    $(\"#j_username\").val($.cookie(COOKIE_NAME));\r\n");
      out.write("\t    $(\"#j_password\").focus();\r\n");
      out.write("\t    $(\"#j_remember\").attr('checked', true);\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\t$(\"#j_username\").focus();\r\n");
      out.write("\t}\r\n");
      out.write("\t/*$(\"#captcha_img\").click(function(){\r\n");
      out.write("\t\tchangeCode();\r\n");
      out.write("\t});*/\r\n");
      out.write("\t$(\"#login_form\").submit(function(){\r\n");
      out.write("\t\tvar issubmit = true;\r\n");
      out.write("\t\tvar i_index  = 0;\r\n");
      out.write("\t\t$(this).find('.in').each(function(i){\r\n");
      out.write("\t\t\tif ($.trim($(this).val()).length == 0) {\r\n");
      out.write("\t\t\t\t$(this).css('border', '1px #ff0000 solid');\r\n");
      out.write("\t\t\t\tissubmit = false;\r\n");
      out.write("\t\t\t\tif (i_index == 0)\r\n");
      out.write("\t\t\t\t\ti_index  = i;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tif (!issubmit) {\r\n");
      out.write("\t\t\t$(this).find('.in').eq(i_index).focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar $remember = $(\"#j_remember\");\r\n");
      out.write("\t\tif ($remember.attr('checked')) {\r\n");
      out.write("\t\t\t$.cookie(COOKIE_NAME, $(\"#j_username\").val(), { path: '/', expires: 15 });\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$.cookie(COOKIE_NAME, null, { path: '/' });  //删除cookie\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$(\"#login_ok\").attr(\"disabled\", true).val('登陆中..');\r\n");
      out.write("\t\t//var password = HMAC_SHA256_MAC($(\"#j_username\").val(), $(\"#j_password\").val());\r\n");
      out.write("\t\t//$(\"#j_password\").val(HMAC_SHA256_MAC($(\"#j_randomKey\").val(), password));\r\n");
      out.write("        //window.location.href = 'index.html'; /*注意：生产环境时请删除此行*/\r\n");
      out.write("        return true;\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("function genTimestamp(){\r\n");
      out.write("\tvar time = new Date();\r\n");
      out.write("\treturn time.getTime();\r\n");
      out.write("}\r\n");
      out.write("function changeCode(){\r\n");
      out.write("\t//$(\"#captcha_img\").attr(\"src\", \"/captcha.jpeg?t=\"+genTimestamp());\r\n");
      out.write("}\r\n");
      out.write("function choose_bg() {\r\n");
      out.write("\tvar bg = Math.floor(Math.random() * 9 + 1);\r\n");
      out.write("\t$('body').css('background-image', 'url(images/loginbg_0'+ bg +'.jpg)');\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!--[if lte IE 7]>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#errorie {position: fixed; top: 0; z-index: 100000; height: 30px; background: #FCF8E3;}\r\n");
      out.write("#errorie div {width: 900px; margin: 0 auto; line-height: 30px; color: orange; font-size: 14px; text-align: center;}\r\n");
      out.write("#errorie div a {color: #459f79;font-size: 14px;}\r\n");
      out.write("#errorie div a:hover {text-decoration: underline;}\r\n");
      out.write("</style>\r\n");
      out.write("<div id=\"errorie\"><div>您还在使用老掉牙的IE，请升级您的浏览器到 IE8以上版本 <a target=\"_blank\" href=\"http://windows.microsoft.com/zh-cn/internet-explorer/ie-8-worldwide-languages\">点击升级</a>&nbsp;&nbsp;强烈建议您更改换浏览器：<a href=\"http://down.tech.sina.com.cn/content/40975.html\" target=\"_blank\">谷歌 Chrome</a></div></div>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<div class=\"main_box\">\r\n");
      out.write("\t<div class=\"login_box\">\r\n");
      out.write("        <div class=\"login_logo\" style=\"font-size: 33px\">\r\n");
      out.write("          \t誠品球衣倉庫管理系統\r\n");
      out.write("        </div>\r\n");
      out.write("        <div style=\"\r\n");
      out.write("    font-size: 15px;\r\n");
      out.write("    color: red;\r\n");
      out.write("    padding-left: 181px;\r\n");
      out.write("        \">\r\n");
      out.write("        \t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errorMessage }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <!--\r\n");
      out.write("\t\t<c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${!empty message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t<div class=\"login_msg\">\r\n");
      out.write("\t      \t\t<font color=\"red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</font>\r\n");
      out.write("\t    \t</div>\r\n");
      out.write("\t    </c:if>\r\n");
      out.write("        -->\r\n");
      out.write("        <div class=\"login_form\">\r\n");
      out.write("            <input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${randomKey }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" id=\"j_randomKey\" />\r\n");
      out.write("    \t\t<form action=\"./logon.html\" id=\"login_form\" method=\"post\">\r\n");
      out.write("                <input type=\"hidden\" name=\"jfinal_token\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${jfinal_token }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("    \t\t\t<div class=\"form-group\">\r\n");
      out.write("    \t\t\t\t<label for=\"j_username\" class=\"t\">用户名：</label> <input id=\"j_username\" value=\"\" name=\"username\" type=\"text\" class=\"form-control x319 in\" autocomplete=\"off\">\r\n");
      out.write("    \t\t\t</div>\r\n");
      out.write("    \t\t\t<div class=\"form-group\">\r\n");
      out.write("    \t\t\t\t<label for=\"j_password\" class=\"t\">密　码：</label> <input id=\"j_password\" value=\"\" name=\"password\" type=\"password\" class=\"form-control x319 in\">\r\n");
      out.write("    \t\t\t</div>\r\n");
      out.write("    \t\t\t<!-- \r\n");
      out.write("    \t\t\t<div class=\"form-group\">\r\n");
      out.write("    \t\t\t\t<label for=\"j_captcha\" class=\"t\">验证码：</label> <input id=\"j_captcha\" name=\"j_captcha\" type=\"text\" class=\"form-control x164 in\">\r\n");
      out.write("    \t\t\t\t<img id=\"captcha_img\" alt=\"点击更换\" title=\"点击更换\" src=\"images/captcha.jpeg\" class=\"m\">\r\n");
      out.write("    \t\t\t</div>\r\n");
      out.write("    \t\t\t -->\r\n");
      out.write("    \t\t\t<div class=\"form-group\">\r\n");
      out.write("                    <label class=\"t\"></label>\r\n");
      out.write("                    <label for=\"j_remember\" class=\"m\"><input id=\"j_remember\" type=\"checkbox\" value=\"true\">&nbsp;记住登陆账号!</label>\r\n");
      out.write("    \t\t\t</div>\r\n");
      out.write("    \t\t\t<div class=\"form-group space\">\r\n");
      out.write("                    <label class=\"t\"></label>　　　\r\n");
      out.write("    \t\t\t\t<input type=\"submit\" id=\"login_ok\" value=\"&nbsp;登&nbsp;录&nbsp;\" class=\"btn btn-primary btn-lg\">&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("    \t\t\t\t<input type=\"reset\" value=\"&nbsp;重&nbsp;置&nbsp;\" class=\"btn btn-default btn-lg\">\r\n");
      out.write("    \t\t\t</div>\r\n");
      out.write("    \t\t</form>\r\n");
      out.write("        </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
