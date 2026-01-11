package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryCostTest {

    private static StandardParcel standardParcel;
    private static FragileParcel fragileParcel;
    private static PerishableParcel perishableParcel;

    @Test
    public void priceForStandardShouldBe2TimesWeight() {
        standardParcel = new StandardParcel("a", 100, "b", 1);
        assertEquals(200, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void priceForFragileShouldBe3TimesWeight() {
        fragileParcel = new FragileParcel("a", 100, "b", 1);
        assertEquals(300, fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void priceForPerishableShouldBe4TimesWeight() {
        perishableParcel = new PerishableParcel("a", 100, "b", 1, 1);
        assertEquals(400, perishableParcel.calculateDeliveryCost());
    }
}
