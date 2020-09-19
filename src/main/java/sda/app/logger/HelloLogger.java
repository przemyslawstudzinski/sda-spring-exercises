package sda.app.logger;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class HelloLogger implements ILogger {

  public void log() {
    System.out.println("Hello logger");
  }
}
