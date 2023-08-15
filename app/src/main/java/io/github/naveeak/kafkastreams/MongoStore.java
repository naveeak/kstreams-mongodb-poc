package io.github.naveeak.kafkastreams;

public class MongoStore {

    public static <K, V> MongoKeyValueStoreBuilder<K, V> keyValueStore(String name) {
        return new MongoKeyValueStoreBuilder<K,V>(name);
    }
    
}
