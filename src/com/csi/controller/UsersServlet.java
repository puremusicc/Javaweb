package com.csi.controller;

import com.csi.biz.UsersBiz;
import com.csi.biz.impl.UsersBizImpl;
import com.csi.pojo.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/users","/manager/users.do"})
public class UsersServlet extends HttpServlet {
    private UsersBiz ubiz=new UsersBizImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        //获取请求的功能
        String mth = req.getParameter("mth");
        switch(mth){
            case "register":
                register(req,resp);
                break;
            case "login":
                login(req,resp);
                break;
            case "findAll":
                findAll(req,resp);
                break;
            case "modifyState":
                modifyState(req,resp);
                break;
            case "userModify":
                userModify(req,resp);
                break;
            case "exit":
                exit(req,resp);
                break;
        }
    }
    protected void exit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("users");
        resp.sendRedirect("index.jsp");
    }
    protected void userModify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取数据
        int userId=Integer.parseInt(req.getParameter("userId"));
        int state=Integer.parseInt(req.getParameter("state"));
        String loginName = req.getParameter("loginName");
        String pwd = req.getParameter("pwd");
        String phone = req.getParameter("phone");
        String nick = req.getParameter("nick");
        String sex = req.getParameter("sex");
        //封装对象
        Users users=new Users(userId,loginName,pwd,nick,sex,phone,state);
        if(ubiz.modify(users)){
            req.setAttribute("result","操作成功");
            req.getSession().setAttribute("users",users);
        }else{
            req.setAttribute("result","操作失败");
        }
        req.getRequestDispatcher("userinfo.jsp").forward(req,resp);
    }
    /**
     * 修改状态
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void modifyState(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户id
        int uid=Integer.parseInt(req.getParameter("uid"));
        //获取状态值
        int state=Integer.parseInt(req.getParameter("state"));

        //根据用户id查询用户
        Users user = ubiz.findById(uid);
        //设置用户状态
        user.setState(state);
        //修改数据库
        boolean b = ubiz.modify(user);
        if(b){
            req.setAttribute("msg","操作成功");

        }else {
            req.setAttribute("msg","操作失败");

        }

        req.getRequestDispatcher("manage-result.jsp").forward(req,resp);

    }
    /**
     * 查看所有用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Users> all = ubiz.findAll();
        req.setAttribute("userList",all);
        req.getRequestDispatcher("user.jsp").forward(req,resp);
    }
    /**
     * 注册功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取数据
        String loginName = req.getParameter("loginName");
        String pwd = req.getParameter("pwd");
        String phone = req.getParameter("phone");
        String nick = req.getParameter("nick");
        String sex = req.getParameter("sex");
        //封装对象
        Users users=new Users(null,loginName,pwd,nick,sex,phone,1);
        //调用biz

        //跳转
        if(ubiz.register(users)){
            resp.sendRedirect("login.jsp");
        }else{
            resp.sendRedirect("register.jsp");
        }
    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginName = req.getParameter("loginName");
        String pwd = req.getParameter("pwd");
        Users users = ubiz.login(loginName, pwd);
        //用户是否为空，如果不是空，证明登录成功
        if(users!=null){
            if(users.getState()!=1){
                req.getSession().setAttribute("msg","该用户已被禁用");
                resp.sendRedirect("login.jsp");
            }else{
                //存储登录用户的信息，存储到当前会话中
                req.getSession().setAttribute("users",users);
                //删除登录失败信息
                req.getSession().removeAttribute("msg");
                resp.sendRedirect("index.jsp");
            }
        }else{
            req.getSession().setAttribute("msg","用户名或密码错误");
            resp.sendRedirect("login.jsp");
        }
    }
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
//    }
}
