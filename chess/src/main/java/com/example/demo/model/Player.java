package com.example.demo.model;

import com.example.demo.model.piece.PieceColor;
import lombok.Data;

@Data
public class Player {

    private String name;

    private PieceColor pieceColor;

}
