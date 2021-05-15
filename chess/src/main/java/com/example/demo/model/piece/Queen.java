package com.example.demo.model.piece;

import com.example.demo.model.Square;

import java.util.List;

public class Queen extends AbstractPiece {

    public Queen(PieceColor pieceColor) {
        super(pieceColor);
        super.id = "Q";
    }

    @Override
    public List<Square> getAllValidMovesFrom(Square square, Square[][] squares) {
        return null;
    }
}
