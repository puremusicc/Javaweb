package com.csi.utils;

import java.util.List;

/**
 * 分页工具类
 * @param <T> 存储数据的类型
 */
public class PageBean<T> {
    private int pageCount=8;  //每页数量 默认 每页8调
    private int totalPage;  //总页数---->无需设置，只能通过总条数和每页数量计算得来
    private int totalCount; //总条数
    private int currentPage;//当前页
    private List<T> list;   //数据

    public PageBean() {
    }

    public PageBean(int pageCount, int totalPage, int totalCount, int currentPage, List<T> list) {
        this.pageCount = pageCount;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.list = list;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalPage() {
        //通过总条数和每页数量计算
        return (totalCount+pageCount-1)/pageCount;
    }



    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
