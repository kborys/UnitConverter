import java.util.Scanner;

public class Converter {

    public static void main(String[] args){
        boolean working = true;
        Scanner sc = new Scanner(System.in);

        System.out.print("Witam w UnitConverter.");
        while(working) {
            String valueType;
            System.out.println("Jeśli chcesz coś przekonwertować wpisz konwertowany typ jednostki z poniższej listy: ");
            System.out.println("length.");
            System.out.println("W przecim wypadku wpisz 'exit'.");
            String i = sc.next();
            System.out.println("Wprowadź liczbę, którą chcesz przekonwertować.");
            double value = sc.nextDouble();
            LengthUnit inputUnit;
            double outputValue = 0;
            boolean active = true;

            if (i.equals("length")) {
                System.out.println("Wybrałeś konwersje długości.");
                System.out.println("Wybierz jednostkę bazową: mm, cm, dm, m, km. W innym wypadku wpisz exit.");
                i = sc.next();

                if (i.equals("mm")) {
                    inputUnit = new Milimeter();
                    System.out.println("Wybrałeś milimetry.");
                    System.out.println("Wybierz jednostkę docelową: mm, cm, dm, m, km. W innym wypadku wpisz exit.");
                    i = sc.next();

                    if (i.equals("mm")) {
                        outputValue = inputUnit.toMilimeters(value);
                        //System.out.println(value + " mm jest równe " + outputValue + " mm.");
                    } else if (i.equals("cm")) {
                        outputValue = inputUnit.toCentimeters(value);
                        //System.out.println(value + " mm jest równe " + outputValue + " cm.");
                    } else if (i.equals("dm")) {
                        outputValue = inputUnit.toDecimeters(value);
                        //System.out.println(value + " mm jest równe " + outputValue + " cm.");
                    } else if (i.equals("m")) {
                        outputValue = inputUnit.toMeters(value);
                        //System.out.println(value + " mm jest równe " + outputValue + " cm.");
                    } else if (i.equals("km")) {
                        outputValue = inputUnit.toKilometers(value);
                        //System.out.println(value + " mm jest równe " + outputValue + " cm.");
                    } else {
                        System.out.println("Taka jednostka nie istnieje. Spróbuj ponownie.");
                    }

                    System.out.println(value + " mm jest równe " + outputValue + " " + i + ".");
                }

            }

            break;
        }
    }
}
