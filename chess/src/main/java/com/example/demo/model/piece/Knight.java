package com.example.demo.model.piece;

import com.example.demo.model.Square;

import java.util.List;

public class Knight extends AbstractPiece {

    public Knight(PieceColor pieceColor) {
        super(pieceColor);
        super.id = "N";
    }

    @Override
    public List<Square> getAllValidMovesFrom(Square square, Square[][] squares) {
        return null;
    }
}
