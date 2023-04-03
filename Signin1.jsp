<%--
    Benevolence Ed-Malik
    Pradsley D'Haiti
--%>
<%@page import="BusinessObject.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizza Palace Rewards - Sign In</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/png" sizes="32x32" href="logo.png">
    </head>

    <%
        Customer c = (Customer) session.getAttribute("customer");
        if (c != null) {
            if (c.getPassword().equals("123")) {
                out.println("You're account info is " + c.getEmail() + " and your default password is '123' ");
            } else {
                out.println("You're account info is " + c.getEmail() + " and your default password is " + c.getPassword());
            }
        }
    %>
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
                <a href="#" class="account">Pizza Palace Rewards</a>
            </nav>
        </header>

        <!--<h3 style="text-align: center">Don't have one? 
            <a href="#" style="color: #cf641c; text-decoration: underline">
                Join the rewards program now</a>
        </h3>-->

        <div class="container">
            <form action="SigninServlet" method="post">
                <br>Email<br> <input type="text" id="email" name="email" placelholder="<%=c.getEmail()%>"> <br>
                Password<br> <input type="text" id="password" name="password">
                <br><br>
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
