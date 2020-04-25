import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		FactoryTree factory  = new FactoryTree();
		Map<String, String> map = null;
		
		System.out.println("Seleccione la opcion a utilizar: ");
		System.out.println("1. HashMap ");
		System.out.println("2. SplayTree ");
		
		int opcion= entrada.nextInt();
		
		if(opcion==1) {
			map = factory.getFactoryMap(1);
			String directorioNuevo = System.getProperty("user.dir");
            Scanner inputScan = new Scanner(new File(directorioNuevo + "\\Spanish.txt"));
            while (inputScan.hasNextLine()) {
                String line = inputScan.nextLine();
                int indice_particion = line.lastIndexOf("	");
                String primera_parte = line.substring(0,indice_particion).trim();
               
                String segunda_parte = line.substring(indice_particion+1).trim();
                segunda_parte = segunda_parte.split(",")[1];
                System.out.println(segunda_parte);
                map.put(primera_parte,segunda_parte);
            }
			//HashMap 
			
		}else if (opcion==2) {
			//SplayTree
			
		}

	}

}
