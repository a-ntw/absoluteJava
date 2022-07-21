
/* 220714 Absolute Java  Chapter7 Programming Projects. Proj0703 */
/**
 * @see Alien.java
 */
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

    public int calculateDamage() {
        int damage = 0;
        for (int i = 0; i < aliens.length; i++) {
            damage += aliens[i].getDamage();
        }
        return damage;
    }

    public static void main(String[] args) {

        AlienSnake s = new AlienSnake(50, "Sss");
        AlienOgre o = new AlienOgre(30, "Ooo");
        AlienMarshmallow m = new AlienMarshmallow(20, "Mmm");

        AlienPack arr = new AlienPack(3);
        arr.addAlien(s, 0);
        arr.addAlien(o, 1);
        arr.addAlien(m, 2);

        for (Alien n : arr.getAliens()) {
            System.out.println(n.getClass());
            System.out.print("Alien name: " + n.getName());
            System.out.print(", Heath: " + n.getHealth());
            System.out.println(", Damage: " + n.getDamage());
        }

        System.out.println("Damage: " + arr.calculateDamage());
    }
}

/* Sample dialogue
run:
class AlienSnake
Alien name: Sss, Heath: 50, Damage: 10
class AlienOgre
Alien name: Ooo, Heath: 30, Damage: 6
class AlienMarshmallow
Alien name: Mmm, Heath: 20, Damage: 1
Damage: 17
BUILD SUCCESSFUL (total time: 0 seconds)
 */
