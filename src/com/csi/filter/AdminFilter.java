package com.csi.filter;

import com.csi.pojo.Admin;
import com.csi.pojo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter",urlPatterns = {"*.do","/manager/index.jsp"})
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        Admin admin=(Admin)request.getSession().getAttribute("admin");
        String url = request.getRequestURI();
        String mth = request.getParameter("mth");
        if(!"login".equals(mth)){
            if(admin==null){
                request.getSession().setAttribute("lmsg","请先登录");
                //如果用户是空，证明没登录，跳转到登录页面
                ((HttpServletResponse)resp).sendRedirect("login.jsp");
            }else{
                ((HttpServletRequest)req).getSession().removeAttribute("lmsg");
                //如果不是空，继续执行下一个过滤器
                chain.doFilter(req,resp);
            }
        }else{
            chain.doFilter(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
