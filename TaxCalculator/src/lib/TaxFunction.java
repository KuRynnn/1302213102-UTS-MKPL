package lib;

public class TaxFunction {
	private static int monthlySalary;
    private static int otherMonthlyIncome;
    private static int deductible;
    private static boolean isMarried;
	private static int numberOfChildren;
	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	public static int calculateTax(EmployeeSalary salary, int numberOfMonthWorking, EmployeeFamily family) {
		monthlySalary = salary.getMonthlySalary();
        otherMonthlyIncome = salary.getOtherMonthlyIncome();
        deductible = salary.getAnnualDeductible();
        isMarried = family.getSpouseName() != null;
        numberOfChildren = family.getChildNames().size();
		int tax = 0;
		
		validateNumberOfMonths(numberOfMonthWorking);
		capNumberOfChildren();

		int taxableIncome = calculateTaxableIncome(numberOfMonthWorking);
		tax = calculateTaxAmount(taxableIncome);
		
		return Math.max(tax, 0);
	}

	private static void validateNumberOfMonths(int numberOfMonthWorking) {
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 months working per year");
		}
	}
	
	private static void capNumberOfChildren() {
		numberOfChildren = Math.min(numberOfChildren, 3);
	}
	
	private static int calculateNonTaxableIncome() {
		int nonTaxableIncome = 54000000;
		if (isMarried) {
			nonTaxableIncome += 4500000; 
		}
		nonTaxableIncome += numberOfChildren * 4500000; 
		return nonTaxableIncome;
	}
	private static int calculateTaxableIncome(int numberOfMonthWorking) {
		int baseIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
		int nonTaxableIncome = calculateNonTaxableIncome();
		return baseIncome - deductible - nonTaxableIncome;
	}
	
	private static int calculateTaxAmount(int taxableIncome) {
		return (int) Math.round(0.05 * taxableIncome);
	}
}
