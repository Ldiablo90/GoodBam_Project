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
<title>메인페이지</title>
<style>

.navbar{
	border-color: #EBE4F7;
}

#head{
background-color:#FFFFFF; 
}
li{
	height: 45px;
	display:flex; 
	align-items:center
	
}
li:hover{
	background-color:  #b88cd2;
	
}
.side{
    list-style: none;
    padding-left: 0px;
    font-size: 17px;
 
}
.side a{
	text-decoration:none;
	color: #585858;
}

.col-sm-2{
	border-right:1px solid #EBE4F7;
	height: 650px;
}
.col-sm-9{
	margin-left: 10px;
}
.datebox{
	
	margin-bottom: 40px;
	border-bottom : 1px solid #EBE4F7;
	border-top : 1px solid #EBE4F7;
	text-align: center;
	float: left ;
	width:50%;
	
}


 @media ( max-width: 560px ) {
        .col-sm-2 {
          width: auto;
          height:10%;
        }
</style>
</head>
<body>

	<!-- header -->
 <nav class="navbar">
	  <div class="container-fluid" id="head">
   		
        <div class="navbar-header">
          <a href="index.jsp"><img src="/asset/images/logow.PNG" class="navbar-brand" style="width:150px; height: 60px;" ></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">로그아웃</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">&nbsp;&nbsp;
           <a href="#" ><i class = "glyphicon glyphicon-search"></i></a>
          </form>
        </div>
    </div>
    </nav>
<form action="">
	<!-- sidebar -->
	 <div class="container-fluid">
		<div class="row">
	        <div class="col-sm-2">
	          <ul class="side" >
	            <li><a href="memberList.jsp">회원관리</a></li>
	            <li><a href="dataTable.jsp">데이터분석</a></li>
	          </ul>
	       </div>
        <div class="col-sm-9">
       <div class = "datebox" >
        <input type='date'>
        </div>
        <div class = "datebox" >
        <input type ='date'>
        </div>
        <h2 class="sub-header">데이터 분석</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>NO</th>
                  <th>UserId</th>
                  <th>Name</th>
                  <th>Email</th>
                  <th>Update/Delete</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1,001</td>
                  <td><a href="memberData.jsp">Lorem</a></td>
                  <td>ipsum</td>
                  <td>dolor</td>
                  <td>
                  <a href="#"><i class="glyphicon glyphicon-ok"></i></a> 
                  &nbsp; &nbsp;/&nbsp;&nbsp;
                  <a href="#"><i class="glyphicon glyphicon-remove"></i></a>    
                  </td>             
                </tr>
              </tbody>
            </table>
            </div>
          </div>
        </div>
      </div>
</form>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../../assets/js/vendor/holder.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>