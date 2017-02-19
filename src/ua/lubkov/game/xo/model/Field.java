package ua.lubkov.game.xo.model;

import ua.lubkov.game.xo.model.exceptions.InvalidPointException;

public class Field {

    private final int fieldSize;

    private static final int MIN_COORDINATE = 0;

    private final Figure[][] field;

    public Field(final int fieldSize) {

        this.fieldSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
    }

    public int getSize() {

        return fieldSize;
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

        return checkCoordinate(point.getX(), fieldSize) && checkCoordinate(point.getY(), fieldSize);
    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {

        return (coordinate >= MIN_COORDINATE) && (coordinate < maxCoordinate);
    }
}
