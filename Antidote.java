public class Antidote implements Item {
    @Override
    public void use(Character character) {
        character.removeStatus(new Poison());
    }
    @Override
    public String toString() {
        return "Antidote";
    }
}