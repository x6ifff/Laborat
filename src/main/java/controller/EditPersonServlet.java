package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import dao.ConnectionProperty;
import dao.PersonDbDAO;
import dao.RoleDbDAO;
import domain.Person;
import domain.Role;
import dao.DAOException;

@WebServlet("/editperson")
public class EditPersonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ConnectionProperty prop;

    public EditPersonServlet() {
        super();
        prop = new ConnectionProperty();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userPath;
        List<Role> roles;
        List<Person> persons = null;
        Person editperson = null;
        RoleDbDAO daoRole = new RoleDbDAO();
        PersonDbDAO dao = new PersonDbDAO();

        try {
            roles = daoRole.findAll();
            request.setAttribute("roles", roles);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        try {
            persons = dao.findAll();
            for (Person person : persons) {
                Role role = daoRole.findById(person.getIdRole());
                person.setRole(role);
            }
            request.setAttribute("persons", persons);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        String strId = request.getParameter("id");
        Long id = null;
        if (strId != null) {
            id = Long.parseLong(strId);
        }

        try {
            editperson = dao.findById(id);
            Role role = daoRole.findById(editperson.getIdRole());
            editperson.setRole(role);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        request.setAttribute("personEdit", editperson);
        userPath = request.getServletPath();
        if ("/editperson".equals(userPath)) {
            request.getRequestDispatcher("/editperson.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        PersonDbDAO dao = new PersonDbDAO();
        String strId = request.getParameter("id");
        Long id = null;
        if (strId != null) {
            id = Long.parseLong(strId);
        }
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String roleIdStr = request.getParameter("role");

        Long idRole = null;
        if (roleIdStr != null && !roleIdStr.isEmpty()) {
            idRole = Long.parseLong(roleIdStr);
        }

        Person editPerson = new Person(id, firstName, lastName, phone, email, idRole, null);
        try {
            dao.update(editPerson);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/person");
    }
}