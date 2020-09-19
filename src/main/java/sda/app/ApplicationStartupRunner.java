package sda.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sda.app.logger.HelloLogger;
import sda.app.logger.HeyLogger;
import sda.app.logger.HiLogger;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {

  @Autowired
  private HelloLogger logger1;
  private HiLogger logger2;
  private HeyLogger logger3;

  @Autowired
  public ApplicationStartupRunner(HeyLogger logger3) {
    this.logger3 = logger3;
  }

  @Override
  public void run(String... args) throws Exception {
    logger1.log();
    logger2.log();
    logger3.log();
  }

  @Autowired
  public void setLogger1(HiLogger logger2) {
    this.logger2 = logger2;
  }
}
