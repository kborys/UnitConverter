abstract public class TemperatureUnit {
    abstract double toCelsius(double input);
    abstract double toKelvin(double input);
    abstract double toFahrenheit(double input);
}

class Celsius extends TemperatureUnit {
    double toCelsius(double input) {
        return input;
    }
    double toKelvin(double input) {
        return input + 273.15;
    }
    double toFahrenheit(double input) {
        return (input * 1.8) + 32;
    }
}

class Kelvin extends TemperatureUnit {
    double toCelsius(double input) {
        return input - 273.15;
    }
    double toKelvin(double input) {
        return input;
    }
    double toFahrenheit(double input) {
        return (input * 1.8) - 459.67;
    }
}

class Fahrenheit extends TemperatureUnit {
    double toCelsius(double input) {
        return (input - 32) * 0.5555555555555556;
    }
    double toKelvin(double input) {
        return (input + 459.67) * 0.5555555555555556;
    }
    double toFahrenheit(double input) {
        return input;
    }
}
