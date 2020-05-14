import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MenuSet
{
    private List<Menu> menus;

    public MenuSet(List<Menu> menus) {
        this.menus = Collections.unmodifiableList(menus);
    }

    public List<Menu> getMenus() {
        return this.menus;
    }

    public List<Menu> getMenusByType(String type) {
        return this.menus.stream()
                         .filter(m -> m.getType()
                                       .equals(type))
                         .collect(Collectors.toList());
    }

    public List<Menu> getMenusByOverCalorie(double calorie) {
        return this.menus.stream()
                         .filter(m -> m.getCal() > calorie)
                         .collect(Collectors.toList());
    }

    public MenuSet getMenusBySpec(MenuSpec menuSpec) {
        var menuList = this.menus.stream()
                                 .filter(menuSpec::satisifedBy)
                                 .collect(Collectors.toList());

        return new MenuSet(menuList);
    }
}
