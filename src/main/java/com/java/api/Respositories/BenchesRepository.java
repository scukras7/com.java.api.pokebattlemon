package com.java.api.Respositories;

import com.java.api.DTOs.BenchesReq;
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

    public void saveBenches (BenchesReq benchesReq) {

        Document doc = new Document("battleId", benchesReq.getBattleId())
                .append("playerBench", benchesReq.getPlayerBench())
                .append("opponentBench", benchesReq.getOpponentBench())
                .append("dateCreated", benchesReq.getDateCreated());

        mongoService.getCollection(collectionBenches).insertOne(doc).subscribe(new GeneralSubscriber<>());

    }

}
