import java.io.IOException;
import java.io.InputStreamReader;

public class GameRun {

  public static void main(String[] args) throws IOException {
    GameBoard gameboard = new GameBoard(3);
    GameBoardManager gameBoardManager = new GameBoardManager(new RandomPlayer(), new RandomPlayer(),
        gameboard);
    InputStreamReader reader = new InputStreamReader(System.in);

    while (gameBoardManager.getGameState() == GameState.IN_GAME) {
      System.out.println("Ruch wykonuje gracz nr " + gameBoardManager.getCurrentTurnPlayerNumber());

      switch (gameBoardManager.gameStep()) {
        case MOVE_OK -> System.out.println("Gracz wykonał prawidłowy ruch");
        case ILLEGAL_MOVE -> System.out.println("Gracz wykonał niedozwolony ruch");
        case GAME_END -> System.out.println("Koniec gry");
      }

      System.out.println(GameBoardVisualizer.toString(gameboard));
      reader.read();
    }

    switch (gameBoardManager.getGameState()) {
      case DRAW -> System.out.println("Remis");
      case PLAYER_1_WON -> System.out.println("Gracz 1 wygrał");
      case PLAYER_2_WON -> System.out.println("Gracz 2 wygrał");
    }
  }
}
