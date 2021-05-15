package com.example.demo.model.piece;

public abstract class AbstractPiece implements Piece {

    protected String id;

    protected PieceColor pieceColor;

    public AbstractPiece(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    @Override
    public PieceColor getColor() {
        return pieceColor;
    }

    @Override
    public String getId() {
        return pieceColor.getId() + id;
    }
}
