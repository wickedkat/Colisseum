import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Colisseum! How many stages of the Tournament do you wish to watch? (2-20)");
        String stagesUserInput = scanner.nextLine();
        int stages = Integer.parseInt(stagesUserInput);
        if (stages <= 1 || stages > 20) {
            throw new Exception("Incorrect number input");
        }

            Simulation simulation = new Simulation(stages);
            simulation.simulateTournament();

    }
}