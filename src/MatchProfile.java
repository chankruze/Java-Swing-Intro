class MatchProfile {

    private int id;
    private String desc, team1, team2, state, status;

    public MatchProfile(int id, String desc, String team1, String team2, String state) {
        this.id = id;
        this.desc = desc;
        this.team1 = team1;
        this.team2 = team2;
        this.state = state;
        this.status = "No idea !";
    }

    public MatchProfile(int id, String desc, String team1, String team2, String state, String status) {
        this.id = id;
        this.desc = desc;
        this.team1 = team1;
        this.team2 = team2;
        this.state = state;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getState() {
        return state;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
