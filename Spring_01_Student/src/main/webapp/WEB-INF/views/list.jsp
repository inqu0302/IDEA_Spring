<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2021-11-03
  Time: 오전 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/home.jsp" %>
<html>

<style>
    section{
        width: 80%;
        margin: 10px auto;
    }
    table{
        margin: 10px auto;
        border-top: 3px solid #707070;
        border-bottom: 3px solid #707070;
        border-spacing: 0;
        width: 80%;
        text-align: center;
    }

    table tbody tr{
        border-bottom: 1px solid #909090;
    }

    table thead tr{
        background: #555555;
        font-weight: bold;
    }

    section div{
        justify-items: right;
    }

    section div button{
        padding: 15px;
        border: 0;
        background: deepskyblue;
        border-radius: 5px;
        color: white;
    }
</style>
<head>
    <title>Title</title>
</head>
<body>
<section>
    <table>
        <thead>
            <tr class="header">
                <th>학번</th>
                <th>이름</th>
                <th>전공</tH>
                <th>학년</th>
                <th>주소</th>
                <th>전화번호</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>2021001</td>
                <td>홍길동</td>
                <td>컴퓨터공학</td>
                <td>1</td>
                <td>서울시 동대문구</td>
                <td>02-123-6547</td>
            </tr>
            <tr>
                <td>2021002</td>
                <td>이몽룡</td>
                <td>전자공학</td>
                <td>1</td>
                <td>전라북도 전주시</td>
                <td>063-654-1597</td>
            </tr>
            <tr>
                <td>2021003</td>
                <td>성춘향</td>
                <td>컴퓨터공학</td>
                <td>1</td>
                <td>전라북도 익산시</td>
                <td>063-984-1597</td>
            </tr>
        </tbody>
    </table>
    <div>
        <button>학생 추가</button>
    </div>
</section>
</body>
</html>
