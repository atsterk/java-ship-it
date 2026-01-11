package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private ArrayList<T> parcels = new ArrayList<>();
    private int maxWeight;
    private int currentWeight = 0;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        if (currentWeight + parcel.getWeight() > maxWeight) {
            System.out.println("Невозможно добавить посылку из-за превышения веса");
        } else {
            parcels.add(parcel);
            currentWeight += parcel.getWeight();
            System.out.println("Посылка была успешно добавлена в коробку");
        }
    }

    public ArrayList<T> getAllParcels() {
        return parcels;
    }
}
