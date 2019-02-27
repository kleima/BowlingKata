package com.chrisdev;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    private void addTries(int nrOfTries, List<Optional<Integer>> pinsPerTry, int tryOne, int tryTwo) {
        for (int i = 0; i < nrOfTries; i++) {
            pinsPerTry.add(Optional.of(tryOne));
            pinsPerTry.add(Optional.of(tryTwo));
        }
    }

    private void addSpares(int nrOfTries, List<Optional<Integer>> pinsPerTry, int tryOne, int tryTwo) {
        for (int i = 0; i < nrOfTries; i++) {
            pinsPerTry.add(Optional.of(tryOne));
            pinsPerTry.add(Optional.of(tryTwo));
        }
    }

    private void addStrikes(int nrOfTries, List<Optional<Integer>> pinsPerTry) {
        for (int i = 0; i < nrOfTries; i++) {
            pinsPerTry.add(Optional.of(10));
            pinsPerTry.add(Optional.empty());
        }
    }

    @Test
    public void noSpareNoStrike() {
        StraightForward straightForward = new StraightForward();

        List<Optional<Integer>> pinsPerTry = new ArrayList<>();
        addTries(10, pinsPerTry, 3,5);
        pinsPerTry.add(Optional.of(0));
        pinsPerTry.add(Optional.of(0));

        assertEquals(straightForward.getScore(pinsPerTry), 80);
    }

    @Test
    public void hasSpareNoStrike() {
        StraightForward straightForward = new StraightForward();

        List<Optional<Integer>> pinsPerTry = new ArrayList<>();

        addSpares(1, pinsPerTry, 3, 7);
        addTries(9, pinsPerTry, 3,5);
        pinsPerTry.add(Optional.of(0));
        pinsPerTry.add(Optional.of(0));

        assertEquals(straightForward.getScore(pinsPerTry), 85);
    }

    @Test
    public void hasMultipleSpareNoStrike() {
        StraightForward straightForward = new StraightForward();

        List<Optional<Integer>> pinsPerTry = new ArrayList<>();

        addSpares(3, pinsPerTry, 3, 7);
        addTries(7, pinsPerTry, 3, 5);
        pinsPerTry.add(Optional.of(0));
        pinsPerTry.add(Optional.of(0));

        assertEquals(straightForward.getScore(pinsPerTry), 95);
    }

    @Test
    public void noSpareHasStrike() {
        StraightForward straightForward = new StraightForward();

        List<Optional<Integer>> pinsPerTry = new ArrayList<>();

        addStrikes(1, pinsPerTry);
        addTries(9, pinsPerTry, 3, 5);
        pinsPerTry.add(Optional.of(0));
        pinsPerTry.add(Optional.of(0));

        assertEquals(straightForward.getScore(pinsPerTry), 90);
    }

    @Test
    public void hasTenStrikes() {
        StraightForward straightForward = new StraightForward();

        List<Optional<Integer>> pinsPerTry = new ArrayList<>();

        addStrikes(10, pinsPerTry);
        pinsPerTry.add(Optional.of(3));
        pinsPerTry.add(Optional.of(5));

        assertEquals(straightForward.getScore(pinsPerTry), 281);
    }

    @Test
    public void hasTwelveStrikes() {
        StraightForward straightForward = new StraightForward();

        List<Optional<Integer>> pinsPerTry = new ArrayList<>();

        addStrikes(10, pinsPerTry);
        pinsPerTry.add(Optional.of(10));
        pinsPerTry.add(Optional.of(10));

        assertEquals(straightForward.getScore(pinsPerTry), 300);
    }

    @Test
    public void hasOnlyNinePinsEachTry() {
        StraightForward straightForward = new StraightForward();

        List<Optional<Integer>> pinsPerTry = new ArrayList<>();

        addTries(10, pinsPerTry, 9, 0);
        pinsPerTry.add(Optional.of(0));
        pinsPerTry.add(Optional.of(0));

        assertEquals(straightForward.getScore(pinsPerTry), 90);
    }

    @Test
    public void hasTenSpares() {
        StraightForward straightForward = new StraightForward();

        List<Optional<Integer>> pinsPerTry = new ArrayList<>();

        addSpares(10, pinsPerTry, 5, 5);
        pinsPerTry.add(Optional.of(5));
        pinsPerTry.add(Optional.of(0));

        assertEquals(straightForward.getScore(pinsPerTry), 150);
    }
}
