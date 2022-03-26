package com.java.api.Respositories;

import com.java.api.Entities.Moves;
import com.java.api.Services.MongoService;
import com.java.api.Subscribers.GeneralSubscriber;
import com.mongodb.client.model.Sorts;
import io.micronaut.context.annotation.Value;
import io.reactivex.rxjava3.core.Flowable;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Singleton
public class MovesRepository {

    @Value("${mongodb.database.collection.moves}")
    private String collectionMoves;

    @Inject
    private MongoService mongoService;

    public MovesRepository () {}

    public void saveMove (Moves moves) {

        Document doc = new Document("battleId", moves.getBattleId())
                .append("event", moves.getEvent())
                .append("turnCount", moves.getTurnCount())
                .append("attackingPokemon", moves.getAttackingPokemon())
                .append("defendingPokemon", moves.getDefendingPokemon())
                .append("name", moves.getName())
                .append("damageAmountDealt", moves.getDamageAmountDealt())
                .append("dateCreated", moves.getDateCreated());

        mongoService.getCollection(collectionMoves).insertOne(doc).subscribe(new GeneralSubscriber<>());

    }

    public List<Moves> getMovesByBattleId (String battleId) {
        List<Moves> moves = new ArrayList<>();

        List<Document> docs = Flowable.fromPublisher(mongoService.getCollection(collectionMoves).find(eq("battleId", battleId))
                .sort(Sorts.ascending("turnCount"))).toList().blockingGet();

        for (Document doc : docs) {
            moves.add(new Moves(
                    doc.getString("battleId"),
                    doc.getInteger("turnCount"),
                    doc.getString("attackingPokemon"),
                    doc.getString("defendingPokemon"),
                    doc.getString("name"),
                    doc.getInteger("damageAmountDealt"),
                    doc.getDate("dateCreated")
            ));
        }

        return moves;
    }

}
