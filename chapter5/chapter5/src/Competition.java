
/** 220601
 * Absolute Java
 * Chapter5 Programming Projects
 * for Team.java
 * 4. You are interested in keeping track of the team members and competition
 * information for your school’s annual entries in computer science programming
 * competitions. Each team consists of exactly four team members. Every year
 * your team competes in two competitions. As an initial start for your database,
 * create a class named Team that has the following instance variables:
 *  `// Name for the team
 *  String teamName;
 *  // Names for each team members.
 *  String name1, name2, name3, name4;
 *  // Info on each competition
 *  Competition competition1, competition2;`
 * Note that there is a much better way to represent the team members and
 * competitions using arrays; this is covered in a subsequent chapter. The class
 * should also have a method that outputs the names of all team members and the
 * competition information to the console.
 * The Competition class contains variables to track the following:
 * String: Name of the competition, Name of the winning team, Name of the
 * runner-up Integer: Year of the competition
 * Implement the Team and Competition classes with appropriate constructor,
 * accessor, and mutator methods. In entering data for past competitions, you
 * note that an entry is usually very similar to the previous year’s entry. To
 * help with the data entry, create a deep copy constructor for the Team class.
 * Test your copy constructor by creating a copy of an existing team object,
 * changing the competition information for the copy, and outputting the data
 * for the original and the copy. The original object should be unchanged if
 * your deep copy constructor is working properly.
 */
public class Competition {

    //String: Name of the competition, 
    private String competitionName;
    // Name of the winning team, 
    private String winningTeam;
    // Name of the runner-up 
    private String runnerUp;
    // Integer: Year of the competition
    private int year;

    @Override
    public String toString() {
        return competitionName + ", winningTeam: " + winningTeam
                + ", runnerUp: " + runnerUp + " in year " + year + '.';
    }

    public Competition() {
    }

    public Competition(String competitionName) {
        this.competitionName = competitionName;
    }

    public Competition(Competition obj) {
        if (obj == null) {
            System.out.println("Fatal Error.");
            System.exit(0);
        }
        this.competitionName = obj.competitionName;
        this.winningTeam = obj.winningTeam;
        this.runnerUp = obj.runnerUp;
        this.year = obj.year;
    }

    public void setCompetition(String competitionName, String winningTeam,
            String runnerUp, int year) {
        this.competitionName = competitionName;
        this.winningTeam = winningTeam;
        this.runnerUp = runnerUp;
        this.setYear(year);
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public void setWinningTeam(String winningTeam) {
        this.winningTeam = winningTeam;
    }

    public void setRunnerUp(String runnerUp) {
        this.runnerUp = runnerUp;
    }

    public void setYear(int year) {
        if ((year < 1000) || (year > 9999)) {
            System.out.println("Fatal Error");
            System.exit(0);
        } else {
            this.year = year;
        }
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    public String getRunnerUp() {
        return runnerUp;
    }

    public int getYear() {
        return year;
    }

}
