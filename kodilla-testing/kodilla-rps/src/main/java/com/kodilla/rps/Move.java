package com.kodilla.rps;

import static java.time.chrono.JapaneseEra.values;

public enum Move {
    ROCK("Kamień", 1),
    PAPER("Papier", 2),
    SCISSORS("Nożyce", 3);

    private final String name;
    private final int key;

    Move(String name, int key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public int getKey() {
        return key;
    }

    public static Move fromKey(int key) {
        for (Move move : values()) {
            if (move.getKey() == key) {
                return move;
            }
        }
        return null;
    }

    public int compareWith(Move other) {
        if (this == other) {
            return 0;

        }
        switch (this) {
            case ROCK:
                return (other == SCISSORS) ? 1 : -1;
            case PAPER:
                return (other == ROCK) ? 1 : -1;
            case SCISSORS:
                return (other == PAPER) ? 1 : -1;
            default:
                return 0;
        }
    }
}
