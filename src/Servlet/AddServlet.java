package Servlet;

import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import DBconnect.DBconnect;
import JavaBean.*;
//添加留言
public class AddServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        request.setCharacterEncoding("gb2312");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        HttpSession session = request.getSession();
        UserTable user = (UserTable) session.getAttribute("user");
        lyUserTable ly = new lyUserTable();
        ly.setUserID(user.getId());
        ly.setDate(new Date(System.currentTimeMillis()));//时间戳计算时间
        ly.setTitle(title);
        ly.setContect(content);
        ArrayList al = (ArrayList) session.getAttribute("al");
        al.add(ly);
        //获取连接数据库
        PreparedStatement ps = null;
        DBconnect dbcn = new DBconnect();
        Connection conn = dbcn.getConn();
        try {
            ps = conn.prepareStatement("insert into lytable values(?,?,?,?) ");
            ps.setInt(1, ly.getUserID());
            ps.setDate(2, ly.getDate());
            ps.setString(3, ly.getTitle());
            ps.setString(4, ly.getContect());
            ps.executeUpdate();//执行插入操作
            response.sendRedirect("main.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
        public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
            doGet(request,response);
        }
    }



