package util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe d'utilitat per a l'ús de bases de dades.
 *
 * @author mor
 * @version 180316
 */
public class DBUtil {
    
    /**
     * Retorna el nombre de files del resultat d'una consulta.
     * 
     * @param rs
     * @return Valor enter del nombre de resultats
     * @throws SQLException 
     */
    public static int rowCount(ResultSet rs) throws SQLException {
        int rowCount = 0;
        int currRow = rs.getRow();
        // Valid ResultSet?
        if (!rs.last()) return -1;
        rowCount = rs.getRow();
        // Return the cursor to the current position
        if (currRow == 0) rs.beforeFirst();
        else rs.absolute(currRow);
            return rowCount;
    }
    
    /**
     * Comprova si un objecte és null.
     * 
     * @param o Object.
     * @return boolean true si és null.
     */
    public static boolean isNull(Object o) {
        return o == null;
    };
    
}
