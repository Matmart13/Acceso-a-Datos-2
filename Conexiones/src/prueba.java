import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class prueba {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda_videojuegos", "root", "");
			// La consulta es un String con código SQL
			String sql1 = "SELECT * FROM cliente";
			Statement st = cn.createStatement();
			// Ejecuta una consulta que devuelve resultados
			ResultSet rs = st.executeQuery(sql1);

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
						+ "" + rs.getInt(5));
			}
			String sql2 = "UPDATE `cliente` SET `id`='3',`Nombre`='Martin',`Apellidos`='[M]',`Edad`= 22,`Telefono`= 616276 WHERE id = "
					+ 2;

			// Ejecuta una consulta de tipo insert, update o delete
			st.executeUpdate(sql2);
			rs.close(); // Cierra el resulset
			st.close(); // Cierra el statement
			cn.close(); // Cierra la conexión
		} catch (ClassNotFoundException ex) {
			System.out.println("conexion no establecida");
		}
	}
}
