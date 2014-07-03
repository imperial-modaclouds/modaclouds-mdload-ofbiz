package mdload.userdefined;

import org.apache.log4j.Logger;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class UserDefs {
public final static Properties properties = new Properties();
public static int MAX_ITEM_QUANTITY = 7;
public static String BASE_IP;
public static int BASE_PORT = 8080;
public static String BASE_URL;
public static String LQN_FILE;
public static String LQN_SERVER;
public static int LQN_PORT = 3;

public static long RANDOM_SEED = 0L;
public static double MAX_SESSION_LENGTH = 50;

static Logger logger = Logger.getLogger(UserDefs.class);

// properties overridden from default values on loading of these definitions
static {
	String file = "/config.userdefs";

	try {
		logger.info("loading from file: " + file);
		InputStream stream = UserDefs.class.getResourceAsStream(file);
		if (stream == null) throw new Exception("config file not found");

		properties.load(stream);

		Field[] fields = UserDefs.class.getFields();

		for (int i = 0; i < fields.length; i++) {
			String type = fields[i].getType().getName();
			String field = fields[i].getName();
			String value = properties.getProperty(fields[i].getName());

			logger.debug("encountered property type '" + type + "' with value: "
					  + value);

			if (field.equals("properties") || field.equals("logger")) continue;
			else if (value == null) throw new Exception("field " + field
					  + " does" + " not have a matching property in the config file");
			else if (type.equals("double")) {
				fields[i].setDouble(null, new Double(value));
			} else if (type.equals("int")) {
				fields[i].setInt(null, new Integer(value));
			} else if (type.equals("boolean")) {
				fields[i].setBoolean(null, new Boolean(value));
			} else if (type.equals("java.lang.String")) {
				fields[i].set(null, value);
			}

			logger.debug(fields[i].getName() + " set to " + value);
		}
	} catch (Exception e) {
		logger.warn("failed to fetch properties: " + e.getMessage()
				  + ", using default values");
	}
}

}
