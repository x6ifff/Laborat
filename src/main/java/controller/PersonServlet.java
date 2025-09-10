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

@WebServlet("/person")
public class PersonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ConnectionProperty prop;

    public PersonServlet() {
        super();
        prop = new ConnectionProperty();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userPath;
        List<Person> persons;
        List<Role> roles;

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

        userPath = request.getServletPath();
        if("/person".equals(userPath)){ 
            request.getRequestDispatcher("/person.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        PersonDbDAO dao = new PersonDbDAO();
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String roleStr = request.getParameter("role");

        Long idRole = null;
        if (roleStr != null && !roleStr.isEmpty()) {
            try {
                idRole = Long.parseLong(roleStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (idRole != null) {
            Person newPerson = new Person();
            newPerson.setFirstName(firstName);
            newPerson.setLastName(lastName);
            newPerson.setEmail(email);
            newPerson.setPhone(phone);
            newPerson.setIdRole(idRole);

            try {
                Long index = dao.insert(newPerson);
                System.out.println("Adding result: " + index);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
        doGet(request, response);
    }
}