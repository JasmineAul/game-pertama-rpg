public class Orc extends Foe {
    public Orc(String name, int hp, int mp) {
        super(name, hp, mp);
    }

    @Override
    public void attack(Character target) {
        System.out.println(this);
        System.out.printf("%s menyerang %s menggunakan metode attack.\n", name, target.name);
        target.hp -= 10;
        System.out.printf("HP %s berkurang sebesar 10.\n\n", target.name);
        System.out.println(target);
    }

    @Override
    public void skill(Character target) {
        if (canUseSkill() && mp >= 20) {
            System.out.printf("Kemudian %s menggunakan skill.\n\n", getName());
            target.receiveDamage(20); // Mengurangi HP target
            mp -= 20; // Mengurangi MP Orc
            System.out.printf("HP %s berkurang sebesar 20.\n", target.getName());
            System.out.println(target);
        } else {
            System.out.println("Tidak cukup MP untuk menggunakan skill.");
        }
    }

    @Override
    protected int getSkillCost() {
        return 10;
    }
}