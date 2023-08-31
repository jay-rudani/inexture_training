package Constructor;

class ParameterizedConstructor {

    String name;
    int age;

    ParameterizedConstructor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {

        ParameterizedConstructor obj = new ParameterizedConstructor("Jay", 23);
        System.out.println("Name : " + obj.name + "\nAge : " + obj.age);
    }
}
