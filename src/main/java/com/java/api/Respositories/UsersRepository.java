package com.java.api.Respositories;

import com.java.api.Entities.User;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import io.micronaut.context.annotation.Value;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import jakarta.inject.Singleton;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Singleton
public class UsersRepository {

    @Value("${mongodb.database}")
    private String databaseName;

    @Value("${mongodb.collection.users}")
    private String collectionUser;

    private MongoClient client;

    public UsersRepository(MongoClient client) {
        this.client = client;
    }

    public Maybe<User> findOne (String email) {
        return Flowable.fromPublisher(getCollection().find(
            eq("email", email)
        )).firstElement();
    }

    public Single<List<User>> findAll () {
        return Flowable.fromPublisher(getCollection().find()).toList();
    }

    private MongoCollection<User> getCollection () {
        return client
                .getDatabase(databaseName)
                .getCollection(collectionUser, User.class);
    }


}
