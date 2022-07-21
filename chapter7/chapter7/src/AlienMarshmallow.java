
/* 220714 Absolute Java  Chapter7 Programming Projects. Proj0703 */
/**
 * @see Alien.java
 * @see AlienPack.java
 */
public class AlienMarshmallow extends Alien {

    private int damage = 1; // Marshmallow Man does 1 damage

    public AlienMarshmallow(int health, String name) {
        super.setHealth(health);
        super.setName(name);
    }

    public int getDamage() {
        return damage;
    }
}
