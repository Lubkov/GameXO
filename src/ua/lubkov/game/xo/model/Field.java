package ua.lubkov.game.xo.model;


public class Field {

    private static final int FIELD_SIZE = 3;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
    }

    public void setFigure(final Point point, Figure figure) {
        field[point.getX()][point.getY()] = figure;
    }

    public Figure getFigure(final Point point) {
        return field[point.getX()][point.getY()];
    }
}
