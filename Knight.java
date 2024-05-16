public class Knight extends Hero {
    public Knight(String name, int hp, int mp) {
        super(name, hp, mp);
    }

    @Override
    public void attack(Character target) {
        System.out.println(this);
        System.out.printf("%s menyerang %s menggunakan metode attack.\n", name, target.name);
        target.hp -= 5;
        System.out.printf("HP %s berkurang sebesar 5.\n", target.name);
        System.out.println(target);
    }

    @Override
    public void skill(Character target) {
        if (canUseSkill()) {
            System.out.printf("Kemudian %s menggunakan skill.\n", name);
            target.hp -= 10;
            mp -= 10;
            System.out.printf("HP %s berkurang sebesar 10.\n", target.name);
            System.out.println(target);
        }
    }

    @Override
    protected int getSkillCost() {
        return 10;
    }
}