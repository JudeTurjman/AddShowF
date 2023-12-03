package com.jude.addshowf;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class FireBaseServices {
    private static FireBaseServices instance;
    private FirebaseStorage storage;
    private FirebaseFirestore store;
    private FirebaseAuth auth;

    private FireBaseServices()
    {
        this.auth= FirebaseAuth.getInstance();
        this.store= FirebaseFirestore.getInstance();
        this.storage= FirebaseStorage.getInstance();

    }

    public static FireBaseServices getInstance()
    {
        if(instance==null) instance=new FireBaseServices();

        return instance;
    }

    public static void setInstance(FireBaseServices instance) {
        FireBaseServices.instance = instance;
    }

    public FirebaseStorage getStorage() {
        return storage;
    }

    public void setStorage(FirebaseStorage storage) {
        this.storage = storage;
    }

    public FirebaseFirestore getStore() {
        return store;
    }

    public void setStore(FirebaseFirestore store) {
        this.store = store;
    }

    public FirebaseAuth getAuth() {
        return auth;
    }

    public void setAuth(FirebaseAuth auth) {
        this.auth = auth;
    }
}
