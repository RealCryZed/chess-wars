package io.deeplay.model.player;

import io.deeplay.domain.Color;
import io.deeplay.domain.GameStates;
import io.deeplay.domain.MoveType;
import io.deeplay.domain.SwitchPieceType;
import io.deeplay.engine.GameState;
import io.deeplay.model.Board;
import io.deeplay.model.Coordinates;
import io.deeplay.model.move.Move;
import io.deeplay.model.piece.Piece;
import io.deeplay.service.IUserCommunication;
import io.deeplay.service.UserCommunicationService;

import java.util.ArrayList;
import java.util.List;

import static io.deeplay.model.Board.BOARD_HEIGHT;
import static io.deeplay.model.Board.BOARD_LENGTH;

public class Human extends Player {
    private final IUserCommunication iUserCommunication;
    public Human(Color color, IUserCommunication iUserCommunication) {
        super(color, iUserCommunication);
        this.iUserCommunication = iUserCommunication;
    }

    /**
     * Возвращает созданный объект класса Move с заданными параметрами. Получает параметры из ввода пользователя
     *
     * @param board текущее состояние доски
     * @param currentColor цвет текущего хода
     * @return новый объект класса Move
     */
    @Override
    public Move getMove(Board board, Color currentColor) {
        List<Piece> possiblePiecesToMove = getPiecesPossibleToMove(board, currentColor);

        Piece selectedPiece = iUserCommunication.selectPiece(possiblePiecesToMove);
        List<Coordinates> availableMoves = selectedPiece.getPossibleMoves(board);
        List<Coordinates> movesWithoutCheck = GameState.getMovesWithoutMakingCheck(board, selectedPiece, availableMoves);
        availableMoves.retainAll(movesWithoutCheck);

        Coordinates moveCoordinates = iUserCommunication.selectCoordinates(availableMoves);

        MoveType moveType = getType(selectedPiece, moveCoordinates, board);
        SwitchPieceType selectedSwitchPiece = SwitchPieceType.NULL;
        if (moveType == MoveType.PROMOTION) selectedSwitchPiece = iUserCommunication.selectSwitchPiece();

        System.out.println("You selected " + selectedPiece.getColor().name() + " "
                + selectedPiece.getClass().getSimpleName() + " to move to coordinates x:" + moveCoordinates.getX()
                + " y:" + moveCoordinates.getY());

        return new Move(selectedPiece.getCoordinates(), moveCoordinates, moveType, selectedSwitchPiece);
    }

    /**
     * Метод для запроса на проигрыш
     */
    public void lose() {
        // surrender
    }
}
