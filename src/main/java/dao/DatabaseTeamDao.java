package dao;

import model.Player;
import model.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTeamDao implements TeamDao {

    private final Connection conn;
    private String query;



    @Override
    public List<Team> getTeams() throws SQLException {

        List<Team> teams = new ArrayList<>();
        query = "SELECT * FROM Team";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            Team t = new Team(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
            teams.add(t);
        }
        return teams;
    }

    public List<Player> getPlayersFromTeam(Integer id) throws SQLException {

        List<Player> players = new ArrayList<>();
        query = "SELECT * FROM Player WHERE Team = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            Player p = new Player(rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4));

            players.add(p);
        }
        return players;
    }

    public Player addNewPlayer(String name, int age, int team) throws SQLException {

        Player player = null;

        query = "INSERT INTO Player(Player_name, Age, Team) VALUES(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setInt(3, team);

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();

        while(rs.next()) {
            player = new Player(rs.getInt(1), name, age, team);
        }
        return player;
    }

    public DatabaseTeamDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public String getTeamName(Integer id) throws Exception {
        return null;
    }

    @Override
    public String getTeamCountry(Integer id) throws Exception {
        return null;
    }

    @Override
    public String getTeamCoach(Integer id) throws Exception {
        return null;
    }


}
/*
    @Override
    public String getMsg(String lang) throws SQLException {
        Statement statement = conn.createStatement();
        String sql = String.format("SELECT `msg` FROM `hi` WHERE `lang` = '%s'", lang);
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            String msg = resultSet.getString("msg");
            if (resultSet.next()) {
                throw new IllegalStateException();
            }
            return msg;
        }
        throw new IllegalStateException();
    }
    */
