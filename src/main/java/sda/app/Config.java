package sda.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import sda.app.logger.HeyLogger;

@Configuration
@ComponentScan(value = "sda.otherplace")
public class Config {

  @Bean
  public HeyLogger heyLoggerFromConfig() {
    return new HeyLogger();
  }
}
