package utils;

public class FilePath {
    public static final String USER_DIRECTORY = System.getProperty("user.dir");
    public static final String UTILS = USER_DIRECTORY + "/src/main/java/utils/";
    public static final String RESOURCES = USER_DIRECTORY + "/src/main/resources/";
    public static final String PAYLOADS = RESOURCES + "payloads/";

    public static final String CONFIG_PROPERTIES_FILE = RESOURCES + "config.properties";
    public static final String EXTENT_REPORT_FILE = USER_DIRECTORY + "/reports/extent-report.html";

   //************************* payload file path starts ********************
    public static final String CREATE_USER_FILE_PATH = PAYLOADS + "CreateUser.json";

    //*********************** payload file path ends **********************

}
