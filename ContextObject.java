public class ContextObject {
    private WeatherData weatherData;

    public ContextObject(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public String getWeatherSummary() {
        float temperature = weatherData.getTemperature();
        float humidity = weatherData.getHumidity();
        float pressure = weatherData.getPressure();
        return String.format("Temperature: %f, Humidity: %f, Pressure: %f", temperature, humidity, pressure);
    }
}
