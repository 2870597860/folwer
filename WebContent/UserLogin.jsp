<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>鲜花销售平台</title>
</head>
<script language="JavaScript">
function validate(f){
	if(!(/^\w{5,15}$/.test(f.username.value))){
		alert("用户ID必须是5~15位");
		f.username.focus();
		return false;
	}
	if(!(/^\w{5,15}$/.test(f.userpwd.value))){
		alert("密码ID必须是5~15位");
		f.userpwd.focus();
		return false;
	}
}
</script>
<body>
<br/><br/>
	<h1 align="center">网上花店登陆</h1>
 <%
		request.setCharacterEncoding("utf-8");//进行乱码处理
		List<String> info=(List<String>) request.getAttribute("info");
		if(info!=null){
			Iterator<String> iter=info.iterator();
			while(iter.hasNext()){
%>
		<h4><%=iter.hashCode() %></h4>
<%
	}
}
%> 
</br>
</br>
	<div align="center">如果您还未注册，请点击<a href="userRegister.jsp" >注册 </a></div>
	<form action="userlogin.view" method="post" onsubmit="return validate(this)">
		<table align="center" >
			<tr align="center">
				<td colspan="2" >注意区分大小写</td>
			</tr>
			<tr>
				<td>用户名：</td>			
				<td><input type="text" id="username" name="username"  value="${username }"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" id="userpwd" name="userpwd"  value="${userpwd }"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="登陆" /></td>
				<td><input type="reset" value="重置" /></td>
			</tr>
			<tr><td><font color="red">${error }</font></td></tr>
		</table>
	</form>
</body>
</html>