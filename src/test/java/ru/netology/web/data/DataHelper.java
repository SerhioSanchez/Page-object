package ru.netology.web.data;

import lombok.Value;

import java.util.Random;

public class DataHelper {
  public static VerificationCode getCode() {
    return new VerificationCode("12345");
  }
  public static LogInfo getLogInfo() {
    return new LogInfo("vasya", "qwerty123");
  }
  public static CardInfo getFirstCardInfo() {
    return new CardInfo("5559 0000 0000 0001", "92df3f1c-a033-48e6-8390-206f6b1f56c0");
  }
  public static CardInfo getSecondCardInfo() {
    return new CardInfo("5559 0000 0000 0002", "0f3f5c2a-249e-4c3d-8287-09f7a039391d");
  }
  public static int generateAmount(int balance) {
    return new Random().nextInt(Math.abs(balance)) + 1;
  }

  @Value
  public static class VerificationCode {
    String code;
  }

  @Value
  public static class LogInfo {
    String login;
    String password;
  }

  @Value
  public static class CardInfo {
    String cardNumber;
    String testId;
  }
}