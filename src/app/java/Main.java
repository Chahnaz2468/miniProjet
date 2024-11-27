import java.util.Scanner;

import controllers.ControllerPrincipal;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	    ControllerPrincipal controller = new ControllerPrincipal();
	    
	    try {
	        controller.init();  
	    } finally {
	        scanner.close();  
	    }
	}
}


