<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <!-- JSTL을 사용하기 위해서는 라이브러리를 로딩 해야 한다 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>My Blog</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="css/clean-blog.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-custom navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    Menu <i class="fa fa-bars"></i>
                </button>
                
               <c:if test="${not empty sessionScope.Member}"> 
               <div class ="navbar-brand"> ${sessionScope.Member.id} 님</div> 
               <a class ="navbar-brand" href="Member.service?cmd=logout">로그아웃</a>
               </c:if>
               
               <c:if test="${empty sessionScope.Member}"> 
               <a class ="navbar-brand"  href ="PageHome.jsp"> Start Bootstrap</a>
               </c:if>
               
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="PageHome.jsp">Home</a>
                    </li>
                    <li>
                        <a href="PageAbout.jsp">About</a>
                    </li>
                    <li>
                        <a href="board.do?cmd=page">Post</a>
                    </li>
                    <li>
                        <a href="PageLogin.jsp">Login</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <header class="intro-header" style="background-image: url('img/home-bg.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="site-heading">
                        <h1>Clean Blog</h1>
                        <hr class="small">
                        <span class="subheading">A Clean Blog Theme by Start Bootstrap</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <div class="post-preview">
                    <a href="PagePost.jsp">
                        <h2 class="post-title">
                            aaaaaaaaaaaaaaa
                        </h2>
                        <h3 class="post-subtitle">
                           bbbbbbbbbbbbbbbbbbbbbbbbbb
                        </h3>
                    </a>
                    <p class="post-meta">Posted by inyoung</a> on September 24, 2014</p>
                </div>
                <hr>
                
        <table id ="boardTable"> 
        <tbody>
        <c:forEach var="member" items="${requestScope.Boardlist}">
          <tr>
                <div class="post-preview">
                    <a href="PagePostEdit.jsp">
                        <h2 class="post-title">
                            ${member.title }
                        </h2>
                        <h3 class="post-subtitle">
                            ${member.content }
                        </h3>
                    </a>
                    <p class="post-meta">Posted by inyoung</a> on September 24, 2014</p>
                </div>
                <hr>
           </tr>
        </c:forEach>
        </tbody>
        </table>
				
				<!-- Pager -->
                <ul class="pager">
                    <li class="next">
                        <input  class="btn btn-default" id ="OrderPostBtn"  type="button"  value ="Older Posts"/>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <hr>

    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <ul class="list-inline text-center">
                        <li>
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                    </ul>
                    <p class="copyright text-muted">Copyright &copy; Your Website 2016</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="js/clean-blog.min.js"></script>
    
    <script type ="text/javascript">
    $(document ).ready(function() {
    	console.log( "ready!" );
    });
    $("#OrderPostBtn").click(function(){
    	//alert("Click")
    	// 테이블에 들어있는 게시글의 갯수
    	
    	//var $content = $(#boardTable tr);
    	//var listCount = #content.length;
    	
    	var listCount = $("#boardTable tr").length;
    	console.log("현재 게시글의 갯수 : " + listCount );
    	//alert(index)
    	// 불러올 페이지 요청
    	var url="main.do";  
        var params="cmd=order&listCount="+listCount;
        
      
        $.ajax({      
            type:"POST",  
            url:url,      
            data:params,      
            success:function(result){   
            	dataParsing(result);  
            	//alert(result);
            },   
            error:function(e){  
                alert(e.responseText);  
            }  
        });
        
    });
    
    function dataParsing(result){
    	console.log("파싱할 데이터 : " + result);
    	var jsonData = JSON.parse(result);
    	
    	for(var i = 0; i < jsonData.length; i++){
    		var data = jsonData[i];
        
    		var tr = $('#boardTable tbody:last').after(""+
    				"<tr>"+"</tr>"
    				);
    		var div = $('#boardTable tr:last').append(""+
    				"<div class='post-preview'>"+
    				"<a href='main.do?cmd=view&id=" +data.id+ "'>"+
    				"<h2 class='post-title'>"+
    				data.title+
    				"</h2>"+
    				"<h3 class='post-subtitle'>"+
    				data.content+
    				"</h3>"+
    				"</a>"+
    				"<p class='post-meta'>Posted by inyoung</a> on September 24, 2014</p>"+
    				"</div>"+
    				"<hr>"
    				
    				);
    		
    		console.log("파싱할 단위 데이터 : " + data);
    		
    		console.log(data.id);
    		console.log(data.title);
    		console.log(data.content);
    		
    		
    	}   	
    };
    </script>

</body>

</html>
