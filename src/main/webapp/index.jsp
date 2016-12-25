<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        .codearea{

            height: 500px;
            width: 650px;
            background-color: #43ff9c;
            resize: none;
        }
    </style>
</head>
<body>
<h2 align="center">follow your code you accepted!</h2>
<hr/>
<div style="text-align: center">
    <h3>page:${page}</h3>
    <textarea class="codearea" >${codes}</textarea>
</div>
<br/>
${request}
<br/>
${model}
<br/>

<table align="center" width="60%" border="0">



    <form method="post" action="${pageContext.request.contextPath}/getcode">
        <tr>
            <th>tell me your cookie :</th>
            <th><input type="text" name="cookie"/></th>
        </tr>
        <tr>
            <th>tell me your url :</th>
            <th><input type="text" name="url"/></th>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="提交"/>
            </th>
        </tr>
    </form>

</table>

</body>
</html>
