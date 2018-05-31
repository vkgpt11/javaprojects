package speech.to.text.speech_text;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;


public class speechtotext {
	public static void main(String args[]) throws IOException
	{
		
		 Configuration configuration = new Configuration();

//	        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
//	        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
//	        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
//	        URL urldict = new File("C:\\\\Users\\\\Vikas\\\\eclipse-workspace\\\\speechtotext\\\\speech-text\\\\resources\\\\grammer\\\\2546.dic").toURI().toURL();
//	        URL urllm = new File("C:\\\\Users\\\\Vikas\\\\eclipse-workspace\\\\speechtotext\\\\speech-text\\\\resources\\\\grammer\\\\2546.lm").toURI().toURL();

//	        configuration.setDictionaryPath(urldict);
//	        configuration.setLanguageModelPath(urllm);
	        
	        configuration.setAcousticModelPath("resources/grammer/en_in");
	        configuration.setDictionaryPath("resources/grammer/en_in.dic");
	        configuration.setLanguageModelPath("resources/grammer/en-us.lm.bin");

	        
	     // Grammar
			configuration.setGrammarPath("resources/grammer");
			configuration.setGrammarName("grammer");
	      //Recognizer object, Pass the Configuration object
	        LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);
	 
	        //Start Recognition Process (The bool parameter clears the previous cache if true)
	        recognize.startRecognition(true);
	 
	        //Creating SpeechResult object
	        SpeechResult result;
	 
	        //Check if recognizer recognized the speech
	        while ((result = recognize.getResult()) != null) {
	 
	            //Get the recognized speech
	            String command = result.getHypothesis();
	            //Match recognized speech with our commands
	            System.out.println(command);
	        }
	        
//		StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
//		InputStream stream = new FileInputStream(new File("C:\\Users\\Vikas\\eclipse-workspace\\speechtotext\\speech-text\\target\\classes\\speech\\to\\text\\speech_text\\s.mp3"));
//
//	        recognizer.startRecognition(stream);
//		SpeechResult result;
//	        while ((result = recognizer.getResult()) != null) {
//	        	System.out.format("words: %s\n",result.getWords().size());
//		    System.out.format("Hypothesis: %s\n", result.getHypothesis());
//		}
//		recognizer.stopRecognition();
	}
}
