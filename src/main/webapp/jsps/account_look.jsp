<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="../plugin/axios.js"></script>
    <script src="../plugin/jquery.js"></script>
    <script src="../plugin/vue.js"></script>
    <title>account</title>
</head>
<body>
当前用户id:${pageMap.user_id}<br>
<table style="border: 1px solid">
    <tr>
        <th>账户ID</th>
        <th>用户名</th>
    </tr>
    <c:forEach begin="0" end="${pageMap.dataList.size()}" items="${pageMap.dataList}" var="account">
        <tr>
            <td>${account.account_id}</td>
            <td>${account.account_name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
