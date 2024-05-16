public class Dragon extends Foe {
    public Dragon(String name, int hp, int mp) {
        super(name, hp, mp);
    }

    @Override
    public void attack(Character target) {
        System.out.println(this);
        System.out.printf("%s menyerang %s menggunakan metode attack.\n", name, target.name);
        target.hp -= 15;
        System.out.printf("HP %s berkurang sebesar 15.\n", target.name);
    }

    @Override
    public void skill(Character target) {
        if (canUseSkill() && mp >= getSkillCost()) {
            System.out.printf("Kemudian %s menggunakan skill.\n", name);
            target.hp -= 25;
            mp -= getSkillCost();
            System.out.printf("HP %s berkurang sebesar 25.\n", target.name);
        } else {
            System.out.println("Tidak cukup MP untuk menggunakan skill.");
        }
    }

    @Override
    protected int getSkillCost() {
        return 15;
    }
}