<%@page import="com.mhh.bean.*"%>
<%@page import="com.mhh.dao.*"%>
<%@page import="com.mhh.util.*"%>
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

        <meta charset="utf-8">

        <title>湖南大学教务处</title>

        <meta name="description" content="湖南大学教务处">
        <meta name="author" content="dqx">
        <meta name="robots" content="湖南大学教务处">
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0">

        <!-- Icons -->
        <!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
        <link rel="shortcut icon" href="assets/img/favicons/favicon.png">

        <link rel="icon" type="image/png" href="assets/img/favicons/favicon-16x16.png" sizes="16x16">
        <link rel="icon" type="image/png" href="assets/img/favicons/favicon-32x32.png" sizes="32x32">
        <link rel="icon" type="image/png" href="assets/img/favicons/favicon-96x96.png" sizes="96x96">
        <link rel="icon" type="image/png" href="assets/img/favicons/favicon-160x160.png" sizes="160x160">
        <link rel="icon" type="image/png" href="assets/img/favicons/favicon-192x192.png" sizes="192x192">

        <link rel="apple-touch-icon" sizes="57x57" href="assets/img/favicons/apple-touch-icon-57x57.png">
        <link rel="apple-touch-icon" sizes="60x60" href="assets/img/favicons/apple-touch-icon-60x60.png">
        <link rel="apple-touch-icon" sizes="72x72" href="assets/img/favicons/apple-touch-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/favicons/apple-touch-icon-76x76.png">
        <link rel="apple-touch-icon" sizes="114x114" href="assets/img/favicons/apple-touch-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="120x120" href="assets/img/favicons/apple-touch-icon-120x120.png">
        <link rel="apple-touch-icon" sizes="144x144" href="assets/img/favicons/apple-touch-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="152x152" href="assets/img/favicons/apple-touch-icon-152x152.png">
        <link rel="apple-touch-icon" sizes="180x180" href="assets/img/favicons/apple-touch-icon-180x180.png">
        <!-- END Icons -->

        <!-- Stylesheets -->
        <!-- Web fonts -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400italic,600,700%7COpen+Sans:300,400,400italic,600,700">
        
        <!-- Page JS Plugins CSS -->
        <link rel="stylesheet" href="assets/js/plugins/slick/slick.min.css">
        <link rel="stylesheet" href="assets/js/plugins/slick/slick-theme.min.css">

        <link rel="stylesheet" href="assets/js/plugins/datatables/jquery.dataTables.min.css">

        <!-- OneUI CSS framework -->
        <link rel="stylesheet" id="css-main" href="assets/css/oneui.css">

        <!-- You can include a specific file from css/themes/ folder to alter the default color theme of the template. eg: -->
        <!-- <link rel="stylesheet" id="css-theme" href="assets/css/themes/flat.min.css"> -->
        <!-- END Stylesheets -->
    </head>
    <body>
        <!-- Page Container -->
        
        <div id="page-container" class="sidebar-l sidebar-o side-scroll header-navbar-fixed">
            <!-- Side Overlay-->
            
            <!-- END Side Overlay -->

            <!-- Sidebar  侧边栏-->
            <nav id="sidebar">
                <!-- Sidebar Scroll Container -->
                <div id="sidebar-scroll">
                    <!-- Sidebar Content -->
                    <!-- Adding .sidebar-mini-hide to an element will hide it when the sidebar is in mini mode -->
                    <div class="sidebar-content">
                        <!-- Side Header 侧边栏颜色 -->
                        <div class="side-header side-content bg-white-op">
                            <!-- Layout API, functionality initialized in App() -> uiLayoutApi() -->
                            <button class="btn btn-link text-gray pull-right hidden-md hidden-lg" type="button" data-toggle="layout" data-action="sidebar_close">
                                <i class="fa fa-times"></i>
                            </button>
                            <!-- Themes functionality initialized in App() -> uiHandleTheme() -->
                            <div class="btn-group pull-right">
                                <button class="btn btn-link text-gray dropdown-toggle" data-toggle="dropdown" type="button">
                                    <i class="si si-drop"></i>
                                </button>
                                <ul class="dropdown-menu dropdown-menu-right font-s13 sidebar-mini-hide">
                                    <li>
                                        <a data-toggle="theme" data-theme="default" tabindex="-1" href="javascript:void(0)">
                                            <i class="fa fa-circle text-default pull-right"></i> <span class="font-w600">Default</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a data-toggle="theme" data-theme="assets/css/themes/amethyst.min.css" tabindex="-1" href="javascript:void(0)">
                                            <i class="fa fa-circle text-amethyst pull-right"></i> <span class="font-w600">Amethyst</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a data-toggle="theme" data-theme="assets/css/themes/city.min.css" tabindex="-1" href="javascript:void(0)">
                                            <i class="fa fa-circle text-city pull-right"></i> <span class="font-w600">City</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a data-toggle="theme" data-theme="assets/css/themes/flat.min.css" tabindex="-1" href="javascript:void(0)">
                                            <i class="fa fa-circle text-flat pull-right"></i> <span class="font-w600">Flat</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a data-toggle="theme" data-theme="assets/css/themes/modern.min.css" tabindex="-1" href="javascript:void(0)">
                                            <i class="fa fa-circle text-modern pull-right"></i> <span class="font-w600">Modern</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a data-toggle="theme" data-theme="assets/css/themes/smooth.min.css" tabindex="-1" href="javascript:void(0)">
                                            <i class="fa fa-circle text-smooth pull-right"></i> <span class="font-w600">Smooth</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <a class="h5 text-white" href="index.html">
                                <span class="h4 font-w600 sidebar-mini-hide">教务处后台管理</span>
                            </a>
                        </div>
                        <!-- END Side Header 侧边栏颜色 -->

                        <!-- Side Content -->
                        <div class="side-content left-menu-wrap">
                            <ul class="nav-main">
                                <li>
                                    <a class="active" href="index.jsp"><i class="si si-speedometer"></i><span class="sidebar-mini-hide">首页</span></a>
                                </li>
                                <li class="nav-main-heading"><span class="sidebar-mini-hide">课程信息管理</span></li>
                                <li>
                                    <a class="nav-submenu" data-toggle="nav-submenu" href="addclass.jsp"><i class="si si-badge"></i><span class="sidebar-mini-hide">增加课程</span></a>
                                    
                                </li>
                                <li class="open">
                                    <a class="nav-submenu" data-toggle="nav-submenu" href="course.jsp"><i class="si si-grid"></i><span class="sidebar-mini-hide">课程管理</span></a>
                                    
                                </li>
                                
                                
                                <li class="nav-main-heading"><span class="sidebar-mini-hide">学生管理</span></li>
                                <li>
                                    <a class="nav-submenu" data-toggle="nav-submenu" href="addstudent.jsp"><i class="si si-wrench"></i><span class="sidebar-mini-hide">添加学生</span></a>
                                    
                                </li>
                                <li>
                                    <a class="nav-submenu" data-toggle="nav-submenu" href="student.jsp"><i class="si si-magic-wand"></i><span class="sidebar-mini-hide">学生管理</span></a>
                                    
                                </li>
                                
                                
                                <li class="nav-main-heading"><span class="sidebar-mini-hide">教师管理</span></li>
                                <li>
                                    <a class="nav-submenu" data-toggle="nav-submenu" href="addteacher.jsp"><i class="si si-layers"></i><span class="sidebar-mini-hide">添加教师</span></a>
                                   
                                </li>
                                <li>
                                    <a class="nav-submenu" data-toggle="nav-submenu" href="teacher.jsp"><i class="si si-fire"></i><span class="sidebar-mini-hide">教师管理</span></a>
                                    
                                </li>
                                
                                <li class="nav-main-heading"><span class="sidebar-mini-hide">管理员管理</span></li>
                                <li>
                                    <a class="nav-submenu" data-toggle="nav-submenu" href="admin_add.jsp"><i class="si si-user"></i><span class="sidebar-mini-hide">添加管理员</span></a>
                                    
                                </li>
                                <!-- <li>
                                    <a class="nav-submenu" data-toggle="nav-submenu" href="#"><i class="si si-user"></i><span class="sidebar-mini-hide">修改管理员信息</span></a>
                                    
                                </li> -->
                            </ul>
                        </div>
                        <!-- END Side Content -->
                        <div class="side-header side-content bg-white-op left-menu_account">
                            <!-- Layout API, functionality initialized in App() -> uiLayoutApi() -->
                            <!-- <button class="btn btn-link text-gray pull-right hidden-md hidden-lg" type="button" data-toggle="layout" data-action="sidebar_close">
                                <i class="fa fa-times"></i>
                            </button> -->
                            <!-- Themes functionality initialized in App() -> 登录人员名称 -->
                            <div class="btn-group pull-right">
                               <i class="si si-drop"><a href="${pageContext.request.contextPath}/RemoveSeesion">退出</a></i>
                                
                            </div>
                            <a class="h5 text-white" href="index.html">
                                <span class="h4 font-w600 sidebar-mini-hide"><c:if test="${admin!=null }">${admin.getAname()}
								</c:if>
								</span>
                            </a>
                        </div>
                    </div>
                    <!-- Sidebar Content -->
                </div>
                <!-- END Sidebar Scroll Container -->
            </nav>
            <!-- END Sidebar 侧边栏 -->

            <!-- Header -->
            <header id="header-navbar" class="content-mini content-mini-full">
                <!-- Header Navigation Right -->
               
                <!-- END Header Navigation Right -->

                <!-- Header Navigation Left -->
                <ul class="nav-header">
                    <li class="hidden-md hidden-lg pull-left">
                        <!-- Layout API, functionality initialized in App() -> uiLayoutApi() -->
                        <button class="btn btn-default" data-toggle="layout" data-action="sidebar_toggle" type="button">
                            <i class="fa fa-navicon"></i>
                        </button>
                    </li>
                    <li class="hidden-xs hidden-sm pull-left">
                        <!-- Layout API, functionality initialized in App() -> uiLayoutApi() -->
                        <button class="btn btn-default" data-toggle="layout" data-action="sidebar_mini_toggle" type="button">
                            <i class="fa fa-ellipsis-v"></i>
                        </button>
                    </li>
                    
                    <li class="js-header-search header-search pull-right">
                        <form class="form-horizontal" action="#" method="post">
                            <div class="form-material form-material-primary input-group remove-margin-t remove-margin-b">
                                <input class="form-control" type="text" id="base-material-text" name="base-material-text" placeholder="Search..">
                                <span class="input-group-addon"><i class="si si-magnifier"></i></span>
                            </div>
                        </form>
                    </li>
                </ul>
                <!-- END Header Navigation Left -->
            </header>
            <!-- END Header -->

            <!-- Main Container -->
            <main id="main-container">
                <!-- Page Header -->
                <div class="content bg-image overflow-hidden" style="background-image: url('assets/img/photos/photo12@2x.jpg');">
                    <div class="push-50-t push-15">
                        <h1 class="h2 text-white animated zoomIn">课程管理</h1>
                        
                    </div>
                </div>
                <!-- END Page Header -->

                <!-- Stats  访问次数-->
                <div class="content bg-white border-b">
                    <div class="row items-push text-uppercase">
                        <div class="col-xs-6 col-sm-3">
                            <div class="font-w700 text-gray-darker animated fadeIn">今日访问次数</div>
                            <div class="text-muted animated fadeIn"><small><i class="si si-calendar"></i> Today</small></div>
                            <a class="h2 font-w300 text-primary animated flipInX" href="base_comp_charts.html">300</a>
                        </div>
                        <div class="col-xs-6 col-sm-3">
                            <div class="font-w700 text-gray-darker animated fadeIn">历史访问次数</div>
                            <div class="text-muted animated fadeIn"><small><i class="si si-calendar"></i> Before</small></div>
                            <a class="h2 font-w300 text-primary animated flipInX" href="base_comp_charts.html">8,790</a>
                        </div>
                        <div class="col-xs-6 col-sm-3">
                            <div class="font-w700 text-gray-darker animated fadeIn">教师注册人数</div>
                            <div class="text-muted animated fadeIn"><small><i class="si si-calendar"></i> All TEACHER</small></div>
                            <a class="h2 font-w300 text-primary animated flipInX" href="base_comp_charts.html">880</a>
                        </div>
                        <div class="col-xs-6 col-sm-3">
                            <div class="font-w700 text-gray-darker animated fadeIn">学生注册人数</div>
                            <div class="text-muted animated fadeIn"><small><i class="si si-calendar"></i> All STUDENT</small></div>
                            <a class="h2 font-w300 text-primary animated flipInX" href="base_comp_charts.html">270</a>
                        </div>
                    </div>
                </div>
                <!-- END Stats  访问次数-->

                <!-- Page Content -->
                <div class="content">
                    <div class="row">
                        <div class="col-lg-12">
                            <!-- Main Dashboard Chart -->
                            <!-- Dynamic Table Full -->
                    <div class="block">
                        <div class="block-header">
                            <h3 class="block-title">课程预览表 <small>All</small></h3>
                        </div>
                        <div class="block-content">
                            <!-- DataTables init on table by adding .js-dataTable-full class, functionality initialized in js/pages/base_tables_datatables.js -->
                            <table class="table table-bordered table-striped js-dataTable-full">
                                <thead>
                                    <tr>
                                        <th class="text-center"></th>
                                        <th>课程编号</th>
                                        <th class="hidden-xs">课程名称</th>
                                        <th class="hidden-xs">绩点</th>
                                        <th class="hidden-xs">上课人数</th>
                                        <th class="hidden-xs">授课教师</th>
                                        <th class="hidden-xs">开课时间</th>
                                        <th class="text-center" style="width: 10%;">Actions</th>
                                    </tr>

                                </thead>
                                 <% 
                                    	AdminDAO aDAO = new AdminDAO();
                                    	List userAllcourse= aDAO.selectAllcourse();
                                    	System.out.println(userAllcourse.size());
                                    	request.setAttribute("userAllcourse", userAllcourse); 
                                  
                                     %>
                                <tbody>
                                <c:forEach items="${userAllcourse}" var="item" varStatus="status">  
								  <tr>
                                   
                                        <td class="text-center">${status.index+1}</td>
                                        <td class="font-w600">${item.getCno() }</td>
                                        <td class="font-w600">${item.getCname() }</td>
                                        <td class="hidden-xs">${item.getCredit() }</td>
                                        <td class="hidden-xs">${item.getCnum() }</td>
                                        <td class="hidden-xs">${item.getTno() }</td>
                                         <td class="hidden-xs">${item.getCtime() }</td>
                                        <td class="text-center">
                                            <div class="btn-group">
                                                <button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" 
                                                title="Edit Client" onclick="edit('${item.getCno() }',
                                                                                  '${item.getCname() }',
                                                                                  '${item.getCredit() }',
                                                                                  '${item.getCnum() }',
                                                                                  '${item.getTno() }',
                                                                                  '${item.getCtime() }')">
                                                <i class="fa fa-pencil"></i></button>
                                                
                                                <button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" title="Remove Client" onclick="del('${item.getCno()}')"><i class="fa fa-times"></i></button>
                                            </div>
                                        </td>
                                    </tr> 
								</c:forEach>  
                                    
                                   
                                   
                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- END Dynamic Table Full -->
                            <!-- END Main Dashboard Chart -->
                        </div>
                       
                    </div>
                    
                </div>
                <!-- END Page Content -->
            </main>
            <!-- END Main Container -->

            <!-- Footer -->
            <footer id="page-footer" class="content-mini content-mini-full font-s12 bg-gray-lighter clearfix">
                <div class="pull-right">
                    Crafted with <i class="fa fa-heart text-city"></i> by <a class="font-w600" href="#" target="_blank">pixelcave</a>
                </div>
                <div class="pull-left">
                    <a class="font-w600" href="javascript:void(0)" target="_blank">湖南大学教务处</a> &copy; <span class="js-year-copy"></span>
                </div>
            </footer>
            <!-- END Footer -->
        </div>
        <!-- END Page Container -->

        <!-- Apps Modal -->
        <!-- Opens from the button in the header -->
        <div class="modal fade" id="apps-modal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-sm modal-dialog modal-dialog-top">
                <div class="modal-content">
                    <!-- Apps Block -->
                    <div class="block block-themed block-transparent">
                        <div class="block-header bg-primary-dark">
                            <ul class="block-options">
                                <li>
                                    <button data-dismiss="modal" type="button"><i class="si si-close"></i></button>
                                </li>
                            </ul>
                            <h3 class="block-title">Apps</h3>
                        </div>
                        <div class="block-content">
                            <div class="row text-center">
                                <div class="col-xs-6">
                                    <a class="block block-rounded" href="index.html">
                                        <div class="block-content text-white bg-default">
                                            <i class="si si-speedometer fa-2x"></i>
                                            <div class="font-w600 push-15-t push-15">Backend</div>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-xs-6">
                                    <a class="block block-rounded" href="frontend_home.html">
                                        <div class="block-content text-white bg-modern">
                                            <i class="si si-rocket fa-2x"></i>
                                            <div class="font-w600 push-15-t push-15">Frontend</div>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- END Apps Block -->
                </div>
            </div>
        </div>
        <!-- END Apps Modal -->
        
        
        
        <!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
    <form action="${pageContext.request.contextPath}/UpdateCourse" method="post">
    	
	    	 <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改</h4>
            </div>
            <div class="modal-body">
           							
            	<div class="form-group">
                    <input type="text" class="form-control" id="cno" placeholder="课程号" name="cno" readonly="true">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="cname" name="cname" placeholder="课程名">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="credit" name="credit" placeholder="学分" >
                </div>
                
                <div class="form-group">
                    <input type="text" class="form-control" id="cnum" name="cnum" placeholder="上课人数" >
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="tno" name="tno" placeholder="上课教师" >
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="ctime" name="ctime" placeholder="开课时间" >
                </div>
                
                
            </div>
            <div class="modal-footer">
                
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary" id="save">提交</button>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<%-- <div class="btn-group">
  <button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" title="Edit Client"><i class="fa fa-pencil"></i></button>
  <button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" title="Remove Client"><i class="fa fa-times"></i></button>
  </div> --%>
