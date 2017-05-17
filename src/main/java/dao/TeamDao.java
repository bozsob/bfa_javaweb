package dao;

import model.Team;

import javax.lang.model.util.ElementScanner6;
import java.util.List;

public interface TeamDao {

    String getTeamName(Integer id) throws Exception;
    String getTeamCountry(Integer id) throws Exception;
    String getTeamCoach(Integer id) throws Exception;
    List<Team> getTeams() throws Exception;

}
