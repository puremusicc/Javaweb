package com.csi.controller;

import com.csi.biz.GoodsTypeBiz;
import com.csi.biz.impl.GoodsTypeBizImpl;
import com.csi.pojo.GoodsType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GoodsTypeServlet",urlPatterns = "/manager/type.do")
public class GoodsTypeServlet extends HttpServlet {
    private GoodsTypeBiz tbiz=new GoodsTypeBizImpl();
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=utf-8");
        res.setCharacterEncoding("UTF-8");
        String mth = req.getParameter("mth");
        switch(mth){
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
//    protected void add(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//
//    }

    /**
     * 添加类型
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String tname = req.getParameter("tname");
        tname=new String(tname.getBytes("ISO-8859-1"),"UTF-8");
        GoodsType type=new GoodsType(tname);
        if(tbiz.addType(type)){
            req.setAttribute("msg","操作成功");
        }else{
            req.setAttribute("msg","操作失败");
        }
        req.getRequestDispatcher("manage-result.jsp").forward(req,res);

    }
    /**
     * 删除功能
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    protected void remove(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //获取要修改的类型编号
        int tid=Integer.parseInt(req.getParameter("tid"));
        if(tbiz.removeType(tid)){
            req.setAttribute("msg","操作成功");
        }else{
            req.setAttribute("msg","操作失败");
        }
        req.getRequestDispatcher("manage-result.jsp").forward(req,res);
    }
    /**
     * 修改类型信息
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    protected void modify(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //获取要修改的类型编号
        int tid=Integer.parseInt(req.getParameter("tid"));
        //根据编号查询类型信息
        GoodsType type = tbiz.findById(tid);
        //获取类型名称
        String tname = req.getParameter("tname");
        //处理字符编码方式
        tname=new String(tname.getBytes("ISO-8859-1"),"UTF-8");
        type.setTname(tname);
        if(tbiz.modifyType(type)){
            req.setAttribute("msg","操作成功");
        }else{
            req.setAttribute("msg","操作失败");
        }
        req.getRequestDispatcher("manage-result.jsp").forward(req,res);
    }
    /**
     * 跳转修改页面之前获取数据
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    protected void toModify(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //获取要修改的类型编号
        int tid=Integer.parseInt(req.getParameter("tid"));
        //根据编号查询类型信息
        GoodsType type = tbiz.findById(tid);
        //存储类型对象，跳转到修改页面
        req.setAttribute("type",type);
        req.getRequestDispatcher("productClass-modify.jsp").forward(req,res);
    }

    protected void findAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<GoodsType> all = tbiz.findAll();
        req.setAttribute("typeList",all);
        req.getRequestDispatcher("productClass.jsp").forward(req,res);
    }
}
