<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.Role" %>
<%@ page import="domain.Person" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Сотрудники</title>
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
                    <h3>Список сотрудников</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Код</th>
                                <th scope="col">Фамилия</th>
                                <th scope="col">Имя</th>
                                <th scope="col">Должность</th>
                                <th scope="col">Телефон</th>
                                <th scope="col">Эл.почта</th>
                                <th scope="col">Редактировать</th>
                                <th scope="col">Удалить</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Person> persons = (List<Person>) request.getAttribute("persons");
                                if (persons != null) {
                                    for (Person person : persons) {
                            %>
                                <tr>
                                    <td><%=person.getId()%></td>
                                    <td><%=person.getLastName()%></td>
                                    <td><%=person.getFirstName()%></td>
                                    <td><%=person.getRole() != null ? person.getRole().getNamerole() : ""%></td>
                                    <td><%=person.getPhone()%></td>
                                    <td><%=person.getEmail()%></td>
                                    <td width="20">
                                        <a href='<%=request.getContextPath()%>/editperson?id=<%=person.getId()%>' role="button" class="btn btn-outline-primary">
                                            <img alt="Редактировать" src="<%=request.getContextPath()%>/images/edit.png" width="20" height="20">
                                        </a>
                                    </td>
                                    <td width="20">
                                        <a href='<%=request.getContextPath()%>/deleteperson?id=<%=person.getId()%>' role="button" class="btn btn-outline-primary"
                                           onclick="return confirm('Удалить сотрудника с кодом: <%=person.getId()%>?')">
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
                        <h3>Новый сотрудник</h3>
                        <br>
                        <div class="mb-3 row">
                            <label for="lastname" class="col-sm-3 col-form-label">Фамилия</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="staticLastname" name="lastname" required>
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label for="firstname" class="col-sm-3 col-form-label">Имя</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="staticFirstname" name="firstname" required>
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label for="rolename" class="col-sm-3 col-form-label">Должность</label>
                            <div class="col-sm-9">
                                <select name="role" class="form-control" required>
                                    <option value="">Выберите должность</option>
                                    <%
                                        List<Role> roles = (List<Role>) request.getAttribute("roles");
                                        if (roles != null) {
                                            for (Role role : roles) {
                                    %>
                                        <option value="<%=role.getId()%>"><%=role.getNamerole()%></option>
                                    <%
                                            }
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label for="phone" class="col-sm-3 col-form-label">Телефон</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="staticphone" name="phone" required>
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label for="email" class="col-sm-3 col-form-label">Эл.почта</label>
                            <div class="col-sm-9">
                                <input type="email" class="form-control" id="staticemail" name="email" required>
                            </div>
                        </div>
                        <p>
                            <br>
                            <button type="submit" class="btn btn-primary">Добавить</button>
                        </p>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="/views/footer.jsp" />
    </div>
</body>
</html>