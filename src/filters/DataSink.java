package filters;

public class DataSink extends Filter {
	private String str="";
	public String run()
	{
		str=readTitles();
		return str;
	}
}
