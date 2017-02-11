package ua.lubkov.game.xo.model;

import org.junit.Test;
import ua.lubkov.game.xo.model.exceptions.AlreadyOccupiedException;
import ua.lubkov.game.xo.model.exceptions.InvalidPointException;

import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void getSize() throws Exception {
        final Field field = new Field();

        assertEquals(3, field.getSize());
    }

    @Test
    public void setFigure() throws Exception {
        final Figure inputFigure = Figure.O;
        final Point inputPoint = new Point(0, 0);
        final Figure expectedValue = inputFigure;
        final Field field = new Field();

        field.setFigure(inputPoint, inputFigure);

        assertEquals(expectedValue, field.getFigure(inputPoint));
    }

    @Test
    public void getFigureWenFigureIsNotSet() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(1, 1);

        assertNull(field.getFigure(inputPoint));
    }

    @Test(expected = InvalidPointException.class)
    public void getFigureWhenXIsLessThenZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, 1);

        field.getFigure(inputPoint);
    }

    @Test(expected = InvalidPointException.class)
    public void getFigureWhenYIsLessThenZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(1, -1);

        field.getFigure(inputPoint);
    }

    @Test(expected = InvalidPointException.class)
    public void getFigureWhenXIsMoreThenSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize(), 1);

        field.getFigure(inputPoint);
    }

    @Test(expected = InvalidPointException.class)
    public void getFigureWhenYIsMoreThenSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, field.getSize());

        field.getFigure(inputPoint);
    }

    @Test(expected = AlreadyOccupiedException.class)
    public void getFigureWhenAlreadyOccupied() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(1, 1);

        field.setFigure(inputPoint, Figure.X);
        field.setFigure(inputPoint, Figure.O);
    }
}