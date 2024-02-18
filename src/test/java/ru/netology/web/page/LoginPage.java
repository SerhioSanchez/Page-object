package ru.netology.web.page;

import com.codeborne.selenide.Selenide;
import ru.netology.web.data.DataHelper;

public class LoginPage {
  public void tryLogin(DataHelper.LogInfo info){
    Selenide.$("[data-test-id=login] input").setValue(info.getLogin());
    Selenide.$("[data-test-id=password] input").setValue(info.getPassword());
    Selenide.$("[data-test-id=action-login]").click();
  }
}