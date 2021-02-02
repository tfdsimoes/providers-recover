package es.duonet.providers.utils;

import es.duonet.providers.entity.Provider;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.stream.Stream;

@Component
public class FileProcessor {

    /**
     * Create a new file and write the providers to it
     *
     * @param providers Stream of Provider to write to the file
     *
     * @return Absolute path of the file
     */
    public String saveProvidersToFile (Stream<Provider> providers) {
        File file = new File(UUID.randomUUID().toString() + ".txt");

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)){

            providers.forEach(provider -> {
                try {
                    fileOutputStream.write(provider.toString().getBytes(StandardCharsets.UTF_8));
                    fileOutputStream.write("\n".getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    throw new RuntimeException("Error writing the provider to file");
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("Error creating file to write");
        }

        return file.getAbsolutePath();
    }
}
