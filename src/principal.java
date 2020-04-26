import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;

public class principal {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		FactoryTree<String, String> factory  = new FactoryTree<String, String>();
		MapInterface<String, String> mapDic;
		
		System.out.println("Seleccione la opcion a utilizar: ");
		System.out.println("1. HashMap ");
		System.out.println("2. SplayTree ");
		
		int opcion= entrada.nextInt();
		
		if(opcion==1) {
			mapDic= factory.getFactoryMap(1);
			
			try {
				String directorioNuevo = System.getProperty("user.dir");
	            
				Scanner inputScan = new Scanner(new File(directorioNuevo + "\\src\\Spanish.txt"));
				while (inputScan.hasNextLine()) {
	                String line = inputScan.nextLine();
	                int indice_particion = line.lastIndexOf("	");
	                String primera_parte = line.substring(0,indice_particion).trim();
	               
	                String segunda_parte = line.substring(indice_particion+1).trim();
	                segunda_parte = segunda_parte.split(",")[1];
	                System.out.println(segunda_parte);
	                mapDic.put(primera_parte,segunda_parte);
	            }
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
			//HashMap 
			
		}else if (opcion==2) {
			//SplayTree
			
		}

	}

}
