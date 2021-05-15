package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class Game {

    private Board board;

    private List<Player> players;

}
