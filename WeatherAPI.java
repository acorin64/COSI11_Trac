
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Scanner;

import org.json.JSONObject;

public class WeatherAPI {

	public static void main(String[] args) {
		getWeatherByZip(args);
	}

  /**
  the makes a call to openweathermap.com to get the weather data
  for the specified zipcode and the prints the info on the screen
  */
  public static void getWeatherByZip(String[] args){
    String zipcode = "02453";
    if (args.length == 1){
      zipcode = args[0];
    }
    getWeather(zipcode);

  }


  /**
  This gets the weather for a given zipcode...
  */
  public static void getWeather(String zipcode){
	System.out.print("Enter a ZIP code: ");
	Scanner scanner = new Scanner(System.in);
	String zip = scanner.next();
	String apiKey = "06d70799a9fcdfb5cffd48536349e502";
    String url = "https://api.openweathermap.org/data/2.5/weather?zip="+zip+",us"+"&appid="+apiKey;
    String json = getStringFromURL(url);
    JSONObject obj = new JSONObject(json);
	System.out.print("Guess the current temperature (°F): ");

    int tempK = obj.getJSONObject("main").getInt("temp");
    int tempF = k2f(tempK);
    int guess = scanner.nextInt();
	int difference = Math.abs(guess - tempF);
	if (difference == 0) {
		System.out.println("Correct!");
	} else {
		System.out.println("So close! you were " + Math.round(difference) + " degrees F away!");
		System.out.println("Current temp in " + zip + ": " + tempF + " degrees F");
		}
  }



  /**
  * This is a method which will connect to a website and return the content as a string.
  * You can get information about time in different timezones by connecting
  * to the URL http://worldtimeapi.org/api/, e.g.
  * myURL="http://worldtimeapi.org/api/timezones/America/New_York.txt"
  * gives info about the current time in New York
  */
	public static String getStringFromURL(String myURL) {
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
		in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:"+ myURL, e);
		}

		return sb.toString();
	}

  public static int k2f(int k){
    return (((k - 273) * 9/5) + 32);
  }

}
