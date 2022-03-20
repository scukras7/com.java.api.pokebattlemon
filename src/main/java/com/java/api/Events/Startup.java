package com.java.api.Events;

import com.java.api.Services.MongoService;
import com.java.api.Subscribers.GeneralSubscriber;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import io.micronaut.context.annotation.Value;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class Startup implements ApplicationEventListener<StartupEvent> {

    private final String INDEX_BATTLEID = "battleId";
    private final String INDEX_TURN_COUNT = "turnCount";

    @Inject
    private MongoService mongoService;

    @Value("${mongodb.database.collection.battleIds}")
    private String collectionBattleIds;

    @Value("${mongodb.database.collection.benches}")
    private String collectionBenches;

    @Value("${mongodb.database.collection.moves}")
    private String collectionMoves;

    @Value("${mongodb.database.collection.faints}")
    private String collectionFaints;

    @Value("${mongodb.database.collection.winners}")
    private String collectionWinners;

    @Override
    public void onApplicationEvent(StartupEvent e) {
        IndexOptions uniqueIndexOption = new IndexOptions().unique(true);

        mongoService.createMongoClient();

        mongoService.getCollection(collectionBattleIds).createIndex(Indexes.ascending(INDEX_BATTLEID), uniqueIndexOption)
                .subscribe(new GeneralSubscriber<>());

        mongoService.getCollection(collectionBenches).createIndex(Indexes.ascending(INDEX_BATTLEID), uniqueIndexOption)
                .subscribe(new GeneralSubscriber<>());

        mongoService.getCollection(collectionMoves).createIndex(Indexes.ascending(INDEX_BATTLEID, INDEX_TURN_COUNT), uniqueIndexOption)
                .subscribe(new GeneralSubscriber<>());

        mongoService.getCollection(collectionFaints).createIndex(Indexes.ascending(INDEX_BATTLEID, INDEX_TURN_COUNT), uniqueIndexOption)
                .subscribe(new GeneralSubscriber<>());

        mongoService.getCollection(collectionWinners).createIndex(Indexes.ascending(INDEX_BATTLEID), uniqueIndexOption)
                .subscribe(new GeneralSubscriber<>());
    }

}
