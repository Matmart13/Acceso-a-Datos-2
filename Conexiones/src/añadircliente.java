import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class añadircliente {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda_videojuegos", "root", "");
			// La consulta es un String con código SQL
			String sql1 = "SELECT * FROM cliente";
			Statement st = cn.createStatement();
			String sql2 = "INSERT INTO `cliente`(`id`, `Nombre`, `Apellidos`, `Edad`, `Telefono`) VALUES ('18','Pedro','Sanchez','50','616349086')";
			String sql3 = "INSERT INTO `cliente`(`id`, `Nombre`, `Apellidos`, `Edad`, `Telefono`) VALUES ('36','Brandon','Sanderson','42','616349076')";
			String sql4 = "INSERT INTO `cliente`(`id`, `Nombre`, `Apellidos`, `Edad`, `Telefono`) VALUES ('45','Alejandro','Sanchez','32','616349016')";
			String sql6 = "INSERT INTO `cliente`(`id`, `Nombre`, `Apellidos`, `Edad`, `Telefono`) VALUES ('18','Guillermo','Perez','16','616349034')";
			// Ejecuta una consulta de tipo insert, update o delete
			st.executeUpdate(sql4);
			st.executeUpdate(sql3);
			st.executeUpdate(sql6);
			st.close(); // Cierra el statement
			cn.close(); // Cierra la conexión
		} catch (ClassNotFoundException ex) {
			System.out.println("conexion no establecida");
		}
	}

}
