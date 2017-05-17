package servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import dao.DatabaseTeamDao;
import dao.TeamDao;
import model.Team;
import util.ConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/teams")
public class TeamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        resp.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();

        try (Connection conn = ConnectionUtil.getConnection(ConnectionUtil.DatabaseName.BFA)) {
            DatabaseTeamDao dao = new DatabaseTeamDao(conn);
            List<Team> teams = dao.getTeams();

            objectMapper.writeValue(resp.getOutputStream(), teams);
        }
        catch (SQLException e) {
            resp.sendError(500, "Error during connection to database");
            e.printStackTrace();
        }

    }

    /*
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lang = req.getParameter("lang");

        try (Connection conn = ConnectionUtil.getConnection(ConnectionUtil.DatabaseName.BFA)) {
            TeamDao dao = new DatabaseTeamDao(conn);
            String msg = dao.getMsg(lang);
            req.setAttribute("msg", String.format(msg, name));
        } catch (Exception e) {
            throw new ServletException(e);
        }

        req.getRequestDispatcher("name.jsp").forward(req, resp);
    }
    */
}
