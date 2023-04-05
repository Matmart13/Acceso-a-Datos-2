import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mostrarlistaprofesores {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd-colegio", "root", "");
		 // La consulta es un String con código SQL
		    String sql1 = "SELECT * FROM profesores";
		    Statement st = cn.createStatement();
		    // Ejecuta una consulta que devuelve resultados                
		    ResultSet rs = st.executeQuery(sql1);   
		    
		    while (rs.next()) {
		        System.out.println (rs.getInt(1) + " " + rs.getString(2)+" "+ rs.getString(3)+ " "+ rs.getString(4) +" "
		    + rs.getString(5) +" " +rs.getInt(6) +" " +rs.getString(7) + " " + rs.getInt(8) +" " +rs.getString(9) + " " + rs.getString(10));
		    }  ;                
		    rs.close(); // Cierra el resulset
		    st.close(); // Cierra el statement
		    cn.close(); // Cierra la conexión
				} catch (ClassNotFoundException ex) {
		    System.out.println("conexion no establecida");
				}		
			}
	}


