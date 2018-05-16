SINGLE CATEGORY
AND ASSOCIATED PRODUCTS


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>

    <title>Category and Associated Products</title>
</head>
<body>

${search_errors}
<div class="container">
    <t:generic_navbar>
            <jsp:attribute name="top_nav">
            </jsp:attribute>
    </t:generic_navbar>
    <br/>
    <h3>SINGLE CATEGORY
        AND ASSOCIATED PRODUCTS
    </h3>
    <div class="associatedItemsList">
        <h4>${category.name} is associated with the following products:</h4>
        <c:forEach var="categoryProduct" items="${category.getCategoriesProducts()}" varStatus="loop">
            <%--${category.getName()}<br/>--%>
            <a href="/categories/view/${categoryProduct.getProduct().getId()}">${categoryProduct.getProduct().name}</a><br/>

        </c:forEach>
    </div>

    <div class="addAssociatedItemForm">
        <h4>Unassigned products</h4>
        <c:forEach var="product" items="${products}" varStatus="loop">
            <%--${category.getName()}<br/>--%>
            <form:form name="add_product_to_category_form" method="POST" action="/categories/add_product_to_category">
                <form:hidden path="category" />
            </form:form>
            <a href="/categories/add_product_to_category/${product.id}/${category.id}">${product.name}</a><br/>
        </c:forEach>

    </div>

</div>

</body>
</html>

<div class="associatedItemsList">
    <h4>Category List</h4>
</div>

<div class="addAssociatedItemForm">
    <h4>Unassigned categories</h4>

</div>
<br/>
FORM with dropdown of unassigned PRODUCTS
<h2>
    ${category.name}
</h2>
<br/>
