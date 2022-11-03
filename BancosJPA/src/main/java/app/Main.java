package app;


import menus.MenuPrincipal;
import operaciones.OperacionesBancos;
import operaciones.OperacionesClientes;
import operaciones.OperacionesCuentas;


public class Main {

	
	final static int CLIENTES = 1;
	final static int BANCOS = 2;
	final static int CUENTAS = 3;
	final static int SALIR = 0;
	
	
	
	public static void main(String[] args) {
		
		boolean salir = false;
		do {
			int opcion = MenuPrincipal.mostrar_menu_princial();
			switch (opcion) {
			case CLIENTES:
				OperacionesClientes.ejecutar_opciones();
				break;
			case BANCOS:
				OperacionesBancos.ejecutar_opciones();
				break;
			case CUENTAS:
				OperacionesCuentas.ejecutar_opciones();
				break;
			case SALIR:
				salir = true;
				break;
			default:
				System.out.println("Opción no válida.");
				System.out.println();
			}
			
		} while (salir == false);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// Cliente
//		Cliente cliente = new Cliente();
//		cliente.setDni("12345678E");
//		cliente.setNombre("Eduardo Antón");
//		cliente.setDireccion("c/Capitan Antonio Mena");
//		
		
//		ClienteService clienteService = new ClienteServiceJPAImpl();
//		clienteService.delete("98765432Z");
//		Cliente cliente = clienteService.read("12345678E");

		
		
		// Banco
		//Banco banco = new Banco();
//		BancoService bancoService = new BancoServiceJPAImpl();
//		Banco banco = bancoService.read(3);
//		
//		banco.setNombre("Caja Murcia");
//		banco.setCiudad("Murcia");
//		
//		
//		bancoService.update(banco);
//		bancoService.delete(7);
//		bancoService.delete(5);
//		bancoService.delete(4);
		//
		//System.out.println(bancoService.read(1).getNombre());
		
		// Cuenta
//		Cuenta cuenta = new Cuenta();
//		cuenta.setCliente(cliente);
//		cuenta.setSaldo(3000);
//		cuenta.setBanco(banco);
//		
//		CuentaService cuentaService = new CuentaServiceJPAImpl();
//		cuentaService.create(cuenta);
		
	}

}
