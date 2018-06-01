package classEmployees;

public class commissionEmployees extends Employees {
	private int grossSales = 0;
	private float CommissionRate = 0;
	private float bonus = 0;

	public int getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(int grossSales) {
		this.grossSales = grossSales;
	}

	public float getCommissionRate() {
		return CommissionRate;
	}

	public void setCommissionRate(float commissionRate) {
		CommissionRate = commissionRate;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

}
