package com.java.api.Events;

import com.java.api.Subscribers.GeneralSubscriber;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import io.micronaut.context.annotation.Value;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Singleton;
import org.bson.Document;

@Singleton
public class Startup implements ApplicationEventListener<StartupEvent> {

    private final String INDEX_BATTLEID = "battleId";

    @Value("${mongodb.uri}")
    private String mongoUri;

    @Value("${mongodb.database.name}")
    private String databaseName;

    @Value("${mongodb.database.collection.battleIds}")
    private String collectionBattleIds;

    @Value("${mongodb.database.collection.benches}")
    private String collectionBenches;

    @Value("${mongodb.database.collection.moves}")
    private String collectionMoves;

    @Value("${mongodb.database.collection.faints}")
    private String collectionFaints;

    @Override
    public void onApplicationEvent(StartupEvent e) {
        IndexOptions uniqueIndexOption = new IndexOptions().unique(true);

        getCollection(collectionBattleIds).createIndex(Indexes.ascending(INDEX_BATTLEID), uniqueIndexOption)
                .subscribe(new GeneralSubscriber<>());

        getCollection(collectionBenches).createIndex(Indexes.ascending(INDEX_BATTLEID), uniqueIndexOption)
                .subscribe(new GeneralSubscriber<>());

        getCollection(collectionMoves).createIndex(Indexes.ascending(INDEX_BATTLEID), uniqueIndexOption)
                .subscribe(new GeneralSubscriber<>());

        getCollection(collectionFaints).createIndex(Indexes.ascending(INDEX_BATTLEID), uniqueIndexOption)
                .subscribe(new GeneralSubscriber<>());
    }

    private MongoCollection<Document> getCollection (String collection) {
        MongoClient mongoClient = MongoClients.create(mongoUri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        return database.getCollection(collection);
    }

}
