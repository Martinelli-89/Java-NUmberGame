import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static class NumberGame {
        int[] guesses = {0,0,0,0,0,0,0,0,0,0,0};
        int numberToGuess;

        void setGuesses (int index, int number) {
            guesses[index] = number;
        }

        void setNumberToGuess() {
            numberToGuess=(int)Math.ceil(Math.random()*100);
        }

        public void play () {
            setNumberToGuess();
            Scanner scannerGuess = new Scanner(System.in);
            System.out.println("Welcome to the find the number!");
            System.out.println("You have 10 chance to guess the right number, ranging from 1 to 100. Let's start!");
            for(int i=0; i < 10; i++) {
                System.out.println("Enter number");
                final int guess = scannerGuess.nextInt();
                if(guess > 100 || guess < 1) {
                    System.out.printf("Please enter a valid number");
                    i--;
                    continue;
                }
                int difference = Math.abs(guess-numberToGuess);
                boolean contains = IntStream.of(guesses).anyMatch(x -> x == guess);

                if(contains) {
                    System.out.println("You already entered this number");
                    i--;
                } else if(difference>30) {
                    System.out.println("No where near..");
                } else if (difference >25){
                    System.out.println("Artic");
                } else if (difference >20){
                    System.out.println("Freezing");
                } else if (difference >15){
                    System.out.println("Very cold");
                } else if (difference >10){
                    System.out.println("Cold");
                } else if (difference >5){
                    System.out.println("Warm");
                } else if (difference >3){
                    System.out.println("Very warm");
                } else if (difference > 0){
                    System.out.println("Very very warm");
                } else if (difference == 0){
                    System.out.println("You got it in " + (i+1) +" attempts");

                    i = 10;
                }
                setGuesses(i,guess);
            }
            System.out.println("End game");
        }
    }

    public static void main(String[] args) {
        NumberGame game = new NumberGame();

        game.play();
    }
}