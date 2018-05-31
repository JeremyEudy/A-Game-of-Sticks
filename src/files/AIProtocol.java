package PickupSticks;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jeremy Eudy
 */
public class AIProtocol {

    private ArrayList<ArrayList> buckets = new ArrayList<ArrayList>();
    private ArrayList<ArrayList> record = new ArrayList<ArrayList>();
    private ArrayList<Integer> options = new ArrayList<Integer>();
    private Random r = new Random();
    private int turn = 0;

    public AIProtocol() {
        options.add(1);
        options.add(2);
        options.add(3);
        for (int i = 0; i < 50; i++) {
            buckets.add(options);
        }
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int AIChoice1() {
        if (turn % 2 == 0) {
            ArrayList<Integer> choice = new ArrayList<Integer>();
            ArrayList<Integer> currentTurn = buckets.get(turn);
            int add = currentTurn.size();
            System.out.println("Size: " + add);
            Integer choiceInt = r.nextInt(add) + 1;
            choice.add(turn);
            choice.add(choiceInt);
            record.add(choice);
            turn++;
            return choiceInt;
        } else {
            turn++;
        }
        return 0;
    }

    public int AIChoice2(int numSticks) {
        if (turn % 2 != 0) {
            ArrayList<Integer> choice = new ArrayList<Integer>();
            ArrayList<Integer> currentTurn = buckets.get(turn);
            int add = currentTurn.size();
            Integer choiceInt = r.nextInt(add) + 1;
            choice.add(turn);
            choice.add(choiceInt);
            record.add(choice);
            turn++;
            return choiceInt;
        } else {
            turn++;
        }
        return 0;
    }

    public void train(int result) {
        ArrayList<Integer> subBucket = new ArrayList<Integer>();
        if (result == 1) {
            for (int i = 0; i < buckets.size(); i++) {
                subBucket = buckets.get(i);
                ArrayList<Integer> current = new ArrayList<Integer>();
                int bucketIndex = buckets.indexOf(subBucket);
                current = record.get(bucketIndex);
                if (current.get(0) == buckets.indexOf(subBucket)) {
                    int add = current.get(1);
                    subBucket.add(add);
                    buckets.remove(i);
                    buckets.add(i, subBucket);
                }
                subBucket.clear();
            }
        } else {
            for (int i = 0; i < buckets.size(); i++) {
                subBucket = buckets.get(i);
                ArrayList<Integer> current = new ArrayList<Integer>();
                current = record.get(i);
                int num = current.get(1);
                if (current.get(0) == buckets.indexOf(subBucket)) {
                    if (subBucket.contains(num)) {
                        int x = subBucket.indexOf(num);
                        subBucket.remove(x);
                        buckets.remove(i);
                        buckets.add(i, subBucket);
                    }
                }
                subBucket.clear();
            }
        }
        turn = 0;
        record.clear();
    }

    public ArrayList<ArrayList> getBuckets() {
        System.out.println("Record: " + record);
        System.out.println("Bucket: " + buckets);
        return buckets;
    }

}
