
public interface ThermalObject {
	int getTemperatureD();
	void setTemperatureD(int newValue);
	
	int getHeatD();
	void setHeatD(int newValue);
	
	
	
	void assertTouches (ThermalObject t);
	void retractTouches(ThermalObject t);
	boolean isTouching(ThermalObject t);
	
	String toString();
}
