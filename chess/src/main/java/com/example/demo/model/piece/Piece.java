package com.example.demo.model.piece;

import com.example.demo.model.Square;

import java.util.List;

public interface Piece {

    String getId();

    PieceColor getColor();

    List<Square> getAllValidMovesFrom(Square square, Square[][] squares);

}
