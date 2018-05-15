<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="top_nav" fragment="true" %>
<%@attribute name="page_header" fragment="true" %>

<HTML>

<body>
<div class="top_nav">
    <jsp:invoke fragment="top_nav" />
    <button name="dojo_list" class="btn-inverse" value="Product List" onclick="location.href='/products/all';">All Products</button>
    <%--<button name="ninja_list" class="btn-inverse" value="All Ninjas" onclick="location.href='/ninjas/all';">All Ninjas</button>--%>
    <button name="new_person" class="btn-inverse" value="New Product" onclick="location.href='/products/new';">New Product</button>
    <button name="new_person" class="btn-inverse" value="New Category" onclick="location.href='/categories/new';">New Category</button>
</div>
</body>
</HTML>