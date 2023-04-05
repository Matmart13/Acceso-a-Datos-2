import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EliminarCliente {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda_videojuegos", "root", "");
		 // La consulta es un String con código SQ
		    Statement st = cn.createStatement();            
		    String sql2 ="DELETE FROM `cliente` WHERE id = '4'";

			//Ejecuta una consulta de tipo insert, update o delete
			st.executeUpdate(sql2);     
		    st.close(); // Cierra el statement
		    cn.close(); // Cierra la conexión
				} catch (ClassNotFoundException ex){
		    System.out.println("conexion no establecida");
				}		
	}
}