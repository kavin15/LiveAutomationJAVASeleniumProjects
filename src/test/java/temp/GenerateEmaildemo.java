package temp;

import java.util.Date;

public class GenerateEmaildemo {

	public static void main(String[] args) 
	{
		Date d=new Date();
	    String dateString=d.toString();//here it's covert date to string
	    String repalceString=dateString.replaceAll(" ", "");
	    String nospaceAndColan = repalceString.replaceAll("\\:", "");
	    String emailwithTimeStamp = nospaceAndColan+"@gmail.com";
	    System.out.println(emailwithTimeStamp);
	}

}
