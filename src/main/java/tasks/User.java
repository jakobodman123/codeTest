package tasks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonProperty("id")
    private int id;

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("username")
    private String userName;

    @JsonProperty("age")
    private int age;

    public int getId() {
       return id;
    }
    public void setId(int id) {
       this.id = id;
    }
    public String getFirstName() {
       return firstName;
    }
    public void setFirstName(String firstName) {
       this.firstName = firstName;
    }
    public String getLastName() {
       return lastName;
    }
    public void setLastName(String lastName) {
       this.lastName = lastName;
    }  

    public String getUserName() {
        return userName;
     }
     public void setUserName(String userName) {
        this.userName = userName;
     }  

     public int getAge() {
        return age;
     }
     public void setAge(int age) {
        this.age = age;
     }

}
