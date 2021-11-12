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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>
    $(function (){

        // 입력박스에서 tab 을 누르거나 마우스를 다른곳으로 클릭했을때
        // lost focus
        $("input#username").on("blur",function (){

            // ID 중복테스트
            $.ajax({url : "${rootPath}/member/idcheck" ,
                    data : {username:$(this).val()}
            }).done(function(result){
                if(result){
                    $("div.input_error").text("이미 사용중인 아아디 입니다")
                    $(this).focus()
                }else{
                    $("div.input_error").text("사용가능한 아이디 입니다")
                        .css("color","green")
                    $("#password").focus()
                }
            })
        })

        $("button.btn_join").on("click",function () {
            const username = $("#username")
            const password = $("#password")
            const re_password = $("#re_password")

            if(username.val() === ""){
                alert("사용자 이름은 반드시 입력하세요")
                username.focus()
                return false
            }

            if(password.val() === ""){
                alert("비밀번호는 반드시 입력하세요")
                password.focus()
                return false
            }

            if(re_password.val() === ""){
                alert("비밀번호를 한번더 입력하세요")
                re_password.focus()
                return false
            }

            if(password.val() !== re_password.val()){
                alert("비밀번호와 비밀번호 확인이 일치하지 않습니다")
                password.val("")
                re_password.val("")
                password.focus()
                return false
            }
            if(confirm("회원가입을 신청할까요?")){
                $("form.join").submit()
            }
        })
    })
</script>
<style>
    div.input_error{
        color: red;
        font-weight: bold;
    }
</style>
<form:form action="${rootPath}/join" cssClass="join">
    <div>
        <input placeholder="사용자 ID" id="username" name="username"/>
    </div>
    <div class="input_error">
    </div>
    <div>
        <input placeholder="비밀번호" id="password" type="password" name="password"/>
    </div>
    <div>
        <input placeholder="비밀번호확인" id="re_password" type="password" name="re_password"/>
    </div>
    <div>
        <input placeholder="E-mail" name="email"/>
    </div>
    <div>
        <button class="btn btn_join" type="button" >회원가입</button>
    </div>
</form:form>
