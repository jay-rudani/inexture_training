package JumpStatements;

public class BreakContinueReturn {

    public int add() {
        return 10 + 10;
    }

    public static void main(String[] args) {

        // break
        for (int i = 0; i < 10; i++) {
            if (i == 5)
                break;
            System.out.println(i);
        }

        // continue
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0)
                continue; // skips even nums
            System.out.println("Odd nums : " + i);
        }
    }
}
