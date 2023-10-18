package webUI.pages.todoist;

import org.openqa.selenium.By;
import webUI.controls.Button;

public class MenuSection {
    public Button addTaskButton = new Button(By.xpath("//button[@data-track=\"navigation|quick_add\"]"));


}
