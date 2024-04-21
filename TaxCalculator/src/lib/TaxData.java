package lib;

public class TaxData {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int numberOfMonthWorking;
    private int deductible;
    private boolean isMarried;
    private int numberOfChildren;

    // Constructor
    public TaxData(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        this.monthlySalary = monthlySalary;
        this.otherMonthlyIncome = otherMonthlyIncome;
        this.numberOfMonthWorking = numberOfMonthWorking;
        this.deductible = deductible;
        this.isMarried = isMarried;
        this.numberOfChildren = numberOfChildren;
    }

    // Getters
    public int getMonthlySalary() {
        return monthlySalary;
    }

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public int getNumberOfMonthWorking() {
        return numberOfMonthWorking;
    }

    public int getDeductible() {
        return deductible;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    // Setters
    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public void setOtherMonthlyIncome(int otherMonthlyIncome) {
        this.otherMonthlyIncome = otherMonthlyIncome;
    }

    public void setNumberOfMonthWorking(int numberOfMonthWorking) {
        this.numberOfMonthWorking = numberOfMonthWorking;
    }

    public void setDeductible(int deductible) {
        this.deductible = deductible;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }
}

