package com.iss.client.router;

import com.iss.client.view.Component.StockWindow;
import com.iss.client.view.Index;

import java.util.HashMap;
import java.util.logging.SocketHandler;


/**
 * 动态的通过类的地址来创建类--反射
 */
public class Router {

    public static String INDEX = "index";
    public static String LOGIN = "login";
    public static String LIST = "list";
    public static String STOCKIN = "in";
    public static String STOCKOUT = "out";

    private  static  StockWindow window;

    private  HashMap<String, String> windowAddress = new HashMap<String, String>();

    public Router() {
        windowAddress.put(Router.INDEX, "com.iss.client.view.Index");
        windowAddress.put(Router.LOGIN, "com.iss.client.view.Login");
        windowAddress.put(Router.LIST, "com.iss.client.view.StockList");
        windowAddress.put(Router.STOCKIN, "com.iss.client.view.StockInView");
        windowAddress.put(Router.STOCKOUT, "com.iss.client.view.StockOutView");

    }

    public   StockWindow getWindow(String windowName) {
            try {
                Class cla = Class.forName(windowAddress.get(windowName));
                window = (StockWindow) cla.newInstance();//创建类的实例。
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        return window;
    }
}
