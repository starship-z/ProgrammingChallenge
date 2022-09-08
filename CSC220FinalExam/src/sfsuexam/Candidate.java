/**
 * @author Ana Nytochka
 * 12/15/2020
 * CSC220 Final Project Exam
 * */

package sfsuexam;

public class Candidate implements Comparable<Candidate>{

    private String state;
    private String county;
    private String name;
    private String party;
    private int votes;
    private boolean won;

    public Candidate(String state, String county, String name, String party, int votes, boolean won) {
        this.state = state;
        this.county = county;
        this.name = name;
        this.party = party;
        this.votes = votes;
        this.won = won;
    }

    public String getState() {
        return state;
    }

    public String getCounty() {
        return county;
    }

    public String getName() {
        return name;
    }

    public String getParty() {
        return party;
    }

    public int getVotes() {
        return votes;
    }

    public boolean isWon() {
        return won;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "state='" + state + '\'' +
                ", county='" + county + '\'' +
                ", name='" + name + '\'' +
                ", party='" + party + '\'' +
                ", votes=" + votes +
                ", won=" + won +
                '}';
    }

    @Override
    public int compareTo(Candidate o) {

        return Integer.compare(votes, o.votes);
    }
}
