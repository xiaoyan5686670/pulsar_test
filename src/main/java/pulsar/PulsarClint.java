package pulsar;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;

/*********************************
 @Author:xiaoyan.qin
 @Description:
 @Date:Created in 11:02 2020/10/18
 @Modified By:
 **********************************/
public class PulsarClint {
    public static void main(String[] args) throws PulsarClientException {
        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar://192.168.15.129:6650")
                .build();
        Producer<byte[]> producer = client.newProducer()
                .topic("my-topic")
                .create();

// You can then send messages to the broker and topic you specified:
        producer.send("My message".getBytes());
        producer.close();
       // consumer.close();
        client.close();
    }
}
