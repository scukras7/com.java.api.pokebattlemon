package com.java.api.Respositories;

import com.java.api.DTOs.WinnerReq;
import com.java.api.Services.MongoService;
import com.java.api.Subscribers.GeneralSubscriber;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Inject;
import org.bson.Document;

public class WinnersRepository {

    @Value("${mongodb.database.collection.winners}")
    private String collectionWinners;

    @Inject
    private MongoService mongoService;

    public WinnersRepository() {}

    public void saveWinner(WinnerReq winnerReq) {

        Document doc = new Document("battleId", winnerReq.getBattleId())
                .append("winningPlayer", winnerReq.getWinningPlayer())
                .append("winningPokemon", winnerReq.getWinningPokemon())
                .append("dateCreated", winnerReq.getDateCreated());

        mongoService.getCollection(collectionWinners).insertOne(doc).subscribe(new GeneralSubscriber<>());

    }
}
