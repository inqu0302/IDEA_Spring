<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2021-11-11
  Time: 오후 3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<script src="${rootPath}/webjars/jquery/dist/jquery.min.js"></script>
<link href="${rootPath}/static/css/login.css" rel="stylesheet"/>
<script>
    $(function (){
        $("button.btn_join").on("click",function (){
            location.href="${rootPath}/member/join"
        })
    })
</script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form action="${rootPath}/login" cssClass="login_form">
    <fieldset>
        <h2>로그인</h2>
        <c:if test="${param.error != null}">
            <h3${ERROR_MSG == null ? "로그인을 하세요" : ERROR_MSG}</h3>
        </c:if>
        <input placeholder="사용자 ID" name="username"/>
        <input placeholder="비밀번호" type="password" name="password"/>
        <button class="btn_login">로그인</button>
        <button class="btn_join" type="button" >회원가입</button>
    </fieldset>
</form:form>
<h1>${AUTHOR}</h1>
