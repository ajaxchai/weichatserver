<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>走势图</title>
<script src="./js/vue.min.js"></script>
</head>
<body>
<table border="1">
<tr>
<%
for(int i=1; i<=33; i++) {
%>
<td> <%=i%> </td>
<%
}
%>
</tr>
</table>
<div id="app">
<p> {{ message }} </p>
</div>

<script>
new Vue ({
	el: '#app',
	data: {message: '本小程序数据来源于福彩官网http://www.cwl.gov.cn，请以福彩官网数据为准!'}
});
</script>

</body>
</html>