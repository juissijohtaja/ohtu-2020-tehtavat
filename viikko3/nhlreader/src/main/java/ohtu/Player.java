
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String team;
    private String nationality;
    private int goals;
    private int assists;
    
    private int points;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }
    
    public int getPoints() {        
        return goals + assists;
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(o.getPoints(), this.getPoints());
    }
    
    @Override
    public String toString() {
        int total = Integer.valueOf(goals) + Integer.valueOf(assists);
        String format = "%-25s %s\t%-2d + %-2d = %d";
        return String.format(format, name, team, goals, assists, getPoints());
    }
      
}
