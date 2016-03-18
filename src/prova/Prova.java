package prova;

import java.sql.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBAccessor;

/**
 * Classe prova de connexió amb una BD preestablerta.
 *
 * @author mor
 * @version 100316
 */
public class Prova {
    
    public static void main(String args[]) {
        try {
            executarTest();
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void executarTest() throws SQLException, IOException {
        Connection conn = DBAccessor.getConnection();


        try {
            Statement stat = (Statement) conn.createStatement();

            stat.executeUpdate("CREATE TABLE prova (text CHAR(20))");
            stat.executeUpdate("INSERT INTO prova VALUES ('JOEL')");

            ResultSet resultat = stat.executeQuery("SELECT * FROM prova");
            if (resultat.next()) {
                System.out.println(resultat.getString(1));
            }
            resultat.close();
            stat.executeUpdate("DROP TABLE prova");
        } finally {
            conn.close();
        }
    }
    
}
