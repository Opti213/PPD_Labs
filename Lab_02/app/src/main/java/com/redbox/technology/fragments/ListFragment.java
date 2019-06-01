package com.redbox.technology.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.redbox.technology.R;
import com.redbox.technology.TechActivity;
import com.redbox.technology.listeners.RecyclerViewTouchListener;
import com.redbox.technology.adapters.TechListAdapter;
import com.redbox.technology.models.Technology;

import java.lang.reflect.Type;
import java.util.List;

public class ListFragment extends Fragment {
    private RecyclerView recyclerView;
    private String rawList;
    private TechListAdapter techListAdapter;
    private List<Technology> technologies;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = (RecyclerView) fragmentView.findViewById(R.id.techRecyclerView);
        techListAdapter = new TechListAdapter();

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(manager);


        try {
            rawList = TechActivity.returnResponse();
            Log.d("T", "onCreateView: " + rawList.length());

            techListAdapter = new TechListAdapter(getContext(), rawList);

            Type listType = new TypeToken<List<Technology>>() {
            }.getType();
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            technologies = gson.fromJson(rawList, listType);
            technologies.remove(0);

        } catch (NullPointerException exc) {
            Log.d("Tag", "LIST FRAGMENT CAUGHT NULL: EMPTY LIST ");
        }

        techListAdapter.notifyDataSetChanged();

        recyclerView.setAdapter(techListAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getContext(), recyclerView, new RecyclerViewTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getContext(), "Launch " + technologies.get(position).getName(), Toast.LENGTH_SHORT).show();
                PagesFragment pagesFragment = new PagesFragment();

                Bundle bundle = new Bundle();
                bundle.putString("List", rawList);
                bundle.putInt("Item", position);

                pagesFragment.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.infoFragment, pagesFragment, "pager").addToBackStack(null).commit();

            }
        }));

        techListAdapter.notifyDataSetChanged();

        return fragmentView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
}
