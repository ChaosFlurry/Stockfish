import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Game activeGame = new Game();
        Stockfish sfWhite = new Stockfish(activeGame);
        Stockfish sfBlack = new Stockfish(activeGame);
        
        for (int i = 0; i < 50; i++) {
            sfWhite.setGame(activeGame);
            Move whiteMove = sfWhite.getBestMove(10);
            System.out.println("White: " + whiteMove.getUCINotation());
            activeGame.makeMove(whiteMove);
            
            sfBlack.setGame(activeGame);
            Move blackMove = sfBlack.getBestMove(1000);
            System.out.println("Black: " + blackMove.getUCINotation());
            activeGame.makeMove(blackMove);
        }
        System.out.println("\n" + activeGame.getMoveListAsString());
    }
}
