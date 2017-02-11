package ua.lubkov.game.xo.model;

import org.junit.Test;

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

}