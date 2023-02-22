import java.util.ArrayList;
public class WeatherData implements SetMeasurements, GetMeasurements, Subject {
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    private Dispatcher dispatcher;

    public WeatherData() {
        observers = new ArrayList<>();
        // Initialize with a logging interceptor
        dispatcher = new Dispatcher(new LoggingInterceptor());
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
        // Intercept the context object and pass it to the dispatcher
        ContextObject contextObject = new ContextObject(this);
        dispatcher.dispatch(contextObject.getWeatherSummary());
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}

