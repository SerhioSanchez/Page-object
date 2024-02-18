package ru.netology.web.page;


import com.codeborne.selenide.Selenide;
import ru.netology.web.data.DataHelper;
public class VerificationPage {
  public void tryVerification(DataHelper.VerificationCode code) {
    Selenide.$("[data-test-id=code] input").setValue(code.getCode());
    Selenide.$("[data-test-id=action-verify]").click();
  }
}