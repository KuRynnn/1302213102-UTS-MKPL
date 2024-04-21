package lib;

import java.util.List;

public class EmployeeFamily {
    private String spouseName;
    private String spouseIdNumber;
    private List<String> childNames;
    private List<String> childIdNumbers;

    public EmployeeFamily(String spouseName, String spouseIdNumber, List<String> childNames, List<String> childIdNumbers) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
        this.childNames = childNames;
        this.childIdNumbers = childIdNumbers;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getSpouseIdNumber() {
        return spouseIdNumber;
    }

    public void setSpouseIdNumber(String spouseIdNumber) {
        this.spouseIdNumber = spouseIdNumber;
    }

    public List<String> getChildNames() {
        return childNames;
    }

    public void setChildNames(List<String> childNames) {
        this.childNames = childNames;
    }

    public List<String> getChildIdNumbers() {
        return childIdNumbers;
    }

    public void setChildIdNumbers(List<String> childIdNumbers) {
        this.childIdNumbers = childIdNumbers;
    }
}

