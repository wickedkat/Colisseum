import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tournament {
    List<List<Combat>> allCombats = new ArrayList<>();
    List<Gladiator> allGladiators = new ArrayList<>();
    private int stages;

    public Tournament(int stages) {
        this.stages = stages;
    }

    public void createAndExecuteCombats(int stages) {
        System.out.println("COMBATS STAGE 1");
        System.out.println("");
        List<Combat> firstStageList = new ArrayList<>();
        double stageCombats = Math.pow(2, stages - 1);
        createFirstStageCombats(allGladiators, firstStageList, stageCombats);
        allCombats.add(firstStageList);
        executeCombats(firstStageList);
        stageCombats /= 2;
        for (int i = 1; i < stages; i++) {
            System.out.println(" ");
            System.out.println("COMBATS STAGE " + (i + 1));
            System.out.println("");
            List<Combat> stageList = new ArrayList<>();
            createStageCombats(stageCombats, stageList, createWinnersList());
            allCombats.add(stageList);
            executeCombats(stageList);
            if (stageCombats > 1) {
                stageCombats /= 2;
            }
        }
    }

    public void createFirstStageCombats(List<Gladiator> allGladiators, List<Combat> stageList, double stageCombats) {
        int j = 0;
        for (int i = 0; i < stageCombats; i++) {
            stageList.add(new Combat(allGladiators.get(j), allGladiators.get(j + 1)));
            if (j < allGladiators.size()) {
                j += 2;
            }

        }

    }

    public void createStageCombats(double stageCombats, List<Combat> stageList, List<Gladiator> winnersList) {
        int j = 0;
        for (int i = 0; i < stageCombats; i++) {
            stageList.add(new Combat(winnersList.get(j), winnersList.get(j + 1)));
            if (j < winnersList.size()) {
                j += 2;
            }
        }
    }

    public void executeCombats(List<Combat> stagelist){
        int combatNumber = 1;
        for (Combat combat : stagelist
        ) {
            combat.simulateCombat(combat, combatNumber);
            combatNumber += 1;

        }
    }

    public void createGladiators() {
        int gladiatorsNumber = (int) Math.pow(2, (double) stages);
        for (int i = 0; i < gladiatorsNumber; i++) {
            int gladiatorType = (int) Math.floor((Math.random() * 4) + 1);
            switch (gladiatorType) {
                case 1:
                    allGladiators.add(new Swordsman());
                    break;
                case 2:
                    allGladiators.add(new Archer());
                    break;
                case 3:
                    allGladiators.add(new Assasin());
                    break;
                case 4:
                    allGladiators.add(new Brutal());
                    break;
            }
        }
        printGladiators(this);
    }

    public void printGladiators(Tournament tournament) {
        System.out.println("These are " + tournament.getAllGladiators().size() + " GLADIATORS fighting in the tournament: ");
        for (Gladiator gladiator : tournament.getAllGladiators()
        ) {
            System.out.println("Name: " + gladiator.getName() + " type: " + gladiator.getGladiatorType() + " stats: " +
                    Arrays.toString(gladiator.getStats()));

        }

    }

    public List<Gladiator> getAllGladiators() {
        return allGladiators;
    }

    public void simulateTournament(int stages) {
        createGladiators();
        createAndExecuteCombats(stages);
        printTheWinner(createWinnersList());

    }

    public List<Gladiator> createWinnersList() {
        List<Gladiator> winnersList = new ArrayList<>();
        for (Gladiator gladiator : getAllGladiators()
        ) {
            if (gladiator.isWinner()) {
                winnersList.add(gladiator);
            }

        }
        return winnersList;


    }
    public void printTheWinner(List<Gladiator> winnerList){
        Gladiator winner = winnerList.get(0);
        System.out.println(winner.getName() + " WINS THE TOURNAMENT!!!");

    }
}
