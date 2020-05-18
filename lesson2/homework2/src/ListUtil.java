import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtil
{
    public static void main(String[] args) {
        System.out.println("-------- evensOf   ---------");
        var evens = ListUtil.evensOf(List.of(1, 2, 3, 4, 5, 6));
        printList(evens);

        System.out.println("-------- replicate ---------");
        var hogeList1 = ListUtil.replicate(3, "hoge"); //大きさ3で全ての要素が文字列”hoge”のリストを生成する。
        var hogeList2 = ListUtil.replicate(2, "java"); //大きさ2で全ての要素が文字列”java”のリストを生成する。
        printList(hogeList1);
        printList(hogeList2);

        System.out.println("-------- zip       ---------");
        var zip1 = ListUtil.zip(List.of(1,2,3), List.of(2,3,4));// [(1,2), (2,3), (3,4)]
        var zip2 = ListUtil.zip(List.of(1,2,3), List.of(10,9)); //[(1,10), (2,9)]
        printList(zip1);
        printList(zip2);

        System.out.println("-------- factors   ---------");
        var factors1 = ListUtil.factors(15); //[1, 3, 5, 15]
        var factors2 = ListUtil.factors(7); // [1, 7]
        printList(factors1);
        printList(factors2);

        System.out.println("-------- perfects  ---------");
        var perfects = ListUtil.perfects(500); //[6, 28, 496]
        printList(perfects);

        System.out.println("-------- pairs     ---------");
        var pairs = ListUtil.pairs(List.of(1,2,3,4));  // [(1,2), (2,3), (3,4)]
        printList(pairs);

        System.out.println("-------- sorted    ---------");
        var sorted1 = ListUtil.sorted(List.of(1,2,3,4)); //true
        var sorted2 = ListUtil.sorted(List.of(3,2,5,6)); //false
        System.out.println(sorted1);
        System.out.println(sorted2);

        System.out.println("-------- positions ---------");
        var positions1 = ListUtil.positions(10, List.of(10, 15, 20, 10, 10, 33)); //[0,3,4]
        var positions2 = ListUtil.positions(3, List.of(1, 2, 3, 4, 5)); //[2]
        printList(positions1);
        printList(positions2);

        System.out.println("-------- scalarp   ---------");
        var scalarProduct = ListUtil.scalarProduct(List.of(1,2,3), List.of(4,5,6)); // 32
        System.out.println(scalarProduct);

        System.out.println("-------- zip4      ---------");
        var tetrads = ListUtil.zip4(List.of(1,2,3), List.of(10,20,30), List.of(100,200,300), List.of(1000,2000,3000));
        printList(tetrads);
    }

    private static <E> void printList(List<E> list) {
        System.out.println(list.stream()
                               .map(String::valueOf)
                               .collect(Collectors.joining(",", "[", "]")));
    }

    public static List<Integer> evensOf(List<Integer> intList) {
        List<Integer> evensList = new ArrayList<>();
        for (Integer e : intList) {
            if (e % 2 == 0) {
                evensList.add(e);
            }
        }
        return evensList;
    }

    public static List<String> replicate(int size, String inital) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(inital);
        }
        return list;
    }

    public static List<Pair<Integer, Integer>> zip(List<Integer> firsts, List<Integer> seconds) {
        var min = Math.min(firsts.size(), seconds.size());
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < min; i++) {
            pairs.add(new Pair<>(firsts.get(i), seconds.get(i)));
        }
        return pairs;
    }

    public static List<Integer> factors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    public static List<Integer> perfects(int n) {
        List<Integer> perfects = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            var factors = factors(i);
            var total = total(factors, i);
            if (total == i) {
                perfects.add(i);
            }
        }
        return perfects;
    }

    private static int total(List<Integer> intList, int exclusive) {
        return intList.stream()
                      .filter(i -> i != exclusive)
                      .mapToInt(Integer::valueOf)
                      .sum();
    }

    public static List<Pair<Integer, Integer>> pairs(List<Integer> list) {
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            pairs.add(new Pair<>(list.get(i), list.get(i + 1)));
        }
        return pairs;
    }

    public static boolean sorted(List<Integer> intList) {
        var pairs = pairs(intList);
        for (var pair : pairs) {
            if (pair.first() > pair.second()) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> positions(int e, List<Integer> intList) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < intList.size(); i++) {
            indexes.add(i);
        }

        var positions = new ArrayList<Integer>();
        var pairs = zip(indexes, intList);
        for (var pair : pairs) {
            if (pair.second() == e) {
                positions.add(pair.first());
            }
        }
        return positions;
    }

    public static int scalarProduct(List<Integer> firsts, List<Integer> seconds) {
        int total = 0;
        for (int i = 0; i < firsts.size(); i++) {
            total += firsts.get(i) * seconds.get(i);
        }
        return total;
    }

    public static List<Pair<Integer, Pair<Integer, Pair<Integer, Integer>>>>
    zip4(List<Integer> list1, List<Integer> list2, List<Integer> list3, List<Integer> list4) {
        var min = Math.min(Math.min(list1.size(), list2.size()),
            Math.min(list3.size(), list4.size()));

        List<Pair<Integer, Pair<Integer, Pair<Integer, Integer>>>> result = new ArrayList<>();

        for (int i = 0; i < min; i++) {
            result.add(tetrad(list1.get(i), list2.get(i), list3.get(i), list4.get(i)));
        }
        return result;
    }

    private static Pair<Integer, Pair<Integer, Pair<Integer, Integer>>> tetrad(Integer a, Integer b,
        Integer c, Integer d) {
        return new Pair<>(a, new Pair<>(b, new Pair<>(c, d)));
    }
}
