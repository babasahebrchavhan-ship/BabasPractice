package Utility;


import java.io.File;
import java.io.IOException;
public class ClearScreenshotFolder {
    public static void clearScreenshotFolder() throws IOException {
        File folder = new File(System.getProperty("user.dir"), "Screenshots");
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));
        if (files != null) {
            for (File file : files) {
                java.nio.file.Files.deleteIfExists(file.toPath());
            }
        }
    }
}

