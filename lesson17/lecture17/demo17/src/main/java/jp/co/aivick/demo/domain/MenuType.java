package jp.co.aivick.demo.domain;

import org.seasar.doma.Domain;

@Domain(valueType = Integer.class, factoryMethod = "valueOf", accessorMethod = "getValue")
public enum MenuType
{
    WA(1, "和食"),
    YO(2, "洋食"),
    CHU(3, "中華");

    final private int code;
    final private String label;

    MenuType(Integer
        code, String label) {
        this.code = code;
        this.label = label;
    }

    public static MenuType valueOf(Integer code) {
        switch (code) {
            case 1:
                return WA;
            case 2:
                return YO;
            case 3:
                return CHU;
            default:
                throw new IllegalArgumentException("unknown menu type:" + code);
        }
    }

    public Integer getValue() {
        return this.code;
    }

    public String getLabel() {
        return this.label;
    }
}
