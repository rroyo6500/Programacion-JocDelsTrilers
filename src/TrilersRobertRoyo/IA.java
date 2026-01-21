package TrilersRobertRoyo;

import java.util.Random;

public class IA {

    public static int iaPlayer = 0;

    public static void setIA (int player) {
        iaPlayer = player;
        Players.setPlayerName(iaPlayer, "IA");
    }

    public static void seleccionar () {
        if (Players.playingPlayer != iaPlayer) return;

        int selection = new Random().nextInt(3)+1;

        Players.setPlayerSelection(iaPlayer, selection);
        LogigaPrincipal.comprobarAcierto();

    }

}
