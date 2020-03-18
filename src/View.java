import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class View {
    public void printGladiators(List<Gladiator> gladiators){
        System.out.println("");
        System.out.println("These are " + gladiators.size() + " GLADIATORS fighting in the tournament: ");
        for (Gladiator gladiator: gladiators
             ) {
            System.out.println("Name: " +gladiator.getName() + " Type: " + gladiator.getGladiatorType()+ " Stats:" + Arrays.toString(gladiator.getStats()));

        }
        System.out.println("");
    }

    public void printWinner(Gladiator winner){
        System.out.println(winner.getName() +" WINS THE TOURNAMENT!");
    }

    public int welcomeAndGetStages(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Colisseum! How many stages of the Tournament do you wish to watch?");
        String stagesUserInput = scanner.nextLine();
        return Integer.parseInt(stagesUserInput);
    }
}
