import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ListUtilTest
{
    @Nested
    class EvensOf
    {
        @Test
        void 空リストからは空となる() {
            var actual = ListUtil.evensOf(List.of());
            assertEquals(List.of(), actual);
        }

        @Test
        void 偶数のみを含むリストはそのリストとなる() {
            var actual = ListUtil.evensOf(List.of(2, 4, 6));
            assertEquals(List.of(2, 4, 6), actual);
        }

        @Test
        void 奇数のみを含むリストは空リストとなる() {
            var actual = ListUtil.evensOf(List.of(1, 3, 5));
            assertEquals(List.of(), actual);
        }

        @Test
        void 奇数と偶数が混在するリストは偶数のみのリストとなる() {
            var actual = ListUtil.evensOf(List.of(1, 2, 3, 4, 5, 6));
            assertEquals(List.of(2, 4, 6), actual);
        }
    }

    @Nested
    class Replicate
    {
        @Test
        void 大きさが0の場合はカラリストとなる() {
            var actual = ListUtil.replicate(0, "hoge");
            assertEquals(List.of(), actual);
        }

        @Test
        void 大きさが2の場合は大きさ2のリストで全ての要素が与えた値となる() {
            var actual = ListUtil.replicate(2, "hoge");
            assertEquals(List.of("hoge", "hoge"), actual);
        }
    }

    @Nested
    class Zip
    {
        @Test
        void 二つのリストをzipできる() {
            List<?> actual = ListUtil.zip(List.of(1, 2, 3), List.of(100, 200, 300));
            assertIterableEquals(
                Arrays.asList(new Pair<>(1, 100), new Pair<>(2, 200), new Pair<>(3, 300)), actual);
        }

        @Test
        void 大きさの異なる二つのリストをzipできる() {
            List<?> actual = ListUtil.zip(List.of(1, 2, 3), List.of(100, 200, 300, 400));
            assertIterableEquals(
                Arrays.asList(new Pair<>(1, 100), new Pair<>(2, 200), new Pair<>(3, 300)), actual);
        }

        @Test
        public void 空のリスト同士をzipすると結果は空のリストとなる() {
            List<?> actual = ListUtil.zip(Collections.emptyList(), Collections.emptyList());
            assertIterableEquals(Collections.emptyList(), actual);
        }

        @Test
        void いずれか一方のリストが空の場合にzipすると結果は空のリストとなる() {
            List<?> actual1 = ListUtil.zip(Collections.emptyList(), Arrays.asList(1, 2));
            assertIterableEquals(Collections.emptyList(), actual1);

            List<?> actual2 = ListUtil.zip(Arrays.asList(1, 2), Collections.emptyList());
            assertIterableEquals(Collections.emptyList(), actual2);
        }
    }

    @TestInstance(PER_CLASS)
    @Nested
    class Factors
    {
        @ParameterizedTest
        @MethodSource("factorsProvider")
        public void 与えた数の約数のリストを取得できる(int n, List<Integer> expected) {
            List<Integer> actual = ListUtil.factors(n);

            assertIterableEquals(expected, actual);
        }

        private Stream<Arguments> factorsProvider() {
            return Stream.of(
                Arguments.arguments(0, List.of()),
                Arguments.arguments(1, Collections.singletonList(1)),
                Arguments.arguments(2, Arrays.asList(1, 2)),
                Arguments.arguments(3, Arrays.asList(1, 3)),
                Arguments.arguments(10, Arrays.asList(1, 2, 5, 10))
            );
        }
    }

    @TestInstance(PER_CLASS)
    @Nested
    class Perfects {

        @ParameterizedTest
        @MethodSource("perfectsProvider")
        public void 完全数を計算できる(int n, List<Integer> expected) {
            List<Integer> actual = ListUtil.perfects(n);

            assertIterableEquals(expected, actual);
        }

        private Stream<Arguments> perfectsProvider() {
            return Stream.of(
                Arguments.arguments(1, Collections.emptyList()),
                Arguments.arguments(10, Collections.singletonList(6)),
                Arguments.arguments(30, Arrays.asList(6, 28)),
                Arguments.arguments(500, Arrays.asList(6, 28, 496))
            );
        }
    }
}
