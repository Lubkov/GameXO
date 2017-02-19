package ua.lubkov.game.xo.controllers;

import ua.lubkov.game.xo.model.Field;
import ua.lubkov.game.xo.model.Figure;
import ua.lubkov.game.xo.model.Point;
import ua.lubkov.game.xo.model.exceptions.InvalidPointException;

public class StepController {

    public StepController() {

    }

    public Figure nextStep(final Field field) {

        int figureCount = 0;

        try {
            for(int i = 0; i < field.getSize(); i++) {
                figureCount += countFigureInTheRow(field, i);
            }
        } catch (InvalidPointException e) {
            return null;
        }

        if (figureCount == field.getSize() * field.getSize()) {
            return null;
        }

        if (figureCount % 2 == 0) {
            return Figure.X;
        }
        return Figure.O;
    }

    int countFigureInTheRow(final Field field, final int row) throws InvalidPointException {
        int figureCount = 0;

        for(int i = 0; i < field.getSize(); i++) {
            if ((field.getFigure(new Point(row, i))) != null) {
                figureCount++;
            }
        }

        return figureCount;
    }
}
