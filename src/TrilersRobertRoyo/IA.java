package TrilersRobertRoyo;

import java.util.Random;

public class IA {

    public static void setIA () {
        Players.setPlayerName(2, "IA");
    }

    public static void seleccionar () {
        if (Players.playingPlayer != 2) return;

        int selection = new Random().nextInt(3)+1;

        Players.setPlayerSelection(2, selection);
        LogigaPrincipal.comprobarAcierto();

    }

}
