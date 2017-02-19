package ua.lubkov.game.xo.view;


import ua.lubkov.game.xo.controllers.*;
import ua.lubkov.game.xo.model.*;
import ua.lubkov.game.xo.model.exceptions.AlreadyOccupiedException;
import ua.lubkov.game.xo.model.exceptions.InvalidPointException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final StepController stepController = new StepController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    public void show(final Game game) {
        Field field = game.getField();

        showGameName(game);
        System.out.println("     x1  x2  x3");

        for (int y = 0; y < field.getSize(); y++) {
            printLine(field, y);
        }
        printSeparator();
    }

    public boolean step(final Game game) {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);

        if (winner != null) {
            System.out.format("Победитель %s, %s!!!\n", game.getPlayer(winner).getName(), winner);
            return false;
        }

        final Figure currentFigure = stepController.nextStep(field);

        if (currentFigure == null) {
            System.out.println("Ничья!!!");
            return false;
        }

        System.out.printf("Ходит %s, %s:\n", game.getPlayer(currentFigure).getName(), currentFigure);
        Point point = askPoint();
        try {
            moveController.applyFigure(field, point, currentFigure);
        } catch (InvalidPointException | AlreadyOccupiedException e) {
            System.out.println("Введены неверные координаты");
        }
        return true;
    }

    public String askPlayerName(final int playerNumber) {
        System.out.format("Введите имя игрока #%s: ", playerNumber);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextLine();
        } catch (final InputMismatchException e) {
            System.out.println("Неверный ввод");
            return askPlayerName(playerNumber);
        }
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Введите %s: ", coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("Неверный ввод");
            return askCoordinate(coordinateName);
        }
    }

    private void showGameName(final Game game) {
        System.out.format("Крестики-нолики: \"%s\"\n\n", game.getName());
    }

    private void printLine(Field field, int y) {
        printSeparator();
        System.out.print("y" + (y + 1) + " |");

        for (int x = 0; x < field.getSize(); x++) {
            final Figure figure;

            try {
                figure = field.getFigure(new Point(x, y));
            } catch (InvalidPointException e) {
                throw new RuntimeException(e);
            }
            System.out.print(" " + (figure != null ? figure : " ") + " ");
            System.out.print("|");
        }

        System.out.println();
    }

    private void printSeparator() {
        //char a = (char) 619;
        System.out.println("   -------------");
    }

}
