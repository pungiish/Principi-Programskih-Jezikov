import java.lang.reflect.GenericArrayType;

public interface JsonSupport<T> {
	public String toJson();
	public T fromJson(String s);
}