<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta charset="UTF-8">
<title>view</title>
<script src="../plugin/axios.js"></script>
<script src="../plugin/jquery.js"></script>
<script src="../plugin/vue.js"></script>
<script>
    $(function () {
        let app = new Vue({
            el: "#app",
            data: {},
            methods: {
                del(id) {
                    axios.post("/stage_three/user/delUser/" + id).then(function () {
                        location.reload();
                    });
                },
                updateUI(id) {
                    location.href = "/stage_three/htmls/updateUI.html?id=" + id;
                },
                search(){
                    let account_name = $("#name_search").val();

                }
            }
        });
    });
</script>
</head>
<body>
<div id="app">
    <input type="text" name="search" id="name_search"><button id="getName" @click="search()">查找</button>
    <table style="border: 1px solid">
        <tr>
            <th><input type="checkbox" name="checkAll"></th>
            <th>ID</th>
            <th>用户名</th>
            <th>年龄</th>
            <th>删除</th>
            <th>修改</th>
        </tr>
        <c:forEach begin="0" end="${pageMap.dataList.size()}" items="${pageMap.dataList}" var="user">
            <tr>
                <td><input type="checkbox" name="checkList"></td>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.age}</td>
                <td><a href="#" @click="del(${user.id})">del</a></td>
                </td>
                <td><a href="#" @click="updateUI(${user.id})">update</a></td>
                </td>
            </tr>
        </c:forEach>
    </table>
    <c:forEach begin="1" end="${pageMap.pages}" var="ps">
        <a href="${pageContext.request.contextPath}/user/allUser?startPage=${ps}">${ps}</a>
    </c:forEach>
</div>
</body>
</html>
