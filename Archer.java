public class Archer extends Hero {
    public Archer(String name, int hp, int mp) {
        super(name, hp, mp);
    }

    @Override
    public void attack(Character target) {
        System.out.println(this);
        System.out.printf("%s menyerang %s menggunakan metode attack.\n", name, target.name);
        target.hp -= 10;
        System.out.printf("HP %s berkurang sebesar 10.\n", target.name);
        System.out.println(target);
    }

    @Override
    public void skill(Character target) {
        if (canUseSkill() && mp >= 15) { // Contoh: Skill membutuhkan minimal 15 MP
            System.out.printf("Kemudian %s menggunakan skill.\n", getName());
            target.receiveDamage(15); // Mengurangi HP target
            mp -= 15; // Mengurangi MP Archer
            System.out.printf("HP %s berkurang sebesar 15.\n", target.getName());
            System.out.println(target);
        } else {
            System.out.println("Tidak cukup MP untuk menggunakan skill.");
        }
    }

    @Override
    protected int getSkillCost() {
        return 8;
    }
}