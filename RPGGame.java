public class RPGGame {
    public static void main(String[] args) {
        Character knight = new Knight("Knight", 100, 50);
        Character archer = new Archer("Archer", 80, 60);
        Character fairy = new Fairy("Fairy", 70, 100);
        Character orc = new Orc("Orc", 120, 30);
        Character elf = new Elf("Elf", 90, 80);
        Character dragon = new Dragon("Dragon", 150, 40);
        Character goblin = new Goblin("Goblin", 60, 30);

        Character[] characters = { knight, archer, fairy, orc, elf, dragon, goblin };

        // Demonstrate polymorphism
        for (Character character : characters) {

            // Attacking the dragon
            character.attack(dragon);

            // Using skill on the dragon if possible
            if (character instanceof Hero) {
                Hero hero = (Hero) character;
                if (hero.canUseSkill()) {
                    hero.skill(dragon);
            }

            System.out.println();
        }

        // Healing demonstration
        if (fairy instanceof Healingable) {
            Healingable healer = (Healingable) fairy;
            healer.heal(orc);
        }

        if (elf instanceof Healingable) {
            Healingable healer = (Healingable) elf;
            healer.heal(knight);
            System.out.println(knight);
        }

        if (elf instanceof Elf) {
            Elf elfCharacter = (Elf) elf;
            elfCharacter.recover();
            System.out.println(elfCharacter);

        Item potion = new Potion();
        Item ether = new Ether();
        Item elixir = new Elixir();
        Item remedy = new Remedy();
        Item antidote = new Antidote();

        knight.useItem(potion);
        System.out.println(knight);

        elf.useItem(ether);
        System.out.println(elf);

        fairy.useItem(elixir);
        System.out.println(fairy);

        dragon.applyStatus(new Poison());
        System.out.println(dragon);

        dragon.useItem(remedy);
        System.out.println(dragon);

        goblin.applyStatus(new Poison());
        System.out.println(goblin);

        goblin.useItem(antidote);
        System.out.println(goblin);
        }
    }
}
}