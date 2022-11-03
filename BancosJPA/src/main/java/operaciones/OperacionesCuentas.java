package operaciones;

import java.util.Scanner;

import entities.Banco;
import entities.Cliente;
import entities.Cuenta;
import menus.MenusCuentas;
import service.BancoService;
import service.BancoServiceJPAImpl;
import service.ClienteService;
import service.ClienteServiceJPAImpl;
import service.CuentaService;
import service.CuentaServiceJPAImpl;

public class OperacionesCuentas {

	
	static final int CREAR = 1;
    static final int MOSTRAR = 2;
    static final int MODIFICAR = 3;
    static final int ELIMINAR = 4;
    static final int SALIR = 0;
	
    
    
	static Scanner scINT = new Scanner(System.in);
	static Scanner scString = new Scanner(System.in);
	static Scanner scDouble = new Scanner(System.in);
	
    

	public static void ejecutar_opciones() {	
		boolean salir = false;
		do {
			int opcion = MenusCuentas.mostrar_menu_princial();
			switch (opcion) {
			case CREAR:
				crear_cuenta();
				break;
			case MOSTRAR:
				mostrar_cuenta();
				break;
			case MODIFICAR:
				modificar_cuenta();
				break;
			case ELIMINAR:
				eliminar_cuenta();
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
	
	
    public static void crear_cuenta() {
    	CuentaService cuentaService = new CuentaServiceJPAImpl();
    	BancoService bancoService = new BancoServiceJPAImpl();
    	ClienteService clienteService = new ClienteServiceJPAImpl();
    	
    	Cuenta new_cuenta = new Cuenta();
    	
    	System.out.println("Introduzca el DNI del cliente: ");
    	Cliente cliente = clienteService.read(scString.nextLine());
    	new_cuenta.setCliente(cliente);
    	System.out.println("Introduzca el ID del banco: ");
    	Banco banco = bancoService.read(scINT.nextInt());
    	new_cuenta.setBanco(banco);
    	System.out.println("Introduzca el saldo de la cuenta: ");
    	new_cuenta.setSaldo(scDouble.nextDouble());
    	
    	cuentaService.create(new_cuenta);
   
    	System.out.println("");
    }
    public static void mostrar_cuenta() {
    	CuentaService cuentaService = new CuentaServiceJPAImpl();
    	System.out.println("Introduzca el ID de la cuenta: ");
    	Cuenta cuentaEncontrada = cuentaService.read(scINT.nextInt());
    	
    	System.out.printf("%-3s | %-15s | %-10s | %-10s \n", "ID", "DNI Cliente", "ID Banco", "Nombre Banco");
		System.out.println("--------------------------------------------------------------------");
		System.out.printf("%-3s | %-15s | %-10s | %-10s \n", cuentaEncontrada.getId(), 
				cuentaEncontrada.getCliente().getDni(), cuentaEncontrada.getBanco().getId(), 
				cuentaEncontrada.getBanco().getNombre());
		
		System.out.println("");
	
    }
    public static void modificar_cuenta() {
    	CuentaService cuentaService = new CuentaServiceJPAImpl();
    	BancoService bancoService = new BancoServiceJPAImpl();
    	ClienteService clienteService = new ClienteServiceJPAImpl();
    	
    	System.out.println("Introduzca el ID de la cuenta a modificar: ");
    	Cuenta cuenta = cuentaService.read(scINT.nextInt());
    	
    	System.out.println("Introduzca el DNI del nuevo cliente de la cuenta: ");
    	Cliente cliente = clienteService.read(scString.nextLine());
    	cuenta.setCliente(cliente);
    	System.out.println("Introduzca la ID del nuevo banco de la cuenta: ");
    	Banco banco = bancoService.read(scINT.nextInt());
    	cuenta.setBanco(banco);
    	System.out.println("Introduzca el nuevo saldo de la cuenta: ");
    	cuenta.setSaldo(scDouble.nextDouble());
    	
    	cuentaService.update(cuenta);
    	
    	System.out.println("");
    }
    public static void eliminar_cuenta() {
    	CuentaService cuenta = new CuentaServiceJPAImpl();
    	System.out.println("Introduzca el ID la cuenta a eliminar: ");
    	cuenta.delete(scINT.nextInt());
    }
	
	
}
