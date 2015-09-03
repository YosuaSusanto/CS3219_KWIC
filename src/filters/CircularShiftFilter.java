package filters;

import java.util.Arrays;

public class CircularShiftFilter extends Filter {
	private static final String SPACE=" ";
	private int startIndex,endIndex=0;
	private String tempString="",title="",str="",KWIC="";
	//To insert in words to ignore
	private String[] titles,wordsToIgnore;	
	public void run()
	 {
		str=readTitles();
		titles=str.split(",");
		wordsToIgnore=readWordsToIgnore().split(",");
		for (int i=0;i<=titles.length-1;i++)
		{
			 startIndex=0;
			 title=titles[i]+SPACE;
			 endIndex=title.indexOf(SPACE);
			 //Iterate through string until end is reached
			 while(endIndex >= 0)
			 {
				 if(!checkList(title.substring(startIndex, endIndex).toLowerCase(),wordsToIgnore))
				 {
					 tempString=title.substring(startIndex, endIndex).toUpperCase()+SPACE+title.substring(endIndex+1,title.length());
					 if(startIndex>0)
					 {
						 tempString+=title.substring(0,startIndex-1);
					 }
					 KWIC+=tempString+",";	
				 }
				 startIndex=endIndex+1;
				 endIndex=title.indexOf(SPACE,endIndex+1);
			 }
		 }
		write(KWIC,null);
	 }
	
	 
	  private boolean checkList(String word,String[] wordsToIgnore)
	 {
		 if(Arrays.asList(wordsToIgnore).contains(word))
		 {
			 return true;
		 }
		 else 
			 return false;
	 }

}
