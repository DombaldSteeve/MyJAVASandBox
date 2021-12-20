package demojdbc;
/*
import java.sql.*;

public class ConnLaurentFormation {

	public static void main(String[] args) {
		
		Connection conn = null;
        Statement stmt = null;
        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/laurentformation", "root", "root");
            System.out.println("Connected database successfully...");

            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM formation.myview";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next())
            {
                int id = rs.getInt("id");
                String title = rs.getString("titre");
                String editor = rs.getString("nom_editeur");
                String author = rs.getString("nom_auteur");
                System.out.format("%s, %s, %s, %s\n", id, title, editor, author);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try 
            {
                conn.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            
        }
		

	}

}
*/
