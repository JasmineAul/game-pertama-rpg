public class Weak implements Status {
    @Override
    public void applyStatus(Character character) {
        character.receiveDamage(5); // Or any other implementation for applying weakness status
    }

    @Override
    public void removeStatus(Character character) {
        // No specific action needed to remove Weak status
    }
    @Override
    public String toString() {
        return "WeakStatus";
    }
    @Override
    public String getStatusName() {
        return "WEAK";
    }
}