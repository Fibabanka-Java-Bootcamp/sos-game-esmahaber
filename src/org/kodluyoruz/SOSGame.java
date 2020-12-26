package org.kodluyoruz;

public class SOSGame {
    int computerPoint = 0;
    int userPoint = 0;
    int selectRow;
    int selectColumn;
    int boardRow;
    int boardColumn;
    int totalBox;
    String userName;
    String computerCharacter;
    String userCharacter;

    public SOSGame(String userName, int boardRow, int boardColumn){
        this.userName = userName;
        this.boardRow = boardRow;
        this.boardColumn = boardColumn;
    }

    public void setBoard(int row, int column, String [][]board)
    {
        for(int i = 0 ; i <= row ; i++){
            for(int j = 0; j <= column; j++){
                board[0][j] = String.valueOf(j);
                board[i][0] = String.valueOf(i);;
            }
        }
        for(int k = 1 ; k <= row ; k++){
            for(int j = 1; j <= column; j++){
                board[k][j] = " ";
            }
        }
    }

    public void boardPrint(int row, int column, String [][]board, int computerPoint, int userPoint)
    {
        System.out.println("Computer = " + computerPoint + " " + userName + " = " + userPoint );
        System.out.println("----------------------------------" );
        for(int i = 0 ; i <= row ; i++){
            for(int j = 0; j <= column; j++){
                System.out.print(board[i][j] + " | ");

            }
            System.out.println("");
        }
        System.out.println("----------------------------------" );

    }

    public String[][] playerComputer(int row, int column, String [][]board )
    {
        if(totalBox > 0){
            boolean check;
            totalBox--;
            System.out.println(totalBox);


            int randomRow, randomColumn;
            do {
                System.out.println("do comp");
                randomRow = (int)(1 + Math.random()*row);
                randomColumn = (int)(1 + Math.random()*column);
            }while(isEmpty(randomRow, randomColumn, board));

            board[randomRow][randomColumn] = computerCharacter;

            check = false;

            if(check){
                System.out.println("Computer check true");
                computerPoint++;
                boardPrint(row, column, board, computerPoint, userPoint);
                return playerComputer(row, column, board);
            }else{
                boardPrint(row, column, board, computerPoint, userPoint);
            }
        }else{
            //set game over
        }

        return board;
    }

    public boolean isEmpty(int row, int column, String [][]board )
    {
        if(board[row][column] != " ")
            return true;

        return false;
    }

    public void startGame (){
        String [][]board = new String[boardRow+1][boardColumn+1];
        totalBox = (boardRow * boardColumn);
        setBoard(boardRow, boardColumn, board);

        // 0 = computer , 1 = user
        int playerBegin = (int)Math.round((Math.random()));

        String []character = {"S","O"};
        int randomInt = (int)Math.round((Math.random()));
        String randomCharacter = character[randomInt];
        computerCharacter = randomCharacter;

        if(randomCharacter.equals("S"))
            userCharacter = "O";
        else
            userCharacter = "S";

        System.out.println("Computer's character: " + computerCharacter);
        System.out.println(userName + "'s character: " + userCharacter);

        boardPrint(boardRow, boardColumn, board, computerPoint, userPoint);

        if(playerBegin == 0){
            playerComputer(boardRow, boardColumn, board);
        }else if(playerBegin == 1){
            //set user player metod
        }


    }
}
