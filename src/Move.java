public class Move {
    private String UCINotation;
    private String algebraicNotation;

    public Move(Board board, String move) {
        boolean isInUCINotation = move.matches("\\[a-h]\\[1-8]\\[a-h]\\[1-8][qrbn]?");
        boolean isInAlgebraicNotation = move.matches("^(?:(K|[QRBN][a-h]?[1-8]?|[a-h])?(?:(?<=K|[QRBN]|[QRBN][a-h]|[QRBN][1-8]|[QRBN][a-h][1-8]|[a-h])(x))?([a-h][1-8])=?([QRBN])?(\\+{1,2}|#)?|(O-O-O|O-O|0-0-0|0-0))$");
        // Capture Group 1: piece involved in move
        // Capture Group 2: if a capture is being made
        // Capture Group 3: square being captured
        // Capture Group 4: if a promotion occurs
        // Capture Group 5: if a check or checkmate occurs
        // Capture Group 6: if castling occurs
        // Note: This regex can only eliminate improperly formatted moves, and can not verify if a move being made is legal
    }
}
