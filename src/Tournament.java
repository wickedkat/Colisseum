import java.util.ArrayList;
import java.util.List;

public class Tournament {
    List<Combat> allCombats = new ArrayList<>();
    List<Gladiator> allGladiators = new ArrayList<>();
    private int stages;
    List<String> listFullNames = new ArrayList<>();
    private String[] listNames = new String[]{"Attticus",
            "Augustus", "Brutus", "Cassius",
            "Caton", "Decimus", "Flavius",
            "Felix", "Jupiter", "Magnus",
            "Marcellus", "Maximus", "Octavius",
            "Romulus", "Septimus", "Severus",
            "Spartacus", "Thelonius", "Tiberius",
            "Titus", "Amulius", "Cantius",
            "Gemellus", "Tullus", "Opsius",
            "Photius", "Flavius", "Papinius",
            "Pompolussa", "Floronius", "Donicus",
            "Vopiscus", "Antonius", "Acilianus",
            "Placus", "Lusius", "Fastidius",
            "Opiter", "Vagennius", "Caius",
            "Pomptinus", "Remus", "Hostus",
            "Laetorius", "Flaccus", "Tertius"};

    public Tournament(int stages) {
        this.stages = stages;
        createGladiators(101,21);
        double stageCombats = Math.pow(2, stages - 1);
        createStageCombats(allGladiators,allCombats, stageCombats);
    }

    public List<Combat> getAllCombats() {
        return allCombats;
    }

    public List<Gladiator> getAllGladiators() {
        return allGladiators;
    }

    public int getStages() {
        return stages;
    }

    public String setName() {
        int randIndex1 = (int) Math.floor(Math.random() * listNames.length);
        int randIndex2 = (int) Math.floor(Math.random() * listNames.length);
        String gladiatorName = listNames[randIndex1] + " " + listNames[randIndex2];
        while (listFullNames.contains(gladiatorName)) {
            gladiatorName = listNames[randIndex1 - 1] + " " + listNames[randIndex2 + 1];
            listFullNames.add(gladiatorName);
        }
        listFullNames.add(gladiatorName);
        return gladiatorName;

    }

    public int setRandomNumber(int max) {
        return (int) Math.floor((Math.random() * max) + 1);

    }

    public void createGladiators(int maxStat, int maxLvl) {
        int gladiatorsNumber = (int) Math.pow(2, (double) stages);
        for (int i = 0; i < gladiatorsNumber; i++) {
            int gladiatorType = (int) Math.floor((Math.random() * 4) + 1);
            switch (gladiatorType) {
                case 1:
                    allGladiators.add(new Swordsman(setName(), maxStat + 1, maxLvl + 1));
                    break;
                case 2:
                    allGladiators.add(new Archer(setName(), maxStat + 1, maxLvl + 1));
                    break;
                case 3:
                    allGladiators.add(new Assasin(setName(), maxStat + 1, maxLvl + 1));
                    break;
                case 4:
                    allGladiators.add(new Brutal(setName(), maxStat + 1, maxLvl + 1));
                    break;
            }
        }


    }

    public void createStageCombats(List<Gladiator> listGladiators, List<Combat> stageCombatList, double combatsInStage) {
        int j = 0;
        for (int i = 0; i < combatsInStage; i++) {
            stageCombatList.add(new Combat(listGladiators.get(j), listGladiators.get(j + 1)));
            if (j < listGladiators.size()) {
                j += 2;
            }

        }
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
}}
