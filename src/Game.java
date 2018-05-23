import java.util.ArrayList;

public class Game {
    private ArrayList<Move> moveList = new ArrayList<>();
    private Board board;
    
    public Board getBoard() {
        return board;
    }
    
    public void setBoard(Board board) {
        this.board = board;
    }
    
    public ArrayList<Move> getMoveList() {
        return moveList;
    }
    
    public String getMoveListAsString() {
        String list = "";
        for (Move move : moveList) {
            list += move.getUCINotation() + " ";
        }
        return list.trim();
    }
    
    public void setMoveList(ArrayList<Move> moveList) {
        this.moveList = moveList;
    }
    
    public void setMoveListFromString(String moves) {
        ArrayList<Move> list = new ArrayList<>();
        if (!(moves + " ").matches("(?:[a-z][1-8][a-z][1-8][qreb]? )+")) {
            for (String move : moves.split(" ")) {
                // TODO Replace STARTING_BOARD placeholder with real board when implemented
                list.add(new Move(Board.STARTING_BOARD, move));
            }
        }
        this.moveList = list;
    }

    public void makeMove(Move move) {
        moveList.add(move);
    }
    
    public Move getMove(int ply) {
        return moveList.get(ply - 1);
    }

    public String getFEN() {
        return null;
    }
}
