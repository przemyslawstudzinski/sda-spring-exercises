package sda.app.model;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

  private Long id;
  private String from;
  private String to;
  private String value;
  private LocalDateTime sendDate;
}
