
public class MyException extends Exception{
	
	Number value;
	
	public Number getValue(){return value;}
	
	public MyException (String message, Number problematicValue){
		super(message + " = " + problematicValue);
		value = problematicValue;
	}
}
