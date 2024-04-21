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
		if (grade == 1) {
			salary.setMonthlySalary(3000000);
			if (information.isForeigner()) {
				salary.setMonthlySalary((int) (3000000 * 1.5));
			}
		}else if (grade == 2) {
			salary.setMonthlySalary(5000000);
			if (information.isForeigner()) {
				salary.setMonthlySalary((int) (3000000 * 1.5));
			}
		}else if (grade == 3) {
			salary.setMonthlySalary(7000000);
			if (information.isForeigner()) {
				salary.setMonthlySalary((int) (3000000 * 1.5));
			}
		}
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
