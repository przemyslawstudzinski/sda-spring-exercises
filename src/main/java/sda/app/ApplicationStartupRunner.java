package sda.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sda.app.logger.HelloLogger;
import sda.app.logger.HeyLogger;
import sda.app.logger.HiLogger;
import sda.app.logger.ILogger;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {

  @Autowired
  private ILogger logger1;
  private ILogger logger2;
  private ILogger logger3;

  public ApplicationStartupRunner(@Qualifier("heyLogger") ILogger logger3) {
    this.logger3 = logger3;
  }

  @Override
  public void run(String... args) throws Exception {
    logger1.log();
    logger2.log();
    logger3.log();
  }

  @Autowired
  public void setLogger1(ILogger logger2) {
    this.logger2 = logger2;
  }
}
