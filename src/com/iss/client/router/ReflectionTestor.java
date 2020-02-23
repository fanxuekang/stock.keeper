package com.iss.client.router;

import com.iss.client.view.Component.StockWindow;
import com.iss.client.view.Index;
import com.iss.client.view.Login;

public class ReflectionTestor {
    /**
     * 应用场景：
     *  在程序运行时，动态创建或者给变类的实例（对象）
     */

    public static void main(String[] args) {
        /**
         * 通过反射获得一个类，并创建他的实例
         * 通过类的地址来创建对象
         */
        Class cls = null;
        try {
            cls = Class.forName("src/com/iss/client/view/Index.java");
//            cls.newInstance();
            Index index = (Index)cls.newInstance();
            index.display();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


//        StockWindow window = new Login();
//        window.display();
//        String windowKey = "";
//        if((windowKey.equals("index")){
//            window = new Index();
//        }
    }
}
