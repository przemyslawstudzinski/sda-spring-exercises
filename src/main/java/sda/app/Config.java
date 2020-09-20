package sda.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sda.app.logger.HeyLogger;

@Configuration
public class Config {

  @Bean
  public HeyLogger heyLoggerFromConfig() {
    return new HeyLogger();
  }
}
