package com.example;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    System.out.println("こんにちは、モードを選んでください");
    System.out.println("1.企業一覧作成 2.財政情報表示");
    int mode = new java.util.Scanner(System.in).nextInt();

    switch (mode) {
      case 1:
        serchCompany();        
        break;
      case 2:
        getFinancialData();
        break;
      default:
        System.out.println("1または2を入力してください");
        break;
    }
  }
  public static void getFinancialData() {
    ArrayList<Integer> companyNumbers = receivingNumbers();
    
  }
  public static void serchCompany() {
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
  private static ArrayList<Integer> receivingNumbers() {
    ArrayList<Integer> returnNumbers = new ArrayList<>();

    System.out.println("数字を入力してください、終了する場合は「end」と入力してください");
    while (true) {
      System.out.print(">");
      String word = new java.util.Scanner(System.in).nextLine();
      if (word == "end") {
        break;
      } else {
        try {
          int number = Integer.parseInt(word);
          returnNumbers.add(number);
        } catch (NumberFormatException e) {
          System.out.println("数字またはendを入力してください");
        }
      }
    }
    return returnNumbers;
  }
}
