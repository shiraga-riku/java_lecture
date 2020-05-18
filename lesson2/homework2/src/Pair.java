import java.util.Objects;

public class Pair<F, S>
{
    final private F first;
    final private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F first() {
        return this.first;
    }

    public S second() {
        return this.second;
    }

    @Override
    public String toString() {
        return String.format("<%s,%s>", first, second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) &&
            Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
