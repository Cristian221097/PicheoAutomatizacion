import basetest.BaseTest;
import org.testng.annotations.Test;
import pages.PlayerPage;
import pages.ScorePage;

public class Picheo extends BaseTest {

    @Test(description = "get pitcheos today")
    public void getPicheos() {
        ScorePage scorePage = new ScorePage(getDriver());
        PlayerPage playerPage = new PlayerPage(getDriver());
        scorePage.goToPageMlb();
        scorePage.clickButtonOk();
      //  scorePage.selectDate("May 5");
        for (int i = 1; i <= scorePage.getCountMatches(); i++) {

            if(i ==23) {
                System.out.println("team: " + scorePage.getNameTeam(i));
                System.out.println("pitcher: " + scorePage.getNamePitcher(i));
                System.out.println("\n");

                scorePage.selectPitcher(i);
                playerPage.clickButonGameLogs();
                playerPage.getGameLogs();
                System.out.println("Promedio Hit: " + playerPage.getPorcentHit());
                System.out.println("Promedio carrera : " + playerPage.getPorcentR());
                System.out.println("Promedio base por bola: " + playerPage.getPorcentBB());
                System.out.println("Promedio ponche: " + playerPage.getPorcentSO());
                scorePage.goToPageMlb();
                //  scorePage.selectDate("May 5");
                System.out.println("\n");
            }
        }
    }

}
