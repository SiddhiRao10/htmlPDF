package percy.test;

import org.testng.annotations.Test;

import java.util.Arrays;

public class percyCompareURLs extends BaseTest {


    @Test
    public void snapshotCompare() {
       /* driver.get(Non_PROD_URL);
        percy.snapshot("/home page", Arrays.asList(375, 480, 720, 1280, 1440, 1920));

        driver.navigate().to(Non_PROD_URL+"/pricing");
        percy.snapshot("/pricing page", Arrays.asList(375, 480, 720, 1280, 1440, 1920));

        driver.navigate().to(Non_PROD_URL+"/integrations/automate");
        percy.snapshot("/integrations/automate page", Arrays.asList(375, 480, 720, 1280, 1440, 1920));

        driver.navigate().to(Non_PROD_URL+"/docs");
        percy.snapshot("/docs page", Arrays.asList(375, 480, 720, 1280, 1440, 1920), null, false, "div#main-content, div.wrapper {overflow: visible !important}");
*/
        driver.get("http://localhost:8888/web/viewer.html?file=%2Ftest%2Fpdfs%2FShowText-ShadingPattern.pdf");
        percy.snapshot("1-page", Arrays.asList(375,1280));

    }

}
