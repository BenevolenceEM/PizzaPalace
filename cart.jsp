<%@page import="BusinessObject.Product"%>
<%@page import="BusinessObject.Cart"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!--
Benevolence Ed-Malik
Pradsley D'Haiti
-->
<%
    List<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    double total = 0;
    if (cart_list != null) {
        for (Cart c : cart_list) {
            total += c.getPrice();
        }
    }
    session.setAttribute("totalPrice", total);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <style>
            table, td{
                width: 800px;
                text-align: center; border: 1px solid black;
                border-collapse: collapse;
            }
            .checkout{
                position: relative;
                left: 38%;
                margin-top: 2%;
                padding : 5px 5%;
                background-color: silver;
                border-radius: 5px;
            }
            .checkout a{
                 text-decoration: none;
                 color: black;
                 font-weight: bold;
            }
            
        </style>
    </head>
    <body>
        <h1>Total Prices: $<%=total%> </h1>
        <table >
            <thead
                <tr>
                    <th>Name</th>
                    <th>Status</th>
                    <th>Price</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (cart_list != null) {
                        for (Cart item : cart_list){%>
                <tr>
                    <td><%=item.getProductName()%></td>
                    <td><%=item.getStatus()%></td>
                    <td><%=item.getPrice()%></td>
                    <td><a href="remove-item?id=<%=item.getId()%>"><button>Remove</button></td>
                </tr>
            </tbody>
            <% }
                }
            %>
        </table>
        <%
            if(cart_list != null && cart_list.size() != 0){
                out.println("<button class='checkout'><a href='checkout.jsp'>Check out</button>");
            }
        %>
    </body>
</html>
