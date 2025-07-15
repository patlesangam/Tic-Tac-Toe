public class Board {
    private final int size = 3;
    private char board[][];

    public Board(){
        board = new char[size][size];
        initializeboard();
    }

    public void initializeboard(){
        for (int i = 0; i<size;i++){
            for (int j = 0; j<size;j++){
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard(){
        System.out.println("____________");
        for (int i=0;i<size;i++){
            System.out.print("|");
            for (int j = 0; j<size; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n____________");
        }
    }

    public boolean isCellEmpty(int row, int col){
        return board[row][col] == ' ';
    }

    public void placMark(int row, int col, char mark){
        board[row][col] = mark;
    }

    public boolean checkWin(char mark){
        for (int i =0; i<size; i++){
            if ((board[i][0]==mark && board[i][1]==mark && board[i][2]==mark) ||
            (board[0][i]==mark && board[1][i]==mark && board[2][i]==mark))
                return true;
        }
        return (board[0][0]==mark && board[1][1]==mark && board[2][2]==mark) ||
                (board[0][2]==mark && board[1][1]==mark && board[2][0]==mark);
    }

    public boolean isFull(){
        for (int i = 0; i<size; i++){
            for (int j = 0; j<size; j++){
                if (board[i][j]==' '){
                    return false;
                }
            }
        }
        return true;
    }

}
