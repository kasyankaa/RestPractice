package ua.lviv.iot.spring.rest.model;

public class Drug {
  public String name;
  public String person;
  private Integer id;
  public Drug() {
  
  }
  public Drug(String name,String person) {
    super();
    this.name = name;
    this.person = person;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getPerson() {
    return person;
  }
  public void setPerson(String person) {
    this.person = person;
  }
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

}
