public class Poison implements Status {
    @Override
    public void applyStatus(Character character) {
        character.receiveDamage(5);
    }

    @Override
    public void removeStatus(Character character) {
    }

    @Override
    public String toString() {
        return "Poison";
    }
    @Override
    public String getStatusName() {
        return "POISON";
    }
}