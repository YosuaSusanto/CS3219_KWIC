package filters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AlphabetizerFilter extends Filter{
	private static final String Newline="\n";
	private String str,outputString="";
	ArrayList<String> string;
	public void run()
	{
		str=readTitles();
		string=new ArrayList<String>(Arrays.asList(str.split(",")));
		Collections.sort(string);
		for(String s: string)
		{
			outputString+=s+Newline;
		}
		write(outputString,null);
	}
}
