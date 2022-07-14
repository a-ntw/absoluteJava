
/* 220714 Absolute Java  Chapter7 Programming Projects. Proj0703 */
/**
 * @see Alien.java
 * @see AlienPack.java
 */
public class AlienOgre extends Alien {

    private int damage = 6; // Ogre does 6 damage

    public AlienOgre(int health, String name) {
        super.setHealth(health);
        super.setName(name);
    }

    public int getDamage() {
        return damage;
    }
}
