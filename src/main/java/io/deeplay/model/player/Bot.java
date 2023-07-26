<<<<<<< HEAD
package io.deeplay.model.player;

import io.deeplay.model.Board;
import io.deeplay.model.move.Move;

import java.util.List;
import java.util.Random;

public class Bot extends Player {
    private int difficultyLevel;
    private char piecesColor;

    public Bot(char piecesColor, int difficultyLevel) {
        super(piecesColor);
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Move move(List<Move> allPossibleMoves) {
        Random random = new Random();
        return allPossibleMoves.get(random.nextInt(allPossibleMoves.size() - 1));
    }

    public void chooseDifficultyLevel(int level) {
        switch (level) {
            case 1: // easy
                break;
            case 2: //medium
                break;
            case 3: //hard
                break;
            default: // incorrect input
                break;
        }
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "difficultyLevel=" + difficultyLevel +
                ", piecesColor=" + piecesColor +
                '}';
    }
}
=======
package io.deeplay.model;public class Bot {
}
>>>>>>> 0f73375 (created board, classes moveHistory and Player)
