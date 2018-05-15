<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%--<link rel="stylesheet" href="../../resources/static/css/style.css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>

    <title>Relationships M2M Project</title>
</head>
<body>
<div class="home_container">
    <div class="foreground">
        <h1>${dojo_search_error}</h1>
        <h1>Welcome to the Products and Stuff</h1>
        <br/>
        <button name="all_persons" class="btn-inverse" value="All Persons" onclick="location.href='/products/all';">All Products</button>

        <br/>
        <br/>
        <button name="new_dojo" class="btn-inverse" value="New Product" onclick="location.href='/products/new';">New Product</button>
        <button name="new_category" class="btn-inverse" value="New Category" onclick="location.href='/categories/new';">New Category</button>

        <br/>
        <br/>
        <br/>
        <br/>
        <br/>

    </div>
</div>


</body>
</html>