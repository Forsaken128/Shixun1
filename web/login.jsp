<%--
  Created by IntelliJ IDEA.
  User: �����
  Date: 2021/9/7
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="gb2312" %>
<html>
  <head>
    <title>�������԰�</title>
  </head>
  <body bgcolor="#E3E3E3">
  <form action="mainServlet" method="post">
    <table>
      <caption>�û���¼</caption>
      <tr>
        <td>�û�����</td>
        <td><input type="text" name="username" size="20"></td>
      </tr>
      <tr>
        <td>���룺</td>
        <td><input type="text" name="password" size="20"></td>
      </tr>
    </table>
    <input type="submit" value="��¼">
    <input type="reset" value="����">
  </form>
  ���δע�ᵥ��<a href="register.jsp">����</a>ע�ᣡ
  </body>
</html>
