package ru.stqa.pft.addressbook.model;

public class UserData {
  private final String firstName;
  private final String lastName;
  private final String middleName;
  private final String nickName;
  private final String title;
  private final String company;
  private final String address;
  private final String phone;
  private final String email;

  public UserData(String FirstName, String LastName, String MiddleName, String NickName, String Title, String Company, String Address, String Phone, String Email) {
    firstName = FirstName;
    lastName = LastName;
    middleName = MiddleName;
    nickName = NickName;
    title = Title;
    company = Company;
    address = Address;
    phone = Phone;
    email = Email;
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

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }
}
