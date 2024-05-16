public class Potion implements Item {
    @Override
    public void use(Character target) {
        System.out.printf("%s menggunakan Potion.\n", target.name);
        target.hp += 100;
        System.out.println("HP " + target.name + " bertambah sebesar 100.");
    }
}