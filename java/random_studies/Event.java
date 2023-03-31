import java.sql.Date;

public class Event {
  // private Date time;
  private String name; 
  private String description;


  // public void setTime(Date time){
  //   this.time = time;
  // }

  public void setName(String name){
    this.name = name;
  }
  
  public void setDescription(String description){
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public String getName() {
    return name;
  }

  // public Date getTime() {
  //   return time;
  // }

  public Event() {}
}