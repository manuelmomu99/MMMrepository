package service;

import entities.Cuenta;

public interface CuentaService {

	public void create (Cuenta cuenta);
	public Cuenta read (int id);
	public Cuenta update (Cuenta cuenta);
	public void delete (int id);
	
}
