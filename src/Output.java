public class Output {
	private Alphabetizer alpha;
	
	public Output(Alphabetizer alpha) {
		this.alpha = alpha;
	}
	
	public String run() {
		String output = "";
		for (WordAndIndex tempWord : alpha.getWordList()) {
			String tempString = "";
			for (int i = 0; i < alpha.getStorage().getLineSize(tempWord.linesNo); i++) {
				int j = i + tempWord.wordNo;
				if (j >= alpha.getStorage().getLineSize(tempWord.linesNo)) {
					j = j % alpha.getStorage().getLineSize(tempWord.linesNo);
				}
				if (tempString == "") {
					tempString += tempWord.word.toUpperCase() + " ";
				}
				else {
					tempString += alpha.getStorage().getWord(tempWord.linesNo, j) + " ";
				}
			}
			output += tempString + "\n";
		}
		return output;
	}
}
