public class Ether implements Item {
    @Override
    public void use(Character target) {
        System.out.printf("%s menggunakan Ether.\n", target.name);
        target.hp += 100;
        System.out.println("MP " + target.name + " bertambah sebesar 100.");
    }
}