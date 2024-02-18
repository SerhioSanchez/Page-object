package ru.netology.web.test;

import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;
import ru.netology.web.page.TransferPage;
import ru.netology.web.page.VerificationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferTest {

  private DashboardPage dashboardPage;
  private TransferPage transferPage;

  @BeforeEach
  void setup() {
    open("http://localhost:9999");
    DataHelper.LogInfo user = DataHelper.getLogInfo();
    LoginPage loginPage = new LoginPage();
    loginPage.tryLogin(user);
    DataHelper.VerificationCode verCode = DataHelper.getCode();
    VerificationPage verificationPage = new VerificationPage();
    verificationPage.tryVerification(verCode);
  }

  @Test
  @DisplayName("Should perform card transfer")
  void shouldPerformCardTransfer() {
    DataHelper.CardInfo fc = DataHelper.getFirstCardInfo();
    DataHelper.CardInfo sc = DataHelper.getSecondCardInfo();
    var dashboardPage = new DashboardPage();
    var beginBalance1 = dashboardPage.getCardBalance(fc);
    var beginBalance2 = dashboardPage.getCardBalance(sc);
    int transferAmount = DataHelper.generateAmount(beginBalance1);
    var expectedBalance1 = beginBalance1 - transferAmount;
    var expectedBalance2 = beginBalance2 + transferAmount;
    dashboardPage.SelectCard(sc);
    var transferPage = new TransferPage();
    transferPage.transferMoney(fc.getCardNumber(), transferAmount);
    var endBalance1 = dashboardPage.getCardBalance(fc);
    var endBalance2 = dashboardPage.getCardBalance(sc);
    assertEquals(expectedBalance1, endBalance1);
    assertEquals(expectedBalance2, endBalance2);
  }
}