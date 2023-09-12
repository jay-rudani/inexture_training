package CollectionFramework.Lists;

class Person {

    private String name;
    private int age;
    private String birthPlace;

    public Person(String name, int age, String birthPlace) {
        this.name = name;
        this.age = age;
        this.birthPlace = birthPlace;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", birthPlace=" + birthPlace + "]";
    }

}
