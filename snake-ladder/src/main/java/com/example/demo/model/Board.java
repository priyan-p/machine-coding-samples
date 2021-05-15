package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Board {

    private List<Snake> snakes;

    private List<Ladder> ladders;

    private int size;

    public Board(int size) {
        this.size = size;
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
    }

    public void addSnake(int head, int tail) {
        if (head >= size || tail >= size || tail < 1 || head <= tail) {
            throw new RuntimeException("Invalid Snake");
        }
        snakes.add(new Snake(head, tail));
    }

    public void addLadder(int bottom, int top) {
        if (bottom >= size || top >= size || bottom < 1 || top < 1 || bottom >= top) {
            throw new RuntimeException("Invalid Ladder");
        }
        ladders.add(new Ladder(bottom, top));
    }

}
