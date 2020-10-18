package pulsar.schema;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.impl.schema.AutoProduceBytesSchema;

/*********************************
 @Author:xiaoyan.qin
 @Description:
 @Date:Created in 16:36 2020/10/18
 @Modified By:
 **********************************/
public class producter {
    public static void main(String[] args) throws PulsarClientException {
        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar://192.168.15.129:6650")
                .build();
        Producer<Student> pulsarProducer = client.newProducer(Schema.JSON(Student.class)).topic("my-topic")
    .create();

        pulsarProducer.send(new Student("qxy","e"));
        pulsarProducer.close();
        // consumer.close();
        client.close();

    }
}
