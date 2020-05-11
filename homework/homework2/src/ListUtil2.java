import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListUtil2
{
    public static void main(String[] args) {
        System.out.println("-------- evensOf   ---------");
        var evens = ListUtil2.evensOf(List.of(1, 2, 3, 4, 5, 6));
        printList(evens);

        System.out.println("-------- replicate ---------");
        var hogeList1 = ListUtil2.replicate(3, "hoge"); //大きさ3で全ての要素が文字列”hoge”のリストを生成する。
        var hogeList2 = ListUtil2.replicate(2, "java"); //大きさ2で全ての要素が文字列”java”のリストを生成する。
        printList(hogeList1);
        printList(hogeList2);

        System.out.println("-------- zip       ---------");
        var zip1 = ListUtil2.zip(List.of(1, 2, 3), List.of(2, 3, 4));// [(1,2), (2,3), (3,4)]
        var zip2 = ListUtil2.zip(List.of(1, 2, 3), List.of(10, 9)); //[(1,10), (2,9)]
        printList(zip1);
        printList(zip2);

        System.out.println("-------- factors   ---------");
        var factors1 = ListUtil2.factors(15); //[1, 3, 5, 15]
        var factors2 = ListUtil2.factors(7); // [1, 7]
        printList(factors1);
        printList(factors2);

        System.out.println("-------- perfects  ---------");
        var perfects = ListUtil2.perfects(500); //[6, 28, 496]
        printList(perfects);

        System.out.println("-------- pairs     ---------");
        var pairs = ListUtil2.pairs(List.of(1, 2, 3, 4));  // [(1,2), (2,3), (3,4)]
        printList(pairs);

        System.out.println("-------- sorted    ---------");
        var sorted1 = ListUtil2.sorted(List.of(1, 2, 3, 4)); //true
        var sorted2 = ListUtil2.sorted(List.of(3, 2, 5, 6)); //false
        System.out.println(sorted1);
        System.out.println(sorted2);

        System.out.println("-------- positions ---------");
        var positions1 = ListUtil2.positions(10, List.of(10, 15, 20, 10, 10, 33)); //[0,3,4]
        var positions2 = ListUtil2.positions(3, List.of(1, 2, 3, 4, 5)); //[2]
        printList(positions1);
        printList(positions2);

        System.out.println("-------- scalarp   ---------");
        var scalarProduct = ListUtil2.scalarProduct(List.of(1, 2, 3), List.of(4, 5, 6)); // 32
        System.out.println(scalarProduct);

        System.out.println("-------- zip4      ---------");
        var tetrads = ListUtil2.zip4(List.of(1, 2, 3), List.of(10, 20, 30), List.of(100, 200, 300),
            List.of(1000, 2000, 3000));
        printList(tetrads);
    }

    private static <E> void printList(List<E> list) {
        System.out.println(list.stream()
                               .map(String::valueOf)
                               .collect(Collectors.joining(",", "[", "]")));
    }

    public static List<Integer> evensOf(List<Integer> intList) {
        return intList.stream()
                      .filter(e -> e % 2 == 0)
                      .collect(Collectors.toList());
    }

    public static <E> List<E> replicate(int size, E inital) {
        return IntStream.range(0, size)
                        .mapToObj(i -> inital)
                        .collect(Collectors.toList());
    }

    public static <F, S> List<Pair<F, S>> zip(List<F> firsts, List<S> seconds) {
        var min = Math.min(firsts.size(), seconds.size());
        return IntStream.range(0, min)
                        .mapToObj(i -> new Pair<>(firsts.get(i), seconds.get(i)))
                        .collect(Collectors.toList());
    }

    public static List<Integer> factors(int n) {
        return IntStream.range(1, n + 1)
                        .filter(i -> n % i == 0)
                        .boxed()
                        .collect(Collectors.toList());
    }

    private static int total(List<Integer> intList, int exclusive) {
        return intList.stream()
                      .filter(i -> i != exclusive)
                      .mapToInt(Integer::valueOf)
                      .sum();
    }

    public static List<Integer> perfects(int n) {
        return IntStream.range(1, n + 1)
                        .mapToObj(i -> new Pair<Integer, List<Integer>>(i, factors(i)))
                        .filter(p -> total(p.second(), p.first()) == p.first())
                        .map(Pair::first)
                        .collect(Collectors.toList());
    }

    public static <F> List<Pair<F, F>> pairs(List<F> list) {
        return IntStream.range(0, list.size() - 1)
                        .mapToObj(i -> new Pair<>(list.get(i), list.get(i + 1)))
                        .collect(Collectors.toList());
    }

    public static boolean sorted(List<Integer> intList) {
        return pairs(intList)
            .stream()
            .noneMatch(p -> p.first() > p.second());
    }

    public static <E> List<Integer> positions(E e, List<E> list) {
        List<Integer> indexes = IntStream.range(0, list.size())
                                         .boxed()
                                         .collect(Collectors.toList());

        return zip(indexes, list)
            .stream()
            .filter(p -> p.second() == e)
            .map(Pair::first)
            .collect(Collectors.toList());
    }

    public static int scalarProduct(List<Integer> firsts, List<Integer> seconds) {
        return zip(firsts, seconds)
            .stream()
            .mapToInt(p -> p.first() * p.second())
            .sum();
    }

    public static <A, B, C, D> List<Pair<A, Pair<B, Pair<C, D>>>> zip4(List<A> list1,
        List<B> list2,
        List<C> list3, List<D> list4) {

        var min = Math.min(Math.min(list1.size(), list2.size()),
            Math.min(list3.size(), list4.size()));

        return IntStream.range(0, min)
                        .mapToObj(
                            i -> tetrad(list1.get(i), list2.get(i), list3.get(i), list4.get(i)))
                        .collect(Collectors.toList());
    }

    private static <A, B, C, D> Pair<A, Pair<B, Pair<C, D>>> tetrad(A a, B b, C c, D d) {
        return new Pair<>(a, new Pair<>(b, new Pair<>(c, d)));
    }
}