<script type="text/javascript">
	var table;
    
            /**
     *编辑方法
     **/
    function edit(no,name,credit,number,teacher,time) {
        console.log(name);
        editFlag = true;
        $("#myModalLabel").text("修改");
        $("#cno").val("课程号： "+no);
        $("#cname").val(name);
        $("#credit").val(credit);
        $("#cnum").val(number);
        $("#tno").val(teacher);
        $("#ctime").val(time);
        $("#myModal").modal("show");
        
        
    }
    
    function ajax(no,name,credit,number,teacher,time) {
        var url ="" ;
        if(editFlag){
            url = "editcourse.jsp";
        }
        /*
        $.ajax({
            url:url ,
            data: {
                "no": no,
                "name": name,
                "credit": credit,
                "number": number,
                "teacher": teacher,
                "time": time
                
            }, success: function (data) {
                table.ajax.reload();
                
            }
        });
        */
        
        alert("修改成功！");
        table.ajax.reload();
        window.navigate("index.jsp"); 
    }
    
    
    
     /**
     * 删除数据
     * @param name
     */
    function del(Cno) {
        $.ajax({
            url: "delcourse.jsp",
            data: {
            	"Cno":Cno
            },
            success: function (data) {
                table.ajax.reload();
            }
        });
        alert("删除成功！");
        table.ajax.reload();
        window.navigate("index.jsp"); 
         
    }
        
