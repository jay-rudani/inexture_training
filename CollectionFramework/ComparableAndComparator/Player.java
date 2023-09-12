package CollectionFramework.ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Player implements Comparable<Player> {

    private int ranking;
    private String name;
    private int age;

    public Player(int ranking, String name, int age) {
        this.ranking = ranking;
        this.name = name;
        this.age = age;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Player [ranking=" + ranking + ", name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(Player otherPlayer) {
        return Integer.compare(getRanking(), otherPlayer.getRanking());
    }

    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(59, "John", 25);
        Player player2 = new Player(67, "Roger", 22);
        Player player3 = new Player(45, "Steven", 24);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);

        // the sorting order is decided by the return value of the compareTo() method
        // Integer.compare(x,y) returns -1 if x < y, 0 if x=y and 1 if x > y
        System.out.println("Before Sorting : ");
        for (Player p : footballTeam) {
            System.out.print(p.getName() + " ");
        }
        Collections.sort(footballTeam);
        System.out.println();
        System.out.println("After Sorting : ");
        for (Player p : footballTeam) {
            System.out.print(p.getName() + " ");
        }
        System.out.println();

        PlayerAgeComparator playerAgeComparator = new PlayerAgeComparator();
        Collections.sort(footballTeam, playerAgeComparator);

        System.out.println("After Sorting : ");
        for (Player p : footballTeam) {
            System.out.print(p.getName() + " ");
        }
        System.out.println();
    }

}

class PlayerAgeComparator implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }

}