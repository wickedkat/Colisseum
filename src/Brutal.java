public class Brutal extends Gladiator {
    private double low = 0.75;
    private double high = 1.25;
    public Brutal(String name, int max, int lvl) {
        super(name, max, lvl);
        updateHP(high);
        updateSP(high);
        updateDEX(low);
    }

}