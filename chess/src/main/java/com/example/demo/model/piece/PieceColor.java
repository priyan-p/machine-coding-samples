package com.example.demo.model.piece;

public enum PieceColor {

    BLACK("B"), WHITE("W");

    private String id;

    PieceColor(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static PieceColor getOpponentColor(PieceColor pieceColor) {
        return pieceColor == BLACK ? WHITE : BLACK;
    }
}
