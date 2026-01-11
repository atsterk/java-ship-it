package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsExpiredTest {
    private static PerishableParcel perishableParcel;

    @Test
    public void shouldReturnTrue() {
        perishableParcel = new PerishableParcel("a", 100, "b", 1, 10);
        assertTrue(perishableParcel.isExpired(12));
    }

    @Test
    public void shouldReturnFalse() {
        perishableParcel = new PerishableParcel("a", 100, "b", 1, 10);
        assertFalse(perishableParcel.isExpired(11));
    }
}
