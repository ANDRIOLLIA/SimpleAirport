import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вас приветствует Международный аэропорт Сочи имени В. И. Севастьянова :) ");
        String nameAirport = "Международный аэропорт Сочи имени В. И. Севастьянова";
        Airport airport = new Airport(nameAirport);
        System.out.println(airport.createFlight());
//        System.out.println("\nВыберите цифру одной из предложенных моделей самолётов -\n" +
//                "1) Boeing_777_300ER,\n" +
//                "2) Boeing_737_800,\n" +
//                "3) Airbus_A350_900,\n" +
//                "4) Airbus_А330_300,\n" +
//                "5) Airbus_А321,\n" +
//                "6) Airbus_A321NEO,\n" +
//                "7) Airbus_A320,\n" +
//                "8) Airbus_А320NEO\n" +
//                "А мы вернём кол-во самолётов указанной Вами модели :)");
//        int numberAircraftModel = new Scanner(System.in).nextInt();
//        System.out.println("Кол-во самолётов \"" +
//                AircraftModels.values()[numberAircraftModel - 1] +
//                "\" равно " + airport.findCountAircraftWithNumberSpecifiedModel(numberAircraftModel));
//
//        System.out.println("\nMap с количеством припаркованных самолетов на каждой полосе: " +
//                airport.findMapCountParkedAircraftByTerminalName());

        System.out.println("\nНапишите название точки прибытия,\n" +
                "чтобы мы вернули ближайший прилет на неё\n(" +
                "\"МОСКВА/ШРМ\", \"МОСКВА/ДМД\", \"Санкт-Петербург/Пулково\"): ");
        String namePlaceForArrival = new Scanner(System.in).nextLine();
        System.out.println(airport.findFirstFlightToSpecifiedPlaceArrival(namePlaceForArrival));

        System.out.println("\nНапишите кол-во часов, в кот-е хотите улететь");
        int hoursForDeparture = new Scanner(System.in).nextInt();
        System.out.println("Напишите название точки прибытия,\n" +
                "чтобы мы вернули ближайший прилет на неё\n(" +
                "\"МОСКВА/ШРМ\", \"МОСКВА/ДМД\", \"Санкт-Петербург/Пулково\"): ");
        String namePlaceForArrivalWithHours = new Scanner(System.in).nextLine();
        System.out.println(airport.findListFlightsDepartureInNextCountHours(hoursForDeparture, namePlaceForArrivalWithHours));
    }
}