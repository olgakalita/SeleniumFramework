package javapracticum;

public class Main {
    public static void main(String[] args){
        String firstname = "Adam";
        int age = 25;
        String location = "Paris";
        String product = "EuropeTravel";
        double price = 799.99;

        System.out.println("Hello " + firstname + ". We noticed you are having a Birthday next week and you are turning " + age + ". We prepared a special gift for you, it's a trip to " + location + " with our sponsor " + product +". Price is only " + price + ". Looking forward to see you on board.");

        int car = 150;
        int daycare = 200;
        int grocery = 250;
        int total = car + daycare + grocery;
        System.out.println(total);

        int income = 1000;
        int bills = 200;
        int rest = income - bills;
        System.out.println(rest);

        int tickets = 600;
        int number = 2;
        int oneticket = tickets/number;
        System.out.println(oneticket);

        int bottle = 20;
        int amount = 7;
        int allbottles = bottle*amount;
        System.out.println(allbottles);





    }
}
