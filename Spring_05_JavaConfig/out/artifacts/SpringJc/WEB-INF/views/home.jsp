<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2021-11-17
  Time: 오전 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewprot" content="width=device-width, initial-scale=1.0"/>
    <title>Title</title>
    <link href="${rootPath}/static/main.css?var=2021-11-19-001" rel="stylesheet"/>
</head>
<body>
<header>
    <h1>READ BOOK 2021</h1>
</header>
<nav>
    <ul>
        <li>HOME</li>
        <li>
            <form method="post">
                <input name="search" placeholder="검색어를 입력하세요">
            </form>
        </li>
    </ul>
</nav>
<section class="main">

</section>
<footer>
    <address> inqu0302@naver.com </address>
</footer>
</body>
</html>
