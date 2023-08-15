package io.github.naveeak.kafkastreams;

import java.io.IOException;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;

public class App {

    public static void main(String[] args) throws IOException {
        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> stream = builder.stream("data");

        stream.foreach(
                (key, value) -> {
                    System.out.println("(DSL) Hello, " + value);
                });

        Properties config = new Properties();
        //get the config from the confluent cloud
        config.load(App.class.getResourceAsStream("/application.properties"));
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "test");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        // build the topology and start streaming
        KafkaStreams streams = new KafkaStreams(builder.build(), config);
        streams.start();

        // close Kafka Streams when the JVM shuts down (e.g. SIGTERM)
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }

}
