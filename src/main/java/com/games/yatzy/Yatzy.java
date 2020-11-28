package com.games.yatzy;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Map.*;
import static java.util.stream.Collectors.*;

public class Yatzy {

    public static int chance(DiceHand diceHand) {
        return diceHand.stream().mapToInt(Integer::intValue).sum();
    }

    public static int yatzy(DiceHand dice) {
        return dice.stream().distinct().count() == 1 ? 50 : 0;
    }

    public static int getSumOf(DiceHand dice, int number) {
        return dice.stream().filter(i -> i == number).mapToInt(die -> number).sum();
    }

    public static int scorePair(DiceHand diceHand) {
        return getOfAKind(diceHand, 2).max().orElse(0) * 2;
    }

    public static int fourOfAKind(DiceHand diceHand) {
        return getOfAKind(diceHand, 4).findFirst().orElse(0) * 4;
    }

    public static int threeOfAKind(DiceHand diceHand) {
        return getOfAKind(diceHand, 3).findFirst().orElse(0) * 3;
    }

    public static int smallStraight(DiceHand diceHand) {
        return getCount(diceHand).entrySet().stream().anyMatch(i -> i.getValue() > 1) ? 0 : 15;
    }

    public static int twoPair(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = new int[6];
        counts[d1 - 1]++;
        counts[d2 - 1]++;
        counts[d3 - 1]++;
        counts[d4 - 1]++;
        counts[d5 - 1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }

    private static IntStream getOfAKind(DiceHand diceHand, int i1) {
        return getCount(diceHand).entrySet().stream().filter(i -> i.getValue() >= i1).mapToInt(Entry::getKey);
    }

    private static Map<Integer, Long> getCount(DiceHand diceHand) {
        return diceHand.stream().collect(groupingBy(i -> i, counting()));
    }

}

class DiceHand implements Iterable<Integer> {
    private final int[] dice;

    public DiceHand(int d1, int d2, int d3, int d4, int d5) {
        this.dice = new int[]{d1, d2, d3, d4, d5};
    }

    @Override
    public Iterator<Integer> iterator() {
        return stream().iterator();

    }

    public Stream<Integer> stream() {
        return IntStream.of(this.dice).boxed();
    }

    @Override
    public String toString() {
        return Arrays.toString(dice);
    }
}


