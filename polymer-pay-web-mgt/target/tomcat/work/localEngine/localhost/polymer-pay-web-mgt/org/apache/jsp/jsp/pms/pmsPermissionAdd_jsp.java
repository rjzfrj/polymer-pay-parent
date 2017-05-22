package org.apache.jsp.jsp.pms;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pmsPermissionAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/jsp/pms/../../common/taglib/taglib.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.release();
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

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<div class=\"pageContent\">\n");
      out.write("\t<form id=\"form1\" method=\"post\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${baseURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/pms/permission/add\" class=\"pageForm required-validate\" onsubmit=\"return validateCallback(this, dialogAjaxDone);\">\n");
      out.write("\t\t<div class=\"pageFormContent\" layoutH=\"58\">\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"navTabId\" value=\"qxgl\">\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"callbackType\" value=\"closeCurrent\">\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"forwardUrl\" value=\"\">\n");
      out.write("\n");
      out.write("\t\t\t<p>\n");
      out.write("\t\t\t\t<label>权限名称：</label>\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"permissionName\" class=\"required\" minlength=\"3\" maxlength=\"50\" size=\"30\" />\n");
      out.write("\t\t\t</p>\n");
      out.write("\t\t\t<p>\n");
      out.write("\t\t\t\t<label>权限标识：</label>\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"permission\" class=\"required\" minlength=\"3\" maxlength=\"50\" size=\"30\" />\n");
      out.write("\t\t\t\t<span class=\"info\"></span>\n");
      out.write("\t\t\t</p>\n");
      out.write("\t\t\t<p style=\"width: 99%\">\n");
      out.write("\t\t\t\t<label></label>\n");
      out.write("\t\t\t\t<span style=\"color: red;\">提示：权限标识添加后将不可修改，请确保添加信息的准确性！</span>\n");
      out.write("\t\t\t</p>\n");
      out.write("\t\t\t<p style=\"height: 50px;\">\n");
      out.write("\t\t\t\t<label>权限描述：</label>\n");
      out.write("\t\t\t\t<textarea rows=\"3\" cols=\"27\" name=\"remark\" class=\"required\" minlength=\"3\" maxlength=\"60\"></textarea>\n");
      out.write("\t\t\t</p>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"formBar\">\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t<div class=\"buttonActive\">\n");
      out.write("\t\t\t\t\t\t<div class=\"buttonContent\">\n");
      out.write("\t\t\t\t\t\t\t<button type=\"button\" onclick=\"submitForm()\">保存</button>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t<div class=\"button\">\n");
      out.write("\t\t\t\t\t\t<div class=\"buttonContent\">\n");
      out.write("\t\t\t\t\t\t\t<button type=\"button\" class=\"close\">取消</button>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t</form>\n");
      out.write("</div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tfunction submitForm() {\n");
      out.write("\t\t$(\"#form1\").submit();\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\t// 查找带回的拓展功能\n");
      out.write("\t$.extend({\n");
      out.write("\t\tbringBackSuggest : function(args) {\n");
      out.write("\t\t\t$(\"input[name='menu.id']\").val(args[\"id\"]);\n");
      out.write("\t\t\t$(\"input[name='menu.name']\").val(args[\"name\"]);\n");
      out.write("\t\t},\n");
      out.write("\t\tbringBack : function(args) {\n");
      out.write("\t\t\t$.bringBackSuggest(args);\n");
      out.write("\t\t\t$.pdialog.closeCurrent();\n");
      out.write("\t\t}\n");
      out.write("\t});\n");
      out.write("</script>\n");
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

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /jsp/pms/../../common/taglib/taglib.jsp(7,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("baseURL");
    // /jsp/pms/../../common/taglib/taglib.jsp(7,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/jsp/pms/../../common/taglib/taglib.jsp(7,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /jsp/pms/../../common/taglib/taglib.jsp(7,0) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setScope("request");
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}
