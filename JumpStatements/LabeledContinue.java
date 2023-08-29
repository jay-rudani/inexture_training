package JumpStatements;

class LabeledContinue {

    public static void main(String[] args) {
        outerLoop: for (int i = 0; i < 4; i++) {
            innerLoop: for (int j = 0; j < 4; j++) {
                if (i == 2 && j == 2) {
                    continue outerLoop; // skips to the next iteration
                }
                System.out.println("i : " + i + " j : " + j);
            }
        }
    }
}
