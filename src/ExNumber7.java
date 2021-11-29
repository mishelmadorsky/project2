import java.util.Scanner;

public class ExNumber7 {
    public static final int SIZE_BOARD = 9;
    public static void main(String[] args){
        int turn = 2, countOfSymbolsOnBoard = 0;
        boolean isThereWinner = false;
        char symbol ='x';

        char[] board = new char[SIZE_BOARD];
        printBoard(board);
        do{
            int location = getPositionFromUser(board);
            isThereWinner = placeSymbolOnBoard(board, location, symbol);
            countOfSymbolsOnBoard++;
            if(turn ==1){
                symbol = 'x';
                turn = 2;
            }
            else{
                symbol = 'o';
                turn = 1;
            }
            if(countOfSymbolsOnBoard ==9){
                isThereWinner =true;
            }
            System.out.println("The game is over? "+isThereWinner);

        }
        while (!isThereWinner);
        if(countOfSymbolsOnBoard == 9 && checkWinner(board) !='x' && checkWinner(board) !='o') {
            System.out.println("Tie");
        }
    }

    public static void printBoard(char[] board) {
        System.out.print(board[0] + " " + board[1] + " " + board[2] +
                ("\n" + board[3] + " " + board[4] + " " + board[5]) +
                ("\n" + board[6] + " " + board[7] + " " + board[8]));
        System.out.println(" ");
    }

    public static boolean isAvailable(char[] board, int boardLocation) {
        if (board[boardLocation] == 'o' || board[boardLocation] == 'x') {
            return false;
        } else {
            return true;
        }
    }

    public static int getPositionFromUser(char[] board) {
        Scanner scanner= new Scanner(System.in);
        int location;
        do {
            System.out.println("Enter location");
            location = scanner.nextInt();
            if (location < 1 || location > 9) {
                System.out.println("Your choice is out of range");
            }
            else if (!isAvailable(board, location-1)){
                System.out.println("The location isn't available");
            }
        } while (location < 1 || location > 9 || !isAvailable(board, location-1));
        return location;
    }

    public static char checkWinner(char[] board) {
        for (int i = 0; i < board.length; i += 3) {
            if (board[i] == board[i + 1] && board[i + 1] == board[i + 2]) {
                return board[i];
            }
            break;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i] == board[i + 3] && board[i + 3] == board[i + 6]) {
                return board[i];
            }
            break;
        }
        if ((board[0] == board[4] && board[4] == board[8]) || (board[2] == board[4] && board[4] == board[6])) {
            return board[4];
        }

        return '-';
    }

    public static boolean placeSymbolOnBoard(char[] board, int locationBoard, char playerSymbol) {
        board[locationBoard-1] = playerSymbol;
        printBoard(board);

        if (checkWinner(board) == 'x') {
            System.out.println("The winner is player 1");
            return true;
        }else if(checkWinner(board)=='o') {
            System.out.println("The winner is player 2");
            return true;
        }
        return false;
    }
}