import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Colisseum! How many stages of the Tournament do you wish to watch?");
        String stages = scanner.nextLine();

        Tournament tournament = new Tournament(Integer.parseInt(stages));
        tournament.simulateTournament(Integer.parseInt(stages));



    }
}
