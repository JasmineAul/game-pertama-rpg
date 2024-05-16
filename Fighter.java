public class Fighter extends Hero {
    public Fighter(String name, int hp, int mp) {
        super(name, hp, mp);
    }

    @Override
    public void attack(Character target) {
        target.receiveDamage(15);
    }

    @Override
    public void skill(Character target) {
        if (canUseSkill()) {
            target.receiveDamage(25);
            mp -= getSkillCost();
        }
    }

    @Override
    protected int getSkillCost() {
        return 12;
    }
}