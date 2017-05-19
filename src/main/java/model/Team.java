package model;

/**
 * Created by trixi on 2017.05.16..
 */
public class Team {

    private int teamId;
    private String teamName;
    private String teamCountry;
    private String teamCoach;

    public Team(int teamId, String teamName, String teamCountry, String teamCoach) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamCountry = teamCountry;
        this.teamCoach = teamCoach;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCountry() {
        return teamCountry;
    }

    public void setTeamCountry(String teamCountry) {
        this.teamCountry = teamCountry;
    }

    public String getTeamCoach() {
        return teamCoach;
    }

    public void setTeamCoach(String teamCoach) {
        this.teamCoach = teamCoach;
    }
}
