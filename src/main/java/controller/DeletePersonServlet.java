package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import dao.ConnectionProperty;
import dao.PersonDbDAO;
import dao.DAOException;

@WebServlet("/deleteperson")
public class DeletePersonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ConnectionProperty prop;

    public DeletePersonServlet() {
        super();
        prop = new ConnectionProperty();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonDbDAO dao = new PersonDbDAO();
        String strId = request.getParameter("id");
        Long deleted = null;
        if (strId != null) {
            deleted = Long.parseLong(strId);
        }

        try {
            dao.delete(deleted);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/person");
    }
}