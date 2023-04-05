import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class añadirVentas {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda_videojuegos", "root", "");
			// La consulta es un String con código SQ
			Statement st = cn.createStatement();
			String sql2 = "INSERT INTO `ventas`(`sal_id`, `emp_id`, `cus_id`, `sal_total`) VALUES ('16','6','10','800')";
			String sql3 = "INSERT INTO `ventas`(`sal_id`, `emp_id`, `cus_id`, `sal_total`) VALUES ('18','10','1','900')";

			// Ejecuta una consulta de tipo insert, update o delete
			st.executeUpdate(sql2);
			st.executeUpdate(sql3);

			st.close(); // Cierra el statement
			cn.close(); // Cierra la conexión
		} catch (ClassNotFoundException ex) {
			System.out.println("conexion no establecida");
		}

	}

}
