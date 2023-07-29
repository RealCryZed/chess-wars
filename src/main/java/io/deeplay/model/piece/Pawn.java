package io.deeplay.model.piece;

import io.deeplay.model.Board;

import java.util.List;

public class Pawn extends Piece {
    public Pawn(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public Color getColor() {
        return super.getColor();
    }

    @Override
    public List<Integer> getPossibleMoves(Board board) {
        return null;
    }

    @Override
    public boolean canMoveAt(int x, int y, Board board) {
        return false;
    }
}
