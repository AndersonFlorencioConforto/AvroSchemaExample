package anderson.dev.produceravro.services;

import anderson.dev.produceravro.dtos.UserDTO;
import com.acme.avro.UserAvro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaService {

    @Value("${topic.name.producer}")
    private String value;

    private final KafkaTemplate<String, UserAvro> kafkaTemplate;

    public KafkaService(KafkaTemplate<String, UserAvro> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void producer(UserDTO userDTO) {
        UserAvro userAvro = UserAvro.newBuilder().setName(userDTO.getName())
                .setAge(userDTO.getAge())
                .setDocumentNumber(userDTO.getDocumentNumber()).build();
        kafkaTemplate.send(value, userAvro);
        log.info("{}",userAvro);
    }
}
