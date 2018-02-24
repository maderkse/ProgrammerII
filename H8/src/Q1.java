import java.util.*;
import java.util.regex.*;

public class Q1
{
	public static void main(String[] args)
	{
		System.out.println("Q1");
		Pattern p = Pattern.compile("\\d*");
		Matcher m = p.matcher("ab34ef");
		while (m.find()) {
			System.out.print(m.start() + m.group());
		}

		

		
	}
}
