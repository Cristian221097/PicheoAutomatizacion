package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlayerPage extends BasePage {


    private By buttonGameLogs = By.xpath("//button[@data-type='gamelogs']");
    private By titleGameLogs = By.xpath("//h3[text()='Game Logs']");
    private By rowsSumTotal = By.xpath("//h3[text()='Game Logs']/..//*[@class='responsive-datatable__scrollable']//*[@class='total']");
    private By indexRow = By.xpath("//h3[text()='Game Logs']/..//*[@class='responsive-datatable__scrollable']//tbody//*[@data-index]");

    private Double porcentSO = 0.0;
    private Double porcentBB = 0.0;
    private Double porcentR = 0.0;
    private Double porcentHit = 0.0;

    public PlayerPage(WebDriver driver) {
        super(driver);
    }

    public void clickButonGameLogs() {
        clickElement(buttonGameLogs, "button game logs");
    }

    public Double getPorcentSO() {
        return porcentSO;
    }

    public Double getPorcentBB() {
        return porcentBB;
    }

    public Double getPorcentR() {
        return porcentR;
    }

    public Double getPorcentHit() {
        return porcentHit;
    }

    public void getGameLogs() {

        int totalMonth = driver.findElements(rowsSumTotal).size();
        int totalIndexRow = driver.findElements(indexRow).size();
        int totalGamePitched = totalIndexRow - totalMonth;
        int totalSO = 0;
        int totalBB = 0;
        int totalR = 0;
        int totalHit = 0;

        for (int i = 1; i <= totalMonth; i++) {
            By tdSO = By.xpath("(//h3[text()='Game Logs']/..//*[@class='responsive-datatable__scrollable']//*[@class='total'])[" + i + "]//td[@data-col='20']");
            By tdBB = By.xpath("(//h3[text()='Game Logs']/..//*[@class='responsive-datatable__scrollable']//*[@class='total'])[" + i + "]//td[@data-col='18']");
            By tdR = By.xpath("(//h3[text()='Game Logs']/..//*[@class='responsive-datatable__scrollable']//*[@class='total'])[" + i + "]//td[@data-col='14']");
            By tdHit = By.xpath("(//h3[text()='Game Logs']/..//*[@class='responsive-datatable__scrollable']//*[@class='total'])[" + i + "]//td[@data-col='13']");

            isElementVisible(tdSO,"tabla ponches");
            totalSO += Integer.parseInt(driver.findElement(tdSO).getText());
            totalBB += Integer.parseInt(driver.findElement(tdBB).getText());
            totalR += Integer.parseInt(driver.findElement(tdR).getText());
            totalHit += Integer.parseInt(driver.findElement(tdHit).getText());
        }

        Double doubleSO = (double) totalSO / totalGamePitched;
        porcentSO = Math.round((doubleSO*10.0))/10.0;

       Double doubleBB = (double) totalBB / totalGamePitched;
        porcentBB = Math.round((doubleBB*10.0))/10.0;

        Double doubleHIt = (double) totalHit / totalGamePitched;
        porcentHit = Math.round((doubleHIt*10.0))/10.0;

        Double douebleR = (double) totalR / totalGamePitched;
        porcentR = Math.round((douebleR*10.0))/10.0;


    }

}
