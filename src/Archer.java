public class Archer extends Gladiator {
    private double high = 1.25;
    public Archer(String name, int max, int lvl) {
        super(name, max, lvl);
        updateDEX( high);

    }
}

