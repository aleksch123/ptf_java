package ru.stqa.pft.addressbook;

public class GroupDate {
  private final String name;
  private final String header;
  private final String footer;

  public GroupDate(String Name, String Header, String Footer) {
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
