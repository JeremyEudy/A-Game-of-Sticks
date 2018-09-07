package PickupSticks;

/**
 *
 * @author Jeremy Eudy
 */
import java.util.Scanner;

public class SticksTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("##################################");
        System.out.println("#                                #");
        System.out.println("# Welcome to the Game of Sticks! #");
        System.out.println("#                                #");
        System.out.println("##################################\n");
        int gameLoop = 1;        
        while (gameLoop == 1) {
            AIProtocol AI = new AIProtocol();
            AI.getBuckets();
            System.out.println("\nWhat would you like to do?\n");
            System.out.println("1 - Play against another player.");
            System.out.println("2 - Play against an AI.");
            System.out.println("3 - Train the AI against itself.");
            System.out.println("0 - Quit\n");
            int inGame = 0;
            System.out.print(">");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    inGame = 1;
                    while (inGame == 1) {
                        System.out.println("How many sticks would you like? (10-100)");
                        System.out.print(">");
                        int numSticks = in.nextInt();
                        if (numSticks >= 10 && numSticks <= 100) {
                            Game newGame = new Game();
                            newGame.setNumSticks(numSticks);
                            int turnNum = newGame.getTurn() % 2;
                            int choiceNum;
                            while (numSticks > 0) {
                                if (turnNum == 0) {
                                    System.out.print("There are ");
                                    System.out.print(newGame.getNumSticks());
                                    System.out.print(" sticks left ");
                                    System.out.println("Player 1, select how many sticks to pull. (1-3)");
                                    System.out.print(">");
                                    choiceNum = in.nextInt();
                                    if (choiceNum == 1 || choiceNum == 2 || choiceNum == 3){
                                        numSticks = newGame.changeSticks(choiceNum);
                                        turnNum = newGame.changeTurn() % 2;
                                    }
                                    else{
                                        System.out.println("Choice must be in range 1-3!");
                                    }
                                } else {
                                    System.out.print("There are ");
                                    System.out.print(newGame.getNumSticks());
                                    System.out.print(" stick(s) left ");
                                    System.out.println("Player 2, select how many sticks to pull. (1-3)");
                                    System.out.print(">");
                                    choiceNum = in.nextInt();
                                    numSticks = newGame.changeSticks(choiceNum);
                                    turnNum = newGame.changeTurn() % 2;
                                }
                            }
                            if (turnNum == 0) {
                                System.out.println("Player 1 wins!");
                            } else {
                                System.out.println("Player 2 wins!");
                            }
                            System.out.println("Thanks for playing!");
                            inGame = 0;
                        } else {
                            System.out.println("That is not a valid number of sticks");
                        }
                    }
                    break;
                case 2:
                    inGame = 1;
                    while (inGame == 1) {
                        System.out.println("How many sticks would you like? (10-100)");
                        System.out.print(">");
                        int numSticks = in.nextInt();
                        if (numSticks >= 10 && numSticks <= 100) {
                            Game newGame = new Game();
                            newGame.setNumSticks(numSticks);
                            int turnNum = newGame.getTurn() % 2;
                            int choiceNum;
                            int counter = 0;
                            while (numSticks != 0) {
                                System.out.print("There are ");
                                System.out.print(newGame.getNumSticks());
                                System.out.print(" sticks left ");
                                System.out.println("Player 1, select how many sticks to pull. (1-3)");
                                System.out.print(">");
                                choiceNum = in.nextInt();
                                numSticks = newGame.changeSticks(choiceNum);
                                turnNum = newGame.changeTurn() % 2;
                                counter++;
                                AI.setTurn(counter);
                                choiceNum = AI.AIChoice1();
                                System.out.print("There are ");
                                System.out.print(newGame.getNumSticks());
                                System.out.print(" stick(s) left ");
                                System.out.println("The AI chose: " + choiceNum);
                                numSticks = newGame.changeSticks(choiceNum);
                                turnNum = newGame.changeTurn() % 2;
                                counter++;
                                AI.setTurn(counter);
                            }
                            if (turnNum == 0) {
                                System.out.println("Player 1 wins!");
                                int result = 0;
                                AI.train(result);
                            } else {
                                System.out.println("The computer wins!");
                                int result = 1;
                                AI.train(result);
                            }
                            System.out.println("Thanks for playing!");
                            inGame = 0;
                        }
                    }
                    break;
                case 3:
                    inGame = 1;
                    while (inGame == 1) {
                        AIProtocol newAI = new AIProtocol();
                        System.out.println("How many games would you like the computer to play?");
                        System.out.print(">");
                        int numGames = in.nextInt();
                        System.out.println("\t" + numGames + " games with 100 sticks each");
                        for (int i = 0; i < numGames; i++) {
                            int numSticks = 100;
                            System.out.format("\nAI Training...\tGame %d/%d\n", i + 1, numGames);
                            Game newGame = new Game();
                            newGame.setNumSticks(100);
                            int turnNum = newGame.getTurn() % 2;
                            int choiceNum;
                            int counter = 0;
                            while (numSticks > 0) {
                                counter++;
                                choiceNum = AI.AIChoice1();
                                numSticks = newGame.changeSticks(choiceNum);
                                turnNum = newGame.changeTurn() % 2;
                                AI.setTurn(counter);
                                counter++;
                                newAI.setTurn(counter);
                                choiceNum = newAI.AIChoice2(numSticks);
                                numSticks = newGame.changeSticks(choiceNum);
                                turnNum = newGame.changeTurn() % 2;
                            }
                            if (turnNum == 0) {
                                int result = 1;
                                AI.train(result);
                            } else {
                                int result = 0;
                                AI.train(result);
                            }
                            AI.setTurn(0);
                            newAI.setTurn(0);
                            System.out.println("\t\tGame ended");
                            AI.getBuckets();
                            newAI.getBuckets();
                        }
                        System.out.println("AI trained!");
                        inGame = 0;
                    }
                    break;

                case 0:
                    System.exit(0);
                default:
                    System.out.println("That is not a valid choice!");
                    System.out.println("--------------------------------------------------------");
                    break;
            }
        }
    }
}
