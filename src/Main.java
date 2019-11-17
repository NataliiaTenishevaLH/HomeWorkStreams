import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args ){

    //  Имеется коллекция из Integes, использую стримы посчитать среденее значения всех чисел
        List<Integer> integerList = new ArrayList();
        integerList.add(10);
        integerList.add(20);
        integerList.add(30);
        integerList.add(40);

        OptionalDouble average = integerList
                .stream()
                .mapToDouble(a -> a)
                .average();
        System.out.println("average "+ average);

      //  Имеется коллекция из String, привести все стринги в UPPERCASE и вернуть коллекцию List<Pair>
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream().map(String::toUpperCase);
        List<Pair> newList = myList.stream().collect(
                Collectors.mapping(
                        p -> new Pair(p.toString()),
                        Collectors.toList()));
        System.out.println(newList);


     //  Имеется коллекция из String, отфильтровать и вывести на экран в все значения, которые написаны в loverCase and length = 4
        List<String>  stringList = new ArrayList<>();
        stringList.add("word");
        stringList.add("worD");
        stringList.add("word");
        stringList.add("word1");

        stringList.stream()
                .filter(u -> u.length() == 4)
                .filter(u -> {
                            for(int i = 0; i< u.length(); i++){
                                if (Character.isLowerCase(u.charAt(i)) == false){
                                    return false;
                                }
                            }
                            return true;
                        }
                        )
                .forEach(System.out::println);
    }
}
