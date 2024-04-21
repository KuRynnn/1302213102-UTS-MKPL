package lib;

import java.time.LocalDate;
import java.util.List;

public class Employee {

	private EmployeeInformation information;
    private EmployeeSalary salary;
    private EmployeeFamily family;
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, boolean gender) {
		this.information = new EmployeeInformation(employeeId, firstName, lastName, idNumber, address,
		yearJoined, monthJoined, dayJoined, isForeigner, gender);
	}
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	public void setMonthlySalary(int grade) {	
		int baseSalary = 0;
		switch (grade) {
			case 1:
				baseSalary = 3000000;
				break;
			case 2:
				baseSalary = 5000000;
				break;
			case 3:
				baseSalary = 7000000;
				break;
			default:
				break;
		}

		if (information.isForeigner()) {
			baseSalary *= 1.5;
		}
		
		salary.setMonthlySalary(baseSalary);
	}
	
	public void setEmployeeFamily(String spouseName, String spouseIdNumber, List<String> childNames, List<String> childIdNumbers) {
		this.family = new EmployeeFamily(spouseName, spouseIdNumber, childNames, childIdNumbers);
	}
	
	
	public int getAnnualIncomeTax() {
		LocalDate date = LocalDate.now();
		int monthWorkingInYear;
		
		if (date.getYear() == information.getYearJoined()) {
			monthWorkingInYear = date.getMonthValue() - information.getMonthJoined();
		} else {
			monthWorkingInYear = 12;
		}

		return TaxFunction.calculateTax(salary, monthWorkingInYear, family);
	}
	
}
