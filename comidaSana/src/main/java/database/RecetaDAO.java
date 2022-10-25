package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.BBDDUtil;

//ACCESO A MI TABLA RECETAS
public class RecetaDAO {

	public static ResultSet ver_recetas() throws SQLException {
		Connection conexion = BBDDUtil.openConnection();

		Statement st = conexion.createStatement();
		ResultSet listaRecetas = st.executeQuery("SELECT RESTAURANTE.NOMBRE, RECETA.NOMBRE "
				+ "FROM RESTAURANTE "
				+ "RIGHT JOIN OFRECE ON  RESTAURANTE.ID = OFRECE.ID_RESTAURANTE "
				+ "RIGHT JOIN RECETA ON RECETA.ID = OFRECE.ID_RECETA "
				+ "ORDER BY RECETA.NOMBRE ");
		
		System.out.printf("| %-20s | %-20s \n", "Receta", "Restaurante");
		System.out.println("--------------------------------------------------------------------");
		while (listaRecetas.next()) {
			String nombreRestaurante = listaRecetas.getString("RESTAURANTE.NOMBRE");
			String nombreReceta = listaRecetas.getString("RECETA.NOMBRE");

			System.out.printf("| %-20s | %-20s \n", nombreReceta, nombreRestaurante);
		}
		System.out.println("");
		conexion.close();
		return listaRecetas;
	}

}

//	public static Receta encuentraReceta(int id) throws SQLException {
//	
//		Receta receta = null;
//
//		Connection con = getConnection();
//
//		PreparedStatement st = con.prepareStatement("SELECT * FROM restaurante.recetas where id=?");
//		st.setInt(1, id);
//
//		ResultSet rs = st.executeQuery();
//
//		while (rs.next()) {
//
//			receta = new Receta(rs.getString("nombre"), null, rs.getString("descripcion"));
//		}
//
//		st = con.prepareStatement("SELECT i.nombre,i.precio,i.calorias FROM receta_ingredientes ri,recetas r,ingredientes i where ri.idreceta=r.id and ri.idingrediente=i.id and r.id=?");
//		st.setInt(1, id);
//		rs = st.executeQuery();
//
//		List<Ingrediente> lista=new ArrayList<Ingrediente>();
//		
//		while (rs.next()) {
//			lista.add(new Ingrediente(rs.getString("nombre"), rs.getDouble("calorias"), rs.getDouble("precio")));
//		}
//		
//		receta.setIngredientes(lista);
//		
//		con.close();
//
//		
//		return receta;
//	}


