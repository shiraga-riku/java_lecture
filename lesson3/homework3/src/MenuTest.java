import java.util.List;
import java.util.stream.Collectors;

public class MenuTest
{
    public static void main(String[] args) {
        System.out.println("------- recipe ----------");
        Recipe r1 = new Recipe("ハンバーグ", 200.5);
        Recipe r2 = new Recipe("サーモン", 120);

        System.out.println(r1.getName());
        System.out.println(r1.getCalorie());
        System.out.println(r2.getName());
        System.out.println(r2.getCalorie());

        System.out.println("------- menu   ----------");
        Menu menu = new Menu("ハンバーグ弁当", "洋食", List.of(r1, r2));
        System.out.println(menu.getName());
        System.out.println(menu.getType());
        System.out.println(menu.getCal());
        System.out.println(menu.getRecipes()
                               .get(0)
                               .getName());

        System.out.println("------- menuSet   ----------");
        Recipe r3 = new Recipe("チキン", 200.5);
        Recipe r4 = new Recipe("肉じゃが", 120);
        Recipe r5 = new Recipe("のり", 50);
        Menu menu1 = new Menu("ハンバーグ弁当", "洋食", List.of(r1, r2));
        Menu menu2 = new Menu("チキン弁当", "和食", List.of(r3, r4));
        Menu menu3 = new Menu("のり弁当", "和食", List.of(r4, r5));
        MenuSet menuSet = new MenuSet(List.of(menu1, menu2, menu3));
        var menus = menuSet.getMenus();
        System.out.println(menus.stream()
                                .map(Menu::getName)
                                .collect(Collectors.joining(",")));

        System.out.println("------- getMenusByType  ----------");
        var waMenus = menuSet.getMenusByType("和食");
        System.out.println(waMenus.stream()
                                  .map(Menu::getName)
                                  .collect(Collectors.joining(",")));

        System.out.println("------- getMenusByOverCalorie  ----------");
        var over200Menus = menuSet.getMenusByOverCalorie(200);
        System.out.println(over200Menus.stream()
                                       .map(Menu::getName)
                                       .collect(Collectors.joining(",")));

        System.out.println("------- getMenusBySpec wa and 200  ----------");
        var waAndOver200Menus = menuSet.getMenusBySpec(
            AndSpec.and(new MenuTypeSpec("和食"), new CalorieOverSpec(200)));
        System.out.println(waAndOver200Menus.getMenus()
                                            .stream()
                                            .map(Menu::getName)
                                            .collect(Collectors.joining(",")));

        System.out.println("------- getMenusBySpec not !(wa and 200) ----------");
        var notWaAndOver200Menus = menuSet.getMenusBySpec(
            NotSpec.not(AndSpec.and(new MenuTypeSpec("和食"), new CalorieOverSpec(200))));
        System.out.println(notWaAndOver200Menus.getMenus()
                                               .stream()
                                               .map(Menu::getName)
                                               .collect(Collectors.joining(",")));
    }
}
