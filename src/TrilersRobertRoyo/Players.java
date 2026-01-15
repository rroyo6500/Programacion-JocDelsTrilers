package TrilersRobertRoyo;

public class Players {

    public static int playerCount = 2;

    public static String[] playerNames = new String[2];
    public static int[] playerPoints = new int[2];
    public static int[] playerSelection = new int[2];
    public static int playingPlayer = 1;

    public static String getPlayerName(int player){
        return playerNames[player-1];
    }
    public static int getPlayerPoints(int player){
        return playerPoints[player-1];
    }
    public static int getPlayerSelection(int player){
        return playerSelection[player-1];
    }

    public static void setPlayerName(int player, String name) {
        playerNames[player-1] = name;
    }
    public static void setPlayerPoints(int player, int points) {
        playerPoints[player-1] = points;
    }
    public static void setPlayerSelection(int player, int selection) {
        playerSelection[player-1] = selection;
    }

}
