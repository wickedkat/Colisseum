public abstract class Gladiator {
    private double BaseHP;
    private double BaseSP;
    private double BaseDEX;
    private double LVL;
    private double CombatHP;
    private boolean winner;
    private String name;
    private String [] listNames = new String [] {"Attticus",
            "Augustus",
            "Brutus",
            "Cassius",
            "Caton",
            "Decimus",
            "Flavius",
            "Felix",
            "Jupiter",
            "Magnus",
            "Marcellus",
            "Maximus",
            "Octavius",
            "Romulus",
            "Septimus",
            "Severus",
            "Spartacus",
            "Thelonius",
            "Tiberius",
            "Titus"};

    public Gladiator() {
        this.BaseHP = setRandomNumber();
        this.BaseSP = setRandomNumber();
        this.BaseDEX = setRandomNumber();
        this.LVL = setRandomNumber();
        this.name = setName();
        this.winner = false;
    }

    public String setName(){
        int randIndex1 = (int) Math.floor(Math.random() * listNames.length);
        return listNames[randIndex1]+ setRandomNumber();
    }

    public String getName() {
        return name;
    }

    public int setRandomNumber(){
        return (int) Math.floor((Math.random() * 101) +1);

    }
    public void updateSP(double multiplier){
        this.BaseSP = BaseSP*multiplier;
    }

    public void updateHP(double multiplier){
        this.BaseHP = BaseHP *multiplier;

    }

    public void updateDEX(double multiplier){
        this.BaseDEX = BaseDEX*multiplier;
    }

    public String[] getStats() {
        String [] gladiatorStats = new String [] {"HP " + this.BaseHP, "SP " +this.BaseSP, "DEX " + this.BaseDEX, "LVL " + this.LVL};
        return gladiatorStats;
    };

    public double getCombatHP() {
        return CombatHP;
    }

    public void setCombatHP(double combatHP) {
        CombatHP = combatHP;
    }

    public double getCurrentHP(){
        return BaseHP * LVL;
    }

    public double getCurrentSP(){
        return  BaseSP*LVL;
    }

    public double getDEX() {
        return BaseDEX;
    }

    public void upgradeLVL(){
        this.LVL +=1;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public abstract String getGladiatorType();
}
