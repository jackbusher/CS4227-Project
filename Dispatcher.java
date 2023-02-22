public class Dispatcher {
    private Interceptor interceptor;

    public Dispatcher(Interceptor interceptor) {
        this.interceptor = interceptor;
    }

    public void dispatch(String request) {
        interceptor.execute(request);
    }
}

