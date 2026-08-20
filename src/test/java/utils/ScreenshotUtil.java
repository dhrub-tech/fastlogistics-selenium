package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String takeScreenshot(
            WebDriver driver,
            String testName) {

        String timestamp =
                new SimpleDateFormat(
                        "yyyyMMdd_HHmmss"
                ).format(new Date());

        String fileName =
                testName + "_" + timestamp + ".png";

        String folder =
                "test-output/screenshots/";

        Path directory =
                Paths.get(folder);

        try {

            Files.createDirectories(directory);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to create screenshot directory",
                    e
            );
        }

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(
                                OutputType.FILE
                        );

        Path destination =
                directory.resolve(fileName);

        try {

            Files.copy(
                    source.toPath(),
                    destination
            );

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to save screenshot",
                    e
            );
        }

        return destination.toString();
    }
}