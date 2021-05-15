package com.example.demo.model.piece;

import com.example.demo.model.Square;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {

    public Pawn(PieceColor pieceColor) {
        super(pieceColor);
        super.id = "P";
    }

    @Override
    public String getId() {
        return super.pieceColor.getId() + id;
    }

    @Override
    public List<Square> getAllValidMovesFrom(Square square, Square[][] squares) {
        List<Square> validSquares = new ArrayList<>();
        if (pieceColor == PieceColor.BLACK) {

        } else {

        }
        return validSquares;
    }
}
