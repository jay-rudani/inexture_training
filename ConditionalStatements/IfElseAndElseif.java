package ConditionalStatements;

class IfElseAndElseif {

    void checkGrade(int marks) {
        if (marks > 90) {
            System.out.println("Grade A");
        } else if (marks > 75 && marks <= 90) {
            System.out.println("Grade B");
        } else if (marks > 55 && marks <= 75) {
            System.out.println("Grade C");
        } else if (marks > 35 && marks <= 55) {
            System.out.println("Grade D");
        } else {
            System.out.println("fail");
        }
    }

    public static void main(String[] args) {
        IfElseAndElseif obj = new IfElseAndElseif();
        obj.checkGrade(95);
    }
}
