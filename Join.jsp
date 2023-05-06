<%--
    Benevolence Ed-Malik
    Pradsley D'Haiti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizza Palace Rewards - Join</title>
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
                <div class="nav">
                <ul>
                <li><a href="" class="promos">Promos</a></li>
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
                </ul>
                </div>
                <div class="nav-1">
                    <li><p class="account" style="text-decoration: none; cursor: default">Pizza Palace rewards</p></li>
                </div>
            </nav>
        </header>
        
        <div class="container">
            <% if(request.getAttribute("message") != null) {%>
                <%= request.getAttribute("message") %>
            <% } %>
            <form action="JoinServlet" method="post">
            <label for="fname">First Name</label><br>
            <input type="text" id="fname" name="fname"><br>
            <label for="lname">Last Name</label><br>
            <input type="text" id="lname" name="lname"><br>
            <label for="email">Email</label><br>
            <input type="text" id="email" name="email"><br>
            <label for="phone">Phone</label><br>
            <input type="text" id="phone" name="phone"><br>
            <label for="password">Password</label><br>
            <input type="password" id="password" name="password"><br><br>
            
            <input type="submit" value="CREATE">
            <input type="reset" value="CLEAR">
            </form>
        </div>
    </body>
</html>
