package com.java.api.Respositories;

import com.java.api.Entities.Faints;
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
public class FaintsRepository {

    @Value("${mongodb.database.collection.faints}")
    private String collectionFaints;

    @Inject
    private MongoService mongoService;

    public FaintsRepository() {}

    public void saveFaint(Faints faints) {

        Document doc = new Document("battleId", faints.getBattleId())
                .append("event", faints.getEvent())
                .append("turnCount", faints.getTurnCount())
                .append("pokemon", faints.getPokemon())
                .append("pokemonOwner", faints.getPokemonOwner())
                .append("dateCreated", faints.getDateCreated());

        mongoService.getCollection(collectionFaints).insertOne(doc).subscribe(new GeneralSubscriber<>());

    }

    public List<Faints> getFaintsByBattleId (String battleId) {
        List<Faints> faints = new ArrayList<>();

        List<Document> docs = Flowable.fromPublisher(mongoService.getCollection(collectionFaints).find(eq("battleId", battleId))
                .sort(Sorts.ascending("turnCount"))).toList().blockingGet();

        for (Document doc : docs) {
            faints.add(new Faints(
                    doc.getString("battleId"),
                    doc.getInteger("turnCount"),
                    doc.getString("pokemon"),
                    doc.getString("pokemonOwner"),
                    doc.getDate("dateCreated")
            ));
        }

        return faints;
    }

}
