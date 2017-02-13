package ua.lubkov.game.xo.controllers;

import ua.lubkov.game.xo.model.Field;
import ua.lubkov.game.xo.model.Figure;
import ua.lubkov.game.xo.model.Point;
import ua.lubkov.game.xo.model.exceptions.AlreadyOccupiedException;
import ua.lubkov.game.xo.model.exceptions.InvalidPointException;

public class MoveController {

    public void applyFigure(Field field, Point point, Figure figure) throws AlreadyOccupiedException,
                                                                            InvalidPointException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }

        field.setFigure(point, figure);
    }
 }
