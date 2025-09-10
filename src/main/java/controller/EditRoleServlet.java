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

@WebServlet("/editrole")
public class EditRoleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ConnectionProperty prop;

    public EditRoleServlet() {
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
        Role editrole = null;
        RoleDbDAO dao = new RoleDbDAO();

        try {
            roles = dao.findAll();
            request.setAttribute("roles", roles);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        String strId = request.getParameter("id");
        Long id = null;
        if (strId != null) {
            id = Long.parseLong(strId);
        }

        try {
            editrole = dao.findById(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        request.setAttribute("roleEdit", editrole);
        userPath = request.getServletPath();
        if ("/editrole".equals(userPath)) {
            request.getRequestDispatcher("/editrole.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RoleDbDAO dao = new RoleDbDAO();
        String strId = request.getParameter("id");
        Long id = null;
        if (strId != null) {
            id = Long.parseLong(strId);
        }
        String namerole = request.getParameter("inputRole");
        Role editrole = new Role(id, namerole);
        try {
            dao.update(editrole);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/role");
    }
}