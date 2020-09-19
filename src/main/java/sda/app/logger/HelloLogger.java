package sda.app.logger;

import org.springframework.stereotype.Component;

@Component
public class HelloLogger {

  public void log() {
    System.out.println("Hello logger");
  }
}
