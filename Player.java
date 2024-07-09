import java.util.Random;

public class Player {
    private int health;
    private int attack;
    private int defense;
    private String name;

    public Player(int health, int attack, int defense, String name) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.name = name;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public int rollDice() {
        Random rand = new Random();
        return rand.nextInt(6) + 1; // Random number between 1 and 6
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " [Health: " + health + ", Attack: " + attack + ", Defense: " + defense + "]";
    }
}
