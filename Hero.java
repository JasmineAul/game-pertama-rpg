public abstract class Hero extends Character {
    public Hero(String name, int hp, int mp) {
        super(name, hp, mp);
    }
    public abstract void skill(Character target);
}