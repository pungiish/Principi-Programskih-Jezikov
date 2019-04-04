import com.google.gson.Gson;

import java.lang.reflect.Type;

public interface JsonSupport {
	public static String toJson(Object o){
		Gson gson = new Gson();
		String json = gson.toJson(o);
		return json;
	}
	public static String fromJson(String s){
		Gson gson = new Gson();
		String fromJson = gson.fromJson(s, String.class);
		return fromJson;
	}
}