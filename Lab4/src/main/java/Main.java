import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {


        var nodes = IntStream.rangeClosed(0, 8).mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);

        Faker faker = new Faker();

        String intersectionName1 = faker.address().streetName();

        Street s1 = new Street("s1", 1,
                Arrays.stream(nodes).filter(v -> v.getName().contains("v0")).collect(Collectors.toList()).get(0),
                Arrays.stream(nodes).filter(v -> v.getName().contains("v1")).collect(Collectors.toList()).get(0));
        Street s2 = new Street("s2", 2,
                Arrays.stream(nodes).filter(v -> v.getName().contains("v1")).collect(Collectors.toList()).get(0),
                Arrays.stream(nodes).filter(v -> v.getName().contains("v2")).collect(Collectors.toList()).get(0));
        Street s3 = new Street("s3", 3,
                Arrays.stream(nodes).filter(v -> v.getName().contains("v0")).collect(Collectors.toList()).get(0),
                Arrays.stream(nodes).filter(v -> v.getName().contains("v2")).collect(Collectors.toList()).get(0));
        Street s4 = new Street("s4", 5,
                Arrays.stream(nodes).filter(v -> v.getName().contains("v0")).collect(Collectors.toList()).get(0),
                Arrays.stream(nodes).filter(v -> v.getName().contains("v2")).collect(Collectors.toList()).get(0));
        Street s5 = new Street("s5", 1,
                Arrays.stream(nodes).filter(v -> v.getName().contains("v0")).collect(Collectors.toList()).get(0),
                Arrays.stream(nodes).filter(v -> v.getName().contains("v2")).collect(Collectors.toList()).get(0));
//am creat doar 3 obiecte din cele 16
        List<Street> streetList = new LinkedList<>();
        streetList.add(s1);
        streetList.add(s2);
        streetList.add(s3);
        streetList.add(s4);
        streetList.add(s5);
        Set<Intersection> intersectionSet = new HashSet<>();

        for( Street i: streetList)
                i.setName(faker.address().streetName());

        Collections.sort(streetList, ((u, v) -> u.getLength().compareTo(v.getLength())));
        Boolean check = intersectionSet.addAll(List.of(nodes));
       System.out.println(streetList);
        System.out.println();
        System.out.println(intersectionSet);
        System.out.println();
        System.out.println(check);

        for (int i = 0; i < nodes.length; i++)
            nodes[i].setNrStreets(0);

        for (Street i : streetList) {
            i.getNode1().setNrStreets(i.getNode1().getNrStreets() + 1);
            i.getNode2().setNrStreets(i.getNode2().getNrStreets() + 1);
        }
        for(int i = 0 ; i< nodes.length; i++)
        System.out.println(nodes[i].getNrStreets());

        streetList.stream().filter(v -> v.getLength() > 2).filter(v -> (v.getNode1().getNrStreets() > 3 || v.getNode1().getNrStreets() > 3)).forEach(System.out::println);

    }
}
