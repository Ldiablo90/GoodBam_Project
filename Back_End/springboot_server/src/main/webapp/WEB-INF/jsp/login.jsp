<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/asset/css/login.css"/>
<title>login</title>
</head>
<body>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
    $(function(){
        var responseMessage = "<c:out value="${message}" />";
        if(responseMessage != ""){
            alert(responseMessage)
        }
    })
</script>

     <div class="login-form">
   <div class="container">
     <div class="row">
       <h1>LOGIN FORM</h1>
         <div class="col-lg-6 col-lg-offset-3">
            <div class = "logo">
            	<img alt="logo" src="images/logoh.PNG" >
            </div>
             <form class="login-form" name="login" action="login"  method="post">
             <div class="form-group">
               <input type="password" class="form-control" placeholder="Password">
             </div>
             <button type="submit" class="btn btn-default">Login</button>
           </form>
         </div>
      </div>
   </div>
</div>
</body>
</html>
</html>