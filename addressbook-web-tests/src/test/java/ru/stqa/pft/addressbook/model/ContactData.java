package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.File;

@XStreamAlias("contact")
@Entity
@javax.persistence.Table(name = "addressbook")

public class ContactData {
  @Id
  @Column(name = "id")
  private int id=Integer.MAX_VALUE;
  @Expose
  @Column(name = "firstname")
  private  String firstName;
  @Expose
  @Column(name = "lastname")
  private  String lastName;
  private  String middleName;
  @Transient
  private  String nickName;
  @Transient
  private  String title;
  @Transient
  private  String company;
  @Expose
  @Type(type = "text")
  private  String address;
  @Expose
  @Transient
  private  String phone;
  @Expose
  @Type(type = "text")
  private  String email;
  @Transient
  private  String email2;
  @Transient
  private  String email3;
  @Transient
  private  String allEmails;
  @Expose
  @Transient
  private  String group;
  @Column(name = "home")
  @Type(type = "text")
  private  String home;
  @Column(name = "mobile")
  @Type(type = "text")
  private  String mobile;
  @Column(name = "work")
  @Type(type = "text")
  private  String work;
  @Transient
  private  String allPhones;
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;





  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
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

  public String getHomePhone() {
    return home;
  }

  public String getMobilePhone() {
    return mobile;
  }

  public String getWorkPhone() {
    return work;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {    return email2;  }

  public String getEmail3() {    return email3;  }

  public String getAllEmails() {    return allEmails;  }

  public int getId() {    return id;  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public String getGroup() {
    return group;
  }

  public File getPhoto() {    return new File(photo);  }


  public ContactData withId(int id) {
    this.id = id;
    return this;
  }
  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData withNickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }
  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }
  public  ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }
  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }
  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }
  public ContactData withHomePhone(String home) {
    this.home = home;
    return this;
  }
  public ContactData withMobilePhone(String mobile) {
    this.mobile = mobile;
    return this;
  }
  public ContactData withWorkPhone(String work) {
    this.work = work;
    return this;
  }
  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + id;
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", middleName='" + middleName + '\'' +
            ", nickName='" + nickName + '\'' +
            ", title='" + title + '\'' +
            ", company='" + company + '\'' +
            ", address='" + address + '\'' +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            ", group='" + group + '\'' +
            ", id=" + id +
            '}';
  }
}
