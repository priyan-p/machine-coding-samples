package com.example.demo.model;

import lombok.Data;

@Data
public class Board {

    private BoardInitalizer boardInitalizer;

    private Square[][] squares;

    public Board(int row, int col, BoardInitalizer boardInitalizer) {
        squares = new Square[row][col];
        boardInitalizer.initBoard(squares);
    }

}
