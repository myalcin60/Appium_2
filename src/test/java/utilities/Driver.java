package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.time.Duration;

public class Driver {
    private Driver() {
    }
    private static UiAutomator2Options options;
    public static AppiumDriverLocalService service;
    public static AppiumDriver driver;

    public static AndroidDriver getDriver() {

        String appUrl = System.getProperty("user.home")
                + File.separator + "IdeaProjects"
                + File.separator + "apps"
                + File.separator + "ApiDemos-debug.apk";
        if (driver == null) {
            options = new UiAutomator2Options()
//                            .withBrowserName("chrome")  //web testleri yaparken bu acik olacak
                    .setUnlockType("pin")
                    .setUnlockKey("1111")

/*
 File.separator: windows ve linux işletim sistemlerindeki farklı slash (/ veya\) farkını ortadan kaldırır
*/

// setApp() icine apk nin bilgisayardaki tam yolu verilir. setAppPackage ve setAppActivity varsa buna gerek yok.
                    .setApp(ConfigReader.getProperty("kitapYurdu")) //icine apk nin bilgisayardaki tam yolu verilir. setAppPackage ve setAppActivity varsa buna gerek yok.
                    //.setUdid() //bu özellik birden fazla cihaz açıkken kullanilacak cihazin tanimidir
//  .setAvd("Pixel6") //ile kapali cihaz test run edilince once acilir sonra test kosulur.
//  .setAvdLaunchTimeout(Duration.ofMinutes(3))
                    /*
                          .setUdid()  metotu  setDeviceName() yerine is gorur. 1 cihaz teste bagli ise bunu kullanmaya gerek yok.
                            .setUdid() bilgisini almak icin cihazlar acik iken cmd ekranina adb devices komutu yazilir
                    */
                    .setDeviceName("Pixel6")
//                            .setAppPackage(ConfigReader.getProperty("kitapyurduPackage"))
//                            .setAppActivity(ConfigReader.getProperty("kitapyurduActivity"))
//setAppPackage ve setAppActivity bilgilerini almak icin adb shell dumpsys window | find "mCurrentFocus" komutunu cmd ekranina yazariz

                    .setAutomationName("Uiautomator2")
                    .setNoReset(true)
                    .setNewCommandTimeout(Duration.ofMinutes(10));

            try {
                driver = new AndroidDriver(
                        new URL("http://127.0.0.1:4723"), options
                );
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return (AndroidDriver) driver;
        //pressKey() kullanabilmek icin Driver'da kullanilan class AndroidDriver olmali. AppiumDriver'da kullanilamaz.
        //Bunun icin Driver da return driver kismi cast ile      return (AndroidDriver) driver; yaptim.
    }
        public static void quitDriver () {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
    public static void serverKapat() {
        service.stop();
    }
    public static boolean isAppiumServerRunning(String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}

