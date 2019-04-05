
public interface JsonSupport<T> {
	String toJson();
	T fromJson(String s);
}