<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>

<form>
    <div class="input_box">
        <ul><input placeholder="ISBN"/> <input placeholder="책 제목"/></ul>
        <ul><input placeholder="날짜"/> <input placeholder="시작시간"/> <input placeholder="종료시간" /> </ul>
        <ul><input placeholder="내용"/> </ul>
        <ul><input placeholder="내용을 입력해주세요"/></ul>
    </div>
    <div class="btn_box">
        <button class="btn_save">저장</button>
        <button class="btn_reset">새로작성</button>
        <button class="btn_list">리스트보기</button>
    </div>
</form>