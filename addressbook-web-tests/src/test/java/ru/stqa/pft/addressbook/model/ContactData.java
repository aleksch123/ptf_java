package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String middleName;
  private final String nickName;
  private final String title;
  private final String company;
  private final String address;
  private final String phone;
  private final String email;
  private  String group;
  private int id;



  public ContactData(String firstName, String lastName,
                     String middleName, String nickName, String title, String company,
                     String address, String phone, String email, String group) {
    this.id=Integer.MAX_VALUE;
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
    this.nickName = nickName;
    this.title = title;
    this.company = company;
    this.address = address;
    this.phone = phone;
    this.email = email;

    this.group = group;
  }
  public ContactData(int id,String firstName, String lastName,
                     String middleName, String nickName, String title, String company,
                     String address, String phone, String email, String group) {
    this.id=id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
    this.nickName = nickName;
    this.title = title;
    this.company = company;
    this.address = address;
    this.phone = phone;
    this.email = email;

    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }
  public int getId() {    return id;
  }




  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }


  public String getGroup() {
    return group;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            ", id=" + id +
            '}';
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }
}
