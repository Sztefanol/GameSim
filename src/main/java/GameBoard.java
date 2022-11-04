//Iniclalizuje, przechowuje planszę, jak i stan jej zapełnienia

public class GameBoard {

    private GameBoardSymbols[][] board;
    private int size;
    private int numberOfMoves;

    public GameBoard(int size) {

        this.size = size;
        this.board = new GameBoardSymbols[size][size];
        this.numberOfMoves = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = GameBoardSymbols.EMPTY;
            }
        }
    }

    public GameBoardSymbols[][] getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addMove(int x, int y, GameBoardSymbols symbol) {
        board[x][y] = symbol;
        numberOfMoves++;
    }

    public boolean isBoardFull() {
        return numberOfMoves == size * size;
    }
}
