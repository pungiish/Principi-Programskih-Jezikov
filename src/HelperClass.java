import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelperClass {
	public static void writeToFile(String filename, String str)
			throws IOException {
		Path path = Paths.get(filename);
		byte[] strToBytes = str.getBytes();
		Files.write(path, strToBytes);
	}

	public static String readFromFile(String filename)
	throws IOException {
		Path path = Paths.get(filename);
		String read = Files.readString(path);
		return read;
	}
	public static Class<?> getMyType(Object o) {
		return o.getClass();
	}
}
