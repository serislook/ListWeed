package com.skyweednet.listweed.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.skyweednet.listweed.R;
import com.skyweednet.listweed.data.Nodes;
import com.skyweednet.listweed.models.Samples;

/**
 * Created by osx on 20-10-17.
 */

public class SamplesAdapter extends FirebaseRecyclerAdapter<Samples, SamplesAdapter.SamplesHolder> {


    public SamplesAdapter() {
        super(Samples.class, R.layout.list_item_samples, SamplesHolder.class,new Nodes().samples());

    }

    @Override
    protected void populateViewHolder(final SamplesHolder viewHolder, Samples model, int position) {
       viewHolder.name.setText(model.getName());


    }

    public  static class SamplesHolder extends RecyclerView.ViewHolder {

        TextView name;



        public SamplesHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.samplesRv);

        }
    }
}







