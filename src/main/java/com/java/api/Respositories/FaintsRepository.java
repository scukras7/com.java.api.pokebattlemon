package com.java.api.Respositories;

import com.java.api.DTOs.FaintsReq;
import com.java.api.Services.MongoService;
import com.java.api.Subscribers.GeneralSubscriber;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.bson.Document;

@Singleton
public class FaintsRepository {

    @Value("${mongodb.database.collection.faints}")
    private String collectionFaints;

    @Inject
    private MongoService mongoService;

    public FaintsRepository() {}

    public void saveFaint(FaintsReq faintsReq) {

        Document doc = new Document("battleId", faintsReq.getBattleId())
                .append("turnCount", faintsReq.getTurnCount())
                .append("pokemon", faintsReq.getPokemon())
                .append("pokemonOwner", faintsReq.getPokemonOwner())
                .append("dateCreated", faintsReq.getDateCreated());

        mongoService.getCollection(collectionFaints).insertOne(doc).subscribe(new GeneralSubscriber<>());

    }

}
