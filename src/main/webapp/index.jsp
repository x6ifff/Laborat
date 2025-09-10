<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <title>Управление персоналом</title>
</head>
<body>
    <div class="container-fluid">
        <jsp:include page="/views/header.jsp" />
        <div class="container">
            <br><br><br>
            <div class="list-group text-center py-3 px-3">
                <h2>Функции системы</h2>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item list-group-item-primary"><a href="${pageContext.request.contextPath}/person">Сотрудники</a></li>
                    </li>
                    <li class="list-group-item list-group-item-info"><a href="${pageContext.request.contextPath}/role">Должности</a></li>
                    </li>
                </ul>
            </div>
            <br><br>
        </div>
        <jsp:include page="/views/footer.jsp" />
    </div>
    
    <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>
</html>