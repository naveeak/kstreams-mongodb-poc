package io.github.naveeak.kafkastreams;

import java.util.Comparator;

import org.apache.kafka.common.serialization.Serde;
import com.mongodb.MongoClient;
import static java.util.Objects.requireNonNull;

public class MongoKeyValueStoreBuilder<K, V> {
    private final String name;
    private MongoConnectionProvider connectionProvider;
    private Serde<K> keySerde;
    private Serde<V> valueSerde;
    private Comparator<K> keyComparator;
    private boolean cached;
    private byte[] keyPrefix;
    private byte[] keystoreKey;

    public MongoKeyValueStoreBuilder(String name) {
        requireNonNull(name, "name cannot be null");

        this.name = name;
        this.keyPrefix = (name + "v").getBytes();
        this.keystoreKey = (name + "k").getBytes();
    }

    public MongoKeyValueStoreSupplier<K, V> build() {
        return new MongoKeyValueStoreSupplier<>(
                name,
                connectionProvider,
                keySerde,
                valueSerde,
                keyComparator,
                keyPrefix,
                keystoreKey,
                cached);
    }

    public MongoKeyValueStoreBuilder<K, V> withClient(MongoClient mongoClient) {
        requireNonNull(mongoClient, "redisClient cannot be null");
        this.connectionProvider = MongoConnectionProvider.fromClient(mongoClient);
        return this;
    }

    public MongoKeyValueStoreBuilder<K, V> withConnection(MongoConnectionProvider connectionProvider) {
        requireNonNull(connectionProvider, "connectionProvider cannot be null");
        this.connectionProvider = connectionProvider;
        return this;
    }

    public MongoKeyValueStoreBuilder<K, V> withKeyPrefix(byte[] prefix) {
        requireNonNull(prefix, "prefix cannot be null");
        this.keyPrefix = prefix;
        return this;
    }

    public MongoKeyValueStoreBuilder<K, V> withKeys(Serde<K> serde) {
        requireNonNull(serde, "serde cannot be null");
        this.keySerde = serde;
        return this;
    }

    public MongoKeyValueStoreBuilder<K, V> withValues(Serde<V> serde) {
        requireNonNull(serde, "serde cannot be null");
        this.valueSerde = serde;
        return this;
    }

    public MongoKeyValueStoreBuilder<K, V> cached() {
        this.cached = true;
        return this;
    }

    public MongoKeyValueStoreBuilder<K, V> cached(boolean cached) {
        this.cached = cached;
        return this;
    }

    public MongoKeyValueStoreBuilder<K, V> withKeyComparator(Comparator<K> keyComparator) {
        requireNonNull(keyComparator, "keyComparator cannot be null");
        this.keyComparator = keyComparator;
        return this;
    }
}
