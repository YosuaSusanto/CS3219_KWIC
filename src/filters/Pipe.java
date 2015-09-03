package filters;

public class Pipe {
	private boolean connection;
	private StringBuffer buffer1,buffer2;
	public Pipe()
	{
		buffer1= new StringBuffer();
		buffer2= new StringBuffer();
		connection=false;
	}
	
	public void write(String title,String wordsToIgnore)
	{
		buffer1.append(title);
		buffer2.append(wordsToIgnore);
		connection=true;
	}
	public String readTitles()
	{
		if(connection)
		{
			connection=false;
			return buffer1.toString();
		}
		else 
			return null;
	}
	public String readWordsToIgnore()
	{
		return buffer2.toString();
	}
}
