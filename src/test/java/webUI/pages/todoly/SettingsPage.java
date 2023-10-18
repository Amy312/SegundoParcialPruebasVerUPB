package webUI.pages.todoly;

import org.openqa.selenium.By;
import webUI.controls.Button;
import webUI.controls.TextBox;

public class SettingsPage {
    public TextBox fullNameTextBox = new TextBox(By.id("FullNameInput"));
    public Button okButton = new Button(By.xpath("//span[@class=\"ui-button-text\"][text()=\"Ok\"]"));
}
