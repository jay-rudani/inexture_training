package JumpStatements;

public class LabeledBreak {

    public static void main(String[] args) {

        outerLoop: for (int i = 0; i < 4; i++) {
            innerLoop: for (int j = 0; j < 4; j++) {
                System.out.println("i : " + i + " j : " + j);
                if (i == 2 && j == 2) {
                    break outerLoop; // exit both loops when i is 2 and j is 2
                }
            }
        }
    }
}
