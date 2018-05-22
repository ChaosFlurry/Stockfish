import java.io.*;

public class Stockfish {
    private Game game;
    private BufferedReader engineOutputReader;
    private BufferedWriter engineInputWriter;

    public Stockfish(Game game) throws IOException {
        this.game = game;
        String enginePath = "C:\\Users\\John\\Desktop\\Stockfish\\stockfish-9-win\\Windows\\stockfish_9_x64_bmi2.exe";
        ProcessBuilder engineBuilder = new ProcessBuilder(enginePath);
        Process engine = engineBuilder.start();
        engineOutputReader = new BufferedReader(new InputStreamReader(engine.getInputStream()));
        engineInputWriter = new BufferedWriter(new OutputStreamWriter(engine.getOutputStream()));
    }

    public Move getBestMove() throws IOException {
        engineInputWriter.write("position " + game.getMoves() + "\n");
        engineInputWriter.flush();
        engineInputWriter.write("go" + "\n");
        engineInputWriter.flush();
        String engineOutput;
        Move bestMove = null;
        while ((engineOutput = engineOutputReader.readLine()) != null) {
            System.out.println(engineOutput);
            if (engineOutput.matches("bestmove \\w\\d\\w\\d ponder \\w\\d\\w\\d")) {
                bestMove = new Move(game.getBoard(), engineOutput.split(" ")[1]);
            }
        }
        return bestMove;
    }
}
