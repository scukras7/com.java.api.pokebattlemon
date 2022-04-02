package com.java.api.Respositories;

import com.java.api.Entities.Winner;
import com.java.api.Services.MongoService;
import com.java.api.Subscribers.GeneralSubscriber;
import io.micronaut.context.annotation.Value;
import io.reactivex.rxjava3.core.Flowable;
import jakarta.inject.Inject;
import org.bson.Document;

import java.util.concurrent.TimeUnit;

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
        // check for winner doc to be created for the given battle id when rendering front-end
        // sometimes the front-end can render before winner document has been written to the database
        final Integer MAX_NUMBER_OF_ATTEMPT_TO_RETRIEVE_DOCUMENT = 20;
        final Long DELAY_MS = 1000L;

        int attempts = 0;
        Document doc = new Document();

        while (attempts < MAX_NUMBER_OF_ATTEMPT_TO_RETRIEVE_DOCUMENT) {
            doc = Flowable.fromPublisher(mongoService.getCollection(collectionWinners).find(eq("battleId", battleId)))
                    .firstElement().blockingGet();

            if (doc != null && !doc.isEmpty()) {
                break;
            }

            attempts++;
            try {
                TimeUnit.MILLISECONDS.sleep(DELAY_MS);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }

        if (doc != null && !doc.isEmpty()) {
            return new Winner(
                    doc.getString("battleId"),
                    doc.getInteger("turnCount"),
                    doc.getString("winningPlayer"),
                    doc.getString("winningPokemon"),
                    doc.getDate("dateCreated")
            );
        } else {
            return new Winner();
        }
    }

}
