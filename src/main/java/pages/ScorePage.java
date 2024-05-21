package pages;

import helpers.HelperDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScorePage extends BasePage {

    private String xpathFecha = "//button//*[text()='%s']";
    private String xpathDateSelected ="//button//*[text()='%s']/../../../../..//*[@class='dayPickerstyle__DateSlide-sc-1jcyvk3-3 dwcvHJ selected']";
    private By buttonOk =By.xpath("//button[text()='OK']");

    private static final String URL = "https://www.mlb.com/scores/";

    public ScorePage(WebDriver driver) {
        super(driver);
    }

    public void goToPageMlb() {
       String date = HelperDate.getInstance().getDate().toString();
        go(URL+date);
    }

    public void selectDate(String date) {
        By locatorDate = By.xpath(String.format(xpathFecha, date));
        By locatorDateSelected = By.xpath(String.format(xpathDateSelected,date));
        clickElement(locatorDate, "date: " + date);
        isElementVisible(locatorDateSelected,"date selected");

    }

    public String getNameTeam(int index) {
        By labelTeams = By.xpath("(//*[@class='TeamMatchupLayerstyle__InlineWrapper-sc-7tca6g-1 iVtGBI']//*[@data-testid='teamNameLabel'])[" + index + "]");
        isElementPresent(labelTeams, "name Teams");
        return driver.findElement(labelTeams).getText();
    }

    public String getNamePitcher(int index) {
        By namePitcher = By.xpath("(//*[@data-testid='playerNameLinks'])["+index+"]");
        isElementPresent(namePitcher, "name Pitcher");
        return driver.findElement(namePitcher).getText();
    }

    public void selectPitcher(int index) {
        By namePitcher = By.xpath("(//*[@data-testid='playerNameLinks'])["+index+"]");
        clickExecuterJS(namePitcher, "name Pitcher");
    }

    public int getCountMatches(){
        By labelTeams = By.xpath("(//*[@class='TeamMatchupLayerstyle__InlineWrapper-sc-7tca6g-1 iVtGBI']//*[@data-testid='teamNameLabel'])");
        return driver.findElements(labelTeams).size();
    }

    public void clickButtonOk(){
        clickElement(buttonOk,"button ok");
    }

}
