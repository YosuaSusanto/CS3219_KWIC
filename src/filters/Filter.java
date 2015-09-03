package filters;

public abstract class Filter{
	protected Pipe in,out;
	
	public void inputPipe(Pipe pipe)
	{
		in=pipe;
	}
	
	public void outputPipe(Pipe pipe)
	{
		out=pipe;
	}
	
	public void write(String str,String str2)
	{
		out.write(str,str2);
	}
	
	public String readTitles()
	{
		return in.readTitles();
	}
	public String readWordsToIgnore()
	{
		return in.readWordsToIgnore();
	}
}
