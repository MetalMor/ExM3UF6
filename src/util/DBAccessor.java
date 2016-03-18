package util;

import java.sql.Connection;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Classe d'utilitat connectora amb una BD preestablerta.
 *
 * @author mor
 * @version 100316
 */
public class DBAccessor {
    
    // Propietats del connector JDBC (per connectarse a una BD han d'estar a un fitxer *.properties)
    private static final String JDBC_URL = "jdbc.drivers";
    private static final String JDBC_USER = "jdbc.drivers";
    private static final String JDBC_PASSWD = "jdbc.drivers";
    private static final String JDBC_DRIVERS = "jdbc.drivers";
    private static final String PROPS_FILE = "/home/mor/Documentos/m3/ExM3UF6/src/util/database.properties";
    
    /**
     * Mètode per connectar-se a una BD preestablerta a un fitxer *.properties.
     * 
     * @return Connection
     * @throws SQLException
     * @throws IOException 
     */
    public static Connection getConnection() throws SQLException, IOException {
        
        Properties props = new Properties(); // classe properties per encapsular les dades del fitxer *.properties
        FileInputStream in = new FileInputStream(PROPS_FILE); // fitxer *.properties
        props.load(in); // carrega el fitxer a l'objecte Properties
        in.close(); // tanca la connexió amb el fitxer

        // AGAFA LES PROPIETATS DEL FITXER *.properties I LES GUARDA A VARIABLES STRING
        String drivers = props.getProperty(JDBC_DRIVERS);
        if (!DBUtil.isNull(drivers))
            System.setProperty(JDBC_DRIVERS, drivers);
        String url = props.getProperty(JDBC_URL);
        String usuari = props.getProperty(JDBC_USER);
        String password = props.getProperty(JDBC_PASSWD);

        // RETORN de l'objecte Connection per començar a enviar queries a la BD
        return DriverManager.getConnection(url, usuari, password);
        
    }
    
}
