package com.example.demo.model.piece;

import com.example.demo.model.Square;

import java.util.List;

public class King extends AbstractPiece {

    public King(PieceColor pieceColor) {
        super(pieceColor);
        super.id = "K";
    }

    @Override
    public String getId() {
        return pieceColor.getId() + id;
    }

    @Override
    public List<Square> getAllValidMovesFrom(Square square, Square[][] squares) {
        return null;
    }

}
