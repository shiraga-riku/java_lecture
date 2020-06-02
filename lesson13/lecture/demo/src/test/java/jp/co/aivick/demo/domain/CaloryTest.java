package jp.co.aivick.demo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CaloryTest
{
    @Test
    void カロリーが生成できる() {
        var sut = new Calory(100);
        assertEquals(100, sut.value());
    }

    @Test
    void マイナスのカロリーは生成できない() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Calory(-10);
        });
    }

    @Test
    void 小数点桁数を指定して文字列整形できる() {
        var sut = new Calory(100.235);

        var acutal = sut.format(2);

        assertEquals("100.24 Kcal", acutal);
    }


}
