import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Tournament {

    private enum STATE {
        SWAP,
        PLAYING,
        END
    }

    public static void main(String[] args) throws FileNotFoundException {
        STATE state = STATE.SWAP;
        Scanner scanner = new Scanner(System.in);
        PrintWriter p1 = new PrintWriter("Player1.txt");
        PrintWriter p2 = new PrintWriter("Player2.txt");
        PrintWriter p1score = new PrintWriter("Player1Score.txt");
        PrintWriter p2score = new PrintWriter("Player2Score.txt");
        int p1s = 0;
        int p2s = 0;
        String p1name;
        String p2name;
        while (state != STATE.END) {
            while (state == STATE.SWAP) {
                System.out.print("Enter player 1: ");
                p1name = scanner.next();
                System.out.println();
                System.out.print("Enter player 2: ");
                p2name = scanner.next();
                System.out.println();
                System.out.print("P1 : " + p1name + ". P2 : " + p2name + ". Are these names correct? Y/N ");
                switch (scanner.next()) {
                    case "Y":
                        p1 = new PrintWriter("Player1.txt");
                        p2 = new PrintWriter("Player2.txt");
                        p1score = new PrintWriter("Player1Score.txt");
                        p2score = new PrintWriter("Player2Score.txt");
                        p1.println(p1name);
                        p2.println(p2name);
                        p1.close();
                        p2.close();
                        p1s = 0;
                        p2s = 0;
                        p1score.print(p1s);
                        p2score.print(p2s);
                        p1score.close();
                        p2score.close();
                        state = STATE.PLAYING;
                        break;
                    default:
                        break;
                }
            }

            while (state == STATE.PLAYING) {
                System.out.print("Enter the winner: ");
                String winner = scanner.next();
                switch (winner) {
                    case "1":
                        p1s += 1;
                        break;
                    case "2":
                        p2s += 1;
                        break;
                }
                System.out.println();
                System.out.print("P1 : " + p1s + ". P2 : " + p2s + ". Are these correct? Y/N ");
                switch (scanner.next()) {
                    case "Y":
                        p1score = new PrintWriter("Player1Score.txt");
                        p2score = new PrintWriter("Player2Score.txt");
                        p1score.print(p1s);
                        p2score.print(p2s);
                        p1score.close();
                        p2score.close();
                        System.out.print("Are there any more games? Y/N ");
                        switch (scanner.next()) {
                            case "Y":
                                break;
                            default:
                                System.out.print("Are there any more matches in the tournament? Y/N ");
                                switch (scanner.next()) {
                                    case "Y":
                                        state = STATE.SWAP;
                                        break;
                                    default:
                                        state = STATE.END;
                                        break;
                                }
                        }
                        break;
                    default:
                        if (winner.equals("1")) {
                            p1s -= 1;
                        } else if (winner.equals("2")) {
                            p2s -= 1;
                        }
                        break;
                }
            }
        }
        p1.close();
        p2.close();
        p1score.close();
        p2score.close();
    }

}
