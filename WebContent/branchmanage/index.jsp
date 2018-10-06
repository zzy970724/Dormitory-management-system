<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="../css/bootstrap.css" />
		<link rel="stylesheet" href="../css/index.css" />
		<script type="text/javascript" src="../js/jquery1.12.2.js"></script>
		<script type="text/javascript" src="../js/bootstrap.js"></script>
		<script type="text/javascript" src="../js/bootstrap-transition.js"></script>
		<script type="text/javascript" src="../js/bootstrap-modal.js"></script>
		<script >
			function zz(){ alert("你的权限不足")}
		</script>
	</head>

	<body>
		<div style="width: 1080px; height: 615px;">
				<ol class="breadcrumb">
					<li>
						<h2>学生寝室信息管理</h2></li>
				</ol>
			<div class=" panel panel-default">
				<form action="../StudentServlet" method="post">
				<input type="hidden" value="find" name="flag">
				<div class="panel-heading">
					<h4>查询条件</h4>
				</div>
				<div class="panel-body">
					<div class="col-md-3">
						<input type="text" name="sname" class="form-control" id="in1" placeholder="学生姓名">
					</div>
					<div class="col-md-3">
						<input type="text" name="sid" class="form-control" id="in1" placeholder="学生学号">
					</div>
					<div class="col-md-3">
						<input type="text" name="sqsld" class="form-control" id="in1" placeholder="寝室楼栋">
					</div>
					<div class="col-md-3">
						<button type="submit" class="btn btn-success form-control" id="but1"><span class="glyphicon glyphicon-search"></span>&nbsp;&nbsp;查询</button>
					</div>
				</div>
               </form>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>查询结果</h4>
				</div>
				<div class="panel-body">
					<div class="col-md-9">
						
		<!-- Button trigger modal -->
		<div class="row">
		<div class="col-md-2">
		<button class="btn btn-success " data-toggle="modal" data-target="#myModal"><h6><span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;新增</h6></button></div>
		<div class="col-md-2">
		<button class="btn btn-warning " data-toggle="modal" data-target="#myModal2"><h6><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;修改</h6></button></div>
		<div class="col-md-2">
		<button class="btn btn-danger " data-toggle="modal" data-target="#myModal3"><h6><span class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;删除</h6></button></div>
		<div class="col-md-1 col-md-offset-5">
		<a href=""><button class="btn btn-info" onclick="zz()"><h6><span class="glyphicon glyphicon-search"></span>&nbsp;&nbsp;查看该下学生信息 </h6></button></a></div>
		</div>
			
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel" style="text-align: center;">新增学生信息</h4>
					</div>
					<div class="modal-body">
						<div class="container-fluid">
						
						<form action="../StudentServlet" method="post">
							<input type="hidden" value="add" name="flag">
							<div class="col-md-12"> 
							
								<div class="col-md-3 col-md-offset-2">
									<h6>*学生学号</h6></div>
								<div class="col-md-5 col-md-offset-0"><input type="text" name="sid" class="form-control"><br></div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3 col-md-offset-2">
									<h6>*学生姓名</h6></div>
								<div class="col-md-5 col-md-offset-0"><input type="text" name="sname" class="form-control"><br></div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3 col-md-offset-2">
									<h6>*人员类型</h6></div>
						<div class="col-md-5 col-md-offset-0"><input type="text" name="stype" class="form-control"><br></div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3 col-md-offset-2">
									<h6>*电话</h6></div>
								<div class="col-md-5 col-md-offset-0"><input type="text" name="snum" class="form-control"><br></div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3 col-md-offset-2">
									<h6>*身份证</h6></div>
								<div class="col-md-5 col-md-offset-0"><input type="text" name="sic" class="form-control"><br></div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3 col-md-offset-2">
									<h6>*指导老师</h6></div>
								<div class="col-md-5 col-md-offset-0"><input type="text" name="steacher" class="form-control"><br></div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3 col-md-offset-2">
									<h6>*寝室门号</h6></div>
								<div class="col-md-5 col-md-offset-0"><input type="text" name="sqsmh" class="form-control"><br></div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3 col-md-offset-2">
									<h6>*寝室楼栋</h6></div>
								<div class="col-md-5 col-md-offset-0"><input type="text" name="sqsld" class="form-control"><br></div>
								<br><br><br>

								<div class="modal-footer">
									<input type="submit" class="btn btn-danger" value="确定添加">
									<input type="reset" class="btn btn-info"  value="取消">
								</div>
								
							</div>
							</form>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
				</div>
			</div>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="myModal2" tabindex="-2" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel" style="text-align: center;">修改学生信息</h4>
					</div>
					<div class="modal-body">
						<div class="container-fluid">
						<form action="../StudentServlet" method="post">
						<input type="hidden" value="upd" name="flag">
							<div class="col-md-12">
								<div class="col-md-3 col-md-offset-2">
									<h6>*学生学号</h6></div>
								<div class="col-md-5 col-md-offset-0"><input type="text" name="sid" class="form-control"><br></div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3 col-md-offset-2">
									<h6>*学生姓名</h6></div>
								<div class="col-md-5 col-md-offset-0"><input type="text" name="sname" class="form-control"><br></div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3 col-md-offset-2">
									<h6>*人员类型</h6></div>

					<div class="col-md-5 col-md-offset-0"><input type="text" name="stype" class="form-control"><br></div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3 col-md-offset-2">
									<h6>*电话</h6></div>

								<div class="col-md-5 col-md-offset-0"><input type="text" name="snum" class="form-control"><br></div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3 col-md-offset-2">
									<h6>*身份证</h6></div>

								<div class="col-md-5 col-md-offset-0"><input type="text" name="sic" class="form-control"><br></div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3 col-md-offset-2">
									<h6>*指导老师</h6></div>

								<div class="col-md-5 col-md-offset-0"><input type="text" name="steacher" class="form-control"><br></div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3 col-md-offset-2">
									<h6>*寝室门号</h6></div>

								<div class="col-md-5 col-md-offset-0"><input type="text" name="sqsmh" class="form-control"><br></div>
							</div>
								<div class="col-md-12">
			                 <div>
								<div class="col-md-3 col-md-offset-2">
									<h6>*寝室楼栋</h6></div>
								<div class="col-md-5 col-md-offset-0"><input type="text" name="sqsld" class="form-control"><br></div>
							</div>
								<br><br><br>

								<div class="modal-footer">
									<button type="submit" class="btn btn-danger">确定修改</button>
									<button type="reset" class="btn btn-info">取消</button>
								</div>
							</div>
							</form>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
				</div>
			</div>
		</div>


		<!-- Modal -->
		<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">操作提示</h4>
					</div>
					<div class="modal-body">
						<h5>是否删除!</h5>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">确定删除</button>
						<button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		</div>
		</div>
			</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered table-hover table-condensed">
						<tr class="active">
							<td></td>
							<td><b>学号</b></td>
							<td><b>姓名</b></td>
							<td><b>类型</b></td>
							<td><b>电话</b></td>
							<td><b>身份证</b></td>
							<td><b>指导老师</b></td>
							<td><b>寝室门号</b></td>
							<td><b>寝室楼栋</b></td>
						</tr>
						<c:forEach items="${list}" var="ws">
						<tr class="success">
							<td><input type="checkbox"></td>
							<td>${ws.sid}</td>
							<td>${ws.sname}</td>
							<td>${ws.stype}</td>
							<td>${ws.snum}</td>
							<td>${ws.sic}</td>
							<td>${ws.steacher}</td>
							<td>${ws.sqsmh}</td>
							<td>${ws.sqsld}栋</td>
						</tr>
						</c:forEach>
						
					</table>

				</div>
			</div>
		</div>
	</body>

</html>