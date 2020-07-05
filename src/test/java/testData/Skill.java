package testData;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import utils.ExcelUtil;

public class Skill extends ExcelUtil {
    private static final Logger LOGGER = Logger.getLogger(Skill.class);

    public Skill() {
        super("src\\test\\resources\\ExcelSheet\\excel.xlsx");
    }

    @DataProvider(name = "Skill")
    public Object[][] employeeDataprovider() {

        int rows = getRowCount("skill");
        int col = getColumnCount("skill");


        LOGGER.info("row = " + rows + " columns = " + col);
        System.out.println("row = " + rows + " columns = " + col);
        Object[][] data = new Object[rows][col];
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < col; j++) data[i - 1][j] = getData("skill", i, j);
        }
        return data;
    }
}
