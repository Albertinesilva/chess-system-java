package application;

import java.util.Scanner;

import application.ui.UI;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
    public static void main(String[] args) throws Exception {
        limparTela();
        Scanner sc = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("\t\tSource: ");
            ChessPosition source = UI.readChessPoition(sc);

            System.out.println();
            System.out.print("\t\tTarget: ");
            ChessPosition target = UI.readChessPoition(sc);

            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
        }
    }

    public static void limparTela() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            // Trata exceções (pode ser uma exceção de interrupção)
            e.printStackTrace();
        }
    }
}
