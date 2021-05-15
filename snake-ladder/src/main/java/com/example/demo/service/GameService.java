package com.example.demo.service;

import com.example.demo.model.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GameService {

    private Game game;

    private boolean gameEnded;

    private Dice dice;

    public GameService(Game game) {
        this.game = game;
        dice = new Dice();
    }

    public void start() {

        while (!isGameEnded()) {
            for (Player player : game.getPlayers()) {
                int diceValue = dice.roll();
                boolean isPlayerWon = makeMove(player, diceValue);
                if (isPlayerWon) {
                    gameEnded = true;
                    printWinningMessage(player);
                    break;
                }
            }
        }

    }

    private boolean makeMove(Player player, int diceValue) {
        int newPosition = player.getCurrentBoardPosition() + diceValue;

        if (newPosition == game.getBoard().getSize()) {
            System.out.println(player.getName() + " rolled a " + diceValue + " and moved from "
                    + player.getCurrentBoardPosition() + " to " + newPosition);
            player.setCurrentBoardPosition(newPosition);
            return true;
        } else if (newPosition > game.getBoard().getSize()) {
            return false;
        } else {
            boolean newPositionAffectedBySnake = false;
            for (Snake snake : game.getBoard().getSnakes()) {
                if (snake.getHead() == newPosition) {
                    newPosition = snake.getTail();
                    newPositionAffectedBySnake = true;
                }
            }
            if (!newPositionAffectedBySnake) {
                for (Ladder ladder : game.getBoard().getLadders()) {
                    if (ladder.getBottom() == newPosition) {
                        newPosition = ladder.getTop();
                    }
                }
            }
            System.out.println(player.getName() + " rolled a " + diceValue + " and moved from "
                    + player.getCurrentBoardPosition() + " to " + newPosition);
            player.setCurrentBoardPosition(newPosition);
            return false;
        }
    }

    private void printWinningMessage(Player player) {
        System.out.println(player.getName() + " wins the game!");
    }

    private boolean isGameEnded() {
        return gameEnded;
    }

}

