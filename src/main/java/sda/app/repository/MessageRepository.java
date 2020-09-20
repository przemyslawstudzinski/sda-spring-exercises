package sda.app.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import sda.app.model.Message;

@Repository
public class MessageRepository {

  private static long id = 0;

  private List<Message> messages = new ArrayList<>();

  public void create(Message message) {
    message.setId(id++);
    message.setSendDate(LocalDateTime.now());
    messages.add(message);
  }

  public Message get(Long id) {
    final Message message = messages
        .stream().filter(x -> x.getId().equals(id)).findFirst().orElseThrow();
    return message;
  }



}
