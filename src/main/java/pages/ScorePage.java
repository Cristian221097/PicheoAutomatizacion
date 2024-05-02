package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScorePage extends BasePage {

    private String xpathFecha = "//button//*[text()='%s']";

    private By buttonOk =By.xpath("//button[text()='OK']");

    private static final String URL = "https://www.mlb.com/scores";

    public ScorePage(WebDriver driver) {
        super(driver);
    }

    public void goToPageMlb() {
        go(URL);
    }

    public void selectDate(String date) {
        By locatorDate = By.xpath(String.format(xpathFecha, date));
        clickElement(locatorDate, "date: " + date);
    }

    public String getNameTeam(int index) {
        By labelTeams = By.xpath("(//*[@class='TeamMatchupLayerstyle__InlineWrapper-sc-7tca6g-1 iVtGBI']//*[@data-testid='teamNameLabel'])[" + index + "]");
        confirmPresentElement(labelTeams, "name Teams");
        return driver.findElement(labelTeams).getText();
    }

    public String getNamePitcher(int index) {
        By namePitcher = By.xpath("(//*[@data-testid='playerNameLinks'])");
        confirmPresentElement(namePitcher, "name Pitcher");
        return driver.findElement(namePitcher).getText();
    }

    public void selectPitcher(int index) {
        By namePitcher = By.xpath("(//*[@data-testid='playerNameLinks'])");
        clickExecuterJS(namePitcher, "name Pitcher");
    }

    public int getCountMatches(){
        By labelTeams = By.xpath("(//*[@class='TeamMatchupLayerstyle__InlineWrapper-sc-7tca6g-1 iVtGBI']//*[@data-testid='teamNameLabel'])");
        return driver.findElements(labelTeams).size() / 2;
    }

    public void clickButtonOk(){
        clickElement(buttonOk,"button ok");
    }

}
