import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Storage {
	private List<List<String>> lines = new ArrayList<List<String>>();
	
	private List<String> excludedWords = new ArrayList<String>();
	
	private int linesSize = lines.size();
	
	private int excludeSize = excludedWords.size();
	
	public int getLinesSize() {
		linesSize = lines.size();
		return linesSize;
	}
	
	public int getLineSize(int i) {
		return lines.get(i).size();
	}
	
	public int getExcludesSize() {
		excludeSize = excludedWords.size();
		return excludeSize;
	}
	
	public String getWord(int i, int j) {
		return lines.get(i).get(j);
	}
	
	public String getExcludedWord(int i) {
		return excludedWords.get(i);
	}
	
	public void setLines(String line) {
		if (line == null) 
        {
        	System.out.println("Error!! Title input is empty!!");
        }
		else
		{
			List<String >inputList = Arrays.asList(line.split(","));
			for (String inputLine : inputList)
			{
				lines.add(Arrays.asList(inputLine.trim().split(" ")));
			}
		}
	}
	
	public void setExcludes(String line) {
		String[] tempArr = null;
		
		if (line == null)
		{
			tempArr = new String[0];
		}
		else
		{
			line = line.replaceAll(", ", ",");
			tempArr = line.split(",");
			for (String temp : tempArr) {
				excludedWords.add(temp);
			}
		}
	}
}
