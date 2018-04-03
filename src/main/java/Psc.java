import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Psc {
    private Connection conn;
    private String driver = "com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/psc";
    private String username="root";
    private String password="";
    public void InsertRowInDB(String Obec,String Okres,String Psc) throws SQLException {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, this.username, this.password);
            String query = "Insert into postcodes (Obec,Okres,Psc) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, Obec);
            ps.setString(2, Okres);
            ps.setString(3, Psc);
            ps.executeUpdate();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            conn.close();
        }

    }
}

