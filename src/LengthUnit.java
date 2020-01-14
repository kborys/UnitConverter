public abstract class LengthUnit {
    double toMilimetersRatio;
    double toCentimetersRatio;
    double toDecimetersRatio;
    double toMetersRatio;
    double toKilometersRatio;


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

    public LengthUnit(double toMilimetersRatio, double toCentimetersRatio, double toDecimetersRatio, double toMetersRatio, double toKilometersRatio) {
        this.toMilimetersRatio = toMilimetersRatio;
        this.toCentimetersRatio = toCentimetersRatio;
        this.toDecimetersRatio = toDecimetersRatio;
        this.toMetersRatio = toMetersRatio;
        this.toKilometersRatio = toKilometersRatio;
    }
}


class Milimeter extends LengthUnit{
    public Milimeter(){
        super(1, 0.1, 0.01, 0.001, 0.000001);
    }
 }

class Centimeter extends LengthUnit{
    public Centimeter(){
        super(10, 1, 0.1, 0.01, 0.00001);
    }
}

class Decimeter extends LengthUnit{
    public Decimeter(){
        super(100, 10, 1, 0.1, 0.0001);
    }
}

class Meter extends LengthUnit{
    public Meter(){
        super(1000, 100, 10, 1, 0.001);
    }
}

class Kilometer extends LengthUnit{
    public Kilometer(){
        super(1000000, 100000, 10000, 1000, 1);
    }
}