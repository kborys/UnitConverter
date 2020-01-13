import java.util.ArrayList;
import java.util.Scanner;

public class Converter {

    public static void main(String[] args){
        ArrayList<String> unitTypes = new ArrayList<String>();
        unitTypes.add("length");
        unitTypes.add("weight");
        unitTypes.add("temperature");

        ArrayList<String> lengthUnits = new ArrayList<String>();
        lengthUnits.add("mm");
        lengthUnits.add("cm");
        lengthUnits.add("dm");
        lengthUnits.add("m");
        lengthUnits.add("km");

        LengthUnit converter = null;

        //boolean working = true;
        boolean correctUnitType = false;
        boolean correctBaseUnit = false;
        boolean correctTargetUnit = false;
        boolean correctInputValue = false;
        String inputUnitType = null;
        String inputBaseUnit = null;
        String inputTargetUnit = null;
        double inputValue = 0;
        double outputValue = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome in the UnitConverter.");

        //wprowadzenie typu jednostki sposrod dlugosci, temperatury czy wagi. petla powtarzana tak dlugo, az zostanie wprowadzona poprawna wartosc
        while(!correctUnitType){
            System.out.println("Choose desired unit type:");
            System.out.println("length, new are coming soon.");

            inputUnitType = scan.nextLine().toLowerCase();

            if(unitTypes.contains(inputUnitType)) {
                correctUnitType = true;
                System.out.println("You chose " + inputUnitType + ".");
            } else {
                inputUnitType = null;
                System.out.println("You chose wrong unit type. Try again.");
            }
        }

        //jezeli wprowadzono juz typ jednostki to nastepuje wprowadzenie bazowej jednostki. petla powtarzana tak dlugo, az zostanie wprowadzona poprawna wartosc
        while(correctUnitType && !correctBaseUnit){
            System.out.println("Choose desired base unit:");
            System.out.println("mm, cm, dm, m, km");

            inputBaseUnit = scan.nextLine().toLowerCase();

            if(lengthUnits.contains(inputBaseUnit)) {
                correctBaseUnit = true;
                System.out.println("You chose " + inputBaseUnit + ".");

                if (inputBaseUnit.equals("mm")){
                    converter = new Milimeter();
                } else if(inputBaseUnit.equals("cm")){
                    converter = new Centimeter();
                } else if(inputBaseUnit.equals("cm")){
                    converter = new Centimeter();
                } else if(inputBaseUnit.equals("dm")){
                    converter = new Decimeter();
                } else if(inputBaseUnit.equals("m")){
                    converter = new Meter();
                } else if(inputBaseUnit.equals("km")){
                    converter = new Kilometer();
                } else {
                    System.out.println("Something went wrong. Contact with the administrator");
                }
            } else {
                inputBaseUnit = null;
                System.out.println("You chose wrong base unit. Try again.");
            }
        }

        //jezeli wprowadzono juz typ jednostki i bazowa jednostke to nastepuje wprowadzenie docelowej jednostki jednostki. petla powtarzana tak dlugo, az zostanie wprowadzona poprawna wartosc
        while(correctBaseUnit && !correctTargetUnit){
            System.out.println("Choose desired target unit:");
            System.out.println("mm, cm, dm, m, km");

            inputTargetUnit = scan.nextLine().toLowerCase();

            if(lengthUnits.contains(inputTargetUnit)) {
                correctTargetUnit = true;
                System.out.println("You chose " + inputTargetUnit + ".");
            } else {
                inputTargetUnit = null;
                System.out.println("You chose wrong target unit. Try again.");
            }
        }

        //jezeli wybrano juz bazowa i docelowa jednostke to nastepuje wprowadzenie liczby do konwersji. petla powtarzana tak dlugo, az liczba bedzie poprawna
        while(correctTargetUnit & !correctInputValue){
            System.out.println("Enter value you want to convert [" + inputBaseUnit +"]");

            //TODO Dodanie sprawdzenia poprawności wprowadzonej wartości. Co jeżeli ktoś wpisze znaki, których nie będziemy w stanie konwertować do double inputValue?
            inputValue = scan.nextDouble();
            correctInputValue = true;

            if(correctInputValue) {
                //wywoluje konwersje zaleznie od podanych jednostek i wartosci bazowej
                if (inputTargetUnit.equals("mm")){
                    outputValue = converter.toMilimeters(inputValue);
                } else if (inputTargetUnit.equals("cm")){
                    outputValue = converter.toCentimeters(inputValue);
                } else if (inputTargetUnit.equals("dm")){
                    outputValue = converter.toDecimeters(inputValue);
                } else if (inputTargetUnit.equals("m")){
                    outputValue = converter.toMeters(inputValue);
                } else if (inputTargetUnit.equals("km")){
                    outputValue = converter.toKilometers(inputValue);
                }
                //wysylamy wynik
                System.out.println(inputValue + inputBaseUnit + " equals to " + outputValue + inputTargetUnit + ".");

            }

        }
    }


}
