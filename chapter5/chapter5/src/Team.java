
/** 220601
 * Absolute Java
 * Chapter5 Programming Projects
 * 4. refer to Competition.java
 */
public class Team {

    // Name for the team
    private String teamName;
    // Names for each team members.
    private String name1, name2, name3, name4;
    // Info on each competition
    private Competition competition1, competition2;

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    public void setCompetition1(Competition competition1) {
        this.competition1 = competition1;
    }

    public void setCompetition2(Competition competition2) {
        this.competition2 = competition2;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public String getName3() {
        return name3;
    }

    public String getName4() {
        return name4;
    }

    public Competition getCompetition1() {
        return competition1;
    }

    public Competition getCompetition2() {
        return competition2;
    }

    @Override
    public String toString() {
        return "\n\t" + name1 + ", " + name2 + ", " + name3 + " & " + name4
                + ",\n\tcompetition1: " + competition1
                + ",\n\tcompetition2: " + competition2;
    }

    public Team() {
        competition1 = new Competition();
        competition2 = new Competition();
    }

    public Team(String teamName) {
        this.teamName = teamName;
        competition1 = new Competition();
        competition2 = new Competition();
    }

    public Team(String teamName, String name1, String name2,
            String name3, String name4, String competitionName1,
            String competitionName2) {
        this.teamName = teamName;
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.name4 = name4;
        this.competition1 = new Competition(competitionName1);
        this.competition2 = new Competition(competitionName2);
    }

    // Deep copy constructor
    public Team(Team obj) {
        if (obj == null) {
            System.out.println("Fatal Error.");
            System.exit(0);
        }
        this.teamName = obj.teamName;
        this.name1 = obj.name1;
        this.name2 = obj.name2;
        this.name3 = obj.name3;
        this.name4 = obj.name4;
        this.competition1 = new Competition(obj.competition1);
        this.competition2 = new Competition(obj.competition2);
    }

    public static void main(String[] args) {
        Team copied = new Team("Target");
        System.out.println("copied: " + copied);

        Team origin = new Team("Champion", "Rick Stoner", "Nick Fury", "Timothy Dugan",
                "G. W. Bridge", "Summer", "Spring");
        System.out.println("The origin : " + origin);
        origin.competition1.setCompetition("Summer", "The First", "The Second", 2020);
        origin.competition2.setCompetition("Spring", "The Winner", "The First", 2021);

        System.out.println("\nAfter deep copied... and changed new Competitions info.");
        copied = new Team(origin); //deep copy
        copied.competition1.setYear(2022);
        copied.competition1.setWinningTeam(null);
        copied.competition1.setRunnerUp(null);
        copied.competition2.setYear(2023);
        copied.competition2.setWinningTeam(null);
        copied.competition2.setRunnerUp(null);
        //t.setCompetition1(new Competition("Dragon"));
        //t.setCompetition2(new Competition("Phonex"));
        System.out.println("\nThe origin : " + origin);
        System.out.println("\nThe copy   : " + copied);
    }
}

/* Sample dialogue
run:
copied: 
	null, null, null & null,
	competition1: null, winningTeam: null, runnerUp: null in year 0.,
	competition2: null, winningTeam: null, runnerUp: null in year 0.
The origin : 
	Rick Stoner, Nick Fury, Timothy Dugan & G. W. Bridge,
	competition1: Summer, winningTeam: null, runnerUp: null in year 0.,
	competition2: Spring, winningTeam: null, runnerUp: null in year 0.

After deep copied... and changed new Competitions info.

The origin : 
	Rick Stoner, Nick Fury, Timothy Dugan & G. W. Bridge,
	competition1: Summer, winningTeam: The First, runnerUp: The Second in year 2020.,
	competition2: Spring, winningTeam: The Winner, runnerUp: The First in year 2021.

The copy   : 
	Rick Stoner, Nick Fury, Timothy Dugan & G. W. Bridge,
	competition1: Summer, winningTeam: null, runnerUp: null in year 2022.,
	competition2: Spring, winningTeam: null, runnerUp: null in year 2023.
BUILD SUCCESSFUL (total time: 0 seconds)
 */
