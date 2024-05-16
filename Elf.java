public class Elf extends Foe implements Healingable {
    public Elf(String name, int hp, int mp) {
        super(name, hp, mp);
    }

    @Override
    public void attack(Character target) {
        System.out.printf("%s menyerang %s menggunakan metode attack.\n\n", getName(), target.getName());
        target.receiveDamage(10);
        System.out.printf("HP %s berkurang sebesar 10.\n\n", target.getName());
        if (target.getStatusName().equals("SLEEP")) {
            target.removeStatus(new Status() {
                @Override
                public String getStatusName() {
                    return "SLEEP";
                }

                @Override
                public void applyStatus(Character target) {
                    target.applyStatus(this);
                }

                @Override
                public void removeStatus(Character target) {
                    target.removeStatus(this);
                }
            });
            System.out.printf("Status SLEEP pada %s dihilangkan karena diserang.\n\n", target.getName());
        }
    }
    @Override
    public void skill(Character target) {
        if (canUseSkill()) {
            System.out.printf("Kemudian %s menggunakan skill lullaby.\n\n", name);
            mp -= getSkillCost();
            target.applyStatus(new Status() {
                @Override
                public String getStatusName() {
                    return "SLEEP";
                }
                @Override
                public void applyStatus(Character target) {
                    target.applyStatus(this);
                }
                @Override
                public void removeStatus(Character target) {
                    target.removeStatus(this);
                }
            });
            System.out.printf("%s terkena status SLEEP.\n\n", target.getName());
        }
    }

    @Override
    public void heal(Character target) {
        System.out.printf("%s menyembuhkan %s.\n\n", getName(), target.getName());
        target.heal(20);
        mp -= 10;
        System.out.printf("HP %s bertambah sebesar 20.\n\n", target.getName());
    }

    public void recover() {
        System.out.printf("%s menggunakan skill recover.\n\n", getName());
        recoverMP(20);
    }

    @Override
    protected int getSkillCost() {
        return 20;
    }
}