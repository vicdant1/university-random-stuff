import java.util.Scanner;
import java.util.Set;

public class CalendarView {

  
  public static void main(String[] args)
  {
    while(true)
    {
      Calendar calendar = new Calendar();
      Scanner sc = new Scanner(System.in);

      

      System.out.println("Select an option: [1 - Show Events] [2 - Create an new event] [3 - Exit]");
      String userResponse = sc.nextLine();


      switch(userResponse) {
        case "1":
          Set<Event> events = calendar.getEvents();

          for(Event event : events)
          {
            System.out.println("asndfkasnkdfnaskdnfkasnd");
            System.out.println(event.getName() + " - " + event.getDescription());
          }
          break;

        case "2":
          System.out.println("Schedule an event");

          System.out.println("Whats the event name?");
          String eventName = sc.nextLine();
          System.out.println("Whats the event description?");
          String eventDesc = sc.nextLine();
          // Date eventTime;

          Event event = new Event();

          event.setName(eventName);
          event.setDescription(eventDesc);
          // event.setTime(eventTime);

          calendar.addEventToCalendar(event);

          break;
        case "3":
          System.exit(1);
          break;
      }
    }
  }
}
