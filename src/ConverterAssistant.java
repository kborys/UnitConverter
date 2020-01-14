public class ConverterAssistant {

    public LengthUnit createLengthUnit(String inputBaseUnit){
        switch (inputBaseUnit) {
            case "mm":
                return new Milimeter();

            case "cm":
                return new Centimeter();

            case "dm":
                return new Decimeter();

            case "m":
                return new Meter();

            case "km":
                return new Kilometer();

            default:
                return null;
        }

    }

    public WeightUnit createWeightUnit(String inputBaseUnit){
        switch (inputBaseUnit) {
            case "g":
                return new Gram();

            case "kg":
                return new Kilogram();

            case "t":
                return new Tonne();

            default:
                return null;
        }

    }

    public TemperatureUnit createTemperatureUnit(String inputBaseUnit){
        switch (inputBaseUnit) {
            case "celsius":
                return new Celsius();

            case "fahrenheit":
                return new Fahrenheit();

            case "kelvin":
                return new Kelvin();

            default:
                return null;
        }

    }
}

class ConverterAssistantTester {

    public static void main(String[] args) {
        String inputBaseUnit = "mm";
        ConverterAssistant converterAssistant = new ConverterAssistant();
        LengthUnit converter = converterAssistant.createLengthUnit(inputBaseUnit);

        System.out.println(converter.toCentimeters(100));
    }

}
