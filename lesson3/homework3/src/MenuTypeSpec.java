public class MenuTypeSpec implements MenuSpec
{
    final private String menuType;

    public MenuTypeSpec(String menuType) {
        this.menuType = menuType;
    }

    @Override
    public boolean satisifedBy(Menu menu) {
        return this.menuType.equals(menu.getType());
    }
}
