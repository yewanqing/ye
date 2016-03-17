<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="jquery.js"></script>
</head>
<body>
<h2>Hello World!</h2>
<input type="button" value="登录" onclick="login()"/>
<input type="button" value="用户登录" onclick="userLogin()"/>
<input type="button" value="命名空间登录" onclick="namespaceLogin()"/>
<input type="button" value="servlet" onclick="servletLogin()"/>
<input type="button" value="用户信息" onclick="userInfo()"/>
</body>
<script>
    function login(){
        $.post("/workspace/login.login.do",function(data){
            console.log(data);

        });

//        location.href="/workspace/user.login.do";
    }



    function userInfo(){
        location.href="/workspace/user.loadUser.do";
    }

    function userLogin(){
        $.post("/workspace/userLogin.login.do",function(data){
            console.log(data);
            $.post("/workspace/userLogin.loadUser.do",function(data){

            });
        });
    }

    function namespaceLogin(){
        $.post("/workspace/html/namespace.login.do",function(data){
            console.log(data);
//            $.post("/workspace/userLogin.loadUser.do",function(data){
//
//            });
        });
    }

    function servletLogin(){
        $.post("/workspace/servlet/testServlet",function(data){
            console.log(data);

        });
    }
</script>
</html>
