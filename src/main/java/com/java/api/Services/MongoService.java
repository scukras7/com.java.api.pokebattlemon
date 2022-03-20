package com.java.api.Services;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

@Singleton
public class MongoService {

    @Value("${mongodb.uri}")
    private String mongoUri;

    @Value("${mongodb.database.name}")
    private String databaseName;

    private MongoClient client;

    public void createMongoClient () {

        if (client == null) {

            CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(
                            PojoCodecProvider.builder()
                                    .automatic(true)
                                    .build()
                    )
            );

            MongoClientSettings settings = MongoClientSettings.builder()
                    .codecRegistry(pojoCodecRegistry)
                    .applyConnectionString(new ConnectionString(mongoUri))
                    .build();

            client = MongoClients.create(settings);

        }

    }

    public void closeClientConnection () {
        client.close();
    }

    public MongoCollection<Document> getCollection (String collection) {
        MongoDatabase database = client.getDatabase(databaseName);
        return database.getCollection(collection);
    }
}
