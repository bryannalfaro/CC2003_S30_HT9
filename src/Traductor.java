import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Clase donde se realiza la traduccion del archivo
 * dependiendo del tipo de mapa.
 * @author Bryann Alfaro
 * @author Diego de Jesus
 *
 */
public class Traductor {
	
	/**
	 * Traducir si es la implementacion de HashMap
	 * @param map
	 */
	public void translateHash(MapInterface<String, String> map) {
		Scanner entrada = new Scanner(System.in);
		String word = "";
		String sentence = "";
		Scanner inputScan;
		try {
			String directorioNuevo = System.getProperty("user.dir");
	        
			
			if(directorioNuevo.contains("src")) {
            	inputScan = new Scanner(new File(directorioNuevo + "\\ejemplo.txt"));
            }else {
            	inputScan = new Scanner(new File(directorioNuevo + "\\src\\ejemplo.txt"));
            }
			
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
	
	/**
	 * Traduccion si es implementacion de splay tree
	 * @param map
	 */
	public void translateSplay(MapInterface<String, String> map) {
		Scanner entrada = new Scanner(System.in);
		String word = "";
		String sentence = "";
		Scanner inputScan;
		try {
			String directorioNuevo = System.getProperty("user.dir");
	        
			if(directorioNuevo.contains("src")) {
            	inputScan = new Scanner(new File(directorioNuevo + "\\ejemplo.txt"));
            }else {
            	inputScan = new Scanner(new File(directorioNuevo + "\\src\\ejemplo.txt"));
            }
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

