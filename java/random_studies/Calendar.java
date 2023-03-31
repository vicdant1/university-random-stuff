import java.util.HashSet;
import java.util.Set;

public class Calendar {
  
  private Set<Event> events;

  public Calendar(){
    this.events = new HashSet<Event>();
  }

  public void addEventToCalendar(Event event){
    this.events.add(event);
  }

  public void setEvents(Set<Event> events) {
    this.events = events;
  }

  public Set<Event> getEvents() {
    return this.events;
  }
}
