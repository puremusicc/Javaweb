package com.csi.filter;

import com.csi.pojo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "UsersFilter",urlPatterns = {"/cart","/cart.jsp","/order"})
public class UsersFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //判断是否是登录过的用户
        //先获取session中存储的用户信息
//        System.out.println("状态过滤");
        HttpServletRequest request=(HttpServletRequest)req;
        Users users=(Users)request.getSession().getAttribute("users");
        if(users==null){
            ((HttpServletRequest)req).getSession().setAttribute("msg","请先登录");
            //如果用户是空，证明没登录，跳转到登录页面
            ((HttpServletResponse)resp).sendRedirect("login.jsp");
        }else{
            ((HttpServletRequest)req).getSession().removeAttribute("msg");
            //如果不是空，继续执行下一个过滤器
            chain.doFilter(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
