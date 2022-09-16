import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FP01Structured {

    public static void main(String[] args) {
//        printAllNumberInlistFunctional(List.of(12, 9, 54, 8, 5, 12, 69, 78, 37));
        List<Integer> numbers = List.of(12, 9, 54, 8, 5, 12, 69, 78, 37);
//        numbers.stream()
//                .filter(number -> number % 2 == 0) // Lambda expression
//                .map(number -> number * number) // mapping  x -> x * x
//                .forEach(System.out::println);

//        numbers.stream()
//                .filter(number -> number % 2 != 0)
//                .map(number -> Math.pow(number, 3))
//                .forEach(System.out::println);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker", "Kubernetes"
                );

        List<String> fruits = List.of("apple", "banana", "mango");
        Predicate<? super String> predicate = fruit -> fruit.startsWith("d");
        Optional<String> optional = fruits.stream().filter(predicate).findFirst();
        System.out.println(optional);
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());
        System.out.println(optional.get());
//        courses.stream()
//                .map(String::length)
//                .forEach(System.out::println);

//        courses.stream()
//        .filter(word -> word.contains("Spring"))
//        .forEach(System.out::println);
//        courses.stream()
//                .filter(word -> word.length() > 4)
//                .forEach(System.out::println);
    }

    private static void print(int number){
        System.out.println(number);
    }

    private static boolean isEven(int number){
        return number % 2 == 0;
    }
    private static void printAllNumberInlistFunctional(List<Integer> integers) {
//        integers.stream()
//                .forEach(FP01Structured::print);
//            Iterator var2 = integers.iterator();
//            while (var2.hasNext()){
//                System.out.println(var2.next());
//            }
//        integers.stream()
//                .filter(FP01Structured::isEven)
//                .forEach(System.out::println);
        integers.stream()
                .filter(number -> number % 2 == 0) // Lambda Expression
                .forEach(System.out::println);
    }

}
