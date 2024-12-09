package com.csi.controller;

import com.csi.biz.CartBiz;
import com.csi.biz.OrderBiz;
import com.csi.biz.impl.CartBizImpl;
import com.csi.biz.impl.OrderBizImpl;
import com.csi.pojo.Cart;
import com.csi.pojo.Orders;
import com.csi.pojo.Users;

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
import java.util.UUID;

@WebServlet(name = "OrdersServlet",urlPatterns = {"/order","/manager/order.do"})
public class OrdersServlet extends HttpServlet {
    private OrderBiz obiz=new OrderBizImpl();
    private CartBiz cbiz=new CartBizImpl();
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=utf-8");
        res.setCharacterEncoding("UTF-8");
        String mth = req.getParameter("mth");
        switch(mth){
            case "createOrder":
                createOrder(req,res);
                break;
            case "submitOrder":
                submitOrder(req,res);
                break;
            case "findAll":
                findAll(req,res);
                break;
            case "showDetails":
                showDetails(req,res);
                break;
            case "modifyState":
                modifyState(req,res);
                break;
            case "searchOrder":
                searchOrder(req,res);
                break;
            case "myOrders":
                myOrders(req,res);
                break;
        }
    }
//    private void findAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
//searchOrder
//    }
    private void myOrders(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        Users u=(Users)req.getSession().getAttribute("users");
        List<Orders> myOrders = obiz.findByUid(u.getUserId());
        req.setAttribute("myOrders",myOrders);
        req.getRequestDispatcher("order_list.jsp").forward(req,res);
    }
    private void searchOrder(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        String oid = req.getParameter("oid");
        int state=Integer.parseInt(req.getParameter("state"));
        List<Orders> search = obiz.search(oid, state);
        req.setAttribute("orderList",search);
        req.getRequestDispatcher("order.jsp").forward(req,res);
    }
    private void modifyState(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        String oid = req.getParameter("oid");
        Orders orders = obiz.findByOid(oid);
        int state=Integer.parseInt(req.getParameter("state"));
        orders.setState(state);
        if(obiz.modifyOrder(orders)){
            req.setAttribute("msg","操作成功");
        }else{
            req.setAttribute("msg","操作失败");
        }
        req.getRequestDispatcher("manage-result.jsp").forward(req,res);
    }
    private void showDetails(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        String oid = req.getParameter("oid");
        Orders orders = obiz.findByOid(oid);
        req.setAttribute("order",orders);
        req.getRequestDispatcher("order-modify.jsp").forward(req,res);
    }
    private void findAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        List<Orders> all = obiz.findAll();
        req.setAttribute("orderList",all);
        req.getRequestDispatcher("order.jsp").forward(req,res);
    }
    private void submitOrder(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        //获取数据
        String oid=req.getParameter("oid");
        String addr=req.getParameter("address");
        String name=req.getParameter("name");
        String phone=req.getParameter("phone");
        //获取订单信息
        Orders orders=obiz.findByOid(oid);
        orders.setConsigneePhone(phone);
        orders.setConsigneeAddress(addr);
        orders.setConsigneeName(name);
        orders.setState(2);
        boolean b = obiz.modifyOrder(orders);
        if(b){
            req.setAttribute("order",orders);
            req.getRequestDispatcher("show_order.jsp").forward(req,res);
        }
    }

    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据---当前购物车提交的信息
        int cid = Integer.parseInt(request.getParameter("ck"));
       System.out.println(cid);
        Cart cart = cbiz.findById(cid);
        //创建订单对象
        Orders order=new Orders();
        String oid= UUID.randomUUID().toString().replace("-","");
        order.setOid(oid);
        order.setUsers((Users) request.getSession().getAttribute("users"));
        order.setGoods(cart.getGoods());
        order.setPrice(cart.getGoods().getPrice());
        order.setNumber(cart.getNumber());
        order.setState(1);
        Date d=new Date();
        //SimpleDateFormat格式化日期
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createDate=sdf.format(d);
        order.setCreateTime(createDate);
        boolean b = obiz.createOrder(order);
        if(b){
            //删除购物车信息
            cbiz.removeCart(cid);
            //存储当前订单
            request.getSession().setAttribute("order",order);
            //跳转到订单页
            response.sendRedirect("order_info.jsp");
        }else{
            response.sendRedirect("失败页面");
        }
    }
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

}
