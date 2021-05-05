package presentacion;

import java.util.Scanner;

import servicios.UserService;
import servicios.impl.UserServiceImpl;

public class Main {

	private static UserService servicio = new UserServiceImpl();
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println();
		String username = teclado.nextLine();
		System.out.println();
		String password = teclado.nextLine();
		
		if (servicio.login(username, password))
			System.out.println("Bienvenid@ "+ username);
		
		else 
			System.out.println("Usuario o contraseña INCORRECTOS");
	}
}
		
