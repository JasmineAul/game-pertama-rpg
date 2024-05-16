public class Elixir implements Item {
    @Override
    public void use(Character target) {
        System.out.printf("%s menggunakan Elixir.\n", target.name);
        target.hp += 150;
        target.mp += 100;
        System.out.println("HP " + target.name + " bertambah sebesar 150 dan MP bertambah sebesar 100.");
    }
}