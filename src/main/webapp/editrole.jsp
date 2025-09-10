<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.Role" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Редактирование должности</title>
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
                <div class="col-6 border bg-light px-4">
                    <h3>Список должностей</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Код</th>
                                <th scope="col">Должность</th>
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
                                </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                </div>
                <div class="col-6 border px-4">
                    <form method="POST" action="" accept-charset="UTF-8">
                        <h3>Редактировать должность</h3>
                        <br><br>
                        <div class="mb-3 row">
                            <label for="idrole" class="col-sm-3 col-form-label">Код должности</label>
                            <div class="col-sm-6">
                                <%
                                    Role roleEdit = (Role) request.getAttribute("roleEdit");
                                    Long roleId = roleEdit != null ? roleEdit.getId() : null;
                                %>
                                <input type="text" class="form-control" readonly value="<%=roleId != null ? roleId : 0%>"/>
                                <input type="hidden" name="id" value="<%=roleId != null ? roleId : 0%>" />
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <br>
                            <label for="inputRole" class="col-sm-3 col-form-label">Должность</label>
                            <div class="col-sm-6">
                                <input type="text" name="inputRole" class="form-control" value="<%=roleEdit != null ? roleEdit.getNamerole() : ""%>" id="personRole" required>
                            </div>
                        </div>
                        <p>
                            <br><br><br>
                            <button type="submit" class="btn btn-primary">Редактировать</button>
                            <a href='<%=request.getContextPath()%>/role' role="button" class="btn btn-secondary">Отменить</a>
                            <br>
                        </p>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="/views/footer.jsp" />
    </div>
</body>
</html>