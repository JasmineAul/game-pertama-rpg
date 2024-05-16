public class Goblin extends Foe {
    public Goblin(String name, int HP, int MP) {
        super(name, HP, MP);
    }

    @Override
    public void attack(Character target) {
        System.out.printf("%s menyerang %s menggunakan metode attack.\n", name, target.name);
        target.hp -= 10;
        System.out.printf("HP %s berkurang sebesar 10.\n", target.name);
    }

    @Override
    public void skill(Character target) {
        if (canUseSkill()) {
            System.out.printf("Kemudian %s menggunakan skill gigit.\n", getName());
            target.receiveDamage(15);
            setMp(getMp() - 15);
            Status poisonStatus = new Status() {
                @Override
                public String getStatusName() {
                    return "POISON";
                }

                @Override
                public void applyStatus(Character target) {
                    target.applyStatus(this);
                }

                @Override
                public void removeStatus(Character target) {
                    target.removeStatus(this);
                }
            };
            target.applyStatus(poisonStatus);
            System.out.printf("HP %s berkurang sebesar 15 dan terkena status POISON.\n", target.getName());
        }
    }
    @Override
    protected int getSkillCost() {
        return 10;
    }
    public int getMp() {
        return mp;
    }
    public void setMp(int mp) {
        this.mp = mp;
    }
}