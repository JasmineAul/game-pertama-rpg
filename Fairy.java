public class Fairy extends Hero implements Healingable  {
    public Fairy(String name, int hp, int mp) {
        super(name, hp, mp);
    }

    @Override
    public void attack(Character target) {
        System.out.println(this);
        System.out.printf("%s menyerang %s menggunakan metode attack.\n", name, target.name);
        target.hp -= 5;
        System.out.printf("HP %s berkurang sebesar 5.\n\n", target.name);
        System.out.println(target);
    }

    @Override
    public void skill(Character target) {
        if (canUseSkill()) {
            System.out.printf("Kemudian %s menggunakan skill.\n", name);
            target.hp -= 10;
            mp -= 10;
            System.out.printf("HP %s berkurang sebesar 10.\n\n", target.name);
            System.out.println(target);
        }
    }

    @Override
    public void heal(Character target) {
        System.out.println(this);
        System.out.printf("%s menyembuhkan %s.\n", name, target.name);
        target.hp += 20;
        mp -= 10;
        System.out.printf("HP %s bertambah sebesar 20.\n\n", target.name);
        System.out.println(target);
    }

    @Override
    protected int getSkillCost() {
        return 5;
    }
}