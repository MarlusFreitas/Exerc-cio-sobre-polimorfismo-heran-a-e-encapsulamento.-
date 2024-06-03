package entities;

public class OutsourcedCharge extends Employee {
    private double additionalChage;

    

    public OutsourcedCharge() {
        super();
    }

    public OutsourcedCharge(String name, int hours, double valuePerHour, double additionalChage) {
        super(name, hours, valuePerHour);
        this.additionalChage = additionalChage;
    }

    public double getAdditionalChage() {
        return additionalChage;
    }

    public void setAdditionalChage(double additionalChage) {
        this.additionalChage = additionalChage;
    }

    @Override
    public double payment(){
    return super.payment() + additionalChage * 1.1;
    }
}
