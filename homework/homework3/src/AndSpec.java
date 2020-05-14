public class AndSpec implements MenuSpec
{
    final private MenuSpec spec1;
    final private MenuSpec spec2;

    public static MenuSpec and(MenuSpec spec1, MenuSpec spec2) {
        return new AndSpec(spec1, spec2);
    }

    private AndSpec(MenuSpec spec1, MenuSpec spec2) {
        this.spec1 = spec1;
        this.spec2 = spec2;
    }

    @Override
    public boolean satisifedBy(Menu menu) {
        return spec1.satisifedBy(menu) && spec2.satisifedBy(menu);
    }
}
