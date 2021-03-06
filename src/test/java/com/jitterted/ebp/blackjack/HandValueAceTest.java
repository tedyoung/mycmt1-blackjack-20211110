package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

    private static final Suit DUMMY_SUIT = Suit.CLUBS;

    @Test
    public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
        Hand hand = createHandWithRanksOf("A", "5");

        assertThat(hand.value())
                .isEqualTo(11 + 5);
    }

    @Test
    public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
        Hand hand = createHandWithRanksOf("A", "8", "3");

        assertThat(hand.value())
                .isEqualTo(1 + 8 + 3); // EVIDENT DATA
    }

    @Test
    public void handWithAceAndOtherCardsValuedAt10IsValuedAt21() throws Exception {
        Hand hand = createHandWithRanksOf("A", "J");

        assertThat(hand.value())
                .isEqualTo(11 + 10);
    }

    @Test
    public void handWithAceAndOtherCardsValuedAt12IsValuedAt13() throws Exception {
        Hand hand = createHandWithRanksOf("A", "7", "5");

        assertThat(hand.value())
                .isEqualTo(1 + 7 + 5);
    }

    private Hand createHandWithRanksOf(String... ranks) {
        List<Card> cards = new ArrayList<>();
        for (String rank : ranks) {
            cards.add(new Card(DUMMY_SUIT, rank));
        }
        return new Hand(cards);
    }
}
