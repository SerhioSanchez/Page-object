package ru.netology.web.page;

import com.codeborne.selenide.ElementsCollection;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
  private ElementsCollection cards = $$(".list__item div");
  private final String balanceStart = "баланс: ";
  private final String balanceFinish = " р.";

  public int getCardBalance(DataHelper.CardInfo cardInfo) {
    var text = cards.findBy(text(cardInfo.getCardNumber().substring(15))).getText();
    return extractBalance(text);
  }

  public void SelectCard(DataHelper.CardInfo cardInfo){
    cards.findBy(attribute("data-test-id",cardInfo.getTestId())).$("button").click();
  }

  private int extractBalance(String text) {
    int start = text.indexOf(balanceStart);
    int finish = text.indexOf(balanceFinish);
    String value = text.substring(start + balanceStart.length(), finish);
    return Integer.parseInt(value.trim());
  }
}