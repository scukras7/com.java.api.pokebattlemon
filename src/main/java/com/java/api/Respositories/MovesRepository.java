package com.java.api.Respositories;

import com.java.api.DTOs.MoveReq;
import com.java.api.Services.MongoService;
import com.java.api.Subscribers.GeneralSubscriber;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.bson.Document;

@Singleton
public class MovesRepository {

    @Value("${mongodb.database.collection.moves}")
    private String collectionMoves;

    @Inject
    private MongoService mongoService;

    public MovesRepository () {}

    public void saveMove (MoveReq moveReq) {

        Document doc = new Document("battleId", moveReq.getBattleId())
                .append("turnCount", moveReq.getTurnCount())
                .append("attackingPokemon", moveReq.getAttackingPokemon())
                .append("defendingPokemon", moveReq.getDefendingPokemon())
                .append("name", moveReq.getName())
                .append("damageAmountDealt", moveReq.getDamageAmountDealt())
                .append("dateCreated", moveReq.getDateCreated());

        mongoService.getCollection(collectionMoves).insertOne(doc).subscribe(new GeneralSubscriber<>());

    }

}
