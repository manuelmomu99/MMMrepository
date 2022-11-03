package dataAccess;

import java.sql.SQLException;

import model.Fingerprint;
import model.User;

public interface FingerprintDAO {
	public void create (Fingerprint fingerprint);
	public Fingerprint read (int id); 
	public void delete (int id);
	public void update (Fingerprint fingerprint);
}
