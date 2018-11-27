package demos.example.code.kafka;


import demos.example.code.kafka.provider.KafkaSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaTest {
    @Autowired
    KafkaSender kafkaSender;

    @Test
    public void sendMsg(){
        kafkaSender.send();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
