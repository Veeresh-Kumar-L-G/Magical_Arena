import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input details for Player A
        System.out.println("Enter player A health:");
        int healthA = scanner.nextInt();

        System.out.println("Enter player A attack:");
        int attackA = scanner.nextInt();

        System.out.println("Enter player A defense:");
        int defenseA = scanner.nextInt();

        // Input details for Player B
        System.out.println("Enter player B health:");
        int healthB = scanner.nextInt();

        System.out.println("Enter player B attack:");
        int attackB = scanner.nextInt();

        System.out.println("Enter player B defense:");
        int defenseB = scanner.nextInt();

        // Create Player objects
        Player playerA = new Player(healthA, attackA, defenseA, "Player A");
        Player playerB = new Player(healthB, attackB, defenseB, "Player B");

        // Print player details before starting the match
        System.out.println("Starting the match between Player A - Player B");
        System.out.println(playerA);
        System.out.println(playerB);

        // Create and start the match
        Match match = new Match(playerA, playerB);
        match.start();

        scanner.close();
    }
}
