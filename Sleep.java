public class Sleep implements Status {
    @Override
    public void applyStatus(Character character) {
        System.out.printf("%s terkena status SLEEP.\n", character.getName());
        character.setStatus(this);
    }

    @Override
    public void removeStatus(Character character) {
        System.out.printf("Status SLEEP pada %s dihilangkan.\n", character.getName());
        character.setStatus(null); // Menghapus status SLEEP
    }
    
    @Override
    public String getStatusName() {
        return "SLEEP";
    }
}