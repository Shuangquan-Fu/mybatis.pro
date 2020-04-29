<%--
  Created by IntelliJ IDEA.
  User: shufu
  Date: 4/24/2020
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>慕课网用户管理中心</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="/lib/jquery-3.5.0.min.js"></script>

    <script src="lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>慕课后台管理系统 <small>用户数据管理中心</small></h1>
        </div>
    </div>
    <div class="row">
        <div class="jumbotron">
            <h1>Mybatis基础入门课程</h1>
            <p>通过一个项目来完成基础部分的学习</p>
            <p><a class="btn btn-primary btn-lg" href="#" role="button">查看更多请看慕课网</a></p>
        </div>
    </div>
    <c:set var="user" value="${user}"></c:set>
    <div class="row">
        <div class="clo-md-8 col-md-offset-2">
            <form class="form-horizontal" action = "${pageContext.request.contextPath}/updateusers">
                <input type="hidden" name = "id" value="${user.id}" >
                <div class="form-group">
                    <label class="col-sm-2 control-label">用户账号</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${user.username}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">登陆密码</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">********</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="nickname" class="col-sm-2 control-label">昵称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="nickname" value="${user.nickname}" name="nickname" placeholder="请输入昵称">
                    </div>
                </div>
                <div class="form-group">
                    <label for="age" class="col-sm-2 control-label">年龄</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="age" value="${user.age}" name="age" placeholder="请输入年龄">
                    </div>
                </div>
                <div class="form-group">
                    <label for="gender" class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="gender" value="${user.gender}" name="gender" placeholder="请输入性别">
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-2 control-label">联系方式</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="phone" value="${user.phone}" name="phone" placeholder="请输入联系方式">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">邮件</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email" value="${user.email}" name="email" placeholder="请输入邮件">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">账号创建时间</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">
                            <fmt:formatDate value="${user.createTime}" pattern="yyyy-mm-dd"></fmt:formatDate>
                        </p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">最后修改时间</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">
                            <fmt:formatDate value="${user.updateTime}" pattern="yyyy-mm-dd"></fmt:formatDate>
                        </p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">最后登陆时间</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">
                            <fmt:formatDate value="${user.lastlogin}" pattern="yyyy-mm-dd"></fmt:formatDate>
                        </p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">用户状态</label>
                    <div class="col-sm-10">
                        <c:if test="${user.userStatus == 0}">
                        <p class="form-control-static">正常</p>
                        </c:if>
                        <c:if test="${user.userStatus == 1}">
                            <p class="form-control-static">锁定</p>
                        </c:if>
                        <c:if test="${user.userStatus == 2}">
                            <p class="form-control-static">删除</p>
                        </c:if>
                    </div>
                </div>
                <div class="form-group">
                    <label for="remark" class="col-sm-2 control-label">备注</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="remark" value="${user.remark}" name="remark" placeholder="请输入备注">
                    </div>
                </div>
                <div class="form-group">
                    <input type="submit" value="提交数据更新" class="btn btn-primary">
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
