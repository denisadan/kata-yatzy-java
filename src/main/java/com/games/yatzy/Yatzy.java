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

    public static int getSumOfN(DiceHand dice, int n) {
        return dice.stream().filter(i -> i == n).mapToInt(die -> n).sum();
    }

    public static int scorePair(DiceHand diceHand) {
        return nOfAKind(diceHand, 2).max().orElse(0) * 2;
    }

    public static int twoPair(DiceHand diceHand) {
        return nOfAKind(diceHand, 2).count() == 2 ? nOfAKind(diceHand, 2).sum() * 2 : 0;
    }

    public static int fourOfAKind(DiceHand diceHand) {
        return nOfAKind(diceHand, 4).findFirst().orElse(0) * 4;
    }

    public static int threeOfAKind(DiceHand diceHand) {
        return nOfAKind(diceHand, 3).findFirst().orElse(0) * 3;
    }

    public static int smallStraight(DiceHand diceHand) {
        return Set.of(1, 2, 3, 4, 5).equals(diceHand.stream().collect(toSet())) ? 15 : 0;
    }

    public static int largeStraight(DiceHand diceHand) {
        return Arrays.asList(2, 3, 4, 5, 6).equals(diceHand.stream().sorted().collect(toList())) ? 20 : 0;
    }

    public static int fullHouse(DiceHand diceHand) {
        return getCountMap(diceHand).entrySet().stream().filter(i -> i.getValue() == 2 || i.getValue() == 3).mapToInt(Entry::getKey).count() == 2 ? diceHand.stream().mapToInt(Integer::intValue).sum() : 0;
    }

    private static IntStream nOfAKind(DiceHand diceHand, int n) {
        return getCountMap(diceHand).entrySet().stream().filter(i -> i.getValue() >= n).mapToInt(Entry::getKey);
    }

    private static Map<Integer, Long> getCountMap(DiceHand diceHand) {
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


