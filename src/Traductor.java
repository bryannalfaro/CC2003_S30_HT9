import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Traductor {
	
	public void translateHash(MapInterface<String, String> map) {
		Scanner entrada = new Scanner(System.in);
		String word = "";
		String sentence = "";
		try {
			String directorioNuevo = System.getProperty("user.dir");
	        
			Scanner inputScan = new Scanner(new File(directorioNuevo + "\\src\\ejemplo.txt"));
			while (inputScan.hasNextLine()) {
	            String line = inputScan.nextLine();
	            String[] tranlateLine = line.split(" ");
	            String translateWord = "";
	            for (int i = 0; i < tranlateLine.length; i++) {
	            	word = tranlateLine[i].toLowerCase();
					if(word.indexOf(",") > -1) {
						word = word.substring(0, word.indexOf(","));
						translateWord = map.get(word);
						if (translateWord == null) {
							translateWord = "*" + word+ "*";
						} else {
							translateWord = map.get(word);
						}
	                } else {
	                	translateWord = map.get(word);
	                	if (translateWord == null) {
	                		translateWord = "*" + word + "*";
						} else {
							translateWord = map.get(word);
						}
	                }
					sentence = (sentence + " " + translateWord).trim();
				}
	            sentence = sentence + "\n";         
	        }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sentence); 
	}
	
}

