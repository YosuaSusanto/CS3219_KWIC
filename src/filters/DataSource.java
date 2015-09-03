package filters;

public class DataSource extends Filter {
	public void run(String words, String wordsToIgnore)
	{
		write(words,wordsToIgnore.toLowerCase());
	}
}
