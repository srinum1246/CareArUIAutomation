package testCases.superAdminCases;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.Test;
import testBase.BaseTest;

public class deleteTenants extends BaseTest {

    @Test
    public void deleteAutoTenants() throws ConfigurationException {
        setApplPropFilePath("superadmin.properties");
        click(home_xpath);
        deleteTenantsWithSpfc("automation");

    }
}
