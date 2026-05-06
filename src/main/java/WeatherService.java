import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class WeatherService {

    private final OkHttpClient client = new OkHttpClient();
    private final String API_KEY ="569d64688f44f62b6a0153dfe857a50f";

    public String getWeather(String city){
        try{
            String url ="https://api.openweathermap.org/data/2.5/weather?q="
                    +city + "&appid=" + API_KEY + "&units=metric";

            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            String json =response.body().string();
            JsonObject obj = JsonParser.parseString(json).getAsJsonObject();

            String name = obj.get("name").getAsString();
            double temp = obj.getAsJsonObject("main").get("temp").getAsDouble();
            String description = obj.getAsJsonArray("weather").get(0)
                    .getAsJsonObject().get("description").getAsString();
            double Fahrenheit = (temp*1.8)+32;
            return "Weather in " + name + ":\n" + Fahrenheit + "°F\n" + description;

        }catch (Exception e){
            e.printStackTrace();
            return "Failed to load weather.";
        }

    }
}
