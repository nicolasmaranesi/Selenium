package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WebDriverUtils {
    public static String folderDate;
    public static void capturarEvidence(WebDriver driver, String clase, String folderName, String fileName) {
        Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy-HHmmss");
        if (folderDate == null) {
            folderDate = formatter.format(fecha);
        }
        String pathAndFile = System.getProperty("user.dir")
                + File.separator + "Evidence"
                + File.separator + folderDate
                + File.separator + clase
                + File.separator + folderName
                + File.separator + fileName + ".png";
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(pathAndFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
