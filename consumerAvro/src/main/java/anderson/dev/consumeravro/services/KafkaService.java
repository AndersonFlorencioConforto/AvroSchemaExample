package anderson.dev.consumeravro.services;

import anderson.dev.consumeravro.models.User;
import anderson.dev.consumeravro.repositories.UserRepository;
import com.acme.avro.UserAvro;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaService {

    private final UserRepository userRepository;

    public KafkaService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "${kafka.topic}",groupId = "group-1")
    public void consumer(ConsumerRecord<String, UserAvro> userAvro){
        User user = new User();
        UserAvro value = userAvro.value();
        user.setDocumentNumber(value.getDocumentNumber());
        user.setName(value.getName());
        userRepository.save(user);
        log.info("{}",user);
    }



}
