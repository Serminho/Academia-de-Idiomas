import java.io.*;
import java.nio.file.*;

public class PersistenceUtil {

    public static void saveText(String path, String content) {
        try {
            Path p = Paths.get(path);
            if (p.getParent() != null) {
                Files.createDirectories(p.getParent());
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                bw.write(content);
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar arquivo: " + e.getMessage(), e);
        }
    }

    public static String loadText(String path) {
        try {
            StringBuilder sb = new StringBuilder();

            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    sb.append(linha).append("\n");
                }
            }

            return sb.toString();

        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar arquivo: " + e.getMessage(), e);
        }
    }
}
