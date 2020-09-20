package sda.otherplace;

import org.springframework.stereotype.Component;
import sda.app.logger.ILogger;

@Component
public class ByeByeLogger implements ILogger {

  @Override
  public void log() {
    System.out.println("Bye Bye logger!!!");
  }
}
