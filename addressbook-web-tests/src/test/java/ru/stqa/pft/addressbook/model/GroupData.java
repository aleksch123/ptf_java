package ru.stqa.pft.addressbook.model;

public class GroupData {
  private final String name;
  private final String header;
  private final String footer;

  public GroupData(String Name, String Header, String Footer) {
    name = Name;
    header = Header;
    footer = Footer;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }
}
