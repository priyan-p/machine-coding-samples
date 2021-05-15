package com.example.demo;

import com.example.demo.model.Board;
import com.example.demo.model.Game;
import com.example.demo.service.GameService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private BeanFactory beanFactory;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Board board = new Board(100);

        System.out.println("Enter snake count");
        int snakeCount = Integer.parseInt(bufferedReader.readLine());
        for (int s = 0; s < snakeCount; s++) {
            System.out.println("Enter snake head and tail");
            String[] snakeInfo = bufferedReader.readLine().split(" ");
            board.addSnake(Integer.parseInt(snakeInfo[0]), Integer.parseInt(snakeInfo[1]));
        }

        System.out.println("Enter ladder count");
        int ladderCount = Integer.parseInt(bufferedReader.readLine());
        for (int l = 0; l < ladderCount; l++) {
            System.out.println("Enter ladder bottom and top");
            String[] ladderInfo = bufferedReader.readLine().split(" ");
            board.addLadder(Integer.parseInt(ladderInfo[0]), Integer.parseInt(ladderInfo[1]));
        }

        Game game = new Game();
        game.setId(123);
        game.setBoard(board);

        System.out.println("Enter player count");
        int playerCount = Integer.parseInt(bufferedReader.readLine());
        for (int l = 0; l < playerCount; l++) {
            System.out.println("Enter player name");
            String playerName = bufferedReader.readLine();
            game.addPlayer(playerName);
        }

        beanFactory.getBean(GameService.class, game).start();

    }
}
