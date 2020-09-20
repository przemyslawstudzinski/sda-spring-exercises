package sda.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sda.app.logger.ILogger;
import sda.otherplace.ByeByeLogger;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {

  @Autowired
  @Qualifier(value = "helloLogger")
  private ILogger logger1;

  private ILogger logger2;

  private ILogger logger3;

  @Autowired
  private ByeByeLogger byeByeLogger;

  //@Autowired
  public ApplicationStartupRunner(@Qualifier("hiLogger") ILogger logger3) {
    this.logger3 = logger3;
  }

  @Override
  public void run(String... args) throws Exception {
    logger1.log();
    logger2.log();
    logger3.log();
    byeByeLogger.log();
  }

  @Autowired
  @Qualifier("heyLoggerFromConfig")
  public void setLogger2(ILogger logger2) {
    this.logger2 = logger2;
  }
}
