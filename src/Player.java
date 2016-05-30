/**
 * Created by Bart on 30-5-2016.
 */
public class Player {
    public int playerId = -1;
    private int healthpoints;

    public Player(int playerId) {
        this.playerId = playerId;
        this.healthpoints = 10;
    }

    public int removeHealth() {
        healthpoints--;
        return healthpoints;
    }

    public void resetHealth() {
        healthpoints = 10;
    }

    public int getHealthpoints(){
        return healthpoints;
    }
}
