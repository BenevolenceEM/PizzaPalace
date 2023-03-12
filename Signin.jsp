<%--
    Benevolence Ed-Malik
    Pradsley D'Haiti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizza Palace Rewards - Sign In</title>
        <link rel="stylesheet" href="main.css">
        <link rel="stylesheet" href="styles.css">
        <link rel="icon" type="image/png" sizes="32x32" href="images/logo.png">
    </head>
    <body>
        <header>
            <a href="index.html" class="logo">
                <img src="images/image.png" alt="logo">
            </a>
            <nav>
                <a href="" class="promos">Promos</a>
                <li class="menu-dropdown">
                    <a href="" class="menu">Menu</a>
                    <div class="menu-content">
                        <a href="">Pizza</a>
                        <a href="">Wings</a>
                        <a href="">Pasta</a>
                        <a href="">Sides</a>
                        <a href="">Desserts</a>
                        <a href="">Salads</a>
                        <a href="">Drinks</a>
                        <a href="">Dips</a>
                    </div>
                </li>
                <a id="active" href="#" class="account">Pizza Palace Rewards</a>
            </nav>
        </header>
        
        <div class="container">
            <form action="SigninServlet">
                <h2 style="text-align: center">Don't have one? 
                <a href="CreateAccount.jsp" style="color: #cf641c; text-decoration: underline">
                    Join the rewards program now</a>
                </h2><br><br>
                
                <label for="email">Email</label><br>
                <input type="text" id="email" name="email"><br><br>
                
                <label for="password">Password</label><br>
                <input type="password" id="password" name="password"><br><br>
                <a href="#" style="color: #cf641c; text-decoration: underline">
                FORGOT PASSWORD?</a><br><br>
                
                <input type="submit" value="SIGN IN">
                <input type="reset" value="CLEAR">
            </form>
        </div>
        <%
            String alert = request.getParameter("alert");
            if ("empty".equals(alert)) {
        %>
        <script>
            alert("Empty login. Please input login credentials");
        </script>
        <%
            }
        %>
        <%
            String alert1 = request.getParameter("alert1");
            if ("invalid".equals(alert1)) {
        %>
        <script>
            alert("Invalid Login. Please try again");
        </script>
        <%
            }
        %>
    </body>
</html>
