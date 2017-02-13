package ua.lubkov.game.xo.model;


import ua.lubkov.game.xo.model.exceptions.AlreadyOccupiedException;
import ua.lubkov.game.xo.model.exceptions.InvalidPointException;

public class Field {

    private static final int FIELD_SIZE = 3;

    private static final int MIN_COORDINATE = 0;

    private static final int MAX_COORDINATE = FIELD_SIZE;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        return field[point.getX()][point.getY()];
    }

    public void setFigure(final Point point, Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        field[point.getX()][point.getY()] = figure;
    }


    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.getX()) && checkCoordinate(point.getY());
    }

    private boolean checkCoordinate(final int coordinate) {
        return (coordinate >= MIN_COORDINATE) && (coordinate < MAX_COORDINATE);
    }
}
