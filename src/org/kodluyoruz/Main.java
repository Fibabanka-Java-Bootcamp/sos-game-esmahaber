package org.kodluyoruz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int boardColumn, boardRow;

        System.out.println("Welcome To SOS Game!");
        System.out.println("Please enter your name:");
        String userName = scanner.nextLine();

        do {
            System.out.println("Enter the row size (min:3 max:7) :");
            boardRow = scanner.nextInt();
            if(boardRow < 3 || boardRow > 7) System.out.println("Please enter a valid number!");
        }while(boardRow < 3 || boardRow > 7);

        do {
            System.out.println("Enter the column size (min:3 max:7) :");
            boardColumn = scanner.nextInt();
            if(boardColumn < 3 || boardColumn > 7) System.out.println("Please enter a valid number!");
        }while(boardColumn < 3 || boardColumn > 7);

        SOSGame SOSGame = new SOSGame(userName, boardRow, boardColumn);
        SOSGame.startGame();
    }
}
