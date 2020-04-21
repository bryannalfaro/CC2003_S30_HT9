import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		FactoryTree factory  = new FactoryTree();
		
		
		System.out.println("Seleccione la opcion a utilizar: ");
		System.out.println("1. HashMap ");
		System.out.println("2. SplayTree ");
		
		int opcion= entrada.nextInt();
		
		if(opcion==1) {
			
			//HashMap 
			
		}else if (opcion==2) {
			//SplayTree
			
		}

	}

}
