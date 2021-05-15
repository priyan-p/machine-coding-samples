package com.example.demo.model;

import com.example.demo.model.piece.Piece;
import lombok.Data;

@Data
public class Square {

    private int row;

    private int col;

    private Piece piece;

    public Square(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public String getValue() {
        return piece == null ? "--" : piece.getId();
    }

}
