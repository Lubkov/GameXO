package ua.lubkov.game.xo.controllers;

import org.junit.Test;
import ua.lubkov.game.xo.FieldBilder;
import ua.lubkov.game.xo.model.Field;
import ua.lubkov.game.xo.model.Figure;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void getWinnerHorizontalTest() throws Exception {
        final Field field = new FieldBilder().getFieldHorizontalWinX();
        final WinnerController win = new WinnerController();
        final Figure expectedValue = Figure.X;
        final Figure actualValue = win.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWinnerVericalTest() throws Exception {
        final Field field = new FieldBilder().getFieldVerticalWinO();
        final WinnerController win = new WinnerController();
        final Figure expectedValue = Figure.O;
        final Figure actualValue = win.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWinnerFirstDiagonalTest() throws Exception {
        final Field field = new FieldBilder().getFieldFirstDiagonalWinX();
        final WinnerController win = new WinnerController();
        final Figure expectedValue = Figure.X;
        final Figure actualValue = win.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWinnerSecondDiagonalTest() throws Exception {
        final Field field = new FieldBilder().getFieldSecondDiagonalWinO();
        final WinnerController win = new WinnerController();
        final Figure expectedValue = Figure.O;
        final Figure actualValue = win.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWinnerNoWinTest() throws Exception {
        final Field field = new FieldBilder().getFieldDoNotHaveWin();
        final WinnerController win = new WinnerController();
        final Figure expectedValue = null;
        final Figure actualValue = win.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

}