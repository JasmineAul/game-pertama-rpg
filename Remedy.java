public class Remedy implements Item {
    @Override
    public void use(Character target) {
        System.out.printf("%s menggunakan Remedy.\n", target.getName());
        target.setStatus(null); // Menghilangkan semua status pada karakter
        System.out.println("Seluruh status pada " + target.getName() + " dihilangkan.");
    }   
}