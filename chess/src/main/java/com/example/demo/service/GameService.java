package com.example.demo.service;

import com.example.demo.exception.InvalidMoveException;
import com.example.demo.model.Game;
import com.example.demo.model.Player;
import com.example.demo.model.Square;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

@Service
public class GameService {

    private Game game;

    public GameService(Game game) {
        this.game = game;
    }

    public void start() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            for (Player player : game.getPlayers()) {
                while (true) {
                    try {
                        String[] moveCommand = bufferedReader.readLine().split(" ");
                        List<Square> squaresToMove = convertCommand(moveCommand);
                        validateMove(squaresToMove.get(0), squaresToMove.get(1), player);
                        makeMove(squaresToMove.get(0), squaresToMove.get(1));
                    } catch (InvalidMoveException e) {
                        System.out.println("Invalid Command. Please enter valid command to continue.");
                    } catch (Exception e) {
                        System.out.println("Internal Error. Please enter valid command to continue.");
                    }
                }
            }
        }

    }

    private void makeMove(Square fromSquare, Square toSquare) {

    }

    private List<Square> convertCommand(String[] command) {
        Square fromSquare = game.getBoard().getSquares()[((int) command[0].charAt(0) - 'a')][((int) command[0].charAt(1) - '0')];
        Square toSquare = game.getBoard().getSquares()[((int) command[1].charAt(0) - 'a')][((int) command[1].charAt(1) - '0')];
        return Arrays.asList(fromSquare, toSquare);
    }

    private void validateMove(Square fromSquare, Square toSquare, Player player) {
        validateCell(fromSquare, toSquare, player);
        List<Square> allValidMoves = fromSquare.getPiece()
                .getAllValidMovesFrom(fromSquare, game.getBoard().getSquares());
        if (!allValidMoves.contains(toSquare)) {
            throw new InvalidMoveException();
        }
    }

    private void validateCell(Square fromSquare, Square toSquare, Player player) {
        if (fromSquare.getPiece() == null
                || player.getPieceColor() != fromSquare.getPiece().getColor()
                || (toSquare.getPiece() != null && toSquare.getPiece().getColor() == player.getPieceColor())) {
            throw new InvalidMoveException();
        }
    }

}
