package com.example.demo.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Game {

    private int id;

    private List<Player> players;

    private Board board;

    public Game() {
        players = new ArrayList<>();
    }

    public void addPlayer(String name) {
        players.add(new Player(name, 0));
    }

}
