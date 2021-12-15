package com.example;

public class Main {
  public static void main(String[] args) {
    SerchCompanyPage page = new SerchCompanyPage();
    try {
      page.loadPage();
    } catch (Exception e) {

      System.out.println("\r\nURLが正しくないかもしれません\r\nプログラムが終了します");
      page.setType(-1);
    }

    System.out.println("---------------------------");
    switch (page.getType()) {
      case -1:
        break;
      case 1:
        page.printNumber();
        break;
      case 2:
        page.printName();
        break;
      case 3:
        page.printComment();
        break;
      case 4:
        page.printMarket();
        break;
      default:
        System.out.println("1～3までの数字を入力してください");
        break;
    }
    System.out.println("-------------------");
  }
}
