<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.Role" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Должности</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <!-- jQuery (not needed) removed -->
    <!-- Bootstrap JS + Popper JS -->
    <script defer src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container-fluid">
        <jsp:include page="/views/header.jsp" />
        <div class="container-fluid">
            <div class="row justify-content-start">
                <div class="col-8 border bg-light px-4">
                    <h3>Список должностей</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Код</th>
                                <th scope="col">Должность</th>
                                <th scope="col">Редактировать</th>
                                <th scope="col">Удалить</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Role> roles = (List<Role>) request.getAttribute("roles");
                                if (roles != null) {
                                    for (Role role : roles) {
                            %>
                                <tr>
                                    <td><%=role.getId()%></td>
                                    <td><%=role.getNamerole()%></td>
                                    <td width="20">
                                        <a href='<%=request.getContextPath()%>/editrole?id=<%=role.getId()%>' role="button" class="btn btn-outline-primary">
                                            <img alt="Редактировать" src="<%=request.getContextPath()%>/images/edit.png" width="20" height="20">
                                        </a>
                                    </td>
                                    <td width="20">
                                        <a href='<%=request.getContextPath()%>/deleterole?id=<%=role.getId()%>' role="button" class="btn btn-outline-primary" 
                                           onclick="return confirm('Удалить должность с кодом: <%=role.getId()%>?')">
                                            <img alt="Удалить" src="<%=request.getContextPath()%>/images/delete.png" width="20" height="20">
                                        </a>
                                    </td>
                                </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                </div>
                <div class="col-4 border px-4">
                    <form method="POST" action="" accept-charset="UTF-8">
                        <h3>Новая должность</h3>
                        <div class="mb-3">
                            <br>
                            <label for="inputRole" class="col-sm-3 col-form-label">Должность</label>
                            <div class="col-sm-9">
                                <input type="text" name="inputRole" class="form-control" id="personRole" required>
                            </div>
                        </div>
                        <p>
                            <br><br>
                            <button type="submit" class="btn btn-primary">Добавить</button>
                            <br>
                        </p>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="/views/footer.jsp" />
    </div>
</body>
