import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.*;

class LiveMatch {

    private static final String LIVE_URL = "http://mapps.cricbuzz.com/cbzios/match/livematches";
    private ArrayList<MatchProfile> matchProfiles;

    LiveMatch() {
        try {
            this.matchProfiles = createProfiles(fetchMatches());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String fetchMatches() throws IOException {
        URL url = new URL(LIVE_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();

        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String output = "", currLine;
            while ((currLine = bufferedReader.readLine()) != null) {
                output += currLine;
            }

            return output;
        } else {
            return null;
        }
    }

    private ArrayList<MatchProfile> createProfiles(String data) {
        ArrayList<MatchProfile> liveMatches = new ArrayList<MatchProfile>();

        JSONObject jsonObject = new JSONObject(data);
        JSONArray matches = jsonObject.getJSONArray("matches");

        for(int i = 0; i < matches.length(); i++) {
            JSONObject match = matches.getJSONObject(i);
            JSONObject header = match.getJSONObject("header");
            JSONObject teamOne = match.getJSONObject("team1");
            JSONObject teamTwo = match.getJSONObject("team2");
            int id = match.getInt("match_id");
            String desc = header.getString("match_desc");
            String state = header.getString("state");
            String status = header.getString("status");
            String team1 = teamOne.getString("name");
            String team2 = teamTwo.getString("name");

            MatchProfile matchProfile = new MatchProfile(id, desc, team1, team2, state, status);
            liveMatches.add(matchProfile);
        }

        return liveMatches;
    }
}
