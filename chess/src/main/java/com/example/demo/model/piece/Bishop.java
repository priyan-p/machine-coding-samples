package com.example.demo.model.piece;

import com.example.demo.model.Square;

import java.util.List;

public class Bishop extends AbstractPiece{

    public Bishop(PieceColor pieceColor) {
        super(pieceColor);
        super.id = "B";
    }

    @Override
    public List<Square> getAllValidMovesFrom(Square square, Square[][] squares) {
        return null;
    }

}
