<%@page import="BusinessObject.Cart"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@page import="BusinessObject.Product"%>
<%@page import="BusinessObject.ProductList"%>
<!DOCTYPE html>
<!--
Benevolence Ed-Malik
Pradsley D'Haiti
-->
<%
    String status = "";
    List<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
%>
<html lang="en">
    <head>
        <title>Pizza Palace | Delivery & CarryOut | Home To Original & Tasty Pizza</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="main.css">
        <link rel="icon" type="image/png" sizes="32x32" href="logo.png">
    </head>
    <style>
        .add-to-cart, .buy-now{
            padding: 5px 40px; ; margin-left: 1%;
            border-radius: 3px;
        }
        .add-to-cart{
            background-color: black;
            color: white;
        }
        #search{
            padding-bottom: 10px;
        }
        input.search{
            width: 500px;
        }
        input{
            padding: 10px 40px;
        }
    </style>
    <body>
        <!-- This line of code loop through every files inside of the images folder and add the image name and extension inside an arraylist call images -->
        <!-- the getProductImage  method copy all the values of the images variable and add them inside the product object -->
        <%
            ProductList products = new ProductList();
            List<Product> prods = (List<Product>)session.getAttribute("products");
            

            File folder = new File("C:\\Users\\pach3\\OneDrive\\Personal\\OneNote\\Documents\\NetBeansProjects\\PizzaStore\\web\\images");
            File[] listOfFiles = folder.listFiles();
            List images = new ArrayList<String>();

            for (File file : listOfFiles) {
                try {
                    BufferedImage image = ImageIO.read(file);
                    images.add(file.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Product proor = new Product();
            List<String> all = proor.getProductImage(images);

            if (cart_list != null) {
                for (int i = 0; i < cart_list.size(); i++) {
                    prods.get(i).setStatus(cart_list.get(i).getStatus());
                }
            }
        %>
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
                <a href="cart.jsp" class="promos" style="margin-left: 40px;">Cart</a>

                <a href="" class="account">Sign in to earn rewards</a>
            </nav>
        </header>
        <main>
            <section class="start">
                <p class="start-1">Start here</p>
                <p class="start-2"><a href="">Delivery</a></p>
                <p class="start-0">or</p>
                <p class="start-3"><a href="">Carryout</a></p>
            </section>

            <section class="new">
                <h2 class="new-1">Newest menu addition</h2>
                <a href="" class="new-1-1">
                    <img src="images/3-pizza-8.png" alt="pizza"/>
                </a>
                <p class="new-2">Enjoy your favorite Hawaiian Supreme with 50% more Cheese, 
                    50% more ham and 50% more pineapple.</p>
            </section>

            <h2 class="popular-1" style="margin-bottom: 0.5em;">Search Result </h2>
            <div id="search">
                <form  action="search-pizza" method="post">
                    <input class="search" type="text" name="searchItem" placeholder ="Search a pizza ">
                    <input type="submit" value="search">
                </form>
            </div>
            <section class="" style="display: grid;  grid-template-columns: auto auto auto; width: 100%; grid-template-rows: auto auto auto;"> 
                <%  if (!prods.isEmpty()) {

                        int i = 0;
                        for (Product p : prods) {%>
                <div class="" >
                    <a href="" class="">
                        <img src="images/<%=all.get(i++)%>" alt="pizza"/>
                    </a>
                    <p class="" style="text-align: center"><%= p.getProductName()%> </p>
                    <div style="margin-bottom: 5%;padding-top: 3%;" >
                        <a href="add-to-cart?id=<%=p.getId()%>">
                            <%
                                String buttons = p.getStatus().equals("READY") ? "<button class='add-to-cart'>Item added.</button>" : "<button class='add-to-cart'>Add to cart</button>";
                                out.println(buttons);
                                status = p.getStatus();
                            %>
                        </a>
                        <button class="buy-now">Buy now</button>
                    </div>

                </div>
                <%}
                    }
                %>  
            </section>
        </main>
        <br>
        <footer>
            Copyright &copy; 2023
            Coded by <a href="https://github.com/BenevolenceEM"><i>Benevolence Ed-Malik</i></a> 
            and <a href=""><i>Pradsley D'Haiti</i></a>.
        </footer>

    </body>
</html>
