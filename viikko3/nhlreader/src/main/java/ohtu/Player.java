
package ohtu;

public class Player implements Comparable<Player>{
    private String name;
    private String nationality;
    private String team;
    private int goals;
    private int assists;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoals() {
        return goals;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getAssists() {
        return assists;
    }

    @Override
    public String toString() {
        String s = name;
        for (int i = 0; i < 21 - name.length(); i++) s += " ";
        s += team + "  " + Integer.toString(goals);
        for (int i = 0; i < 3 - Integer.toString(goals).length(); i++) s += " ";
        s += "+";
        for (int i = 0; i < 3 - Integer.toString(assists).length(); i++) s += " ";
        s += Integer.toString(assists) + " = " + Integer.toString(goals+assists);
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.goals != other.goals) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Player p) {
        return p.goals + p.assists - (goals+assists);
    }
      
}
