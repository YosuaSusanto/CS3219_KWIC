import java.util.Comparator;


public class WordAndIndex implements Comparable<WordAndIndex>{
	 public String word;
	 public Integer linesNo;
	 public Integer wordNo;
	 public WordAndIndex() {
		 this.word = "";
		 this.linesNo = -1;
		 this.wordNo = -1;
	 }
	 
	 public WordAndIndex(String word, Integer linesNo, Integer wordNo) {  
		 this.word = word;
		 this.linesNo = linesNo;
		 this.wordNo = wordNo;
	 }
	 
	 public void print() {
		 System.out.print("[" + this.word + ", " + this.linesNo + ", " + this.wordNo + "]");
	 }
	 
	 public int compareTo(WordAndIndex obj) {
		 Integer temp = this.word.compareTo(obj.word);
		 if (temp == 0) {
			 temp = this.linesNo.compareTo(obj.linesNo);
			 if (temp == 0) {
				 temp = this.wordNo.compareTo(obj.wordNo);
				 return temp;
			 }
			 else {
				 return temp;
			 }
		 }
		 else {
			 return temp;
		 }
			 
	 }
	 
//	 public class WordComparator<T> implements Comparator<WordAndIndex>
	 Comparator<WordAndIndex> comparator = new Comparator<WordAndIndex>() {
		 @Override
	     public int compare(WordAndIndex obj1, WordAndIndex obj2) {
	         return obj1.compareTo(obj2);
	     }
	 };
}
