package com.iss.server.util;

import com.iss.server.model.Stock;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DBUtil {
    //声明属性
    private static Connection conn = null;
    private static PreparedStatement prep = null;
    private static ResultSet rs = null ;
    public DBUtil() {
        connect();
    }

    public  static void connect(){

        //0.读取配置文件
        Properties pp = new Properties();
        try {
            pp.load(DBUtil.class.getResourceAsStream("db.properties"));
            //1.加载驱动
            Class.forName(pp.getProperty("driver"));
            //2.创建链接
            conn = DriverManager.getConnection(pp.getProperty("url"),
                    pp.getProperty("user"),pp.getProperty("password"));
        }catch (IOException | ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        File file = new File("src/com/iss/server/util/db.properties");
        Properties props = new Properties();
        try {
            FileInputStream fis = new FileInputStream(file);
            props.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Connection conn = null;


    }

    public  static boolean update(String sql){
        boolean flag = false;
        DBUtil.connect();
        try {
            prep = conn.prepareStatement(sql);
            int i = prep.executeUpdate();
            if(i == 1){
                flag =  true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }

    public  static ResultSet query(String sql){
                DBUtil.connect();
        //1.定义接受结果
        try{
            //2.实例化执行sql语句的 对象
            prep  = conn.prepareStatement(sql);
            //3.执行并接受结果
            rs= prep.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
        }
        return rs;
    }


    public  static void query(String s,Object obj){

    }

    public  static void close(){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(prep!=null){
            try {
                prep.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public  static void close(String s,Object obj){

    }

    public  static void main(String s,Object obj){

    }
}
