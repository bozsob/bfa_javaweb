package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.DatabaseTeamDao;
import model.Player;
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

/**
 * Created by trixi on 2017.05.16..
 */
@WebServlet("/PlayerServlet")
public class PlayerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String name = request.getParameter("name");
        int age = Integer.valueOf(request.getParameter("age"));
        int team = Integer.valueOf(request.getParameter("team"));

        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();

        try (Connection conn = ConnectionUtil.getConnection(ConnectionUtil.DatabaseName.BFA)) {
            DatabaseTeamDao dao = new DatabaseTeamDao(conn);

            Player player = dao.addNewPlayer(name, age, team);


            objectMapper.writeValue(response.getOutputStream(), player);


        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String teamId = req.getParameter("teamId");
        System.out.println("teamId: " + teamId);
        int id = Integer.valueOf(teamId);
        System.out.println(id);

        resp.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();

        try (Connection conn = ConnectionUtil.getConnection(ConnectionUtil.DatabaseName.BFA)) {
            DatabaseTeamDao dao = new DatabaseTeamDao(conn);
            List<Player> players = dao.getPlayersFromTeam(id);

            objectMapper.writeValue(resp.getOutputStream(), players);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
