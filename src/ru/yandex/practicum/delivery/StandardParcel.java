package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {
    private static final int STANDARD_COST_PER_WEIGHT = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getCostPerWeight() {
        return STANDARD_COST_PER_WEIGHT;
    }
}
