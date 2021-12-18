package by.iTransition.rockPaperScissorsLizardSpock.util;

import by.iTransition.rockPaperScissorsLizardSpock.moves.*;

import javax.crypto.SecretKey;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private Hmac hmac = new Hmac();

    private final static String ENTER_YOUR_MOVE = "Enter your move:";
    private final static String COMPUTER_MOVE = "Computer's move: %s";

    public void start() {
        System.out.println("Hello");
        run();
        System.out.println("Bye");
    }

    private void run() {
        while (true) {
            SecretKey secretKey = hmac.generateKey();
            String computersSelect = computersSelect();
            String generateHMAC = hmac.generate(secretKey, computersSelect);
            System.out.println("HMAC: " + generateHMAC);
            Moves move = playersSelect();
            if (move == null) {
                break;
            }
            message(COMPUTER_MOVE, computersSelect);
            if (move.compare(computersSelect)) {
                System.out.println("You win!!!");
            } else System.out.println("You fail");
        }
    }

    private String computersSelect() {
        int number = random.nextInt(5);
        switch (number) {
            case 1:
                return "rock";
            case 2:
                return "scissors";
            case 3:
                return "paper";
            case 4:
                return "lizard";
            default:
                return "Spock";
        }
    }

    private Moves playersSelect() {
        showMenu();
        System.out.println(ENTER_YOUR_MOVE);
        String number = scanner.nextLine();
        switch (number) {
            case "1":
                return new Rock();
            case "2":
                return new Scissors();
            case "3":
                return new Paper();
            case "4":
                return new Lizard();
            case "5":
                return new Spock();
            case "0":
                System.out.println("");
                return null;
            case "?":
                return null;
        }
        System.out.println("Failed");
        return playersSelect();
    }

    private void showMenu() {
        System.out.println("Available moves:");
        System.out.println("1 - Rock");
        System.out.println("2 - Scissors");
        System.out.println("3 - Paper");
        System.out.println("4 - Lizard");
        System.out.println("5 - Spock");
        System.out.println("0 - Exit");
        System.out.println("? - Help");
    }

    private void message(String text, String str) {
        System.out.printf(text, str);
        System.out.println();
    }
}
