package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel {
    private static final int FRAGILE_COST_PER_WEIGHT = 3;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + getDescription() + " обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public int getCostPerWeight() {
        return FRAGILE_COST_PER_WEIGHT;
    }
}
