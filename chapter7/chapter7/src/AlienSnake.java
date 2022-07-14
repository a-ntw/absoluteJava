
/* 220714 Absolute Java  Chapter7 Programming Projects. Proj0703 */
/**
 * @see Alien.java
 * @see AlienPack.java
 */
public class AlienSnake extends Alien {

    private int damage = 10; // Snake does 10 damage

    public AlienSnake(int health, String name) {
        super.setHealth(health);
        super.setName(name);
    }

    public int getDamage() {
        return damage;
    }
}
