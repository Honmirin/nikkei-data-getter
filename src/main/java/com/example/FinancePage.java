package com.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class FinancePage {
  private int companyNumber;
  private String pageUrl;
  private Document doc;

  
  public void loadPage() throws Exception {
    Document doc = Jsoup.connect(this.pageUrl).get();
    this.doc = doc;
  }
  public FinancePage(int companyNumber) {
    this.companyNumber = companyNumber;
    this.pageUrl = "https://www.nikkei.com/nkd/company/kessan/?scode=" + companyNumber + "&ba=9";
  }
  public int getCompanyNumber() { return this.companyNumber; }
  public String getPageUrl() { return this.pageUrl; }
  public Document getDoc() { return this.doc; }
}
