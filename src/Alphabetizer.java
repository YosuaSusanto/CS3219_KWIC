import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Alphabetizer {
	private List<WordAndIndex> sortedWordList = new ArrayList<WordAndIndex>();
	
	private Storage storage = null;
	
	public Alphabetizer(CircularShift circularShift) {
		sortedWordList = circularShift.getWordList();
		storage = circularShift.getStorage();
	}
	
	public List<WordAndIndex> getWordList() {
		return sortedWordList;
	}
	
	public Storage getStorage() {
		return storage;
	}
	
	public void run() {
		Collections.sort(sortedWordList);
	}
}
