package Servlet;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import DBconnect.DBconnect;
import JavaBean.*;

public class RegisterServlet extends HttpServlet{

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        request.setCharacterEncoding("gb2312");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //向数据库获取连接
        PreparedStatement ps;
        DBconnect dbcn=new DBconnect();
        Connection conn= dbcn.getConn();
        try {
            ps=conn.prepareStatement("insert into usertable values (?,?)");
            ps.setString(1,username);
            ps.setString(2,password);
            ps.executeUpdate();//执行插入操作
            response.sendRedirect("login.jsp");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        doGet(request, response);
    }
    }
