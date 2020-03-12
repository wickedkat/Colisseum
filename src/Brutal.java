public class Brutal extends Gladiator {
    public Brutal() {
        updateHP(1.25);
        updateSP(1.25);
        updateDEX(0.75);
    }

    @Override
    public String getGladiatorType() {
        return "Brutal";
    }
}