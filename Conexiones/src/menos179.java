import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class menos179 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda_videojuegos", "root", "");
			// La consulta es un String con código SQL
			String sql1 = "SELECT * FROM ventas where total < 179";
			Statement st = cn.createStatement();
			// Ejecuta una consulta que devuelve resultados
			ResultSet rs = st.executeQuery(sql1);

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getInt(3) + " " + rs.getDouble(4));
			}
			;
			rs.close(); // Cierra el resulset
			st.close(); // Cierra el statement
			cn.close(); // Cierra la conexión
		} catch (ClassNotFoundException ex) {
			System.out.println("conexion no establecida");
		}
	}

}
