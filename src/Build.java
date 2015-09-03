import filters.*;

public class Build {
 public  String KWIC_PipeAndFilter(String words, String wordsToIgnore)
 {
	 DataSource dataSource = new DataSource();
	 AlphabetizerFilter alphabetizerFilter= new AlphabetizerFilter();
	 CircularShiftFilter circularShiftFilter=new CircularShiftFilter();
	 InputParserFilter inputParserFilter= new InputParserFilter();
	 DataSink dataSink= new DataSink();
	 Pipe sourceInput= new Pipe(),inputCircular= new Pipe(),circularAlphabet=new Pipe(),alphabetSink=new Pipe();

	 dataSource.outputPipe(sourceInput);
	 inputParserFilter.inputPipe(sourceInput);
	 inputParserFilter.outputPipe(inputCircular);
	 circularShiftFilter.inputPipe(inputCircular);
	 circularShiftFilter.outputPipe(circularAlphabet);
	 alphabetizerFilter.inputPipe(circularAlphabet);
	 alphabetizerFilter.outputPipe(alphabetSink);
	 dataSink.inputPipe(alphabetSink);
	 dataSource.run(words, wordsToIgnore);
	 inputParserFilter.run();
	 circularShiftFilter.run();
	 alphabetizerFilter.run();
	 return dataSink.run();
 }
}