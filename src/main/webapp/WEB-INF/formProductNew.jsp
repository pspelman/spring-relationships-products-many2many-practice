<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <%--<link rel="stylesheet" href="../../resources/static/css/style.css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
    <title>New Product Form</title>
</head>
<body>
<div class="container">
    <t:generic_navbar>
            <jsp:attribute name="top_nav">
            </jsp:attribute>
    </t:generic_navbar>

    <div class="foreground">
        <form:form method="POST" action="/products/new" modelAttribute="product" cssClass="user_form">


            <%--<form:label path="product">Product category</form:label>--%>
            <%--<form:select path="category" items="${categories}" itemLabel="name" ></form:select>--%>
            <%--<br/>--%>

            <form:label path="name">Product Name</form:label>
            <form:input path="name" /><br/>
            <form:errors path="name" cssClass="alert-danger" />

            <form:label path="description">Description</form:label>
            <form:input path="description" /><br/>
            <form:errors path="description" cssClass="alert-danger" />

            <form:label path="price">Price ($)</form:label>
            <form:input path="price" /><br/>
            <form:errors path="price" cssClass="alert-danger" />
            <br/>

            <input type="submit" value="create">

        </form:form>
    </div>
</div>

</body>
</html>
