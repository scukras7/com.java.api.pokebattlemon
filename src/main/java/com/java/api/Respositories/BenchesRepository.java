package com.java.api.Respositories;

import com.java.api.Entities.Benches;
import com.java.api.Services.MongoService;
import com.java.api.Subscribers.GeneralSubscriber;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.bson.Document;

@Singleton
public class BenchesRepository {

    @Value("${mongodb.database.collection.benches}")
    private String collectionBenches;

    @Inject
    private MongoService mongoService;

    public BenchesRepository () {}

    public void saveBenches (Benches benches) {

        Document doc = new Document("battleId", benches.getBattleId())
                .append("playerBench", benches.getPlayerBench())
                .append("opponentBench", benches.getOpponentBench())
                .append("dateCreated", benches.getDateCreated());

        mongoService.getCollection(collectionBenches).insertOne(doc).subscribe(new GeneralSubscriber<>());

    }

}
