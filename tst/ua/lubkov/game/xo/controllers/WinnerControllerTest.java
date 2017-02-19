package ua.lubkov.game.xo.controllers;

import org.junit.Test;
import ua.lubkov.game.xo.model.Field;
import ua.lubkov.game.xo.model.Figure;
import ua.lubkov.game.xo.model.Point;
import ua.lubkov.game.xo.model.exceptions.InvalidPointException;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    private final Figure[][] FIELD_HORIZONTAL_WIN_X =
            {
                    {Figure.O, null, Figure.O},
                    {Figure.X, Figure.X, Figure.X},
                    {null, null, null}
            };

    private final Figure[][] FIELD_VERTICAL_WIN_O =
            {
                    {Figure.X, null, Figure.O},
                    {Figure.X, Figure.X, Figure.O},
                    {null, null, Figure.O}
            };

    private final Figure[][] FIELD_DIAGONAL_WIN_X =
            {
                    {Figure.X, null, Figure.O},
                    {Figure.O, Figure.X, Figure.O},
                    {Figure.X, null, Figure.X}
            };

    private final Figure[][] FIELD_DIAGONAL_WIN_O =
            {
                    {Figure.X, null, Figure.O},
                    {Figure.X, Figure.O, Figure.O},
                    {Figure.O, Figure.X, Figure.X}
            };

    private final Figure[][] FIELD_DIAGONAL_NO_WIN =
            {
                    {Figure.X, null, Figure.O},
                    {Figure.X, null, Figure.O},
                    {Figure.O, Figure.X, Figure.X}
            };

    private Field createField(Figure[][] data) throws InvalidPointException {
        Field field = new Field();

        for (int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                field.setFigure(new Point(x, y), data[x][y]);
            }
        }
        return field;
    }

    @Test
    public void getWinnerHorizontalTest() throws Exception {
        final Field field = createField(FIELD_HORIZONTAL_WIN_X);
        final WinnerController win = new WinnerController();
        final Figure expectedValue = Figure.X;
        final Figure actualValue = win.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWinnerVericalTest() throws Exception {
        final Field field = createField(FIELD_VERTICAL_WIN_O);
        final WinnerController win = new WinnerController();
        final Figure expectedValue = Figure.O;
        final Figure actualValue = win.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWinnerFirstDiagonalTest() throws Exception {
        final Field field = createField(FIELD_DIAGONAL_WIN_X);
        final WinnerController win = new WinnerController();
        final Figure expectedValue = Figure.X;
        final Figure actualValue = win.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWinnerSecondDiagonalTest() throws Exception {
        final Field field = createField(FIELD_DIAGONAL_WIN_O);
        final WinnerController win = new WinnerController();
        final Figure expectedValue = Figure.O;
        final Figure actualValue = win.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWinnerNoWinTest() throws Exception {
        final Field field = createField(FIELD_DIAGONAL_NO_WIN);
        final WinnerController win = new WinnerController();
        final Figure expectedValue = null;
        final Figure actualValue = win.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

}