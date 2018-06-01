package classEmployees;

public class BasePluscommissionEmployees extends Employees {
	private int grossSales = 0;
	private float commissionRate = 0;
	private float baseSalary = 0;
	private float bonus = 0;

	public int getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(int grossSales) {
		this.grossSales = grossSales;
	}

	public float getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(float commissionRate) {
		this.commissionRate = commissionRate;
	}

	public float getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(float baseSalary) {
		this.baseSalary = baseSalary;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

}
