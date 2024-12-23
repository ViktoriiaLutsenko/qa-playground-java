package com.vlutsenko.qaplaygroundjavaspring.page.multileveldropdown;

import com.vlutsenko.framework.page.AbstractComponent;
import org.openqa.selenium.WebDriver;

public class MultiLevelDropdownPage extends AbstractComponent {

    private DropdownComponent dropdownComponent;

    public MultiLevelDropdownPage(WebDriver driver) {
        super(driver);
        dropdownComponent = new DropdownComponent(driver);
    }

    public DropdownComponent getDropdownComponent() {
        return dropdownComponent;
    }

    @Override
    public boolean isAt() {
        return wait.until((d) -> dropdownComponent.isAt());
    }
}
