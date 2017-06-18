package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12.06.2017.
 */
public class ContactDataGenerator {

  @Parameter (names = "-c", description = "Contact count")
  public int count;

  @Parameter (names = "-f", description = "Target file")
  public String file;

  @Parameter (names = "-d", description = "Data format")
  public String format;

  private void run() throws IOException {
    List<ContactData> contacts =generateContacts(count);
    if (format.equals("csv")){
      saveAsCsv(contacts,new File(file));
    } else if(format.equals("xml")) {
      saveAsXml(contacts,new File(file));
    } else if(format.equals("json")) {
      saveAsJson(contacts,new File(file));
    }
    else {
      System.out.println("Unrecognized format "+format);
    }




  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try(Writer writer =new FileWriter(file)) {
      ;
      writer.write(json);
    }
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream=new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    try(Writer writer =new FileWriter(file)) {
      writer.write(xml);
    }
  }

  private  void saveAsCsv(List<ContactData> contacts, File file) throws IOException {

    try (Writer writer = new FileWriter(file)) {
      for (ContactData contact : contacts) {
        writer.write(String.format("%s;%s;%s;%s;%s;%s\n", contact.getFirstName(), contact.getLastName(),contact.getAddress(),
                contact.getPhone(),contact.getEmail(),contact.getGroup()));
      }
    }

  }
  public static void main (String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    }
    catch (ParameterException ex){
      jCommander.usage();
      return;
    }

    generator.run();

  }



  private  List<ContactData> generateContacts(int count) {

    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i=0; i<count;i++){
      contacts.add(new ContactData().withFirstName(String.format("John%s",i))
              .withLastName(String.format("Smith%s",i)).withAddress(String.format("1005%s",i))
              .withPhone(String.format("1234567%s",i)).withEmail(String.format("email%s@yahoo.com",i))
              .withGroup("Test1").withPhoto(new File("src/test/resources/img.jpg")));
    }
    return contacts;

  }

}
/**File photo= new File("src/test/resources/img.jpg");
 ContactData contact = new ContactData().withFirstName("John").withLastName("Smith")
 .withAddress("10005 NY 5st ave 123").withPhone("+1234567890")
 .withEmail("johmsmith@yahoo.cpm").withGroup("Test1").withPhoto(new File("src/test/resources/img.jpg"));
 */