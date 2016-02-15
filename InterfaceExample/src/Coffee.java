import java.util.ArrayList;


public class Coffee implements ThermalObject {
	
	private int temperatureD = 0;
	@Override
	public int getTemperatureD() {
		return temperatureD;
	}

	@Override
	public void setTemperatureD(int newValue) {
		temperatureD = newValue;

	}

	private int heatD = 0;
	@Override
	public int getHeatD() {
		return heatD;
	}

	@Override
	public void setHeatD(int newValue) {
		heatD = newValue;

	}

	private ArrayList<ThermalObject> ObjectsTouched = new ArrayList<ThermalObject>();
	@Override
	public void assertTouches(ThermalObject t) {
		ObjectsTouched.add(t);
		
	}

	@Override
	public void retractTouches(ThermalObject t) {
		ObjectsTouched.remove(t);
		
	}
	
	@Override
	public boolean isTouching(ThermalObject t) {
		return ObjectsTouched.contains(t);
	}
}
