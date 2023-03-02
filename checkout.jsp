<%-- 
    Document   : Checkout
    Created on : Feb 26, 2023, 9:05:42 AM
    Author     : pach3
--%>

<%@page import="java.math.BigDecimal"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="BusinessObject.Cart"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession tPrice = request.getSession();
    List<Cart> cart_list = (ArrayList<Cart>)tPrice.getAttribute("cart-list");
    Double price = (Double)tPrice.getAttribute("totalPrice");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check out page</title>
        <style>
            form{
                width: 800px;
                margin: auto;
                background: #cf641c;
                padding: 20px 60px;
                border-radius: 5px;
                font-size: 1.5rem;
            }
            form input{
                border-radius: 5px;
                margin-left: 5%;
            }
            h2{
                text-align: center;
            }
            button{
                padding: 12px 100px;
                font-weight: bold;
                margin: auto;
                display: block;
            }
        </style>
    </head>

    <body>
        <h1>Check out</h1>
        <main>
            <form action="check-out" method="post">
                <p>
                    <label for="firstname">First Name : </label>
                    <input type="text" name="firstname" id="firstname" required>
                </p>
                <p>
                    <label for="lastname">Last Name : </label>
                    <input type="text" name="lastname" id="lastname" required>
                </p>
                <p>
                    <label for="email">Email : </label>
                    <input type="email" name="email" id="email" required>
                </p>
                <p>
                    <label for="phone">Phone Number : </label>
                    <input type="phone" name="phone" id="phone" required>
                </p>
                <p>
                    <label for="cardnumber">Card Number : </label>
                    <input type="text" name="lastname" id="lastname">
                </p>
                <p>
                <fieldset>
                    <legend> Credit | Debit (card) </legend>
                    <label>Card Number : </label>
                    <input type="text" name="cardnumber" id="cardnumber" placeholder="Your card number here">
                    <p>
                        <label>Expiration Date: </label>
                        <input type="text" name="expiration-date" id="expirationDate">
                    </p>
                    <p>
                        <label>Security Code : </label>
                        <input type="password" name="security-code" id="securityCode">
                    </p>
                </fieldset>
                </p>
                <p>
                <h2>Total: $<%=price%></h2>
                <button type="submit">Buy</button>
                </p>
            </form>
            <div>
            </div>
        </main>
                <script>
                    
                </script>
    </body>

</html>
