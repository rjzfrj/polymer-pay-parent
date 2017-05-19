package org.apache.jsp.jsp.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, (java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${baseURL }/common/taglib/taglib.jsp", java.lang.String.class, (PageContext)_jspx_page_context, null, false), out, false);
      out.write("\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<title>支付后台</title>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${baseURL }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/dwz/themes/css/login.css\" />\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${baseURL }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/common/js/login/login.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<div id=\"login\">\n");
      out.write("\t\t<div id=\"login_header\">\n");
      out.write("\t\t\t<h1 class=\"login_logo\">\n");
      out.write("\t\t\t\t<a href=\"http://demo.dwzjs.com\">\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${baseURL }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/dwz/themes/default/images/login_logo.png\" />\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t</h1>\n");
      out.write("\t\t\t<div class=\"login_headerContent\">\n");
      out.write("\t\t\t\t<div class=\"navList\">\n");
      out.write("\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">设为首页</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<h2 class=\"login_title\">\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${baseURL }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/dwz/themes/default/images/login_title.png\" />\n");
      out.write("\t\t\t\t</h2>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"login_content\">\n");
      out.write("\t\t\t<div class=\"loginForm\">\n");
      out.write("\t\t\t\t<form id=\"form1\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${baseURL }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/login\" method=\"post\">\n");
      out.write("\t\t\t\t\t<div style=\"color: red; padding-left: 80px; padding-bottom: 10px;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</div>\n");
      out.write("\t\t\t\t\t<div class=\"login_user\">\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t<label>帐&nbsp;&nbsp;&nbsp;&nbsp;号：</label>\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"loginName\" size=\"18\" class=\"login_input\" />\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t<label>密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\" name=\"roncooPwd\" size=\"18\" class=\"login_input\" />\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${captchaEbabled}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t\t\t\t\t<div class=\"login_code\">\n");
      out.write("\t\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<label>验证码：</label>\n");
      out.write("\t\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"input_code\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"code\" name=\"captchaCode\" size=\"6\" />\n");
      out.write("\t\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<span> <img class=\"rcCaptcha-btn rcCaptcha-img\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${baseURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/rcCaptcha.jpg\" alt=\"点击更换验证码\" title=\"点击更换验证码\" width=\"65\" height=\"24\" />\n");
      out.write("\t\t\t\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</c:if>\n");
      out.write("\t\t\t\t\t<div class=\"login_bar\">\n");
      out.write("\t\t\t\t\t\t<input class=\"sub\" type=\"submit\" value=\" \" />\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"login_banner\">\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${baseURL }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/dwz/themes/default/images/login_banner.jpg\" />\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"login_main\">\n");
      out.write("\t\t\t\t<ul class=\"helpList\">\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t\t<div class=\"login_inner\"></div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"login_footer\">\n");
      out.write("\t\t\tCopyright &copy; 2015-2016\n");
      out.write("\t\t\t<a href=\"http://\" target=\"_blank\"></a>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<script>\n");
      out.write("\t\t$(function() {\n");
      out.write("\t\t\t$(\".rcCaptcha-btn\").click(\n");
      out.write("\t\t\t\t\tfunction() {\n");
      out.write("\t\t\t\t\t\t$(\".rcCaptcha-img\").attr(\n");
      out.write("\t\t\t\t\t\t\t\t\"src\",\n");
      out.write("\t\t\t\t\t\t\t\t'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${baseURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/rcCaptcha.jsp?'\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ new Date().getTime());\n");
      out.write("\t\t\t\t\t});\n");
      out.write("\t\t});\n");
      out.write("\t</script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
