package com.chrisdev;

import java.util.List;
import java.util.Optional;

class StraightForward {

    int getScore(List<Optional<Integer>> pinsPerTry) {
        int score = 0;

        for (int i = 0; i < 20; i = i + 2) {
            if (isStrike(pinsPerTry, i)) {
                score += pinsPerTry.get(i).get();
                score += pinsPerTry.get(i+2).get();

                if (pinsPerTry.get(i+3).isPresent()) {
                    score += pinsPerTry.get(i+3).get();
                }
                else {
                    score += pinsPerTry.get(i+4).get();
                }
            } else if (isSpare( pinsPerTry, i)) {
                score += getScoreOfCurrentFrame(pinsPerTry, i);
                score += pinsPerTry.get(i + 2).get();
            } else {
                score += getScoreOfCurrentFrame(pinsPerTry, i);
            }
        }
        return score;
    }

    private boolean isStrike(List<Optional<Integer>> pinsPerTry, int i) {
        return pinsPerTry.get(i).get().equals(10);
    }

    private boolean isSpare(List<Optional<Integer>> pinsPerTry, int i) {
        return pinsPerTry.get(i).get() + pinsPerTry.get(i + 1).get() == 10;
    }

    private int getScoreOfCurrentFrame(List<Optional<Integer>> pinsPerTry, int i) {
        return pinsPerTry.get(i).get() + pinsPerTry.get(i + 1).get();
    }
}
