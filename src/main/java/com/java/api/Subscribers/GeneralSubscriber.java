package com.java.api.Subscribers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class GeneralSubscriber<T> implements Subscriber<T> {

    @Override
    public void onSubscribe(final Subscription s) {
        s.request(1);  // <--- Data requested and the insertion will now occur
    }

    @Override
    public void onNext(final T result) {
        // System.out.println("Inserted: " + result);
    }

    @Override
    public void onError(final Throwable t) {
        System.out.println("MongoDB insertion Failed");
        System.out.println(t.getMessage());
    }

    @Override
    public void onComplete() {
        //System.out.println("Completed");
    }

}
