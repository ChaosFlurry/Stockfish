import java.io.*;

public class Stockfish {
    private Game game;
    private BufferedReader engineOutputReader;
    private BufferedWriter engineInputWriter;

    public Stockfish(Game game) throws IOException {
        this.game = game;
        String enginePath = "C:\\Users\\John\\Desktop\\Stockfish\\stockfish-9-win\\Windows\\stockfish_9_x64_popcnt.exe";
        ProcessBuilder engineBuilder = new ProcessBuilder(enginePath);
        Process engine = engineBuilder.start();
        engineOutputReader = new BufferedReader(new InputStreamReader(engine.getInputStream()));
        engineInputWriter = new BufferedWriter(new OutputStreamWriter(engine.getOutputStream()));

        // Stockfish 9 64 POPCNT by T. Romstad, M. Costalba, J. Kiiski, G. Linscott
        // position startpos moves [MOVES]
        // position fen [FEN]

        // bench 128 8 18
        // results:
        // bmi2: ~13 mil n/s
        // popcnt: ~13 mil n/s

        // https://www.reddit.com/r/chess/comments/7x79ys/syzygy_tablebases_with_stockfish_9/
    }
    
    public Game getGame() {
        return game;
    }
    
    public void setGame(Game game) {
        this.game = game;
    }

    public Move getBestMove() throws IOException {
        engineInputWriter.write("position startpos moves " + game.getMoveListAsString() + "\n");
        engineInputWriter.flush();
        engineInputWriter.write("go" + "\n");
        engineInputWriter.flush();
        String engineOutput;
        Move bestMove = null;
        while ((engineOutput = engineOutputReader.readLine()) != null) {
            System.out.println(engineOutput);
            if (engineOutput.matches("bestmove [a-h][1-8][a-h][1-8][qrbn]? ponder [a-h][1-8][a-h][1-8][qrbn]?")) {
                bestMove = new Move(game.getBoard(), engineOutput.split(" ")[1]);
                break;
            }
        }
        return bestMove;
    }
    
    public Move getBestMove(int time) throws IOException {
        engineInputWriter.write("position startpos moves " + game.getMoveListAsString() + "\n");
        engineInputWriter.flush();
        engineInputWriter.write("go movetime " + time + "\n");
        engineInputWriter.flush();
        String engineOutput;
        Move bestMove = null;
        while ((engineOutput = engineOutputReader.readLine()) != null) {
            System.out.println(engineOutput);
            if (engineOutput.matches("bestmove [a-h][1-8][a-h][1-8][qrbn]? ponder [a-h][1-8][a-h][1-8][qrbn]?")) {
                bestMove = new Move(game.getBoard(), engineOutput.split(" ")[1]);
                break;
            }
        }
        return bestMove;
    }
}
