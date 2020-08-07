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
.temp, .humi{
	height: 300px;
}
.buttondisplay{
	float: right;
	
}
.btn-primary {
    background-color: #b88cd2;
    border-color: #7bc143;
    color: #FFF; 
    }
<%-- @media ( max-width: 560px ) {--%>
<%--        .col-sm-2 {--%>
<%--          width: auto;--%>
<%--          height:10%;--%>
<%--        }--%>
</style>
</head>
<body>



<!-- header -->
 <nav class="navbar">
	  <div class="container-fluid" id="head">
   		
        <div class="navbar-header">
          <a href="memberList"><img src="/asset/logow.png" class="navbar-brand" style="width:150px; height: 60px;" ></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="login">로그아웃</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">&nbsp;&nbsp;
           <a href="#" ><i class = "glyphicon glyphicon-search"></i></a>
          </form>
        </div>
    </div>
    </nav>
	<form>
	<!-- sidebar -->
	 <div class="container-fluid">
		<div class="row">
	        <div class="col-sm-2">
	          <ul class="side" >
	            <li><a href="memberList">회원관리</a></li>
	            <li><a href="dataTable">데이터분석</a></li>
	          </ul>
	       </div>
        <div class="col-sm-9">
      
        <h2>사용자 데이터</h2><br>
        <div class = "buttondisplay">
			<button i class ="btn btn-default" href="/memberList">목록</button>
			<button  class ="btn btn-default">삭제</button>
         </div>
       	<table id = "usertable">
			<tr>
			<td style="width:7%;">
				<form role="form" method="POST" autocomplete="off">
			NO : <input type="hidden" id="num" name="num"
					value="" readonly="readonly" style="border: none;">
				</form>
			</td>

			<td style="width: 20%;"></td>
			<td style="width: 20%;">ID :</td>
			<td style="width: 20%;"></td>
			<td style="width: 20%;">Date :</td>
			<td style="width: 20%;"></td>
		</tr>
	</table>

	<div class="userContent">
    		<hr color="grey">
    
    <div class="data"></div>
   		<div class="temp">
    		온도:
			<div style="width:60%">

				<div>

					<canvas id="canvas1" height="200" width="600"></canvas>

				</div>

			</div>

			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

			<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>

			<script>

				var tempLabel = [];

				var tempData = [];



				$.getJSON("http://localhost:8070/temperatureList", function(data){



					$.each(data, function(inx, obj){

						tempLabel.push(obj.time);

						tempData.push(obj.temperature);

					});

					createTemperature();

					console.log("create Chart")

				});



				var lineTempData = {

					labels : tempLabel,

					datasets : [

						{

							label : "Date Temperature",

							fillColor : "rbga(151,187,205,0.2)",

							strokeColor : "rbga(151,187,205,1)",

							pointColor : "rbga(151,187,205,1)",

							pointStrokeColor : "#fff",

							pointHighlightFill : "#fff",

							pointHighlightStroke : "rbga(151,187,205,1)",

							data : tempData



						}

					]

				}



				function createTemperature(){

					var ctx1 = document.getElementById("canvas1").getContext("2d");

					LineTempDemo = Chart.Line(ctx1,{

						data : lineTempData,

						options :{

							scales : {

								yAxes : [{

									ticks :{

										beginAtZero : true

									}

								}]

							}

						}

					})



				}



			</script>
    		</div>
    		
    		<div class="humi">
    		습도:
				<div style="width:60%">

					<div>

						<canvas id="canvas2" height="200" width="600"></canvas>

					</div>

				</div>

				<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

				<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>

				<script>

					var humidityLabels = [];

					var humidityData = [];



					$.getJSON("http://localhost:8070/temperatureList", function(data){



						$.each(data, function(inx, obj){

							humidityLabels.push(obj.time);

							humidityData.push(obj.humidity);

						});

						createHumidity();

						console.log("create Chart")

					});



					var lineHumidityData = {

						labels : humidityLabels,

						datasets : [

							{

								label : "Date humidity",

								fillColor : "rbga(151,187,205,0.2)",

								strokeColor : "rbga(151,187,205,1)",

								pointColor : "rbga(151,187,205,1)",

								pointStrokeColor : "#fff",

								pointHighlightFill : "#fff",

								pointHighlightStroke : "rbga(151,187,205,1)",

								data : humidityData



							}

						]

					}



					function createHumidity(){

						var ctx2 = document.getElementById("canvas2").getContext("2d");

						LineHumidityDemo = Chart.Line(ctx2,{

							data : lineHumidityData,

							options :{

								scales : {

									yAxes : [{

										ticks :{

											beginAtZero : true

										}

									}]

								}

							}

						})



					}



				</script>
				</div>
    		</div>
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