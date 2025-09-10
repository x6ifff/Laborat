package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import domain.Role;
import dao.DAOException;
import dao.RoleDbDAO;
import dao.ConnectionProperty;

@WebServlet("/role")
public class RoleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    ConnectionProperty prop;

    public RoleServlet() {
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
        RoleDbDAO dao = new RoleDbDAO();

        try {
            roles = dao.findAll();
            request.setAttribute("roles", roles);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        userPath = request.getServletPath();
        if ("/role".equals(userPath)) {
            request.getRequestDispatcher("/role.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RoleDbDAO dao = new RoleDbDAO();
        String name = request.getParameter("inputRole");
        Role newRole = new Role(name);

        try {
            Long index = dao.insert(newRole);
            System.out.println("Adding result: " + index);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        doGet(request, response);
    }
}