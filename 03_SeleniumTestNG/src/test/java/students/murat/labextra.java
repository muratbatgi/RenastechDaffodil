package students.murat;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class labextra {
    public static void main(String[] args) throws InterruptedException {
        //Task - 1 //Open Chrome Browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();


        // Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        //maximize.
        driver.manage().window().maximize();
        Thread.sleep(4000);


        // Verify title: Expected: "Facebook - Log In or Sign Up"
        String expectedTitle= "Facebook";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Facebook Title Verification Has Passed");
        }else{
            System.out.println("Facevook Title Verification Has Failed");

        }
        System.out.println("actual title="+actualTitle);





    }
}
