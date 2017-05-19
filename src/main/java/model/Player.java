package model;

/**
 * Created by trixi on 2017.05.16..
 */
public class Player {

    private int id;
    private String name;
    private int age;
    private int team;

    public Player(int id, String name, int age, int team) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }
}
