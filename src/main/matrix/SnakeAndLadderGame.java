package main.matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by HarshPatil on 3/30/17.
 */
public class SnakeAndLadderGame {

    static Map<Integer, Integer> snakeMap = new HashMap<Integer, Integer>();
    static Map<Integer, Integer> ladderMap = new HashMap<Integer, Integer>();
    static int finalPosition = 64;
    static int startPosition = 1;

    public static void main(String []args) throws Exception {

        createSnakeMap(snakeMap);
        createLadderMap(ladderMap);
        startGame();
    }

    public static void createSnakeMap(Map<Integer, Integer> snakeMap){

        snakeMap.put(11, 8);
        snakeMap.put(62, 23);
        snakeMap.put(42, 19);
        snakeMap.put(35, 2);
    }

    public static void createLadderMap(Map<Integer, Integer> ladderMap){

        ladderMap.put(5, 28);
        ladderMap.put(12, 23);
        ladderMap.put(34, 60);
        ladderMap.put(22, 44);
    }

    public static void startGame() throws Exception{

        int currentPosition = startPosition;
        System.out.println("Current Position ::::" + currentPosition);
        while(currentPosition < finalPosition){

            Random random = new Random();

            int rollDice = random.nextInt(6)+1;
            System.out.println("Roll Dice ::::" + rollDice);

            currentPosition = currentPosition + rollDice;
            System.out.println("Current Position ::::" + currentPosition);

            if(snakeMap.containsKey(currentPosition)){
                System.out.println("Snake Found :::: Head of Snake :: " + currentPosition + " & Tail :: " + snakeMap.get(currentPosition));
                currentPosition = snakeMap.get(currentPosition);
            }
            if(ladderMap.containsKey(currentPosition)){
                System.out.println("Ladder Found :::: Head of ladder :: " + currentPosition + " & Tail :: " + ladderMap.get(currentPosition));
                currentPosition = ladderMap.get(currentPosition);
            }
            Thread.sleep(1000);
        }
        System.out.println("Atta Boy !!! You are at the destination !!!!");
    }
}
