package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {


    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @FindBy(id="com.mobisoft.kitapyurdu:id/imageViewBigLogo")
    public WebElement kitapyurdu;
    @FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mobisoft.kitapyurdu:id/smallLabel\" and @text=\"Kampanyalar\"]")
    public WebElement kampanyalar;



}
