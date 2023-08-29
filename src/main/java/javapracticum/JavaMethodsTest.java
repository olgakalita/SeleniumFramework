package javapracticum;


public class JavaMethodsTest {

    public static void main(String[] args){

        int income = 100;

        if (income >= 0 && income <= 10275) {
            System.out.println("your tax will be 10%");
        }
        //if value is 10276
        else if ( income >= 10276 && income <= 41775) {
            System.out.println("your tax will be12%");
        }
        //if value is 41776
        else if (income >= 41776 && income <= 89075) {
            System.out.println("your tax will be22%");
        }
        //if value is more than 89075
        else {
            System.out.println("please call your CPA" );
        }

        String department = "sales";
        switch(department){
            case "sales":
                System.out.println("Sales depatrment works from 8am to 12pm.");
            case "operations":
                System.out.println("Operations depatrment works from 8am to 13pm.");
            case "marketing":
                System.out.println("Marketing depatrment works from 8am to 6pm.");
            case "logistic":
                System.out.println("Logistic depatrment works from 8am to 8pm.");
            case "HR":
                System.out.println("HR works from 8am to 4pm.");
            case "accounting":
                System.out.println("Accounting depatrment works from 8am to 5pm.");

        }
        for (int i =0; i<24; i++){
            System.out.println(i);
            i++;
        }
    }
}
