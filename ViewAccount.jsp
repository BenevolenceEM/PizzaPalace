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
        <title>Pizza Palace Rewards - My Account</title>
        <link rel="stylesheet" href="main.css">
        <link rel="stylesheet" href="styles.css">
        <link rel="icon" type="image/png" sizes="32x32" href="images/logo.png">
    </head>
    <body>
        <%
            Customer c1 = (Customer)session.getAttribute("c1");
            session.getAttribute("c1");
        %>
        <header>
            <a id="active" href="index.html" class="logo">
                <img src="images/image.png" alt="logo">
            </a>
            <nav>
                <div class="nav">
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
                </div>
                </li>
                <div class="nav-1">
                <a id="active" href="ViewAccount.jsp" class="account"><%=c1.getCustomerId()%></a>
                <a href="">Log Out</a>
                </div>
            </nav>
        </header>
        
        <div class="container">
            <h2 style="text-align: center; color: #cf641c;">My Account</h2><br>
            <form action="ViewAccountServlet">
            <label for="email">Email</label><br>
            <input readonly type="text" id="email" name="email" value="<%=c1.getEmail()%>"><br>
            <label for="id">Customer ID</label><br>
            <input readonly type="text" id="id" name="id" value="<%=c1.getCustomerId()%>"><br>
            <label for="password">Password</label><br>
            <input type="password" id="password" name="password" value="<%=c1.getPassword()%>"><br>
            <label for="fname">First Name</label><br>
            <input type="text" id="fname" name="fname" value="<%=c1.getFirstname()%>"><br>
            <label for="lname">Last Name</label><br>
            <input type="text" id="lname" name="lname" value="<%=c1.getLastname()%>"><br>
            <label for="phone">Phone</label><br>
            <input type="text" id="phone" name="phone" value="<%=c1.getPhone()%>"><br><br>
            <center><input type="submit" value="UPDATE"></center>
            </form>
        </div>
    </body>
</html>
