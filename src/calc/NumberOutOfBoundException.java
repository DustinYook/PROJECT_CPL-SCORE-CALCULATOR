package calc;

public class NumberOutOfBoundException extends Exception 
{
	public NumberOutOfBoundException() 
	{
		super();
	}
	
	public NumberOutOfBoundException(String message)
	{
		super(message);
	}
}