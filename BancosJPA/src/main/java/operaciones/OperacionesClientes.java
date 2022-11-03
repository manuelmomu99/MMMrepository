package operaciones;

import java.util.List;
import java.util.Scanner;


import entities.Cliente;
import entities.Cuenta;
import menus.MenusClientes;
import service.ClienteService;
import service.ClienteServiceJPAImpl;

public class OperacionesClientes {

    static final int CREAR = 1;
    static final int MOSTRAR_TODO = 2;
    static final int MOSTRAR = 3;
    static final int MOSTRAR_CUENTAS = 4;
    static final int MODIFICAR = 5;
    static final int ELIMINAR = 6;
    static final int SALIR = 0;
	
    
    
	static Scanner scINT = new Scanner(System.in);
	static Scanner scString = new Scanner(System.in);
	
	
    

	public static void ejecutar_opciones() {	
		boolean salir = false;
		do {
			int opcion = MenusClientes.mostrar_menu_princial();
			switch (opcion) {
			case CREAR:
				crear_cliente();
				break;
			case MOSTRAR_TODO:
				mostrar_CLIENTES();
			case MOSTRAR:
				mostrar_cliente();
			case MOSTRAR_CUENTAS:	
				mostrar_cuentas_cliente();
				break;
			case MODIFICAR:
				modificar_cliente();
				break;
			case ELIMINAR:
				eliminar_cliente();
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
	
	
	
    public static void crear_cliente() {
    	ClienteService clienteService = new ClienteServiceJPAImpl();
    	Cliente new_cliente = new Cliente();
    	
    	System.out.println("Introduzca el DNI del cliente: ");
    	new_cliente.setDni(scString.nextLine());
    	System.out.println("Introduzca el nombre del cliente: ");
    	new_cliente.setNombre(scString.nextLine());
    	System.out.println("Introduzca la dirección del cliente: ");
    	new_cliente.setDireccion(scString.nextLine());
    	
    	clienteService.create(new_cliente);
    	
    	System.out.println("");
    }
    public static void mostrar_cliente() {
    	ClienteService clienteService = new ClienteServiceJPAImpl();
    	System.out.println("Introduzca el DNI del cliente: ");
    	Cliente clienteEncontrado = clienteService.read(scString.nextLine());
    	
    	System.out.printf("%-9s | %-22s | %-30s  \n", "DNI", "Nombre", "Dirección");
		System.out.println("--------------------------------------------------------------------");
		System.out.printf("%-9s | %-22s | %-30s  \n", clienteEncontrado.getDni(), 
				clienteEncontrado.getNombre(), clienteEncontrado.getDireccion());
		
		System.out.println("");
    }
    public static void mostrar_CLIENTES() {
    	

    	
    	
    	
    	
    	
    	
    }
    public static void mostrar_cuentas_cliente() {
    	ClienteService clienteService = new ClienteServiceJPAImpl();
    	System.out.println("Introduzca el DNI del cliente: ");
    	Cliente clienteEncontrado = clienteService.read(scString.nextLine());
    	
    	List <Cuenta> cuentas = clienteEncontrado.getCuentas();
    	System.out.printf("%-9s | %-22s | %-30s  \n", "ID", "Nombre Banco", "Saldo");
    	System.out.println("--------------------------------------------------------------------");
    	for (Cuenta cuenta : cuentas) {
    		System.out.printf("%-9s | %-22s | %-30s  \n", cuenta.getId(), 
    				cuenta.getBanco().getNombre(), cuenta.getSaldo());
    	}
    }
    public static void modificar_cliente() {
    	ClienteService clienteService = new ClienteServiceJPAImpl();
    	System.out.println("Introduzca el DNI del cliente a modificar: ");
    	Cliente cliente = clienteService.read(scString.nextLine());
    	
    	System.out.println("Introduzca el nuevo DNI del cliente: ");
    	cliente.setDni(scString.nextLine());
    	System.out.println("Introduzca el nuevo nombre del cliente: ");
    	cliente.setNombre(scString.nextLine());
    	System.out.println("Introduzca la nueva dirección del cliente: ");
    	cliente.setDireccion(scString.nextLine());
    	
    	clienteService.update(cliente);
    	
    	System.out.println("");
    }
    public static void eliminar_cliente() {
    	ClienteService clienteService = new ClienteServiceJPAImpl();
    	System.out.println("Introduzca el DNI del cliente a eliminar: ");
    	clienteService.delete(scString.nextLine());
    }
	
}
