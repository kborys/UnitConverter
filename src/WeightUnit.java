public abstract class WeightUnit {
    double toGramsRatio;
    double toKilogramsRatio;
    double toTonnesRatio;

    public double toGrams(double input){
        return input * toGramsRatio;
    }
    public double toKilorams(double input){
        return input * toKilogramsRatio;
    }
    public double toTonnes(double input){
        return input * toTonnesRatio;
    }

    public WeightUnit(double toGramsRatio, double toKilogramsRatio, double toTonnesRatio){
        this.toGramsRatio = toGramsRatio;
        this.toKilogramsRatio = toKilogramsRatio;
        this.toTonnesRatio = toTonnesRatio;
    }
}

class Gram extends WeightUnit{
    public Gram(){
        super(1, 0.001, 0.000001);
    }
}

class Kilogram extends WeightUnit{
    public Kilogram(){
        super(1000, 1, 0.001);
    }
}

class Tonne extends WeightUnit{
    public Tonne(){
        super(1000000, 1000, 1);
    }
}


