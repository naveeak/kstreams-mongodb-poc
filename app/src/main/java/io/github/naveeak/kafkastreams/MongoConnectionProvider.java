package io.github.naveeak.kafkastreams;

import com.mongodb.*;
import static java.util.Objects.requireNonNull;

public interface MongoConnectionProvider {
    MongoClient connect();

    static MongoConnectionProvider fromClient(MongoClient client) {
        requireNonNull(client, "client cannot be null");
     
        return () -> {
            ServerAddress serverAddress = new ServerAddress("http://localhost", 27017);
            return new MongoClient(serverAddress);
        };
    }

    // static MongoConnectionProvider fromClientAndNodes(MongoClient client, MongoURI... nodes) {
    //     requireNonNull(client, "client cannot be null");
    //     return () -> {
    //         StatefulRedisMasterSlaveConnection<byte[], byte[]> connection =
    //                 MasterSlave.connect(client, ByteArrayCodec.INSTANCE, Arrays.asList(nodes));
    //         connection.setReadFrom(ReadFrom.SLAVE_PREFERRED);
    //         return connection;
    //     };

    // }
}
