package TrilersRobertRoyo;

public class LogigaPrincipal {

    public static void comprobarAcierto() {

        new Thread(Tazones::revelarPremio).start();

        if (Players.getPlayerSelection(Players.playingPlayer) == Tazones.tazonPremiado){
            Players.setPlayerPoints(Players.playingPlayer, Players.getPlayerPoints(Players.playingPlayer) + 1);
            Players.setPlayerSelection(Players.playingPlayer, 0);

            if (Players.getPlayerPoints(Players.playingPlayer) == 5) {
                GraphicalInterface.win(
                        Players.getPlayerName(Players.playingPlayer),
                        Players.getPlayerPoints(Players.playingPlayer)
                );
                GraphicalInterface.it.dispose();
            }
        }
        Tazones.tazonPremiado = Tazones.mezclar(10);
        Players.playingPlayer = 3 - Players.playingPlayer;

        GraphicalInterface.playingPlayer.setText("Turno de: " + Players.getPlayerName(Players.playingPlayer));
        GraphicalInterface.pointsP1.setText("Puntos: " + Players.getPlayerPoints(1));
        GraphicalInterface.pointsP2.setText("Puntos: " + Players.getPlayerPoints(2));

        new Thread(() -> Tazones.remover(10)).start();
    }

}
