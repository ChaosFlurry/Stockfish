public class Board {
    private String[][] squares;
    private boolean whiteCanCaslteKingside;
    private boolean whiteCanCastleQueenside;
    private boolean blackCanCastleKingside;
    private boolean blackCanCastleQueenside;
    private boolean whiteToMove;
    private boolean enPassantSquareExists;
    private String enPassantSquare;
    private int halfMoves;
    private int fullMoves;

    public Board(String information, String format) {
        String[][] squares = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = "";
            }
        }
        if (format.equals("FEN")) {
            generateBoardFromFEN(information);
        }
    }

    private void generateBoardFromFEN(String FEN) {
        if (FEN.matches())
        String[] FENInfo = FEN.split(" ");
        for (int r = 8; r > 1; r--) {
            String rowPieces = FENInfo[0].split("/")[r - 8];
            for (int f = 1; f < 8; f++) {
                String piece = rowPieces.split("")[f - 1];
                if (piece.matches("[pnbrqkPNBRQK]")) {
                    squares[f - 1][r - 1] = piece;
                } else if (piece.matches("[1-8]")) {
                    f += Integer.parseInt(piece);
                } else {
                    throw new IllegalArgumentException("Invalid FEN");
                }
            }
        }


    }

    private void generateBoardFromMoves(String moves) {

    }

    public Board(String[][] squares) {

    }

    public String getFEN() {

    }
}
