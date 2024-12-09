package com.csi.controller;

import com.csi.biz.CartBiz;
import com.csi.biz.impl.CartBizImpl;
import com.csi.dao.impl.GoodsDaoImpl;
import com.csi.pojo.Cart;
import com.csi.pojo.Goods;
import com.csi.pojo.Users;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private CartBiz cbiz=new CartBizImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        String mth = req.getParameter("mth");
        switch(mth){
            case "addCart":
                addCart(req,resp);
                break;
            case "toCart":
                toCart(req,resp);
                break;
            case "modifyNum":
                modifyNum(req,resp);
                break;
            case "removeCart":
                removeCart(req,resp);
                break;
            case "removeMore":
                removeMore(req,resp);
                break;
        }

    }


//    public void removeCart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//
//    }

    public void removeMore(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       
    	
    	//获取当前用户
        Users u=(Users)req.getSession().getAttribute("users");
        //查询当前用户购物车中所有的商品
        List<Cart> list = cbiz.findByUid(u.getUserId());
        for (int i = 0; i < list.size(); i++) {
        	Cart c=list.get(i);
        	cbiz.removeCart(c.getCid());
		}
        res.sendRedirect("cart?mth=toCart");
    }
    /**
     * 删除购物车
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void removeCart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //获取要删除的编号
        int cid=Integer.parseInt(req.getParameter("cid"));
        boolean b = cbiz.removeCart(cid);
        res.sendRedirect("cart?mth=toCart");
    }
    /**
     * 修改数量
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void modifyNum(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        int cid=Integer.parseInt(req.getParameter("cid"));
        int num=Integer.parseInt(req.getParameter("num"));
        boolean b = cbiz.modifyNum(cid, num);
        out.print(b);
    }

    /**
     * 添加购物车商品
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void addCart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //获取当前用户
        Users u=(Users)req.getSession().getAttribute("users");
        //获取添加的商品编号
        int gid=Integer.parseInt(req.getParameter("gid"));
        boolean b=false;
        //查询当前用户购物车中所有的商品
        List<Cart> list = cbiz.findByUid(u.getUserId());
        for (int i = 0; i < list.size(); i++) {
        	Cart c=list.get(i);
        	if(gid==c.getGoods().getGid()) {
        		int cid=c.getCid();
                int num=c.getNumber()+1;
                b = cbiz.modifyNum(cid, num);
        	}
		}
        if(!b) {
        	 //添加到数据库
        	 b = cbiz.addCart(new Cart(null, u, new GoodsDaoImpl().selectById(gid), 1));
        }
        //跳转到购物车页面
        if(b){
            res.sendRedirect("cart?mth=toCart");
        }
    }

    /**
     * 跳转到购物车
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void toCart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //获取当前用户
        Users u=(Users)req.getSession().getAttribute("users");
        //查询当前用户购物车中所有的商品
        List<Cart> list = cbiz.findByUid(u.getUserId());
        //将购物车讯息存储到req中
        req.setAttribute("cartList",list);
        //转发到购物车页面
        req.getRequestDispatcher("cart.jsp").forward(req,res);
    }
}
