package operaciones;

import java.util.List;
import java.util.Scanner;

import entities.Banco;
import entities.Cuenta;
import menus.MenusBancos;
import service.BancoService;
import service.BancoServiceJPAImpl;

public class OperacionesBancos {

    static final int CREAR = 1;
    static final int MOSTRAR = 2;
    static final int MOSTRAR_CUENTAS = 3;
    static final int MODIFICAR = 4;
    static final int ELIMINAR = 5;
    static final int SALIR = 0;
	
    
    
	static Scanner scINT = new Scanner(System.in);
	static Scanner scString = new Scanner(System.in);
	
	
    

	public static void ejecutar_opciones() {	
		boolean salir = false;
		do {
			int opcion = MenusBancos.mostrar_menu_princial();
			switch (opcion) {
			case CREAR:
				crear_banco();
				break;
			case MOSTRAR:
				mostrar_banco();
				break;
			case MOSTRAR_CUENTAS:	
				mostrar_cuentas_banco();
			case MODIFICAR:
				modificar_banco();
				break;
			case ELIMINAR:
				eliminar_banco();
				break;
			case SALIR:
				salir = true;
				break;
			default:
				System.out.println("Opción no válida.");
				System.out.println();
			}
			
		} while (salir == false);
	}
	
	
    public static void crear_banco() {
    	BancoService bancoService = new BancoServiceJPAImpl();
    	Banco new_banco = new Banco();
    	
    	System.out.println("Introduzca el nombre del banco: ");
    	new_banco.setNombre(scString.nextLine());
    	System.out.println("Introduzca la ciudad del banco: ");
    	new_banco.setCiudad(scString.nextLine());
    	
    	bancoService.create(new_banco);
    	
    	System.out.println("");
    }
    public static void mostrar_banco() {
    	BancoService bancoService = new BancoServiceJPAImpl();
    	System.out.println("Introduzca el ID del banco: ");
    	Banco bancoEncontrado = bancoService.read(scINT.nextInt());
    	
    	System.out.printf("%-3s | %-22s | %-30s  \n", "ID", "Nombre", "Ciudad");
		System.out.println("--------------------------------------------------------------------");
		System.out.printf("%-3s | %-22s | %-30s  \n", bancoEncontrado.getId(), 
				bancoEncontrado.getNombre(), bancoEncontrado.getCiudad());
		
		System.out.println("");
	
    }
    public static void mostrar_cuentas_banco() {
    	BancoService bancoService = new BancoServiceJPAImpl();
    	System.out.println("Introduzca el ID del banco: ");
    	Banco bancoEncontrado = bancoService.read(scINT.nextInt());
    	
    	List <Cuenta> cuentas = bancoEncontrado.getCuentas();
    	System.out.printf("%-9s | %-22s | %-30s  \n", "ID", "DNI Cliente", "Saldo");
    	System.out.println("--------------------------------------------------------------------");
    	for (Cuenta cuenta : cuentas) {
    		System.out.printf("%-9s | %-22s | %-30s  \n", cuenta.getId(), 
    				cuenta.getCliente().getDni(), cuenta.getSaldo());
    	}
    }
    public static void modificar_banco() {
    	BancoService bancoService = new BancoServiceJPAImpl();
    	System.out.println("Introduzca el ID del banco a modificar: ");
    	Banco banco = bancoService.read(scINT.nextInt());
    	
    	System.out.println("Introduzca el nuevo nombre del banco: ");
    	banco.setNombre(scString.nextLine());
    	System.out.println("Introduzca la nueva ciudad del banco: ");
    	banco.setCiudad(scString.nextLine());
    	
    	bancoService.update(banco);
    	
    	System.out.println("");
    }
    public static void eliminar_banco() {
    	BancoService banco = new BancoServiceJPAImpl();
    	System.out.println("Introduzca el ID del banco a eliminar: ");
    	banco.delete(scINT.nextInt());
    }
	
}
