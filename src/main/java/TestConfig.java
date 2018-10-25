

import java.io.*;
import java.util.Properties;

public final class TestConfig {
    public static void load() throws IOException {
        Properties properties = new Properties();
        InputStream stream = new FileInputStream(new File("string"));
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                try {
                    properties.load(reader);
                }
                finally {
                    stream.close();
                    reader.close();
                }
    }
}
