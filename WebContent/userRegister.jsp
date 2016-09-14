<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>
</head>
<script language="JavaScript">
	function validate(f) {
		if (!(/^\w{5,15}$/.test(f.username.value))) {
			alert("用户ID必须是5~15位");
			f.username.focus();
			return false;
		}
		if (!(/^\w{5,15}$/.test(f.userpwd.value))) {
			alert("用户ID必须是5~15位");
			f.userpwd.focus();
			return false;
		}
		if (!(/^\w{11}$/.test(f.photoNum.value))) {
			alert("手机号码ID必须是11位");
			f.userpwd.focus();
			return false;
		}
		if (f.userpwd.value != f.userpwd1.value) {
			alert("两次密码不一样");
			f.userpwd.focus();
			return false;
		}
	}
</script>
<body background="img/12.jpg">
	<br />
	<br />
	<h1 align="center">新用户注册</h1>
	<form action="userregister.view" method="post"
		onsubmit="return validate(this)">
		<table align="center" border="1px" cellspacing="10px">
			<tr>
				<td>用户名：</td>
				<td><input type="text" id="username" name="username" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" id="userpwd" name="userpwd" /></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="text" id="userpwd1" name="userpwd1" /></td>
			</tr>
			<tr>
				<td>真实姓名：</td>
				<td><input type="text" id="realName" name="realName" /></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><input type="text" id="address" name="address" /></td>
			</tr>
			<tr>
				<td>手机：</td>
				<td><input type="text" id="photoNum" name="photoNum" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="注册" /></td>
				<td><input type="reset" name="reset" value="取消" /></td>
			</tr>
			<tr><td><font color="red">${error }</font></td></tr>
		</table>
	</form>
</body>
</html>