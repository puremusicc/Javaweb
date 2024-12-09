package com.csi.controller;

import com.csi.biz.GoodsBiz;
import com.csi.biz.impl.GoodBizImpl;
import com.csi.dao.impl.GoodsTypeDaoImpl;
import com.csi.pojo.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从数据库取出数据
        GoodsBiz gbiz=new GoodBizImpl();
        List<Goods> t1 = gbiz.toIndex(1);
        List<Goods> t2 = gbiz.toIndex(2);
        //保存到req里
        req.setAttribute("t1",t1);
        req.setAttribute("t2",t2);
        //转发到首页
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
