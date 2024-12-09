package com.csi.controller;

import com.csi.biz.AdminBiz;
import com.csi.biz.impl.AdminBizImpl;
import com.csi.pojo.Admin;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet",urlPatterns = "/manager/admin.do")
public class AdminServlet extends HttpServlet {
    private AdminBiz abiz =new AdminBizImpl();
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=utf-8");
        res.setCharacterEncoding("UTF-8");
        String mth = req.getParameter("mth");
        switch(mth){
            case "login":
                login(req,res);
                break;
            case "exit":
                exit(req,res);
                break;
            case "findAll":
                findAll(req,res);
                break;
            case "toModify":
                toModify(req,res);
                break;
            case "modify":
                modify(req,res);
                break;
            case "remove":
                remove(req,res);
                break;
            case "add":
                add(req,res);
                break;
        }
    }
//    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        super.service(req, res);
//    }
    public void add(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String aname = req.getParameter("aname");
        String pwd = req.getParameter("pwd");
        Admin a=new Admin(aname,pwd);
        if(abiz.add(a)){
            req.setAttribute("msg","操作成功");
        }else{
            req.setAttribute("msg","操作失败");
        }
        req.getRequestDispatcher("manage-result.jsp").forward(req,res);
    }
    /**
     * 删除管理员
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void remove(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int aid=Integer.parseInt(req.getParameter("aid"));
        if(abiz.remove(aid)){
            req.setAttribute("msg","操作成功");
        }else{
            req.setAttribute("msg","操作失败");
        }
        req.getRequestDispatcher("manage-result.jsp").forward(req,res);
    }
    /**
     * 修改管理员信息
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void modify(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Admin login=(Admin)req.getSession().getAttribute("admin");
        int aid=Integer.parseInt(req.getParameter("aid"));
        String state=req.getParameter("state");
        String pwd = req.getParameter("pwd");
//        Admin admin=new Admin(aid,pwd,state);
        Admin admin = abiz.findByAid(aid);
        if(state!=null){
            admin.setState(Integer.parseInt(state));
        }
        admin.setPwd(pwd);
        if(abiz.modify(admin)){
            if(aid==login.getAid()&&pwd!=login.getPwd()){
                res.sendRedirect("login.jsp");
            }else{
                req.setAttribute("msg","操作成功");
                req.getRequestDispatcher("manage-result.jsp").forward(req,res);
            }

        }else{
            req.setAttribute("msg","操作失败");
            req.getRequestDispatcher("manage-result.jsp").forward(req,res);
        }


    }
    public void toModify(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int aid=Integer.parseInt(req.getParameter("aid"));
        Admin am = abiz.findByAid(aid);
        req.setAttribute("am",am);
        req.getRequestDispatcher("admin-modify.jsp").forward(req,res);
    }


    /**
     * 获取所有管理员
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void findAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Admin> all = abiz.findAll();
        req.setAttribute("adminList",all);
        req.getRequestDispatcher("admin.jsp").forward(req,res);
    }
    /**
     * 退出登录
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void exit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getSession().removeAttribute("admin");
        res.sendRedirect("login.jsp");
    }
    /**
     * 管理员登录
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String aname = req.getParameter("aname");
        String pwd = req.getParameter("pwd");
        Admin admin = abiz.login(aname, pwd);
        System.out.println("aa"+admin);
        if(admin!=null){
            if(admin.getState()!=1){
                req.getSession().setAttribute("bmsg","该账号被禁用");
                res.sendRedirect("login.jsp");
            }else{
                req.getSession().setAttribute("admin",admin);
                req.getSession().removeAttribute("bmsg");
                res.sendRedirect("index.jsp");
            }
        }else {
            req.getSession().setAttribute("bmsg","用户名或密码错误");
            res.sendRedirect("login.jsp");
        }
    }

}
