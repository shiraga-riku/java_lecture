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
}
