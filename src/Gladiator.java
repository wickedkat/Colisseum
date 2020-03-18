import java.util.Arrays;

public abstract class Gladiator {
    private double BaseHP;
    private double BaseSP;
    private double BaseDEX;
    private double CurrentHP;
    private double LVL;
    private boolean winner;
    private String name;


    public Gladiator(String name, int max, int lvl) {
        this.BaseHP = setRandomNumber(max);
        this.BaseSP = setRandomNumber(max);
        this.BaseDEX = setRandomNumber(max);
        this.LVL = setRandomNumber(lvl);
        this.name = name;
        this.winner = false;
    }


    public String getName() {
        return name;
    }

    public int setRandomNumber(int max) {
        return (int) Math.floor((Math.random() * max) + 1);

    }

    public void updateSP(double multiplier) {
        if (multiplier <= 0) {
            multiplier = 1;
        }

        this.BaseSP = BaseSP * multiplier;
    }

    public void updateHP(double multiplier) {
        if (multiplier <= 0) {
            multiplier = 1;
        }
        this.BaseHP = BaseHP * multiplier;

    }

    public void updateDEX(double multiplier) {

        if (multiplier <= 0) {
            multiplier = 1;
        }
        this.BaseDEX = BaseDEX * multiplier;
    }

    public String[] getStats() {
        return new String[]{"HP " + this.BaseHP, "SP " + this.BaseSP, "DEX " + this.BaseDEX, "LVL " + this.LVL};
    }

    ;

    public double getCombatHP() {
        return CurrentHP;
    }

    public void setCurrentHP() {
        CurrentHP = BaseHP * LVL;
    }

    public void damageHP(double damage){
        CurrentHP -=damage;
    }

    public double getCurrentHP() {
        return CurrentHP;
    }

    public double getCurrentSP() {
        return BaseSP * LVL;
    }

    public double getDEX() {
        return BaseDEX;
    }

    public void upgradeLVL() {
        this.LVL += 1;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public String getGladiatorType() {

        return this.getClass().getSimpleName();
    }

    public void printGladiator() {
        System.out.println("Name: " + this.getName() + " type: " + this.getGladiatorType() + " stats: " +
                Arrays.toString(this.getStats()));
    }
}

