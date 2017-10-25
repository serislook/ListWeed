package com.skyweednet.listweed.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

/**
 * Created by osx on 20-10-17.
 */

public class Nodes {

    private DatabaseReference root = FirebaseDatabase.getInstance().getReference();

    public DatabaseReference samples (){
        return root.child("samples");
    }


    public Query prueba() {

        return samples().orderByValue();
    }
}
