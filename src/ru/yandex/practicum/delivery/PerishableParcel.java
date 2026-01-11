package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private static final int PERISHABLE_COST_PER_WEIGHT = 4;
    private int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return (getSendDay() + timeToLive) < currentDay;
    }

    @Override
    public int getCostPerWeight() {
        return PERISHABLE_COST_PER_WEIGHT;
    }
}
