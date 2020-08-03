<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>CSS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
	   #jb-container{
	   	height: 100%;
	   	
	   }
      #jb-header {
        margin-bottom: 20px;
        
      }
      #jb-content {
       	width: 70%;
        padding: auto;
        margin-bottom: 20px;
        float: right;
      	margin-right: 10%
      }
      #jb-sidebar {
        width: 15%;
        padding: 20px;
        margin-bottom: 20px;
        float: left;
        border: 1px solid #bcbcbc;
       
      }
    .navbar-right{
    	float:right;
    	padding: 10px;
    	margin-right: 10px;
    }
      @media ( max-width: 560px ) {
        #jb-container {
          width: auto;
        }
     
        #jb-sidebar {
          float: none;
          width: auto;
          height: 20%;
        }
        #jb-content {
          float: none;
          width: auto;
        }
      }
     
      
    </style>
  </head>
  <body>
  	<div id = "jb-container">
     <nav id="jb-header">
        <a href="index.jsp"><img src="/asset/images/logow.png" class="brand" style="width:150px; height: 60px;" ></a>
       <div class="navbar-right">
          <a>로그아웃</a>
      	</div>
      	<div class="navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          <a href="#" ><i class = "glyphicon glyphicon-search"></i></a>
        </div>
     </nav>
      <div id="jb-sidebar">
        <h2>Sidebar</h2>
        <ul>
          <li>Lorem</li>
          <li>Ipsum</li>
          <li>Dolor</li>
        </ul>
      </div>
      <div id="jb-content">
        <h2>Content</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec mollis nulla. Phasellus lacinia tempus mauris eu laoreet. Proin gravida velit dictum dui consequat malesuada. Aenean et nibh eu purus scelerisque aliquet nec non justo. Aliquam vitae aliquet ipsum. Etiam condimentum varius purus ut ultricies. Mauris id odio pretium, sollicitudin sapien eget, adipiscing risus.</p>
      </div>
    </div>
  </body>
</html>