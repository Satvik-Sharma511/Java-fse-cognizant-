public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is a test log message.");

        if (logger1 == logger2) {
            System.out.println("Success! Both variables point to the same Logger instance. Singleton pattern is working correctly.");
        } else {
            System.out.println("Failure! The variables point to different instances.");
        }
    }
}
