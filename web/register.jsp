<%--
  Created by IntelliJ IDEA.
  User: �����
  Date: 2021/9/8
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<html>
<head>
    <title>�������԰�</title>
</head>
<body bgcolor="#E3E3E3">
<form action="registerServlet" method="post">
    <table>
        <caption>�û�ע��</caption>
        <tr>
            <td>��¼����</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>���룺</td>
            <td><input type="password" name="password"></td>
        </tr>
    </table>
    <input type="submit" value="ע��">
    <input type="reset" value="����">
</form>

</body>
</html>
