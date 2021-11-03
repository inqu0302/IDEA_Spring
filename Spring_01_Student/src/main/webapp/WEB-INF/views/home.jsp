<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2021-11-03
  Time: 오전 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    *{
        margin: 0;
        padding:0;
        box-sizing: border-box;
    }

    div.header{
        width: 100%;
        height: 80px;
        background: deepskyblue;
        text-align: center;
        font-size: 20px;
        font-width: bold;
        color: white;
    }

    nav.main_nav{
        list-style: none;
        display: flex;
        width: 100%;
        background: gray;
        color: white;
        font-weight: bold;
    }

    nav.main_nav li{
        margin: 0 10px;
        padding: 10px;
    }

    nav.main_nav li:hover{
        background: green;
        cursor: pointer;
    }
</style>
<head>
    <title>Title</title>
</head>
<body>
    <div class="header">
        <h1>학사관리 시스템</h1>
    </div>
    <nav class="main_nav">
        <li class="home">HOME</li>
        <li class="list">학생정보</li>
        <li class="">성적일람표</li>
    </nav>
</body>
<script>
    document.querySelector("nav.main_nav").addEventListener("click",(e)=>{
        let target = e.target

        if(target.tagName === "LI"){
            if(target.className === "home"){
                location.href = "${rootPath}/student/"
            } else if(target.className === "list"){
                location.href = "${rootPath}/student/list"
            }
        }
    })
</script>
</html>
