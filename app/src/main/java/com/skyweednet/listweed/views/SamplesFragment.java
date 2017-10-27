package com.skyweednet.listweed.views;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.skyweednet.listweed.R;
import com.skyweednet.listweed.adapters.SamplesAdapter;
import com.skyweednet.listweed.models.Samples;

/**
 * A simple {@link Fragment} subclass.
 */
public class SamplesFragment extends Fragment {

    private SamplesAdapter adapter;



    public static SamplesFragment newInstance() {

        return new SamplesFragment();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_samples, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.samplesRv);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getResources()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        adapter = new SamplesAdapter();
        recyclerView.setAdapter(adapter);


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("samples");

        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<Samples, SamplesHolder>(Samples.class, android.R.layout.activity_list_item, SamplesHolder.class, reference) {
            @Override
            protected void populateViewHolder(SamplesHolder viewHolder, Samples model, int position) {
                viewHolder.setName(model.localized_name);

            }

        };

        recyclerView.setAdapter(adapter);


    }

    public static class SamplesHolder extends RecyclerView.ViewHolder {
        View mView;

        public SamplesHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setName(final String name) {
            TextView field = (TextView) mView.findViewById(android.R.id.text1);
            field.setText(name);

            field.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    DatabaseReference favorite = FirebaseDatabase.getInstance().getReference().child("favorite").child(uid);
                    favorite.child(name).setValue(name);

                }
            });

        }
    }
}
