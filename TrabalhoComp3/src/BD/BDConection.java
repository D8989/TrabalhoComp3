package BD;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BDConection {
	// private static final Logger logger = LoggerFactory.getLogger(DatabaseConnectionSingleton.class);

    private static BDConection instance = new BDConection();

    private String dbString;

    @SuppressWarnings("deprecation")
	private BDConection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        } catch (Exception e) {
            // logger.error("failed to initialize derby");
            throw new RuntimeException("failed to initialize derby");
        }

        try {
            // logger.info("opening database properties file");
            InputStream propertiesStream = this.getClass().getResourceAsStream("db.properties");
            Properties dbConnProps = new Properties();
            dbConnProps.load(propertiesStream);

            dbString = dbConnProps.getProperty("dbString");
        } catch (IOException ex) {
            // logger.error("failed to load db properties");
            throw new RuntimeException("failed to load db properties");
        }
    }

    public static BDConection getInstance() {
        return instance;
    }

    public Connection getConnection() {
        //logger.debug("acquiring connection");
        try {
            return DriverManager.getConnection(dbString);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void shutdown() {
        // logger.info("shutting down database");
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException ex) {
            if (ex.getSQLState().equals("XJ015")) {
                //logger.info("derby shutdown ok");
                return;
            }

            //logger.error("something happened, I guess");
            //logger.error(ex.toString());
        }
    }
}
