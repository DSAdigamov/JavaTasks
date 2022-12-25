import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        CustomMap<Person, Account> customMap = new CustomMap<>();
        fillUpMap(customMap);

        System.out.println("Вывод мапы до удаления:");
        System.out.println(customMap + "\n");

        customMap.remove(new Person("Vova", "+79274445555"));
        System.out.println("Мапа после удаления Vova: \n"
                + customMap + "\n");

        System.out.println("Получение ключей: \n" +
                Arrays.toString(customMap.getKeys()));
    }

    private static void fillUpMap(CustomMap<Person, Account> map) {
        map.put(new Person("Vova", "+79274445555"), new Account("111111", 1111));
        map.put(new Person("Petya", "+19992321321"), new Account("222222", 2222));
        map.put(new Person("Vanya", "+23213123212"), new Account("33333", 3333));
        map.put(new Person("Vladimir", "+3232132323"), new Account("44444", 4444));
        map.put(new Person("Kent", "+43423432345"), new Account("55555", 5555));
        map.put(new Person("Shrek", "+53423423"), new Account("6666", 6666));
    }
}
