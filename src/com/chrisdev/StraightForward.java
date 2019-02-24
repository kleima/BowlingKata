package com.chrisdev;

import java.util.List;

public class StraightForward {

    public int getScore(List<Integer> pinsPerTry) {
        int score = 0;

        for (int i = 0; i < 20; i = i + 2) {
            if (isStrike(pinsPerTry, i)) {
                score += pinsPerTry.get(i);
                score += pinsPerTry.get(i+2);

                if (pinsPerTry.get(i+3) != null) {
                    score += pinsPerTry.get(i+3);
                }
                else {
                    score += pinsPerTry.get(i+4);
                }
            } else if (isSpare( pinsPerTry, i)) {
                score += getScoreOfCurrentFrame(pinsPerTry, i);
                score += pinsPerTry.get(i + 2);
            } else {
                score += getScoreOfCurrentFrame(pinsPerTry, i);
            }
        }
        return score;
    }

    private boolean isStrike(List<Integer> pinsPerTry, int i) {
        return pinsPerTry.get(i).equals(10);
    }

    private boolean isSpare(List<Integer> pinsPerTry, int i) {
        return pinsPerTry.get(i) + pinsPerTry.get(i + 1) == 10;
    }

    private int getScoreOfCurrentFrame(List<Integer> pinsPerTry, int i) {
        return pinsPerTry.get(i) + pinsPerTry.get(i + 1);
    }
}