</script>

        <!-- OneUI Core JS: jQuery, Bootstrap, slimScroll, scrollLock, Appear, CountTo, Placeholder, Cookie and App.js -->
        <script src="assets/js/core/jquery.min.js"></script>
        <script src="assets/js/core/bootstrap.min.js"></script>
        <script src="assets/js/core/jquery.slimscroll.min.js"></script>
        <script src="assets/js/core/jquery.scrollLock.min.js"></script>
        <script src="assets/js/core/jquery.appear.min.js"></script>
        <script src="assets/js/core/jquery.countTo.min.js"></script>
        <script src="assets/js/core/jquery.placeholder.min.js"></script>
        <script src="assets/js/core/js.cookie.min.js"></script>
        <script src="assets/js/app.js"></script>

        <!-- Page Plugins -->
        <script src="assets/js/plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="assets/js/pages/base_tables_datatables.js"></script>
        <!-- <script src="assets/js/plugins/slick/slick.min.js"></script>
        <script src="assets/js/plugins/chartjs/Chart.min.js"></script> -->

        <!-- Page JS Code -->
        <script src="assets/js/pages/base_pages_dashboard.js"></script>

        
        <script>
            $(function () {
                // Init page helpers (Slick Slider plugin)
                App.initHelpers('slick');
            });
        </script>
    </body>

</html>