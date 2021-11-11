package com.jitterted.ebp.blackjack;

public class Wallet {

    private int balance;

    public Wallet() {
        balance = 0;
    }

    public boolean isEmpty() {
        return balance == 0;
    }

    public void addMoney(int amount) {
        requireGreaterThanZero(amount);
        balance += amount;
    }

    private void requireGreaterThanZero(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public int balance() {
        return balance;
    }

    // boolean canBet(int betAmount)

    public void bet(int betAmount) {
        requireSufficientBalance(betAmount);
        balance -= betAmount;
    }

    private void requireSufficientBalance(int betAmount) {
        if (betAmount > balance) {
            throw new IllegalStateException();
        }
    }
}
