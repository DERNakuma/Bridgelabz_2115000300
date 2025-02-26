// IPL Match Class
import java.util.Map;
public class IPLMatch {
    public int match_id;
    public String team1;
    public String team2;
    public Map<String, Integer> score;
    public String winner;
    public String player_of_match;

    public IPLMatch() {} 

    public IPLMatch(int match_id, String team1, String team2, Map<String, Integer> score, String winner, String player_of_match) {
        this.match_id = match_id;
        this.team1 = team1;
        this.team2 = team2;
        this.score = score;
        this.winner = winner;
        this.player_of_match = player_of_match;
    }
}
