import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Clase principal para la traduccion del archivo
 * @author Bryann Alfaro
 * @author Diego de Jesus
 *
 */
public class principal {

	
	public static void main(String[] args) {
		
		/**
		 * Variables 
		 */
		Scanner entrada = new Scanner(System.in);
		FactoryTree<String, String> factory  = new FactoryTree<String, String>();
		MapInterface<String, String> mapDic;
		String temp = "";
		Traductor traductor = new Traductor();
		
		System.out.println("Seleccione la opcion a utilizar: ");
		System.out.println("1. HashMap ");
		System.out.println("2. SplayTree ");
		
		int opcion= entrada.nextInt();
		
		//Si se desea la implementacion por hashmap
		if(opcion==1) {
			mapDic= factory.getFactoryMap(1);
			String directorioTexto = System.getProperty("user.dir");
			Scanner inputScan;
			try {
				
				
	            if(directorioTexto.contains("src")) {
	            	inputScan = new Scanner(new File(directorioTexto + "\\Spanish.txt"));
	            }else {
	            	inputScan = new Scanner(new File(directorioTexto + "\\src\\Spanish.txt"));
	            }
				
				
				while (inputScan.hasNextLine()) {
	                String line = inputScan.nextLine();
	                int indice_particion = line.lastIndexOf("	");
	                String ingles = line.substring(0,indice_particion).trim();
	                if(!ingles.equals(temp)) {
	                	String espanol = line.substring(indice_particion+1).trim();
		                if(espanol.indexOf(",") > -1) {
		                	espanol = espanol.substring(0, espanol.indexOf(","));
		                } else if (espanol.indexOf(";") > -1) {
		                	espanol = espanol.substring(0, espanol.indexOf(";"));
						} else if (espanol.indexOf("(") > -1) {
							espanol = espanol.substring(0, espanol.indexOf("("));
						} else if (espanol.indexOf("[") > -1) {
							espanol = espanol.substring(0, espanol.indexOf("["));
						}
		                mapDic.put(ingles,espanol);
	                }
	                temp = ingles;
	                
	            }
				inputScan.close();
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
            
			traductor.translateHash(mapDic); //Se realiza la traduccion
			
		}
		//Si se desea la implementacion por splay Tree
		else if (opcion==2) {
			
			mapDic= factory.getFactoryMap(2);
			Scanner inputScan;
			try {
				String directorioNuevo = System.getProperty("user.dir");
				
				if(directorioNuevo.contains("src")) {
	            	inputScan = new Scanner(new File(directorioNuevo + "\\Spanish.txt"));
	            }else {
	            	inputScan = new Scanner(new File(directorioNuevo + "\\src\\Spanish.txt"));
	            }
	            
				while (inputScan.hasNextLine()) {
	                String line = inputScan.nextLine();
	                int indice_particion = line.lastIndexOf("	");
	                String ingles = line.substring(0,indice_particion).trim();
	                if(!ingles.equals(temp)) {
	                	String espanol = line.substring(indice_particion+1).trim();
		                if(espanol.indexOf(",") > -1) {
		                	espanol = espanol.substring(0, espanol.indexOf(","));
		                } else if (espanol.indexOf(";") > -1) {
		                	espanol = espanol.substring(0, espanol.indexOf(";"));
						} else if (espanol.indexOf("(") > -1) {
							espanol = espanol.substring(0, espanol.indexOf("("));
						} else if (espanol.indexOf("[") > -1) {
							espanol = espanol.substring(0, espanol.indexOf("["));
						}
		                mapDic.put(ingles,espanol);
	                }
	                temp = ingles;
	                
	            }
				inputScan.close();
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
            
			traductor.translateSplay(mapDic); //Se realiza la traduccion
			
		}

	}

}
