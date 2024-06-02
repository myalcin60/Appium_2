package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KampanyalarPage {


    public KampanyalarPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mobisoft.kitapyurdu:id/textViewTitle\" and @text=\"Öne Çıkan Kampanyalar\"]")
    public WebElement oneCikanKampanyalar;



}
