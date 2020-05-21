package jp.co.aivick.doma;

import java.util.List;
import jp.co.aivick.doma.dao.MenuDao;
import jp.co.aivick.doma.dao.MenuDaoImpl;
import jp.co.aivick.doma.entity.Menu;
import org.seasar.doma.jdbc.tx.TransactionManager;

public class DomaMain
{
    public static void main(String[] args) throws Exception {
        MenuDao impl = new MenuDaoImpl();

        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        tm.required(() -> {
            List<Menu> menus = impl.findAll();
            menus.forEach(m -> {
                System.out.println(m.getMenuName());
            });
        });
    }

}
