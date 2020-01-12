public abstract class LengthUnit {
    double toMilimetersRatio;
    double toCentimetersRatio;
    double toDecimetersRatio;
    double toMetersRatio;
    double toKilometersRatio;

    abstract double toMilimeters(double input);
    abstract double toCentimeters(double input);
    abstract double toDecimeters(double input);
    abstract double toMeters(double input);
    abstract double toKilometers(double input);

}


class Milimeter extends LengthUnit{
    double toMilimetersRatio = 1.0f;
    double toCentimetersRatio = 0.1f;
    double toDecimetersRatio = 0.01f;
    double toMetersRatio = 0.001f;
    double toKilometersRatio = 0.000001f;

    double toMilimeters(double input){
        return input * toMilimetersRatio;
    }

    double toCentimeters(double input){
        return input * toCentimetersRatio;
    }

    double toDecimeters(double input){
        return input * toDecimetersRatio;
    }

    double toMeters(double input){
        return input * toMetersRatio;
    }

    double toKilometers(double input){
        return input * toKilometersRatio;
    }
 }
