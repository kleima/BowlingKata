package com.chrisdev;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    void addTries(int nrOfTries, List<Integer> pinsPerTry, int tryOne, int tryTwo) {
        for (int i = 0; i < nrOfTries; i++) {
            pinsPerTry.add(tryOne);
            pinsPerTry.add(tryTwo);
        }
    }

    void addSpares(int nrOfTries, List<Integer> pinsPerTry,  int tryOne, int tryTwo) {
        for (int i = 0; i < nrOfTries; i++) {
            pinsPerTry.add(tryOne);
            pinsPerTry.add(tryTwo);
        }
    }

    void addStrikes(int nrOfTries, List<Integer> pinsPerTry) {
        for (int i = 0; i < nrOfTries; i++) {
            pinsPerTry.add(10);
            pinsPerTry.add(null);
        }
    }

    @Test
    public void noSpareNoStrike() {
        StraightForward straightForward = new StraightForward();

        List<Integer> pinsPerTry = new ArrayList<>();
        addTries(10, pinsPerTry, 3,5);
        pinsPerTry.add(0);
        pinsPerTry.add(0);

        assertEquals(straightForward.getScore(pinsPerTry), 80);
    }

    @Test
    public void hasSpareNoStrike() {
        StraightForward straightForward = new StraightForward();

        List<Integer> pinsPerTry = new ArrayList<>();

        addSpares(1, pinsPerTry, 3, 7);
        addTries(9, pinsPerTry, 3,5);
        pinsPerTry.add(0);
        pinsPerTry.add(0);

        assertEquals(straightForward.getScore(pinsPerTry), 85);
    }

    @Test
    public void hasMultipleSpareNoStrike() {
        StraightForward straightForward = new StraightForward();

        List<Integer> pinsPerTry = new ArrayList<>();

        addSpares(3, pinsPerTry, 3, 7);
        addTries(7, pinsPerTry, 3, 5);
        pinsPerTry.add(0);
        pinsPerTry.add(0);

        assertEquals(straightForward.getScore(pinsPerTry), 95);
    }

    @Test
    public void noSpareHasStrike() {
        StraightForward straightForward = new StraightForward();

        List<Integer> pinsPerTry = new ArrayList<>();

        addStrikes(1, pinsPerTry);
        addTries(9, pinsPerTry, 3, 5);
        pinsPerTry.add(0);
        pinsPerTry.add(0);

        assertEquals(straightForward.getScore(pinsPerTry), 90);
    }

    @Test
    public void hasTenStrikes() {
        StraightForward straightForward = new StraightForward();

        List<Integer> pinsPerTry = new ArrayList<>();

        addStrikes(10, pinsPerTry);
        pinsPerTry.add(3);
        pinsPerTry.add(5);

        assertEquals(straightForward.getScore(pinsPerTry), 281);
    }

    @Test
    public void hasTwelveStrikes() {
        StraightForward straightForward = new StraightForward();

        List<Integer> pinsPerTry = new ArrayList<>();

        addStrikes(10, pinsPerTry);
        pinsPerTry.add(10);
        pinsPerTry.add(10);

        assertEquals(straightForward.getScore(pinsPerTry), 300);
    }

    @Test
    public void hasOnlyNinePinsEachTry() {
        StraightForward straightForward = new StraightForward();

        List<Integer> pinsPerTry = new ArrayList<>();

        addTries(10, pinsPerTry, 9, 0);
        pinsPerTry.add(0);
        pinsPerTry.add(0);

        assertEquals(straightForward.getScore(pinsPerTry), 90);
    }

    @Test
    public void hasTenSpares() {
        StraightForward straightForward = new StraightForward();

        List<Integer> pinsPerTry = new ArrayList<>();

        addSpares(10, pinsPerTry, 5, 5);
        pinsPerTry.add(5);
        pinsPerTry.add(0);

        assertEquals(straightForward.getScore(pinsPerTry), 150);
    }
}
