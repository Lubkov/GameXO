package ua.lubkov.game.xo.controllers;

import org.junit.Test;
import ua.lubkov.game.xo.FieldBilder;
import ua.lubkov.game.xo.model.Field;
import ua.lubkov.game.xo.model.Figure;

import static org.junit.Assert.*;

public class StepControllerTest {

    @Test
    public void nextStepXTest() throws Exception {

        final Field field = new FieldBilder().getFieldNextStepX();
        final StepController stepController = new StepController();
        final Figure expectedValue = Figure.X;
        final Figure actualValue = stepController.nextStep(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void nextStepOTest() throws Exception {

        final Field field = new FieldBilder().getFieldNextStepO();
        final StepController stepController = new StepController();
        final Figure expectedValue = Figure.O;
        final Figure actualValue = stepController.nextStep(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void countFigureInTheRow() throws Exception {

        final int row = 0;
        final Field field = new FieldBilder().getFieldFirstDiagonalWinX();
        final StepController stepController = new StepController();
        final int expectedValue = 2;
        final int actualValue = stepController.countFigureInTheRow(field, row);

        assertEquals(expectedValue, actualValue);
    }

}