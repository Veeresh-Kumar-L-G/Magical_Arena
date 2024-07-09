public class Match {
    private Player playerA;
    private Player playerB;
    private int roundCount;

    public Match(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.roundCount = 0;
    }

    public void start() {
        System.out.println("Player B will start with attacking");

        // Continue rounds until one player is defeated
        while (playerA.isAlive() && playerB.isAlive()) {
            roundCount++;
            System.out.println("\nRound : " + roundCount);

            if (roundCount % 2 == 1) {
                attack(playerB, playerA); // Player B attacks on odd rounds
            } else {
                attack(playerA, playerB); // Player A attacks on even rounds
            }
        }

        // Print match statistics
        System.out.println("\nStatistics:");
        if (playerA.isAlive()) {
            System.out.println("Winner: Player A");
        } else {
            System.out.println("Winner: Player B");
        }
        System.out.println("Rounds Taken: " + roundCount);
    }

    private void attack(Player attacker, Player defender) {
        System.out.println("Attacker: " + attacker.getName());

        int attackDice = attacker.rollDice();
        int attackValue = attacker.getAttack() * attackDice;
        System.out.println(attacker.getName() + ": Rolling dice; Got dice value of " + attackDice);
        System.out.println(attacker.getName() + ": Attack Value: " + attackValue);

        int defenseDice = defender.rollDice();
        int defenseValue = defender.getDefense() * defenseDice;
        System.out.println(defender.getName() + ": Rolling dice; Got dice value of " + defenseDice);
        System.out.println(defender.getName() + ": Defend Value: " + defenseValue);

        int damage = Math.max(0, attackValue - defenseValue);
        System.out.println(attacker.getName() + ": Damaging " + defender.getName() + " with:" + damage);
        defender.takeDamage(damage);
        System.out.println(defender.getName() + ": Remaining Health: " + defender.getHealth());
    }
}
