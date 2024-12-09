package com.csi.test;

import com.csi.dao.impl.GoodsDaoImpl;
import com.csi.dao.impl.GoodsTypeDaoImpl;
import com.csi.pojo.Goods;
import com.csi.utils.PageBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Test {
    public static void main(String[] args) {
//        UUID id=UUID.randomUUID();
//        System.out.println(id.toString().replace("-",""));
        Date d=new Date();
        //SimpleDateFormat格式化日期
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createDate=sdf.format(d);
        System.out.println(createDate);
    }
}
