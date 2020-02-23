package com.iss.server.dao;

import com.iss.server.model.User;
import com.iss.server.util.DBUtil;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * 数据访问对象
 * 1.增加
 * 2.修改
 * 3.删除
 * 4.查询
 */
public class UserDao {

    public static boolean query(User user){
        String sql = "SELECT username,password FROM k_user where username = '"+ user.getUserName()+"'";
        ResultSet rs  =  DBUtil.query(sql);
        boolean flag = false;
        try{
                while(rs.next()){
                    if(rs.getString("username").equals(user.getUserName()) &&
                            rs.getString("password").equals(user.getPassword())){
                        flag = true;
                    }
                }
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
