import basetest.BaseTest;
import helpers.HelperFile;
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
        StringBuilder content = new StringBuilder();

        for (int i = 1; i <= scorePage.getCountMatches(); i++) {
            content.append("\nteam: ").append(scorePage.getNameTeam(i)).append("\n").append("pitcher: ").append(scorePage.getNamePitcher(i)).append("\n").append("\n");
            scorePage.selectPitcher(i);
            playerPage.clickButonGameLogs();
            playerPage.getGameLogs();
            content.append("Partidos lanzados: ").append(playerPage.getTotalGamePitched()).append("\n");
            content.append("Promedio Ining: ").append(playerPage.getPorcentIP()).append("\n");
            content.append("Promedio carrera : ").append(playerPage.getPorcentR()).append("\n");
            content.append("Promedio ponche: ").append(playerPage.getPorcentSO()).append("\n");
            scorePage.goToPageMlb();
        }

        HelperFile.getInstance().createFile(System.clearProperty("user.dir") + "\\src\\main\\resources\\picheo\\PicheoToday", content.toString(), "txt");


    }

}
