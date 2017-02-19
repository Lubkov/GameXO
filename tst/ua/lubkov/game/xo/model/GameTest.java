package ua.lubkov.game.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;


public class GameTest {

    @Test
    public void getPlayer() throws Exception {
        final Field field = new Field(3);
        final Player fistPlayer = new Player("First player", Figure.X);
        final Player secondPlayer = new Player("Second player", Figure.O);
        final Player[] players = {fistPlayer, secondPlayer};
        final String gameName = "Game name";
        final Game game = new Game(players, field, gameName);

        assertEquals(secondPlayer, game.getPlayer(secondPlayer.getFigure()));
    }

}