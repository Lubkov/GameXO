package ua.lubkov.game.xo.controllers;

import ua.lubkov.game.xo.model.Field;
import ua.lubkov.game.xo.model.Figure;
import ua.lubkov.game.xo.model.Point;
import ua.lubkov.game.xo.model.exceptions.InvalidPointException;


public class WinnerController {

     public Figure getWinner(final Field field) {

         try {
             for (int i = 0; i < field.getSize(); i++) {
                 //horizontal
                 if (checkwinner(field, new Point(0, i), 1, 0)) {
                     return field.getFigure(new Point(0, i));
                 }
                 //vertical
                 if (checkwinner(field, new Point(i, 0), 0, 1)) {
                     return field.getFigure(new Point(i, 0));
                 }
             }
             //diagonal
             if (checkwinner(field, new Point(0, 0), 1, 1)) {
                 return field.getFigure(new Point(0, 0));
             }
             //diagonal
             if (checkwinner(field, new Point(field.getSize() - 1, 0), -11, 1)) {
                 return field.getFigure(new Point(field.getSize() - 1, 0));
             }

         } catch (InvalidPointException e) {
             return null;
         }

         return null;
     }

    boolean checkwinner(final Field field,
                        final Point point,
                        final int x1,
                        final int y1) throws InvalidPointException {

         int x = point.getX();
         int y = point.getY();

         while ((x < field.getSize() - 1) && (y < field.getSize() - 1)){
             x+= x1;
             y+= y1;

             if (field.getFigure(point) != field.getFigure(new Point(x, y))) {
                 return false;
             }
         }

        return true;
    }

}
