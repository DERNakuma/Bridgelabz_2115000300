// Read & Censor JSON Data

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.List;
import java.util.Map;

public class IPLJsonProcessor {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            List<IPLMatch> matches = objectMapper.readValue(new File("ipl_data.json"), new TypeReference<List<IPLMatch>>() {});
            for (IPLMatch match : matches) {
                match.team1 = censorTeamName(match.team1);
                match.team2 = censorTeamName(match.team2);
                match.winner = censorTeamName(match.winner);
                match.player_of_match = "REDACTED";
            }

            objectMapper.writeValue(new File("ipl_censored.json"), matches);
            System.out.println("Censored JSON file generated: ipl_censored.json");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String censorTeamName(String teamName) {
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            return words[0] + " ***";
        }
        return teamName; 
    }
}
