package sda.app.logger;

import org.springframework.stereotype.Component;

@Component
public class HiLogger {
  public void log() {
    System.out.println("Hi logger");
  }
}
