import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    Tournament tournament;
    View view;

    public Simulation(int stages) {
        this.tournament = new Tournament(stages);
        this.view = new View();
    }

    public void simulateTournament(){
        view.printGladiators(tournament.getAllGladiators());
        System.out.println("COMBATS STAGE 1");
       executeCombats(tournament.getAllCombats());
        int stageCombats = tournament.allCombats.size()/2;
        for (int i = 1; i < tournament.getStages(); i++) {
            System.out.println(" ");
            System.out.println("COMBATS STAGE " + (i + 1));
            System.out.println("");
            List<Combat> stageList = new ArrayList<>();
            tournament.createStageCombats(tournament.createWinnersList(), stageList, stageCombats);
            executeCombats(stageList);
            if (stageCombats > 1) {
                stageCombats /= 2;
            }
        }
        view.printWinner(getWinner(tournament.createWinnersList()));

    }




    public void executeCombats(List<Combat> stagelist){
        int combatNumber = 1;
        for (Combat combat : stagelist
        ) {
            combat.simulateCombat(combatNumber);
            combatNumber += 1;

        }
    }

    public Gladiator getWinner(List<Gladiator> winnersList){
        return winnersList.get(0);

    }


}
