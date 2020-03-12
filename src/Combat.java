import java.util.Random;

public class Combat {
    private Gladiator gladiator1;
    private Gladiator gladiator2;


    public Combat(Gladiator gladiator1, Gladiator gladiator2) {
        this.gladiator1 = gladiator1;
        this.gladiator2 = gladiator2;
    }

    public void simulateCombat(Combat combat, int i) {
        System.out.println("COMBAT no " + i);
        combat.gladiator1.setCombatHP(combat.gladiator1.getCurrentHP());
        combat.gladiator2.setCombatHP(combat.gladiator2.getCurrentHP());
        while (combat.gladiator1.getCombatHP() > 0 && combat.gladiator2.getCombatHP() > 0) {
            combatTurn(this);

        }
    }

    public void combatTurn(Combat combat) {
        attackOrMiss(combat.gladiator1, combat.gladiator2);
        if (combat.gladiator2.getCombatHP() > 0) {
            attackOrMiss(combat.gladiator2, combat.gladiator1);
        }
    }

    public void attackOrMiss(Gladiator activeGladiator, Gladiator passiveGladiator) {
        double chance = activeGladiator.getDEX();
        double random = Math.floor((Math.random() * 101) + 1);
        if (random <= chance) {
            Random r = new Random();
            double damageMultiplier = (r.nextInt(5)) / 10.0 + 0.1;
            double dmg = Math.floor(damageMultiplier * activeGladiator.getCurrentSP());
            passiveGladiator.setCombatHP(passiveGladiator.getCombatHP() - dmg);
            System.out.println(activeGladiator.getName() + " attacks at " + dmg + " dmg.");
            checkWinningCondition(activeGladiator, passiveGladiator);


        }
    }

    public void checkWinningCondition(Gladiator activeGladiator, Gladiator passiveGladiator) {
        if (passiveGladiator.getCombatHP() <= 0) {
            activeGladiator.setWinner(true);
            passiveGladiator.setWinner(false);
            activeGladiator.upgradeLVL();
            System.out.println(passiveGladiator.getName() + " dies. " + activeGladiator.getName() + " wins!");

        } else {
            System.out.println(activeGladiator.getName() + " misses.");
        }
    }
}
