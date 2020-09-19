package sda.app.logger;

import org.springframework.stereotype.Component;

@Component
public class HiLogger implements ILogger{
  public void log() {
    System.out.println("Hi logger");
  }
}
