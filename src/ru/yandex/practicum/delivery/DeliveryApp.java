package ru.yandex.practicum.delivery;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Parcel> trackableParcels = new ArrayList<>();

    private static ParcelBox<Parcel> standardParcelBox = new ParcelBox<>(1000);
    private static ParcelBox<Parcel> fragileParcelBox = new ParcelBox<>(1000);
    private static ParcelBox<Parcel> perishableParcelBox = new ParcelBox<>(1000);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    checkStatus();
                    break;
                case 5:
                    checkBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Проверить статус отслеживаемых посылок");
        System.out.println("5 - Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Какой тип посылки вы хотите отправить?");
        System.out.println("1 - Стандартная");
        System.out.println("2 - Хрупкая");
        System.out.println("3 - Скоропортящаяся");

        int typeOfParcel = Integer.parseInt(scanner.nextLine());
        if (typeOfParcel < 1 || typeOfParcel > 3) {
            System.out.println("Неверный выбор");
            return;
        }

        System.out.println("Введите описание посылки");
        String description = scanner.nextLine();

        System.out.println("Введите вес посылки");
        int weight = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите адрес доставки");
        String deliveryAddress = scanner.nextLine();

        System.out.println("Введите дату отправки");
        int sendDay = Integer.parseInt(scanner.nextLine());

        Parcel parcel = null;
        switch (typeOfParcel) {
            case 1: {
                parcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                standardParcelBox.addParcel(parcel);
                break;
            }
            case 2: {
                parcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                trackableParcels.add(parcel);
                fragileParcelBox.addParcel(parcel);
                break;
            }
            case 3: {
                System.out.println("Введите срок годности посылки");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                parcel = new PerishableParcel(description, weight,
                        deliveryAddress, sendDay, timeToLive);
                perishableParcelBox.addParcel(parcel);
            }
            default: {
                System.out.println("Неверный ввод");
            }
        }

        allParcels.add(parcel);
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
        System.out.println("Все посылки были успешно отправлены");
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int result = 0;
        for (Parcel parcel : allParcels) {
            result += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая цена за отправку: " + result);
    }

    private static void checkStatus() {
        for (Parcel parcel : trackableParcels) {
            System.out.println("Введите местоположение посылки");
            String newLocation = scanner.nextLine();
            FragileParcel fragileParcel = (FragileParcel) parcel;
            fragileParcel.reportStatus(newLocation);
        }
    }

    private static void checkBox() {
        System.out.println("Введите тип коробки которую хотите посмотреть");
        System.out.println("1 - Стандартные посылки");
        System.out.println("2 - Хрупкие посылки");
        System.out.println("3 - Скоропортящиеся посылки");

        int typeOfBox = Integer.parseInt(scanner.nextLine());

        switch (typeOfBox) {
            case 1:
                System.out.println("Все стандартные посылки: ");
                List<Parcel> standardParcels = standardParcelBox.getAllParcels();
                for (Parcel parcel : standardParcels) {
                    System.out.println("Посылка " + parcel.getDescription());
                }
                break;
            case 2:
                System.out.println("Все хрупкие посылки: ");
                List<Parcel> fragileParcels = fragileParcelBox.getAllParcels();
                for (Parcel parcel : fragileParcels) {
                    System.out.println("Посылка " + parcel.getDescription());
                }
                break;
            case 3:
                System.out.println("Все скоропортящиеся посылки: ");
                List<Parcel> perishableParcels = perishableParcelBox.getAllParcels();
                for (Parcel parcel : perishableParcels) {
                    System.out.println("Посылка " + parcel.getDescription());
                }
                break;
            default:
                System.out.println("Неверный выбор");
        }
    }

}

