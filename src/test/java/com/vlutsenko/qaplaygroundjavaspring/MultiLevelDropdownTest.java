package com.vlutsenko.qaplaygroundjavaspring;

import com.vlutsenko.framework.service.csv.CSVMapper;
import com.vlutsenko.qaplaygroundjavaspring.page.HomePage;
import com.vlutsenko.qaplaygroundjavaspring.page.multileveldropdown.MultiLevelDropdownPage;
import com.vlutsenko.qaplaygroundjavaspring.page.multileveldropdown.entity.Submenu;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static com.vlutsenko.qaplaygroundjavaspring.constants.ApplicationConstants.Apps.MULTI_LEVEL_DROPDOWN;
import static com.vlutsenko.qaplaygroundjavaspring.constants.ApplicationConstants.HomePage.HOME_PAGE_TITLE;
import static com.vlutsenko.qaplaygroundjavaspring.constants.ApplicationConstants.MultiLevelDropdown.*;

public class MultiLevelDropdownTest extends BaseTest {

    private HomePage homePage;
    private MultiLevelDropdownPage multiLevelDropdownPage;

    @Test
    public void multiLevelDropdownTest() throws IOException {
        homePage = new HomePage(driver);
        multiLevelDropdownPage = new MultiLevelDropdownPage(driver);
        homePage.goTo();
        Assert.assertTrue(homePage.isAt());
        Assert.assertEquals(homePage.getTitleText(), HOME_PAGE_TITLE);
        homePage.clickOnCard(MULTI_LEVEL_DROPDOWN);

        Assert.assertTrue(multiLevelDropdownPage.isAt());
        List<Submenu> submenus = CSVMapper.readCSV("src/test/resources/testdata/multileveldropdown/settings_submenu.csv", Submenu.class);

        multiLevelDropdownPage.getDropdownComponent().clickOnDropDownButton();
        checkDropDownOptions(submenus, MAIN_MENU);

        multiLevelDropdownPage.getDropdownComponent().selectDropDownOption(SETTINGS);
        checkDropDownOptions(submenus, SETTINGS);

        multiLevelDropdownPage.getDropdownComponent().selectDropDownOption(MY_TUTORIAL);
        returnToMainMenu(submenus);

        multiLevelDropdownPage.getDropdownComponent().selectDropDownOption(ANIMALS);
        checkDropDownOptions(submenus, ANIMALS);

    }

    private void checkDropDownOptions(final List<Submenu> submenus, final String menuOption) {
        List<String> submenuLinks = submenus
            .stream()
            .filter(s -> Objects.equals(s.getMenu(), menuOption))
            .map(Submenu::getLink)
            .toList();
        List<String> submenuTitles = submenus
            .stream()
            .filter(s -> Objects.equals(s.getMenu(), menuOption))
            .map(Submenu::getTitle)
            .toList();

        wait.until((d) -> multiLevelDropdownPage.getDropdownComponent().getDropdownOptionsText().size() == submenuTitles.size());

        List<String> actualSubmenuTitles = multiLevelDropdownPage.getDropdownComponent().getDropdownOptionsText();
        for (int i = 0; i < submenuTitles.size(); i++) {
            Assert.assertTrue(actualSubmenuTitles.get(i).contains(submenuTitles.get(i)));
        }
        Assert.assertEquals(multiLevelDropdownPage.getDropdownComponent().getDropdownOptionsLinks(),
            submenuLinks);
    }

    private void returnToMainMenu(final List<Submenu> submenus) {
        List<String> submenuTitles = submenus
            .stream()
            .filter(s -> Objects.equals(s.getMenu(), MAIN_MENU))
            .map(Submenu::getTitle)
            .toList();
        wait.until((d) -> multiLevelDropdownPage.getDropdownComponent().getDropdownOptionsText().size() == submenuTitles.size());
    }
}
