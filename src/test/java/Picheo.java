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
        for (int i = 1; i <= scorePage.getCountMatches(); i++) {

            if(i!=7 && i!=8) {
                System.out.println("team: " + scorePage.getNameTeam(i));
                System.out.println("pitcher: " + scorePage.getNamePitcher(i)+"\n");
                scorePage.selectPitcher(i);
                playerPage.clickButonGameLogs();

                playerPage.getGameLogs();
                System.out.println("Partidos lanzados: " + playerPage.getTotalGamePitched());
                System.out.println("Promedio Ining: " + playerPage.getPorcentIP());
            //  System.out.println("Promedio Hit: " + playerPage.getPorcentHit());
                System.out.println("Promedio carrera : " + playerPage.getPorcentR());
            //    System.out.println("Promedio base por bola: " + playerPage.getPorcentBB());
                System.out.println("Promedio ponche: " + playerPage.getPorcentSO()+"\n");
                scorePage.goToPageMlb();
            }
        }
    }

}
