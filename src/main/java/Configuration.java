

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public final class Configuration {
    private static Properties properties;
    public static void load() throws IOException{
        properties = new Properties();
        InputStream is = new FileInputStream(new File("D:\\repositories\\example\\src\\main\\resources\\config.properties"));
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            try{
                properties.load(reader);
            }
            finally {
                is.close();
                reader.close();
            }
    }
    public static String get(String option){
        String value = properties.getProperty(option);
        if(value==null)
        {
            return "";
        }
        print();
        return value;
    }
    public static void print()
    {
        properties.entrySet().stream().forEach(property -> System.out.println(String.format("%s=%s", property.getKey(),property.getValue())));
}
public static long timeout()
{
    String value = get("timeout").trim();
    return Long.parseLong(value);

}
}
