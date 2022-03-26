package com.java.api.Respositories;

import com.java.api.Entities.Winner;
import com.java.api.Services.MongoService;
import com.java.api.Subscribers.GeneralSubscriber;
import io.micronaut.context.annotation.Value;
import io.reactivex.rxjava3.core.Flowable;
import jakarta.inject.Inject;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class WinnersRepository {

    @Value("${mongodb.database.collection.winners}")
    private String collectionWinners;

    @Inject
    private MongoService mongoService;

    public WinnersRepository() {}

    public void saveWinner(Winner winner) {

        Document doc = new Document("battleId", winner.getBattleId())
                .append("event", winner.getEvent())
                .append("turnCount", winner.getTurnCount())
                .append("winningPlayer", winner.getWinningPlayer())
                .append("winningPokemon", winner.getWinningPokemon())
                .append("dateCreated", winner.getDateCreated());

        mongoService.getCollection(collectionWinners).insertOne(doc).subscribe(new GeneralSubscriber<>());

    }

    public Winner getWinnerByBattleId (String battleId) {
        Document doc = Flowable.fromPublisher(mongoService.getCollection(collectionWinners).find(eq("battleId", battleId)))
                .firstElement().blockingGet();

        return new Winner(
                doc.getString("battleId"),
                doc.getInteger("turnCount"),
                doc.getString("winningPlayer"),
                doc.getString("winningPokemon"),
                doc.getDate("dateCreated")
        );
    }

}
