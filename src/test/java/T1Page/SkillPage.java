package T1Page;

import controllers.MethodBase;
import controllers.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import testData.Skill;

public class SkillPage extends TestBase {
    private static final Logger LOGGER = Logger.getLogger(SkillPage.class);

    @Test(priority = 0,dataProviderClass = Skill.class,dataProvider = "Skill")
    public static void Hi(String name,String Desc,String Status,String alertmsg){
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

            MethodBase.assertEqual_Text_ByXpath("//span[@for=\"skill_name\"]",alertmsg);
            LOGGER.info(alertmsg);
        }

    }
    @Test(priority = 1)
    public static void Delete(){
        MethodBase.click_ByXpath("//a[@id=\"menu_admin_viewSkills\"]");//   SkillPageClick
        MethodBase.click_ById("checkAll"); // click check Box
        MethodBase.click_ById("btnDel");//   Delete btn
    }
}
