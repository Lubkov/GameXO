package ua.lubkov.game.xo;

import ua.lubkov.game.xo.model.Field;
import ua.lubkov.game.xo.model.Figure;
import ua.lubkov.game.xo.model.Point;
import ua.lubkov.game.xo.model.exceptions.InvalidPointException;

public class FieldBilder {

    private static final int FIELD_SIZE = 3;

    private static final Figure[][] FIELD_HORIZONTAL_WIN_X =
            {
                    {Figure.O, null, Figure.O},
                    {Figure.X, Figure.X, Figure.X},
                    {null, null, null}
            };

    private static final Figure[][] FIELD_VERTICAL_WIN_O =
            {
                    {Figure.X, null, Figure.O},
                    {Figure.X, Figure.X, Figure.O},
                    {null, null, Figure.O}
            };

    private static final Figure[][] FIELD_DIAGONAL_WIN_X =
            {
                    {Figure.X, null, Figure.O},
                    {Figure.O, Figure.X, Figure.O},
                    {Figure.X, null, Figure.X}
            };

    private static final Figure[][] FIELD_DIAGONAL_WIN_O =
            {
                    {Figure.X, null, Figure.O},
                    {Figure.X, Figure.O, Figure.O},
                    {Figure.O, Figure.X, Figure.X}
            };

    private static final Figure[][] FIELD_NO_WIN =
            {
                    {Figure.X, null, Figure.O},
                    {Figure.X, null, Figure.O},
                    {Figure.O, Figure.X, Figure.X}
            };

    private static final Figure[][] FIELD_PAT =
            {
                    {Figure.X, Figure.O, Figure.X},
                    {Figure.X, Figure.X, Figure.O},
                    {Figure.O, Figure.X, Figure.O}
            };

    private Field createField(Figure[][] data) throws InvalidPointException {
        Field field = new Field(FIELD_SIZE);

        for (int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                field.setFigure(new Point(x, y), data[x][y]);
            }
        }
        return field;
    }

    public Field getFieldHorizontalWinX() throws InvalidPointException {

        return createField(FIELD_HORIZONTAL_WIN_X);
    }

    public Field getFieldVerticalWinO() throws InvalidPointException {

        return createField(FIELD_VERTICAL_WIN_O);
    }

    public Field getFieldFirstDiagonalWinX() throws InvalidPointException {

        return createField(FIELD_DIAGONAL_WIN_X);
    }

    public Field getFieldSecondDiagonalWinO() throws InvalidPointException {

        return createField(FIELD_DIAGONAL_WIN_O);
    }

    public Field getFieldDoNotHaveWin() throws InvalidPointException {

        return createField(FIELD_NO_WIN);
    }

    public Field getFieldPat() throws InvalidPointException {

        return createField(FIELD_PAT);
    }
}
