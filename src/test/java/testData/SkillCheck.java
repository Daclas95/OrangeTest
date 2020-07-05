package testData;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import utils.ExcelUtil;

public class SkillCheck extends ExcelUtil {
    private static final Logger LOGGER = Logger.getLogger(SkillCheck.class);

    public SkillCheck() {
        super("src\\test\\resources\\ExcelSheet\\excel.xlsx");
    }

    @DataProvider(name = "SkillCheck")
    public Object[][] employeeDataprovider() {

        int rows = getRowCount("SkillCheck");
        int col = getColumnCount("SkillCheck");


        LOGGER.info("row = " + rows + " columns = " + col);
        System.out.println("row = " + rows + " columns = " + col);
        Object[][] data = new Object[rows][col];
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < col; j++) data[i - 1][j] = getData("SkillCheck", i, j);
        }
        return data;
    }
}
