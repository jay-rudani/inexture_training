package OOPs.Encapsulation;

class Person {

    private String name;
    private int age;

    // getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        // you can perform validations as well
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Please enter valid age!");
        }
    }

    @Override
    public String toString() {
        return "Person {name = " + name + ", age = " + age + " }";
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("Jay Rudani");
        p1.setAge(23);
        System.out.println(p1.toString());
    }

}
