import java.io.*;

public class KWIC_ADT {
	private String outputText = "";
	
	public void run(String words, String wordsToIgnore) throws IOException {
		Storage storage = new Storage();
		Input input = new Input();
		input.run(words, wordsToIgnore, storage);
		
		CircularShift circularShift = new CircularShift(storage);
		circularShift.run();
		
		Alphabetizer alphabetizer = new Alphabetizer(circularShift);
		alphabetizer.run();
		
		Output output = new Output(alphabetizer);
		outputText = output.run();
	}
	
	public String getOutputText() {
		return this.outputText;
	}
}

//	
//	
//	private static void getInput(String fileName, List<List<String>> lines, List<String> excludedWords) throws IOException {
//		try 
//		{
//			BufferedReader in = null;
//			List<String> inputList = null;
//			String[] tempArr = null;
//			
//			in = new BufferedReader(new FileReader("input.txt"));
//			String str;
//			str = in.readLine();
//			if (str == null) 
//	        {
//	        	System.out.println("Error!! Title input is empty!!");
//	        }
//			else
//			{
//				inputList = Arrays.asList(str.split(","));
//				for (String inputLine : inputList)
//				{
//					lines.add(Arrays.asList(inputLine.trim().split(" ")));
//				}
//			}
//			str = in.readLine();
//			if (str == null)
//			{
//				tempArr = new String[0];
//			}
//			else
//			{
//				str = str.replaceAll(" ", "");
//				tempArr = str.split(",");
//				for (String temp : tempArr) {
//					excludedWords.add(temp);
//				}
//			}
//			
//			in.close();
//		} 
//		catch (FileNotFoundException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	private static void createCircularShift(List<List<String>> lines,
//			List<String> excludedWords, List<WordAndIndex> wordList) {
//		for (int i = 0; i < lines.size(); i++) {
//			for (int j = 0; j < lines.get(i).size(); j++) {
//				if (!(excludedWords.contains(lines.get(i).get(j).toLowerCase()))) {
//					WordAndIndex tempWord = new WordAndIndex(lines.get(i)
//							.get(j).toUpperCase(), i, j);
//					wordList.add(tempWord);
//				}
//			}
//		}
//	}
//	
//	private static void printOutput(List<WordAndIndex> wordList, List<List<String>> lines) throws UnsupportedEncodingException, FileNotFoundException, IOException {
//		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
//	              new FileOutputStream("output.txt"), "utf-8"))) 
//	    {
//			for (WordAndIndex tempWord : wordList)
//			{
//				String tempString = "";
//				for (int i = 0; i < lines.get(tempWord.linesNo).size(); i++)
//				{
//					int j = i + tempWord.wordNo;
//					if (j >= lines.get(tempWord.linesNo).size())
//					{
//						j = j % lines.get(tempWord.linesNo).size();
//					}
//					if (tempString == "")
//					{
//						tempString += tempWord.word.toUpperCase() + " ";
//					}
//					else
//					{
//						tempString += lines.get(tempWord.linesNo).get(j) + " ";
//					}
//				}
//				System.out.println(tempString.trim());
//				writer.write(tempString + "\n");		
//			}
//	    }
//	}
//}