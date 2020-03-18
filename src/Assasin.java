public class Assasin extends Gladiator {
    private double low = 0.75;
    private double high = 1.25;
    public Assasin(String name, int max, int lvl) {
        super(name, max, lvl);
        updateHP(low);
        updateSP(high);
        updateDEX(high);
    }

}
