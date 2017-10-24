package com.skyweednet.listweed.views;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skyweednet.listweed.R;
import com.skyweednet.listweed.adapters.SamplesAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SamplesFragment extends Fragment {

    private SamplesAdapter adapter;


    public SamplesFragment() {
        // Required empty public constructor
    }

    public static SamplesFragment newIstance() {
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
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        adapter = new SamplesAdapter();
        recyclerView.setAdapter(adapter);

    }
}
