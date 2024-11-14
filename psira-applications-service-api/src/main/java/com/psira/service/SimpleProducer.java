package com.psira.service;

import com.google.gson.*;
import com.psira.pojo.AuthUser;
import com.psira.utils.LocalDateTimeAdapter;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.LocalDateTime;
import java.util.Properties;
import java.util.UUID;

public class SimpleProducer {

     Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
             .create();

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Enter topic name");
            return;
        }
        SimpleProducer producer = new SimpleProducer();
        producer.produce(new AuthUser());}

    public void produce(AuthUser user) {

        String topicName ="user-logins-topic2";


        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        // Sample data for demonstration
       /* AuthUser user = new AuthUser();
        user.setUsername("testUser");
        user.setPassword("password123");
        user.setEmail("testuser@example.com");
        user.setRole("user");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());*/

       // for (int i = 0; i < 10; i++) {
            String key = generateHexKey();
            String value = gson.toJson(user);

            producer.send(new ProducerRecord<>(topicName, key, value));
            System.out.println("Message sent successfully: Key=" + key + ", Value=" + value);
      //  }

        producer.close();
    }

    private String generateHexKey() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
