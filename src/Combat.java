import java.util.Random;

public class Combat {
    private Gladiator gladiator1;
    private Gladiator gladiator2;


    public Combat(Gladiator gladiator1, Gladiator gladiator2) {
        this.gladiator1 = gladiator1;
        this.gladiator2 = gladiator2;
    }

    public void simulateCombat( int i) {
        gladiator1.setCurrentHP();
        gladiator2.setCurrentHP();

        System.out.println("COMBAT no " + i);
        while (this.gladiator1.getCurrentHP() > 0 && this.gladiator2.getCurrentHP() > 0) {
            combatTurn();

        }
    }

    public void combatTurn() {
        attackOrMiss(this.gladiator1, this.gladiator2);
        if (this.gladiator2.getCurrentHP() > 0) {
            attackOrMiss(this.gladiator2, this.gladiator1);
        }
    }

    public void attackOrMiss(Gladiator activeGladiator, Gladiator passiveGladiator) {
        double chance = activeGladiator.getDEX();
        double random = Math.floor((Math.random() * 21) + 1);
        if (random <= chance) {
            Random r = new Random();
            double damageMultiplier = (r.nextInt(5)) / 10.0 + 0.1;
            double dmg = Math.floor(damageMultiplier * activeGladiator.getCurrentSP());
            passiveGladiator.damageHP(dmg);
            System.out.println(activeGladiator.getName() + " attacks at " + dmg + " dmg.");
            checkWinningCondition(activeGladiator, passiveGladiator);


        }
    }

    public void checkWinningCondition(Gladiator activeGladiator, Gladiator passiveGladiator) {
        if (passiveGladiator.getCurrentHP() <= 0) {
            activeGladiator.setWinner(true);
            passiveGladiator.setWinner(false);
            activeGladiator.upgradeLVL();
            System.out.println(passiveGladiator.getName() + " dies. " + activeGladiator.getName() + " wins!");

        } else {
            System.out.println(activeGladiator.getName() + " misses.");
        }
    }
}
