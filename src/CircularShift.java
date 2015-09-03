import java.util.ArrayList;
import java.util.List;


public class CircularShift {
	private Storage storage = null;
	
	private List<WordAndIndex> wordList = new ArrayList<WordAndIndex>();
	
	public CircularShift(Storage storage) {
		this.storage = storage;
	}
	
	public List<WordAndIndex> getWordList() {
		return wordList;
	}
	
	public Storage getStorage() {
		return storage;
	}
	
	public void run() {
		for (int i = 0; i < storage.getLinesSize(); i++) {
			for (int j = 0; j < storage.getLineSize(i); j++) {
				boolean containExclWord = false;
				for (int k = 0; k < storage.getExcludesSize(); k++) {
					if (storage.getExcludedWord(k).equalsIgnoreCase(storage.getWord(i, j))) {
						containExclWord = true;
					}
				}
				if (!containExclWord) {
					WordAndIndex tempWord = new WordAndIndex(storage.getWord(i, j).toUpperCase(), i, j);
					wordList.add(tempWord);					
				}
			}
		}
	}
}
