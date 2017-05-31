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


  public ContactData(String FirstName, String LastName,
                     String MiddleName, String NickName, String Title, String Company,
                     String Address, String Phone, String Email, String Group) {
    this.id=0;
    this.firstName = FirstName;
    this.lastName = LastName;
    this.middleName = MiddleName;
    this.nickName = NickName;
    this.title = Title;
    this.company = Company;
    this.address = Address;
    this.phone = Phone;
    this.email = Email;

    this.group = Group;
  }
  public ContactData(int id,String FirstName, String LastName,
                     String MiddleName, String NickName, String Title, String Company,
                     String Address, String Phone, String Email, String Group) {
    this.id=id;
    this.firstName = FirstName;
    this.lastName = LastName;
    this.middleName = MiddleName;
    this.nickName = NickName;
    this.title = Title;
    this.company = Company;
    this.address = Address;
    this.phone = Phone;
    this.email = Email;

    this.group = Group;
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
    return email != null ? email.equals(that.email) : that.email == null;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (phone != null ? phone.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + id;
    return result;
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


}
