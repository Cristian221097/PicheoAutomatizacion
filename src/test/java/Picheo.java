import basetest.BaseTest;
import org.testng.annotations.Test;
import pages.ScorePage;

public class Picheo extends BaseTest {

    @Test(description = "get pitcheos today")
    public void getPicheos() {
        ScorePage scorePage = new ScorePage(getDriver());
        scorePage.goToPageMlb();
        scorePage.clickButtonOk();
        scorePage.selectDate("May 3");
        for (int i = 0; i < scorePage.getCountMatches(); i++) {
            System.out.println("team: " + scorePage.getNameTeam(i));
            System.out.println("pitcher: " + scorePage.getNamePitcher(i));
            System.out.println(" \n");
        }
    }

}
