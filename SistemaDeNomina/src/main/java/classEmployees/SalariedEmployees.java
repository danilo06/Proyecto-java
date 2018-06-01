package classEmployees;

public class SalariedEmployees extends Employees {
	private float weeklySalary = 0;
	private float bonus = 0;

	public float getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(float weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

}
