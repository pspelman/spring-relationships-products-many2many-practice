<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>

    <title>All Products</title>
</head>
<body>

${search_errors}
<div class="container">
    <t:generic_navbar>
            <jsp:attribute name="top_nav">
            </jsp:attribute>
    </t:generic_navbar>
    <br/>
    <div class="body_content">

        <h3>SINGLE PRODUCT
            AND ASSOCIATED CATEGORIES
        </h3>
        <br/>
        <div class="associatedItemsList">
            <h4>${product.name} is in these categories:</h4>
            <c:forEach var="categoryProduct" items="${product.getCategoriesProducts()}" varStatus="loop">
                <%--${category.getName()}<br/>--%>
                <a href="/categories/view/${categoryProduct.getCategory().getId()}">${categoryProduct.getCategory().name}</a><br/>

            </c:forEach>
        </div>

        <div class="addAssociatedItemForm">
            <h4>Unassigned categories</h4>
            <c:forEach var="category" items="${categories}" varStatus="loop">
                <%--${category.getName()}<br/>--%>
                <%--<a href="/categories/view/${category.id}">${category.name}</a><br/>--%>
                Assign to: <a href="/categories/add_product_to_category/${product.id}/${category.id}">${category.name}</a><br/>
            </c:forEach>

        </div>



    </div>


    <%--<div class="allProductsList">--%>
        <%--&lt;%&ndash;${loop.index+1}. ${song} <br/>&ndash;%&gt;--%>


        <%--<table class="table table-bordered">--%>
            <%--<thead>--%>
            <%--<tr>--%>
                <%--<th scope="col">--%>
                    <%--#--%>
                <%--</th>--%>
                <%--<th scope="col">--%>
                    <%--Name--%>
                <%--</th>--%>
            <%--</tr>--%>
            <%--</thead>--%>
            <%--<tbody>--%>
            <%--&lt;%&ndash;for loop can go here, or in the tr tag &ndash;%&gt;--%>
            <%--<c:forEach var="category" items="${categories}" varStatus="loop" >--%>
                <%--<tr>--%>
                    <%--<th scope="row">--%>
                            <%--${loop.index+1}--%>
                    <%--</th>--%>
                    <%--<td>--%>
                            <%--&lt;%&ndash;${product.name}&ndash;%&gt;--%>
                    <%--</td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
            <%--</tbody>--%>
        <%--</table>--%>

    <%--</div>--%>






</div>

</body>
</html>
