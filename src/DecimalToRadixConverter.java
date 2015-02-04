
public class DecimalToRadixConverter {

	private int base=10;
	//any base up to 36
	public DecimalToRadixConverter (int base)
	{
		this.base=base;
	}
	public String convertDecimalNumber(int decNum)
	{
		int quotient=1;
		int remainder;
		String baseRNum="";
		while(quotient !=0){
			quotient=decNum / base;
			remainder=decNum % base;
//			System.out.println("decNum = "+decNum);
//			System.out.println("quotient = "+quotient);
//			System.out.println("remainder = "+remainder);
			baseRNum = singleDigitRepr(remainder)+baseRNum;
			decNum = quotient;
		}
		return baseRNum;

	}
	private char singleDigitRepr(int num)
	{
		if (num<10)
			return(char) ('0'+num);
		else if (num<(10+26))
			return (char) ('A'+(num-10));
		else
		{
			System.err.println("Digit too large (base should be 36 or less)");
			return 0;
		}
	}
}