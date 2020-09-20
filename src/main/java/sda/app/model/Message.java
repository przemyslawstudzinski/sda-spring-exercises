package sda.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

  private Long id;

  @JsonProperty("consignor")
  private String from;

  @JsonProperty("recipent")
  private String to;

  private String value;

  private LocalDateTime sendDate;

  @JsonIgnore
  public boolean isInFuture() {
    return sendDate.isAfter(LocalDateTime.now());
  }
}
