package Servlet;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import DBconnect.DBconnect;
import JavaBean.*;


public class MainServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("gb2312");
        //获取提交的用户名
        String username=request.getParameter("username");
        //获取提交的密码
        String password=request.getParameter("password");
        //验证成功的标识
        boolean validated=false;
        DBconnect dbcn=new DBconnect();
        HttpSession session=request.getSession();
        UserTable user=null;
        //获取UserTable对象，第一次访问时用户为空，后续登录无需重复验证
        user=(UserTable)session.getAttribute("user");
        //第一次进入，Session会存储user持久化的对象，故为null;
        if (user==null){
            //查询userTable表中的记录
            String sql="select * from usertable";
            ResultSet rs=DBconnect.selectSql(sql);
            try {
                while (rs.next()){
                    if ((rs.getString("username").trim().compareTo(username)==0)&&(rs.getString("password").compareTo(password)==0)){
                        user=new UserTable();
                        user.setId(rs.getInt(1));
                        user.setUsername(rs.getString(2));
                        user.setPassword(rs.getString(3));
                        session.setAttribute("user",user);
                        validated=true;
                    }
                }
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            DBconnect.closeStmt();
        }
        else {
         validated=true;
        }
     if (validated){
         //验证成功，去往主页，主页包含了所有的留言信息，所以要从留言表中查出来，并暂存于Seesion中
        ArrayList al=new ArrayList();
        try {
            String sql="select * from lytable";
            ResultSet rs=DBconnect.selectSql(sql);
            while (rs.next()){
                lyUserTable ly=new lyUserTable();
                ly.setId(rs.getInt(1));
                ly.setUserID(rs.getInt(2));
                ly.setDate(rs.getDate(3));
                ly.setTitle(rs.getString(4));
                ly.setContect(rs.getString(5));
                al.add(ly);
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        DBconnect.closeStmt();
        session.setAttribute("al",al);
        //然后跳转到main.jsp
         response.sendRedirect("main.jsp");
     }
     else {
         //验证失败跳转到error.jsp
         response.sendRedirect("error.jsp");
     }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        doGet(request,response);
    }
}
