import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class Main {

    static Map<Integer, Player> players = new HashMap<>();


    public static void main(String[] args) {

        createPlayers();

        post("/healthpoints/:id", (req, res) -> {
            int playerId = Integer.parseInt(req.params(":id"));

            if (keyExists(playerId)) {
                Player pl = players.get(playerId);
                pl.removeHealth();
            }
            return "Done";
        });

        get("/healthpoints", (req, res) -> {
            String values = "";
            for (Player key : players.values()) {
                values += "\n" + key.playerId + ": " + key.getHealthpoints();
            }
            return values;
        });


        post("/newgame", (req, res) -> {
             players.clear();
             createPlayers();
             String values = "";
             for (Player key : players.values()) {
                 values += "\n" + key.playerId + ": " + key.getHealthpoints();
             }
             return values;
           }
        );
    }


    public static void createPlayers() {
        for (int i = 0; i < 3; i++) {
            players.put(i + 1, new Player(i + 1));
        }
    }

    private static boolean keyExists(int id) {
        Player value = players.get(id);
        if (value != null) {
            return true;
        }
        return false;
    }
}
