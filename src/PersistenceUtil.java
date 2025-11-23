import java.io.*;
import java.nio.file.*;

public class PersistenceUtil {

    public static void saveText(String path, String content) {
        try {
            Path p = Paths.get(path);
            if (p.getParent() != null) {
                Files.createDirectories(p.getParent());
            }
            Files.writeString(p, content);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar arquivo TXT: " + e.getMessage(), e);
        }
    }

    public static String loadText(String path) {
        try {
            return Files.readString(Paths.get(path));
        } catch (FileNotFoundException e) {
            return "";
        } catch (IOException e) {
            System.err.println("Aviso: arquivo não encontrado ou inválido: " + path);
            return "";
        }
    }
}
