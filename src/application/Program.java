package application;

import application.ui.UI;
import chess.ChessMatch;

public class Program {
    public static void main(String[] args) throws Exception {
        limparTela();

        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
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
