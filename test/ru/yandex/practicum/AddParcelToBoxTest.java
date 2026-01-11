package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AddParcelToBoxTest {
    private static ParcelBox<StandardParcel> standardParcelBox;
    private static StandardParcel parcel = new StandardParcel("a", 100, "b", 1);

    @Test
    public void shouldAddParcel() {
        standardParcelBox = new ParcelBox<>(100);
        standardParcelBox.addParcel(parcel);

        assertFalse(standardParcelBox.getAllParcels().isEmpty());
    }

    @Test
    public void shouldNotAddParcel() {
        standardParcelBox = new ParcelBox<>(99);
        standardParcelBox.addParcel(parcel);

        assertTrue(standardParcelBox.getAllParcels().isEmpty());
    }
}
