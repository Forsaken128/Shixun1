<%--
  Created by IntelliJ IDEA.
  User: �����
  Date: 2021/9/7
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" import="java.sql.*,java.util.*,JavaBean.*,DBconnect.DBconnect" %>
<html>
<head>
    <title>���԰���Ϣ</title>
</head>
<body bgcolor="#E3E3E3">
    <form action="liuyan.jsp" method="post">
        <table border="1">
            <caption>����������Ϣ</caption>
            <tr>
                <th>����������</th>
                <th>����ʱ��</th>
                <th>���Ա���</th>
                <th>��������</th>
            </tr>
            <%
                PreparedStatement ps=null;
                DBconnect dbcn=new DBconnect();
                Connection conn=dbcn.getConn();
                ArrayList al=(ArrayList)session.getAttribute("al");
                Iterator iter=al.iterator();
                while (iter.hasNext()){
                    lyUserTable ly=(lyUserTable)iter.next();
                    String username=null;
                    try {
                        ps=conn.prepareStatement("select username from usertable where id=?");
                        ps.setInt(1,ly.getUserID());
                        ResultSet rs=ps.executeQuery();
                        while (rs.next()){
                            username=rs.getString(1);
                        }
                    }catch (SQLException e){
                        e.printStackTrace();
                    }

            %>
            <tr>
                <td><%=username%></td>
                <td><%=ly.getDate().toString()%></td>
                <td><%=ly.getTitle()%></td>
                <td><%=ly.getContect()%></td>
            </tr>
            <%
                }
            %>
        </table>
        <input type="submit" value="����">
    </form>

</body>
</html>
