package com.games.yatzy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YatzyTest {

    @Test
    public void test_chance() {
        assertEquals(15, Yatzy.chance(new DiceHand(2, 3, 4, 5, 1)));
        assertEquals(16, Yatzy.chance(new DiceHand(3, 3, 4, 5, 1)));
    }

    @Test
    public void test_yatzy() {
        assertEquals(0, Yatzy.yatzy(new DiceHand(6, 6, 6, 6, 3)));
        assertEquals(50, Yatzy.yatzy(new DiceHand(6, 6, 6, 6, 6)));
        assertEquals(50, Yatzy.yatzy(new DiceHand(4, 4, 4, 4, 4)));
    }

    @Test
    public void test_ones() {
        assertEquals(1, Yatzy.getSumOfN(new DiceHand(1, 2, 3, 4, 5), 1));
        assertEquals(2, Yatzy.getSumOfN(new DiceHand(1, 2, 1, 4, 5), 1));
        assertEquals(0, Yatzy.getSumOfN(new DiceHand(6, 2, 2, 4, 5), 1));
        assertEquals(4, Yatzy.getSumOfN(new DiceHand(1, 2, 1, 1, 1), 1));
    }

    @Test
    public void test_twos() {
        assertEquals(4, Yatzy.getSumOfN(new DiceHand(1, 2, 3, 2, 6), 2));
        assertEquals(10, Yatzy.getSumOfN(new DiceHand(2, 2, 2, 2, 2), 2));
    }

    @Test
    public void test_threes() {
        assertEquals(6, Yatzy.getSumOfN(new DiceHand(1, 2, 3, 2, 3), 3));
        assertEquals(12, Yatzy.getSumOfN(new DiceHand(2, 3, 3, 3, 3), 3));
    }

    @Test
    public void test_fours() {
        assertEquals(12, Yatzy.getSumOfN(new DiceHand(4, 4, 4, 5, 5), 4));
        assertEquals(8, Yatzy.getSumOfN(new DiceHand(4, 4, 5, 5, 5), 4));
        assertEquals(4, Yatzy.getSumOfN(new DiceHand(4, 5, 5, 5, 5), 4));
    }

    @Test
    public void test_fives() {
        assertEquals(10, Yatzy.getSumOfN(new DiceHand(4, 4, 4, 5, 5), 5));
        assertEquals(15, Yatzy.getSumOfN(new DiceHand(4, 4, 5, 5, 5), 5));
        assertEquals(20, Yatzy.getSumOfN(new DiceHand(4, 5, 5, 5, 5), 5));
    }

    @Test
    public void test_sixes() {
        assertEquals(0, Yatzy.getSumOfN(new DiceHand(4, 4, 4, 5, 5), 6));
        assertEquals(6, Yatzy.getSumOfN(new DiceHand(4, 4, 6, 5, 5), 6));
        assertEquals(18, Yatzy.getSumOfN(new DiceHand(6, 5, 6, 6, 5), 6));
    }

    @Test
    public void test_score_pair() {
        assertEquals(6, Yatzy.scorePair(new DiceHand(3, 4, 3, 5, 6)));
        assertEquals(10, Yatzy.scorePair(new DiceHand(5, 3, 3, 3, 5)));
        assertEquals(12, Yatzy.scorePair(new DiceHand(5, 3, 6, 6, 5)));
        assertEquals(12, Yatzy.scorePair(new DiceHand(5, 6, 6, 6, 6)));
        assertEquals(12, Yatzy.scorePair(new DiceHand(6, 6, 6, 6, 6)));
    }

    @Test
    public void test_two_pairs() {
        assertEquals(16, Yatzy.twoPair(new DiceHand(3, 3, 5, 4, 5)));
        assertEquals(16, Yatzy.twoPair(new DiceHand(3, 3, 5, 5, 5)));
        assertEquals(0, Yatzy.twoPair(new DiceHand(1, 2, 3, 4, 5)));
        assertEquals(0, Yatzy.twoPair(new DiceHand(1, 1, 1, 1, 5)));
    }

    @Test
    public void test_three_of_a_kind() {
        assertEquals(9, Yatzy.threeOfAKind(new DiceHand(3, 3, 3, 4, 5)));
        assertEquals(15, Yatzy.threeOfAKind(new DiceHand(5, 3, 5, 4, 5)));
        assertEquals(9, Yatzy.threeOfAKind(new DiceHand(3, 3, 3, 3, 5)));
        assertEquals(9, Yatzy.threeOfAKind(new DiceHand(3, 3, 3, 3, 3)));
    }

    @Test
    public void test_four_of_a_kind() {
        assertEquals(12, Yatzy.fourOfAKind(new DiceHand(3, 3, 3, 3, 5)));
        assertEquals(20, Yatzy.fourOfAKind(new DiceHand(5, 5, 5, 4, 5)));
        assertEquals(20, Yatzy.fourOfAKind(new DiceHand(5, 5, 5, 5, 5)));
    }

    @Test
    public void test_smallStraight() {
        assertEquals(15, Yatzy.smallStraight(new DiceHand(1, 2, 3, 4, 5)));
        assertEquals(15, Yatzy.smallStraight(new DiceHand(2, 3, 4, 5, 1)));
        assertEquals(0, Yatzy.smallStraight(new DiceHand(1, 2, 2, 4, 5)));
        assertEquals(15, Yatzy.smallStraight(new DiceHand(5, 4, 3, 2, 1)));
        assertEquals(0, Yatzy.smallStraight(new DiceHand(6, 2, 3, 4, 5)));
    }

    @Test
    public void test_largeStraight() {
        assertEquals(20, Yatzy.largeStraight(new DiceHand(6, 2, 3, 4, 5)));
        assertEquals(20, Yatzy.largeStraight(new DiceHand(2, 3, 4, 5, 6)));
        assertEquals(0, Yatzy.largeStraight(new DiceHand(1, 2, 2, 4, 5)));
    }

    @Test
    public void test_fullHouse() {
        assertEquals(18, Yatzy.fullHouse(new DiceHand(6, 2, 2, 2, 6)));
        assertEquals(9, Yatzy.fullHouse(new DiceHand(1, 1, 1, 3, 3)));
        assertEquals(0, Yatzy.fullHouse(new DiceHand(2, 3, 4, 5, 6)));
    }

}