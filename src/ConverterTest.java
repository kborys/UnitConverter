import java.util.ArrayList;
import java.util.Scanner;

public class ConverterTest {

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

        LengthUnit converter;

        boolean working = true;
        boolean correctUnitType = true;
        boolean correctBaseUnit = true;
        boolean correctTargetUnit = true;
        double inputValue = 0;
        double outputValue = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome in the UnitConverter.");


        while(working) {
            //jezeli wprowadzono nieprawidlowy typ, to wracamy tutaj. wysylamy informacje
            if (!correctUnitType) {
                System.out.println("Entered unit type does not exist. Try again.");
                correctUnitType = true;
            }

            System.out.println("Choose unit type: length, weight, temperature.");
            String inputUnitType = scan.next().toLowerCase();

            //jeżeli wprowadzono prawidłowy typ jednostki, wyślij do konsoli
            if (unitTypes.contains(inputUnitType)){
                System.out.println("You chose " + inputUnitType + ".");
            }


            while (correctUnitType) {
                if (inputUnitType.equals("length")) {
                    //jezeli wprowadzono nieprawidlowa jednostke bazowa, to wracamy tutaj. wysylamy informacje
                    if (!correctBaseUnit) {
                        System.out.println("Entered base unit does not exist. Try again.");
                        correctBaseUnit = true;
                    }

                    System.out.println("Choose base unit: mm, cm, dm, km.");
                    String inputBaseUnit = scan.next().toLowerCase();

                    //jeżeli wprowadzono prawidlowa jednostke bazowa, wyślij do konsoli
                    if (lengthUnits.contains(inputBaseUnit)){
                        System.out.println("You chose " + inputBaseUnit + ".");
                    }


                    while (correctBaseUnit) {
                        if (inputBaseUnit.equals("mm")) {
                            //jezeli wprowadzono nieprawidlowa jednostke docelowa, to wracamy tutaj. wysylamy informacje
                            if (!correctTargetUnit) {
                                System.out.println("Entered target unit does not exist. Try again.");
                                correctTargetUnit = true;
                            }

                            System.out.println("Choose target unit: mm, cm, dm, km.");
                            String inputTargetUnit = scan.next().toLowerCase();

                            //jeżeli wprowadzono prawidlowa jednostke docelowa, wyślij do konsoli
                            if (lengthUnits.contains(inputTargetUnit)){
                                System.out.println("You chose " + inputTargetUnit + ".");
                            }


                            while (correctTargetUnit) {
                                if (lengthUnits.contains(inputTargetUnit)){
                                    converter = new Milimeter();
                                    System.out.println("Type value that you want to convert.");
                                    inputValue = scan.nextDouble();

                                    if (inputTargetUnit.equals("mm")) {
                                        outputValue = converter.toMilimeters(inputValue);
                                    } else if (inputTargetUnit.equals("cm")) {
                                        outputValue = converter.toCentimeters(inputValue);
                                    } else if (inputTargetUnit.equals("dm")) {
                                        outputValue = converter.toDecimeters(inputValue);
                                    } else if (inputTargetUnit.equals("m")) {
                                        outputValue = converter.toMeters(inputValue);
                                    } else if (inputTargetUnit.equals("km")) {
                                        outputValue = converter.toKilometers(inputValue);
                                    }
                                    System.out.println(inputValue + inputBaseUnit + " is equal to " + outputValue + inputTargetUnit);
                                    correctTargetUnit = false;
                                    correctBaseUnit = false;
                                    correctUnitType = false;
                                    working = false;
                                } else {
                                    correctTargetUnit = false;
                                }
                            }






                        }

                        else {correctBaseUnit = false;
                        }
                    }//koniec petli while(CorrectBaseUnit)





                //} else if (inputUnitType.equals("weight")) {
                //    System.out.println("You chose weight.");
                //    break;
                //} else if (inputUnitType.equals("temperature")) {
                //    System.out.println("You chose temperature.");
                //    break;
                } else {
                    correctUnitType = false;
                } //koniec instrukcji if else
            } //koniec petli while(correctUnitType)
        }
    }
}
