package com.java.api.Respositories;

import com.java.api.Services.MongoService;
import com.java.api.Subscribers.GeneralSubscriber;
import com.mongodb.client.result.InsertOneResult;
import io.micronaut.context.annotation.Value;
import io.reactivex.rxjava3.core.Flowable;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.bson.Document;

import java.util.Date;
import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;

@Singleton
public class BattleIdsRepository {

    @Value("${mongodb.database.collection.battleIds}")
    private String collectionBattleIds;

    @Inject
    private MongoService mongoService;

    public BattleIdsRepository() {}

    public String createUUID () {
        Boolean createNewId = true;
        UUID uuid = null;

        while (createNewId) {

            uuid = UUID.randomUUID();

            Document doc = Flowable.fromPublisher(mongoService.getCollection(collectionBattleIds).find(
                    eq("battleId", uuid.toString())
            )).firstElement().blockingGet();

            if (doc == null) {
                break;
            }

        }

        Document document = new Document("battleId", uuid.toString())
                .append("dateCreated", new Date());

        mongoService.getCollection(collectionBattleIds).insertOne(document).subscribe(new GeneralSubscriber<InsertOneResult>());

        return uuid.toString();
    }

}
