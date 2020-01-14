import java.util.*;

public class Converter {
    ArrayList<String> unitTypes;
    ArrayList<String> lengthUnits;
    ArrayList<String> weightUnits;
    ArrayList<String> temperatureUnits;
    LengthUnit lengthUnit = null;
    WeightUnit weightUnit = null;
    TemperatureUnit temperatureUnit = null;

    ConverterAssistant converterAssistant = new ConverterAssistant();

    public static void main(String[] args){
        Converter converter = new Converter();

        converter.setConverter();
        converter.runConverter();
    }

    private void setConverter() {
        unitTypes = new ArrayList<String>(){
            {
                add("length");
                add("weight");
                add("temperature");}
        };

        lengthUnits = new ArrayList<String>(){
            {
                add("mm");
                add("cm");
                add("dm");
                add("m");
                add("km");}
        };

        weightUnits = new ArrayList<String>(){
            {
                add("g");
                add("kg");
                add("t");}
        };

        temperatureUnits = new ArrayList<String>(){
            {
                add("celsius");
                add("fahrenheit");
                add("kelvin");}
        };
        System.out.println("Welcome in the UnitConverter.");

    }

    private void runConverter() {
        Scanner scan = new Scanner(System.in);
        String inputUnitType = null;
        String inputBaseUnit = null;
        String inputTargetUnit = null;

        boolean correctUnitType = false;
        boolean correctBaseUnit = false;
        boolean correctTargetUnit = false;
        boolean correctInputValue = false;
        double inputValue = 0;
        double outputValue = 0;

        //choose unit type. loop until correct unit type is chosen
        while(!correctUnitType){
            System.out.println("Choose desired unit type:");
            System.out.println("length, weight, temperature.");

            inputUnitType = scan.nextLine().toLowerCase();

            if(unitTypes.contains(inputUnitType) || weightUnits.contains(inputUnitType) || temperatureUnits.contains(inputUnitType)) {
                correctUnitType = true;
                System.out.println("You chose " + inputUnitType + ".");
            } else {
                inputUnitType = null;
                System.out.println("You chose wrong unit type. Try again.");
            }
        }

        //choose base unit. loop until correct base unit is chosen
        while(correctUnitType && !correctBaseUnit){
            System.out.println("Choose desired base unit:");
            showAvailableUnits(inputUnitType);
            inputBaseUnit = scan.nextLine().toLowerCase();

            if(checkInputBaseUnit(inputUnitType, inputBaseUnit)) {
                setBaseUnit(inputUnitType, inputBaseUnit); //constructs object depending on unit type and base unit
                System.out.println("You chose " + inputBaseUnit + ".");
                correctBaseUnit = true;

            } else {
                inputBaseUnit = null;
                System.out.println("You chose wrong base unit. Try again.");
            }
        }

        //choose target unit. loop until correct target unit is chosen
        while(correctBaseUnit && !correctTargetUnit){
            System.out.println("Choose desired target unit:");
            showAvailableUnits(inputUnitType);
            inputTargetUnit = scan.nextLine().toLowerCase();

            if(checkInputTargetUnit(inputUnitType, inputTargetUnit)) {
                System.out.println("You chose " + inputTargetUnit + ".");
                correctTargetUnit = true;
            } else {
                inputTargetUnit = null;
                System.out.println("You chose wrong target unit. Try again.");
            }
        }

        //type value. loop until entered value is correct
        while(correctTargetUnit & !correctInputValue){
                System.out.println("Enter value you want to convert [" + inputBaseUnit +"]");
                correctInputValue = true;

                try {
                    inputValue = scan.nextDouble();
                } catch(InputMismatchException e) {
                    System.out.println("You entered wrong value. Try again.");
                    correctInputValue = false;
                }
        }

        //if everything is set properly - finalize conversion
        if(correctInputValue) {
            outputValue = finalizeConversion(inputTargetUnit, inputValue);
            System.out.println(inputValue + inputBaseUnit + " equals to " + outputValue + inputTargetUnit + ".");
        }
    }

    private void showAvailableUnits(String inputUnitType) {
        switch (inputUnitType) {
            case "length":
                System.out.println(lengthUnits);
                break;

            case "weight":
                System.out.println(weightUnits);
                break;

            case "temperature":
                System.out.println(temperatureUnits);
                break;
        }
    }

    private boolean checkInputBaseUnit(String inputUnitType, String inputBaseUnit) {
        if((inputUnitType.equals("length") && lengthUnits.contains(inputBaseUnit)) || (inputUnitType.equals("weight") && weightUnits.contains(inputBaseUnit))  ||(inputUnitType.equals("temperature") && temperatureUnits.contains(inputBaseUnit)) ) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkInputTargetUnit(String inputUnitType, String inputTargetUnit) {
        if((inputUnitType.equals("length") && lengthUnits.contains(inputTargetUnit)) || (inputUnitType.equals("weight") && weightUnits.contains(inputTargetUnit))  ||(inputUnitType.equals("temperature") && temperatureUnits.contains(inputTargetUnit)) ) {
            return true;
        } else {
            return false;
        }
    }

    private void setBaseUnit(String inputUnitType, String inputBaseUnit){
        switch(inputUnitType){
            case "length":
                lengthUnit = converterAssistant.createLengthUnit(inputBaseUnit);
                break;

            case "weight":
                weightUnit = converterAssistant.createWeightUnit(inputBaseUnit);
                break;

            case "temperature":
                temperatureUnit = converterAssistant.createTemperatureUnit(inputBaseUnit);
                break;
        }
    }

    private double finalizeConversion(String inputTargetUnit, double inputValue){
        if (lengthUnits.contains(inputTargetUnit)) {
            return convertLength(inputTargetUnit, inputValue);
        } else if (weightUnits.contains(inputTargetUnit)) {
            return convertWeight(inputTargetUnit, inputValue);
        } else if (temperatureUnits.contains(inputTargetUnit)) {
            return convertTemperature(inputTargetUnit, inputValue);
        } else {
            System.out.println("Something went wrong. Contact with the administrator.");
            return 0;
        }
    }

    private double convertLength(String inputTargetUnit, double inputValue){
        switch(inputTargetUnit) {
            case "mm":
                return lengthUnit.toMilimeters(inputValue);
            case "cm":
                return lengthUnit.toCentimeters(inputValue);
            case "dm":
                return lengthUnit.toDecimeters(inputValue);
            case "m":
                return lengthUnit.toMeters(inputValue);
            case "km":
                return lengthUnit.toKilometers(inputValue);
            default:
                System.out.println("Something went wrong. Contact the administrator");
                return 0;
        }
    }

    private double convertWeight(String inputTargetUnit, double inputValue){
        switch(inputTargetUnit) {
            case "g":
                return weightUnit.toGrams(inputValue);
            case "kg":
                return weightUnit.toKilorams(inputValue);
            case "t":
                return weightUnit.toTonnes(inputValue);
            default:
                System.out.println("Something went wrong. Contact the administrator");
                return 0;
        }
    }

    private double convertTemperature(String inputTargetUnit, double inputValue){
        switch(inputTargetUnit) {
            case "celsius":
                return temperatureUnit.toCelsius(inputValue);
            case "fahrenheit":
                return temperatureUnit.toFahrenheit(inputValue);
            case "kelvin":
                return temperatureUnit.toKelvin(inputValue);
            default:
                System.out.println("Something went wrong. Contact the administrator");
                return 0;
        }
    }
}
