public class LoggingInterceptor implements Interceptor {
    public void execute(String request){
        System.out.println("Logging: " + request);
    }
}
