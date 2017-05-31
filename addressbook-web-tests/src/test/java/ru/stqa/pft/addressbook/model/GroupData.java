package ru.stqa.pft.addressbook.model;

public class GroupData {
  private final String id;
  private final String name;
  private final String header;
  private final String footer;


  public GroupData(String id,String Name, String Header, String Footer) {
    this.id = id;
    this.name = Name;
    this.header = Header;
    this.footer = Footer;
  }
  public GroupData(String Name, String Header, String Footer) {
    this.id = null;
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

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != null ? !id.equals(groupData.id) : groupData.id != null) return false;
    return name != null ? name.equals(groupData.name) : groupData.name == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

  public String getFooter() {
    return footer;
  }

  public String getId() {    return id;
  }
}

