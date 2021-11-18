package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class SerchCompanyPage {
  private String url;
  private Document text;
  //1.証券番号 2.社名 3.一言コメント 4.市場
  private int type;

  public void loadPage() throws Exception {
    Document document = Jsoup.connect(this.url).get();
    this.text = document;
  }
  public void printNumber() {
    Elements numbers = this.text.select(".tblModel-1 tbody tr td");
    int n = 0;
    for (Element number : numbers) {
      if (n%4 == 0) {
        System.out.println(number.select("a").text());
      }
      n++;
    }
  }
  public void printName() {
    Elements names = this.text.select(".tblModel-1 tbody tr .left .campany-name-td");
    for (Element name : names) {
      System.out.println(name.text());
    }
  }
  public void printComment() {
    Elements comments = this.text.select(".tblModel-1 tbody tr .left");
    for (Element comment : comments) {
      Pattern p = Pattern.compile("(?<=【).+(?=】)");
      Matcher m = p.matcher(comment.text());
      if (m.find()) { System.out.println(m.group()); } else { System.out.println(""); }
    }
  }
  public void printMarket() {
    Elements markets = this.text.select(".tblModel-1 tbody tr td");
    int n = 0;
    for (Element market : markets) {
      if (n%4 == 0) {
        Pattern p = Pattern.compile("\\D+");
        Matcher m = p.matcher(market.text());
        if (m.find()) {
          String marketName = m.group();
          marketName = marketName.trim();
          String printText;

          switch (marketName) {
            case "東証１部":
              printText = "1";
              break;
            case "東証２部":
              printText = "2";
              break;
            case "ＪＱグ":
              printText = "JQグ";
              break;
            case "ＪＱス":
              printText = "JQス";
              break;
            case "マザーズ":
              printText = "ﾏｻﾞｰｽﾞ";
              break;          
            default:
              printText = marketName;
              break;
          }
          System.out.println(printText);
        }
      }
      n++;
    }
  }

  public SerchCompanyPage() {
    System.out.println("スクレイピングするページのURlをを入力してください");
    String url = new java.util.Scanner(System.in).nextLine();
    this.url = url;

    System.out.println("何をスクレイピングしますか？");
    System.out.println("1.証券番号 2.社名 3.一言コメント 4.市場");
    int type = new java.util.Scanner(System.in).nextInt();
    this.type = type;
  }
  public void setType(int i) { this.type = i; }
  public int getType() { return this.type; }
}
