package service;

import entities.Cliente;

public interface ClienteService {

	public void create (Cliente cliente);
	public Cliente read (String dni);
	public Cliente update (Cliente cliente);
	public void delete (String dni);
	
}
