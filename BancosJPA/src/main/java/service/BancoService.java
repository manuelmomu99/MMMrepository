package service;

import entities.Banco;

public interface BancoService {
	public void create (Banco banco);
	public Banco read (int id);
	public Banco update (Banco banco);
	public void delete (int id);
}
