<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<title>로그인</title>
<style>
h1{
    font-weight: bold;
    text-transform: uppercase;
    text-align: center;
    color: #FFF;
}
.login-form{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    -webkit-transform: translate(-50%,-50%);
    width: 100%;
   
}
 
.login{
    background: #FFF;
    padding: 80px; 
    box-shadow: 0 2px 4px 0 rgba(0,0,0,0.4);
}
.login .form-control {
    box-shadow: none;
    padding: 30px;
    border: 1px solid #e8e8e8;
    background: #e8e8e8;
}
 
.login .btn{ 
    background: #b88cd2;
    border: none;
    color: #FFF; 
    text-transform: uppercase;
    border-radius: 0;
    font-size: 16px;
    height: 50px;
    width: 100%;
}
.logo{
	text-align:center;
	margin-bottom: 20px;
	
}
img{
	width:75%;
	height: 75%;
}

</style>
</head>
<body>
     <div class="login-form">
   <div class="container">
     <div class="row">
       <h1>LOGIN FORM</h1>
         <div class="col-lg-6 col-lg-offset-3">
           <form class="login">
            <div class = "logo">
            	<img src="/asset/logoh.PNG" >
            </div>
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
