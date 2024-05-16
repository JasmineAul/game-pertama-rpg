abstract class Character {
    protected String name;
    protected int hp;
    protected int mp;
    protected Status status;

    public Character(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.status = null;
    }

    public boolean canUseSkill() {
        return mp >= 10;
    }

    public void removeStatus(Status statusToRemove) {
        if (this.status != null && this.status.getClass() == statusToRemove.getClass()) {
            this.status = null;
        }
    }

    public void applyStatus(Status newStatus) {
        this.status = newStatus;
    }

    public String getStatus() {
        return status != null ? status.toString() : "No status applied.";
    }
    public String setStatus(Status status) {
        this.status = status;
        return "Status updated.";
    }

    public String getStatusName() {
        return status != null ? status.getStatusName() : "NONE";
    }

    public String getName() {
        return name;
    }

    public void printStatus() {
        System.out.printf("%s status: %s\n", name, getStatusName());
    }

    public abstract void attack(Character target); 

    public void receiveDamage(int amount) {
        if (status != null && status.getStatusName().equals("SLEEP")) {
            System.out.printf("%s sedang tertidur, tidak bisa menerima serangan!\n", name);
        } else {
            hp -= amount;
            if (hp <= 0) {
                System.out.printf("%s kalah!\n", name);
            }
        }
    }

    public void heal(int amount) {
        hp += amount;
    }

    public void recoverMP(int amount) {
        mp += amount;
    }

    public void useItem(Item item) {
        item.use(this);
    }
    protected abstract int getSkillCost();

    @Override
    public String toString() {
        return name + " [HP=" + hp + ", MP=" + mp + ", Status=" + status+"]";
    }
}