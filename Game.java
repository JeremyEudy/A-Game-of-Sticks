package PickupSticks;

/**
 *
 * @author Jeremy Eudy
 */
public class Game {

    private int turn;
    private int numSticks;

    public Game() {
        turn = 0;
        numSticks = 0;
    }

    public void setNumSticks(int numSticks) {
        this.numSticks = numSticks;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getNumSticks() {
        return numSticks;
    }

    public int getTurn() {
        return turn;
    }

    public int changeSticks(int choiceNum) {
        numSticks -= choiceNum;
        return numSticks;
    }

    public int changeTurn() {
        turn++;
        return turn;
    }

}
