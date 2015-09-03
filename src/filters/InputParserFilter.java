package filters;

public class InputParserFilter extends Filter {
	private static final String SPACE=" ";
	 public void run()
	 {
		 write(split(readTitles()),split(readWordsToIgnore()));
	 }
	 private String split(String input)
	 {
		 String str="";
		 String[] words= input.split(",");
		 for(String s:words)
		 {
			 if(s.endsWith(SPACE))
			 {
				 s=s.substring(0,s.length()-1);
			 }
			 if(s.startsWith(SPACE))
			 {
				 str+=s.substring(1 , s.length());
			 }
			 else 
			 {
				 str+=s;
			 }
			 str+=",";
		 }
		 return str;
	 }
}
