package ua.lubkov.game.xo;


import ua.lubkov.game.xo.model.Field;
import ua.lubkov.game.xo.model.Figure;
import ua.lubkov.game.xo.model.Game;
import ua.lubkov.game.xo.model.Player;
import ua.lubkov.game.xo.view.ConsoleView;

public class XOCLI {

    private static final int PLAYER_COUNT = 2;

    public static void main(final String[] arg) {

        final String name1 = "Сергей";
        final String name2 = "Вероника";

        final Player[] players = new Player[PLAYER_COUNT];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        Game game = new Game(players, new Field(3), "X&O");

        ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);

        while (consoleView.step(game)) {
            consoleView.show(game);
        }
    }
}
