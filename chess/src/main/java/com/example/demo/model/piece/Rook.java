package com.example.demo.model.piece;

import com.example.demo.model.Square;

import java.util.List;

public class Rook extends AbstractPiece {

    public Rook(PieceColor pieceColor) {
        super(pieceColor);
        super.id = "R";
    }

    @Override
    public List<Square> getAllValidMovesFrom(Square square, Square[][] squares) {
        return null;
    }

}
