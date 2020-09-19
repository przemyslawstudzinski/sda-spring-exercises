package sda.app.logger;

import org.springframework.stereotype.Component;

@Component
public class HelloLogger implements ILogger {

  public void log() {
    System.out.println("Hello logger");
  }
}
