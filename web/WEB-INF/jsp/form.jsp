<%--
  Created by IntelliJ IDEA.
  User: leiji
  Date: 2019/11/18
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>

    <base href="<%=basePath %>" />
    <title>发布新的招聘信息</title>
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script type="text/javascript">
        var flag1=false;
        var flag2=false;
        var flag3=false;
        $(function () {
            $("#position").blur(function () {
                if($("#position").val().length==0){
                    $("#btn").attr("disabled",true);
                    $("#posi").html("职位名不得为空");

                }else {
                    $("#posi").html("√")
                    flag1=true;
                }
                if(flag1&&flag2&&flag3){
                    $("#btn").attr("disabled",false);
                }
            })

            $("#minsal").blur(function () {
                if($("#minsal").val().length==0){
                    $("#btn").attr("disabled",true);
                    $("#min").html("最低工资不得为空");

                }else {
                    $("#min").html("√")
                    flag2=true;
                }
                if(flag1&&flag2&&flag3){
                    $("#btn").attr("disabled",false);
                }
            })

            $("#maxsal").blur(function () {
                if($("#maxsal").val().length==0){
                    $("#btn").attr("disabled",true);
                    $("#max").html("最高工资不得为空");

                }else {
                    $("#max").html("√")
                    flag3=true;
                }
                if(flag1&&flag2&&flag3){
                    $("#btn").attr("disabled",false);
                }
            })
        })
    </script>
</head>
<body style="text-align: center">
<h1>发布职位招聘信息</h1><br/><hr/>
<form action="http://localhost:8080/addInfo" method="post" >
    职位名称：<input type="text" name="pname" id="position"><span id="posi"></span><br/>
    最低薪水：<input type="text" name="minsal" id="minsal"><span id="min"></span><br/>
    最高薪水：<input type="text" name="maxsal" id="maxsal"><span id="max"></span><br/>
    发布公司：<select name="cname">
    <option value="腾讯">腾讯</option>
    <option value="京东">京东</option>
    <option value="阿里巴巴">阿里巴巴</option>
    <option value="百度">百度</option>
    <option value="尚学堂">尚学堂</option>
    <option value="今日头条">今日头条</option>
</select><br/>
    工作地点：<input type="text" name="location">
    <input type="submit" value="发布" id="btn" disabled>
</form>
</body>
</html>
