public class Assasin extends Gladiator {
    public Assasin() {
        updateHP(0.75);
        updateSP(1.25);
        updateDEX(1.25);
    }

    @Override
    public String getGladiatorType() {
        return "Assasin";
    }
}
