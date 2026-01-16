package TrilersRobertRoyo;

public class LogigaPrincipal {

    public static void comprobarAcierto() {

        Tazones.revelarPremio();
        if (Players.getPlayerSelection(Players.playingPlayer) == Tazones.tazonPremiado){
            Players.setPlayerPoints(Players.playingPlayer, Players.getPlayerPoints(Players.playingPlayer) + 1);
            Players.setPlayerSelection(Players.playingPlayer, 0);
        }
        Players.playingPlayer = 3 - Players.playingPlayer;

        GraphicalInterface.playingPlayer.setText("Turno de: " + Players.getPlayerName(Players.playingPlayer));
        GraphicalInterface.pointsP1.setText("Puntos: " + Players.getPlayerPoints(1));
        GraphicalInterface.pointsP2.setText("Puntos: " + Players.getPlayerPoints(2));

        if (Players.getPlayerPoints(1) == 5) {
            GraphicalInterface.win(Players.getPlayerName(1), Players.getPlayerPoints(1));
            GraphicalInterface.it.dispose();
        } else if (Players.getPlayerPoints(2) == 5) {
            GraphicalInterface.win(Players.getPlayerName(2), Players.getPlayerPoints(2));
        }

        Tazones.tazonPremiado = Tazones.mezclar(10);
        Tazones.remover(10);
    }

}
