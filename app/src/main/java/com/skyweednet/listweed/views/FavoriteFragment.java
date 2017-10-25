package com.skyweednet.listweed.views;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.skyweednet.listweed.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {



    public static FavoriteFragment newInstance() {
        return new FavoriteFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.fragmentRv);
        recycler.addItemDecoration(new SimpleDividerItemDecoration(getResources()));
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setItemAnimator(new DefaultItemAnimator());


        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("favorite").child(uid);

        FirebaseRecyclerAdapter<String, FavHolder> adapter = new FirebaseRecyclerAdapter<String, FavHolder>(String.class, android.R.layout.simple_list_item_1, FavoriteFragment.FavHolder.class, reference) {
            @Override
            protected void populateViewHolder(FavHolder viewHolder, String model, int position) {
                viewHolder.setView(model);
            }
        };


        recycler.setAdapter(adapter);

    }


    public static class FavHolder extends RecyclerView.ViewHolder {
        View mView;

        private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        private String uid = user.getUid();
        private DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("favorite");

        public FavHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setView(final String name) {
            TextView field = (TextView) mView.findViewById(android.R.id.text1);
            field.setText(name);
            field.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reference.child(uid).child(name).removeValue();

                }
            });

        }
    }

}
