package com.example.demo.model;

import com.example.demo.model.piece.*;

public class DefaultBoardInitializer implements BoardInitalizer {

    @Override
    public void initBoard(Square[][] squares) {

        squares[0][0] = new Square(0, 0, new Rook(PieceColor.BLACK));
        squares[0][1] = new Square(0, 1, new Knight(PieceColor.BLACK));
        squares[0][2] = new Square(0, 2, new Bishop(PieceColor.BLACK));
        squares[0][3] = new Square(0, 3, new Queen(PieceColor.BLACK));
        squares[0][4] = new Square(0, 4, new King(PieceColor.BLACK));
        squares[0][5] = new Square(0, 5, new Bishop(PieceColor.BLACK));
        squares[0][6] = new Square(0, 6, new Knight(PieceColor.BLACK));
        squares[0][7] = new Square(0, 7, new Rook(PieceColor.BLACK));

        for (int c = 0; c < squares.length; c++) {
            squares[1][c] = new Square(0, 0, new Pawn(PieceColor.BLACK));
        }

        squares[0][0] = new Square(squares.length - 1, 0, new Rook(PieceColor.WHITE));
        squares[0][1] = new Square(squares.length - 1, 1, new Knight(PieceColor.WHITE));
        squares[0][2] = new Square(squares.length - 1, 2, new Bishop(PieceColor.WHITE));
        squares[0][3] = new Square(squares.length - 1, 3, new Queen(PieceColor.WHITE));
        squares[0][4] = new Square(squares.length - 1, 4, new King(PieceColor.WHITE));
        squares[0][5] = new Square(squares.length - 1, 5, new Bishop(PieceColor.WHITE));
        squares[0][6] = new Square(squares.length - 1, 6, new Knight(PieceColor.WHITE));
        squares[0][7] = new Square(squares.length - 1, 7, new Rook(PieceColor.WHITE));

        for (int c = 0; c < squares.length; c++) {
            squares[1][c] = new Square(0, 0, new Pawn(PieceColor.WHITE));
        }

        for (int i = 2; i < squares.length; i++) {
            for (int j = 0; j < squares[0].length; j++) {
                squares[i][j] = new Square(i, j, null);
            }
        }
    }

}
