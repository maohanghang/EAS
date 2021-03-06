<%@page import="com.mhh.bean.Student"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-focus">
<head>
<style type="text/css">
body{margin:0;padding:0;font:14px/1.6 Arial,Sans-serif;background:#fff url(img/body.png) repeat-x;}
a:link,a:visited{color:#007ab7;text-decoration:none;}
h1{
	position:relative;
	z-index:2;
	width:600px;
	height:0;
	margin:30px auto 15px;
	padding:180px 0 0;
	overflow:hidden;
	xxxxborder:1px solid;
	background-image: url(img/a02.gif);
	background-repeat: no-repeat;
}
h2{
	position:absolute;
	top:17px;
	left:187px;
	margin:0;
	font-size:0;
	text-indent:-999px;
	-moz-user-select:none;
	-webkit-user-select:none;
	user-select:none;
	cursor:default;
	width: 534px;
}
h2 em{display:block;font:italic bold 200px/120px "Times New Roman",Times,Serif;text-indent:0;letter-spacing:-5px;color:rgba(216,226,244,0.3);}
.link a{margin-right:1em;}
.link,.texts{width:540px;margin:0 auto 15px;color:#505050;}
.texts{line-height:2;}
.texts dd{margin:0;padding:0 0 0 15px;}
.texts ul{margin:0;padding:0;}
.portal{color:#505050;text-align:center;white-space:nowrap;word-spacing:0.45em;}
.portal a:link,.portal a:visited{color:#505050;word-spacing:0;}
.portal a:hover,.portal a:active{color:#007ab7;}
.portal span{display:inline-block;height:38px;line-height:35px;background:url(img/a02.gif) repeat-x;}
.portal span span{padding:0 0 0 20px;background:url(img/portal.png) no-repeat 0 -40px;}
.portal span span span{padding:0 20px 0 0;background-position:100% -80px;}
.STYLE1 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 65px;
}
</style>

        <meta charset="utf-8">

        <title>提示</title>

        <meta name="description" content="教务管理系统">
        <meta name="author" content="sdut">
        <meta name="robots" content="教务管理系统">
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0">

        <!-- Icons -->
        <!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
        <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
 <body>
 <h1></h1>
 <h2><em><span class="STYLE1">Tips: </span></em></h2>    
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="texts">
              <%--  <button type="button" class="close" data-dismiss="modal" 
                        aria-hidden="true">×
                </button>--%> 
                <h4 class="modal-title" id="myModalLabel">
                    消息提示
                </h4>
            </div>
            <div class="texts">
                ${message}
            </div>
            <div class="link">
                <button id="btnss" onclick="javascript:history.go(-1);" type="button" class="btn btn-default" 
                        data-dismiss="modal">返回
                </button>
                
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<%-- <div class="btn-group">
  <button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" title="Edit Client"><i class="fa fa-pencil"></i></button>
  <button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" title="Remove Client"><i class="fa fa-times"></i></button>
  </div> --%>
<script>
$(function () { $('#myModal').modal({
    keyboard: true
})});

</script>
    </body>

</html>