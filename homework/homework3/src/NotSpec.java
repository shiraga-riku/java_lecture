public class NotSpec implements MenuSpec
{
    final private MenuSpec spec;

    public static MenuSpec not(MenuSpec spec) {
        return new NotSpec(spec);
    }

    private NotSpec(MenuSpec spec) {
        this.spec = spec;
    }

    @Override
    public boolean satisifedBy(Menu menu) {
        return !spec.satisifedBy(menu);
    }
}
