
/* 220714 Absolute Java  Chapter7 Programming Projects. Proj0703 */
 /*
class Alien {
    public static final int SNAKE_ALIEN = 0;
    public static final int OGRE_ALIEN = 1;
    public static final int MARSHMALLOW_MAN_ALIEN = 2;
    public int type; // Stores one of the three above types 
    public int health; // 0=dead, 100=full strength
    public String name;
    public Alien(int type, int health, String name) {
        this.type = type;
        this.health = health;
        this.name = name;
    }
}
public class AlienPack {
    private Alien[] aliens;

    public AlienPack(int numAliens) {
        aliens = new Alien[numAliens];
    }
    public void addAlien(Alien newAlien, int index) {
        aliens[index] = newAlien;
    }
    public Alien[] getAliens() {
        return aliens;
    }
}
public int calculateDamage() {
    int damage = 0;
    for (int i = 0; i < aliens.length; i++) {
        if (aliens[i].type == Alien.SNAKE_ALIEN) {
            damage += 10; // Snake does 10 damage 
        } else if (aliens[i].type == Alien.OGRE_ALIEN) {
            damage += 6;// Ogre does 6 damage 
        } else if (aliens[i].type
                == Alien.MARSHMALLOW_MAN_ALIEN) {
            damage += 1;
            // Marshmallow Man does 1 damage
        }
        return damage;
    }
}
 */
/**
 * The following is some code designed by J Hacker for a video game. There is an
 * {@code Alien} class to represent a monster and an {@code AlienPack} class
 * that represents a band of aliens and how much damage they can inflict:
 *
 * The code is not very object oriented and does not support information hiding
 * in the {@code Alien} class. Rewrite the code so that inheritance is used to
 * represent the different types of aliens instead of the “type” parameter. This
 * should result in deletion of the “type” parameter. Also rewrite the
 * {@code Alien} class to hide the instance variables and create a
 * {@code getDamage} method for each derived class that returns the amount of
 * damage the alien inflicts. Finally, rewrite the {@code calculateDamage}
 * method to use getDamage and write a {@code main} method that tests the code.
 *
 * @see AlienSnake.java
 * @see AlienOgre.java
 * @see AlienMarshmallow.java
 * @see AlienPack.java
 */
public class Alien {

    private int health; // 0=dead, 100=full strength
    private String name;

    public void setHealth(int health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return 0;
    }

    public static void main(String[] args) {
        AlienPack.main(args);
    }
}
