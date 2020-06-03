package Theme1;

public class Main   {
    // 1 task
    public static void main(String[] args) {
        // 2 task
        byte byteValue = 10;
        short shortValue = 11;
        int intValue= 100;
        long longValue = 200L;
        char charValue = 'C';
        boolean booleanValue = false;
        float floatValue = 1.25f;
        double doubleValue = 12.56;
        String StingValue = "StringValue";

    }

    // 3 task
    public static double calculationMethod(double a, double b, double c, double d){
        return a * (b + (c / d));
    }

    // 4 task
    public static boolean task3Method (double a, double b){
        return ( a+b >=10 ) && ( a+b <= 20 );
    }

    // 5 task
    public static void whatNumber(int num){
        if (isNegative(num)) {
            System.out.println("Negative");
        }
        else{
            System.out.println("Positive");
        }
    }

    // 6 task
    public static boolean isNegative(int value){
        return value < 0 ;
    }

    // 7 task
    public static void HelloMethod(String methodName){
        System.out.println("Hello, " + methodName);
    }

    // 8 task
    public static boolean isLeapYear (int year){
        if ( (( year % 4 == 0 ) && ( year % 100 != 0 )) || ( year % 400 == 0 ) ){
            System.out.println(year + " is Leap year");
            return true;
        }
        else {
            System.out.println(year + " is not Leap year");
            return false;
        }
    }

    // 9 task
    // Это две разные сигнатуры одного метода (перегрузка метода).
}
