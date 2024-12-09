package com.csi.dao.impl;

import com.csi.dao.GoodsDao;
import com.csi.pojo.Goods;
import com.csi.utils.DBHelper;
import com.csi.utils.PageBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public int insertGoods(Goods goods) {
        int row=0;
        conn=DBHelper.getConn();
        String sql="insert into goods values(null,?,?,?,?,?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,goods.getGname());
            ps.setString(2,goods.getPic());
            ps.setDouble(3,goods.getPrice());
            ps.setString(4,goods.getCreateDate());
            ps.setInt(5,goods.getTid().getTid());
            ps.setString(6,goods.getDetails());
            ps.setInt(7,goods.getState());
            row=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(null,ps,conn);
        }
        return row;
    }

    @Override
    public int deleteGoods(int id) {
        return 0;
    }

    @Override
    public int updateGoods(Goods goods) {
        int row=0;
        conn=DBHelper.getConn();
        String sql="update goods set gname=?,pic=?,price=?,createDate=?,tid=?,details=?,state=? where gid=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,goods.getGname());
            ps.setString(2,goods.getPic());
            ps.setDouble(3,goods.getPrice());
            ps.setString(4,goods.getCreateDate());
            ps.setInt(5,goods.getTid().getTid());
            ps.setString(6,goods.getDetails());
            ps.setInt(7,goods.getState());
            ps.setInt(8,goods.getGid());
            row=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(null,ps,conn);
        }
        return row;
    }

    @Override
    public List<Goods> selectAll() {
        List<Goods> list=new ArrayList<>();
        conn= DBHelper.getConn();
        String sql="SELECT * from goods";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Goods g=new Goods();
                g.setGid(rs.getInt("gid"));
                g.setGname(rs.getString("gname"));
                g.setPic(rs.getString("pic"));
                g.setPrice(rs.getDouble("price"));
                g.setTid(new GoodsTypeDaoImpl().selectById(rs.getInt("tid")));
                g.setDetails(rs.getString("details"));
                g.setState(rs.getInt("state"));
                g.setCreateDate(rs.getString("createDate"));
                //将对象放入集合
                list.add(g);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }

        return list;
    }

    @Override
    public Goods selectById(int id) {
        Goods g=null;
        conn=DBHelper.getConn();
        String sql="select * from goods where gid=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                g=new Goods();
                g.setGid(rs.getInt("gid"));
                g.setGname(rs.getString("gname"));
                g.setPic(rs.getString("pic"));
                g.setPrice(rs.getDouble("price"));
                g.setTid(new GoodsTypeDaoImpl().selectById(rs.getInt("tid")));
                g.setDetails(rs.getString("details"));
                g.setState(rs.getInt("state"));
                g.setCreateDate(rs.getString("createDate"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return g;
    }

    @Override
    public List<Goods> selectTop8(int tid) {
        List<Goods> list=new ArrayList<>();
        conn= DBHelper.getConn();
        String sql="SELECT * from goods where tid=?  ORDER BY createDate desc LIMIT 0,8";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,tid);
            rs=ps.executeQuery();
            while(rs.next()){
                Goods g=new Goods();
                g.setGid(rs.getInt("gid"));
                g.setGname(rs.getString("gname"));
                g.setPic(rs.getString("pic"));
                g.setPrice(rs.getDouble("price"));
                g.setTid(new GoodsTypeDaoImpl().selectById(rs.getInt("tid")));
                g.setDetails(rs.getString("details"));
                g.setState(rs.getInt("state"));
                g.setCreateDate(rs.getString("createDate"));
                //将对象放入集合
                list.add(g);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }

        return list;
    }

    /**
     * 分页时，查询总条数的方法
     * @param sql
     * @return
     */
    @Override
    public int selectTotal(String sql) {
        int row=0;
        conn=DBHelper.getConn();
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                row=rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return row;
    }

    /**
     * 根据类型查询商品
     * @param tid
     * @param page
     * @return
     */
    @Override
    public PageBean<Goods> selectByTid(int tid, PageBean<Goods> page) {
        List<Goods> list=new ArrayList<>();
        //拼写sql
        String sql="SELECT count(*) from goods where state=1 and tid="+tid;
        //设置总条数
        page.setTotalCount(selectTotal(sql));
        conn=DBHelper.getConn();
        sql="SELECT * from goods where state=1 and tid=? limit ?,?";

        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,tid);
            ps.setInt(2,page.getPageCount()*(page.getCurrentPage()-1));
            ps.setInt(3,page.getPageCount());
            rs=ps.executeQuery();
            //封装数据
            while(rs.next()){
                Goods g=new Goods();
                g.setGid(rs.getInt("gid"));
                g.setGname(rs.getString("gname"));
                g.setPic(rs.getString("pic"));
                g.setPrice(rs.getDouble("price"));
                g.setTid(new GoodsTypeDaoImpl().selectById(rs.getInt("tid")));
                g.setDetails(rs.getString("details"));
                g.setState(rs.getInt("state"));
                g.setCreateDate(rs.getString("createDate"));
                //将对象放入集合
                list.add(g);
            }
            page.setList(list);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return page;
    }

    /**
     * 根据名称模糊查询
     * @param gname
     * @param page
     * @return
     */
    @Override
    public PageBean<Goods> selectByGname(String gname, PageBean<Goods> page) {
        List<Goods> list=new ArrayList<>();
        //拼写sql
        String sql="SELECT count(*) from goods where state=1 and gname like '%"+gname+"%'";
        //设置总条数
        page.setTotalCount(selectTotal(sql));
        conn=DBHelper.getConn();
        sql="SELECT * from goods where state=1 and gname like ? limit ?,?";

        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,"%"+gname+"%");
            ps.setInt(2,page.getPageCount()*(page.getCurrentPage()-1));
            ps.setInt(3,page.getPageCount());
            rs=ps.executeQuery();
            //封装数据
            while(rs.next()){
                Goods g=new Goods();
                g.setGid(rs.getInt("gid"));
                g.setGname(rs.getString("gname"));
                g.setPic(rs.getString("pic"));
                g.setPrice(rs.getDouble("price"));
                g.setTid(new GoodsTypeDaoImpl().selectById(rs.getInt("tid")));
                g.setDetails(rs.getString("details"));
                g.setState(rs.getInt("state"));
                g.setCreateDate(rs.getString("createDate"));
                //将对象放入集合
                list.add(g);
            }
            page.setList(list);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return page;
    }
}
