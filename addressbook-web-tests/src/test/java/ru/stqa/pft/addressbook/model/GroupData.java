package ru.stqa.pft.addressbook.model;

public class GroupData {
  private  int id;
  private final String name;
  private final String header;
  private final String footer;


  public GroupData(int id,String Name, String Header, String Footer) {
    this.id = id;
    this.name = Name;
    this.header = Header;
    this.footer = Footer;
  }
  public GroupData(String Name, String Header, String Footer) {
    this.id = 0;
    this.name = Name;
    this.header = Header;
    this.footer = Footer;
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

  public int getId() {    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }


}

