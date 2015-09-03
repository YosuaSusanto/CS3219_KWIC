public class Input {
	public void run(String titles, String excludedWords, Storage storage) {
		storage.setLines(titles);
		storage.setExcludes(excludedWords);
	}
}
