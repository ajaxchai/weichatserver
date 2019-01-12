<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>走势图</title>
<script type="text/javascript" src="./js/vue.min.js"></script>
<script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.3.2.js"></script>

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

<button onclick="jumpTo()">跳转到小程序页面</button>

<script>
function jumpTo() {
	// 跳转到小程序的一个页面
	wx.miniProgram.navigateTo({url: '/pages/combinetool/combinetool'});
}

new Vue ({
	el: '#app',
	data: {message: '本小程序数据来源于福彩官网http://www.cwl.gov.cn，请以福彩官网数据为准!'}
});

</script>

</body>
</html>