package com.csi.controller;

import com.csi.biz.GoodsBiz;
import com.csi.biz.impl.GoodBizImpl;
import com.csi.biz.impl.GoodsTypeBizImpl;
import com.csi.pojo.Goods;
import com.csi.pojo.GoodsType;
import com.csi.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/GoodsServlet","/manager/goods.do"})
public class GoodsServlet extends HttpServlet {
    GoodsBiz gbiz=new GoodBizImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        //获取请求的功能
        String mth = req.getParameter("mth");
        switch(mth){
            case "findByTid":
                findByTid(req,resp);
                break;
            case "search":
                search(req,resp);
                break;
            case "findGoods":
                findGoods(req,resp);
                break;
            case "findAll":
                findAll(req,resp);
                break;
            case "toAdd":
                toAdd(req,resp);
                break;
            case "add":
                add(req,resp);
                break;
            case "toModify":
                toModify(req,resp);
                break;
            case "modify":
                modify(req,resp);
                break;
        }
    }
//    public void modify(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//
//    }
    public void modify(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //获取数据
        int gid=Integer.parseInt(req.getParameter("gid"));
        String gname = req.getParameter("gname");
        gname=new String(gname.getBytes("ISO-8859-1"),"UTF-8");
        int tid=Integer.parseInt(req.getParameter("tid"));
        String pic=req.getParameter("pic");
        double price =Double.parseDouble(req.getParameter("price"));
        int state=Integer.parseInt(req.getParameter("state"));
        String context = req.getParameter("context");
        String createDate = req.getParameter("createDate");
        //创建Goods对象
        Goods g=new Goods(gid,gname,pic,price,new GoodsType(tid),context,state,createDate);
        if(gbiz.modifyGoods(g)){
            req.setAttribute("msg","操作成功");
        }else{
            req.setAttribute("msg","操作失败");
        }
        req.getRequestDispatcher("manage-result.jsp").forward(req,res);
    }
    public void toModify(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //获取商品id
        int gid=Integer.parseInt(req.getParameter("gid"));
        Goods goods = gbiz.findById(gid);
        req.setAttribute("goods",goods);
        List<GoodsType> all = new GoodsTypeBizImpl().findAll();
        req.setAttribute("typeList",all);
        req.getRequestDispatcher("product-modify.jsp").forward(req,res);
    }
    public void add(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //获取数据
        String gname = req.getParameter("gname");
        int tid=Integer.parseInt(req.getParameter("tid"));
        String pic=req.getParameter("pic");
        double price =Double.parseDouble(req.getParameter("price"));
        int state=Integer.parseInt(req.getParameter("state"));
        String context = req.getParameter("context");
        Date d=new Date();
        String createDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
        //创建Goods对象
        Goods g=new Goods(null,gname,pic,price,new GoodsType(tid),context,state,createDate);
        if(gbiz.addGoods(g)){
            req.setAttribute("msg","操作成功");
        }else{
            req.setAttribute("msg","操作失败");
        }
        req.getRequestDispatcher("manage-result.jsp").forward(req,res);
    }
    public void toAdd(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //获取所有类型
        List<GoodsType> all = new GoodsTypeBizImpl().findAll();
        req.setAttribute("typeList",all);
        req.getRequestDispatcher("product-add.jsp").forward(req,res);
    }
    public void findAll(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        List<Goods> all = gbiz.findAll();
        req.setAttribute("goodsList",all);
        req.getRequestDispatcher("product.jsp").forward(req,res);
    }
    /**
     * 根据商品编号查询商品
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void findGoods(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //获取id
        int gid = Integer.parseInt(req.getParameter("gid"));
        Goods goods = gbiz.findById(gid);
        if(goods!=null){
            //存
            req.setAttribute("goods",goods);
            req.getRequestDispatcher("product_info.jsp").forward(req,res);
        }

    }

    /**
     * 根据名字模糊查询
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void search(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PageBean<Goods> pb=new PageBean<>();
        //当前页
        String curr = req.getParameter("curr");
        if(curr!=null){
            pb.setCurrentPage(Integer.parseInt(curr));
        }else{
            pb.setCurrentPage(1);
        }
        String gname=req.getParameter("gname");
        pb=gbiz.findByGname(gname,pb);
        // 存储数据和搜索的关键字
        req.setAttribute("gname",gname);
        req.setAttribute("page",pb);
        req.getRequestDispatcher("search.jsp").forward(req,res);
    }

    /**
     * 根据类型查找
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void findByTid(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PageBean<Goods> pb=new PageBean<>();
        //获取数据
        //当前页，tid
        String curr = req.getParameter("curr");
        if(curr!=null){
            pb.setCurrentPage(Integer.parseInt(curr));
        }else{
            pb.setCurrentPage(1);
        }
        pb.setPageCount(8);  //设置每页数量，如果不需要，可以不写
        Integer tid=Integer.parseInt(req.getParameter("tid"));
        //调用biz
        pb=gbiz.findByTid(tid,pb);
        //存储
        req.setAttribute("page",pb);
        //当前类型
        req.setAttribute("tid",tid);
        //转发
        req.getRequestDispatcher("product_list.jsp").forward(req,res);
    }
}













