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
    
    public Board(String[][] squares) {
        this.squares = squares;
    }

    public Board(String information) {
        String[][] squares = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = "";
            }
        }
        
        // TODO Complete FEN pattern
        if (information.matches("^([wb]) ([KQkq\\-]) ([a-h][1-8]|-) (\\d \\d)$")) {
            generateBoardFromFEN(information);
        } else if (information.matches("") {
            generateBoardFromAlgebraicNotation(information);
        } else if (information.matches(""))) {
            generateBoardFromUCINotation(information);
        }
    }

    private void generateBoardFromFEN(String FEN) {
        if (FEN.matches("^([wb]) ([KQkq\\-]) ([a-h][1-8]|-) (\\d \\d)$")) {
        
        } else {
            throw new IllegalArgumentException("Invalid FEN");
        }
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
    
    private void generateBoardFromAlgebraicNotation(String moves) {
    
    }
    
    private void generateBoardFromUCINotation(String moves) {
    
    }

    public String getFEN() {
    
    }
}
