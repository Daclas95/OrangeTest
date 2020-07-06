package T1Page;

import controllers.MethodBase;
import controllers.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testData.Skill;
import testData.SkillCheck;

public class SkillPage extends TestBase {
    private static final Logger LOGGER = Logger.getLogger(SkillPage.class);
    private static SoftAssert softAssert;


    @Test(priority = 0,dataProviderClass = Skill.class,dataProvider = "Skill")
    public static void Hi(String name,String Desc,String Status,String alertmsg){
        softAssert = new SoftAssert();
        /**/    LOGGER.info("now starting Skill");
        MethodBase.click_ByXpath("//a[@id=\"menu_admin_viewSkills\"]");//   SkillPageClick
        MethodBase.assertTrue_ByXpath("//*[@id=\"recordsListDiv\"]/div[1]/h1","DisplayNot visible");//For check
        MethodBase.click_ById("btnAdd");//   ClickAddButton
        MethodBase.assertTrue_ById("saveFormHeading","Disploy not visible");
        MethodBase.setText_ByID("skill_name",name);//   EnterName
        MethodBase.setText_ByID("skill_description",Desc);//   EnterDescription
        MethodBase.click_ById("btnSave");//   save btn
        if (Status.equals("Valid")){
            LOGGER.info("VeryGood");
        }
        else{
            softAssert.assertEquals(MethodBase.get_Text("//span[@for=\"skill_name\"]"),alertmsg,"what happened");
            LOGGER.info(alertmsg);
        }
        softAssert.assertAll();
    }
    @Test(priority = 1,dataProviderClass = SkillCheck.class,dataProvider = "SkillCheck")
    public static void Delete(String name,String names){
            MethodBase.click_ByXpath("//a[@id=\"menu_admin_viewSkills\"]");//   SkillPageClick
        if (MethodBase.SelectText_ByLink(name).equals(names))
        {
            MethodBase.click_ByXpath("//input[@name=\"chkListRecord[]\"]"); // click check Box
            MethodBase.click_ById("btnDel");//   Delete btn
            LOGGER.info("i have found and deleted");
        }
        else {
            LOGGER.info("Don't have any data");
        }

    }
}
