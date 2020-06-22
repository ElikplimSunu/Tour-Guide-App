package com.android.sunuerico.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MuseumsFragment extends Fragment {

	//variable to contain the RecyclerView in the xml layout
	private RecyclerView mRecyclerView;

	//provides as many items needed
	private TourAdapter mAdapter;

	//Responsible for the arrangement of the views
	private RecyclerView.LayoutManager mLayoutManager;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.list_view, container, false);


		//create the list of restaurants
		final ArrayList<Tour> museum = new ArrayList<Tour>();
		museum.add(new Tour(getString(R.string.museum_name), getString(R.string.museum_category),
				getString(R.string.museum_opentime),
				R.drawable.museum_image1,
				R.drawable.museum_image2, getString(R.string.museum_location),
				getString(R.string.museum_contact), getString(R.string.museum_summary)));


		mRecyclerView = rootView.findViewById(R.id.list_recyclerview);
		mRecyclerView.setHasFixedSize(true);

		mLayoutManager = new LinearLayoutManager(getActivity());

		mAdapter = new TourAdapter(museum);


		mRecyclerView.setLayoutManager(mLayoutManager);

		mRecyclerView.setAdapter(mAdapter);

		mAdapter.setOnItemClickListener(new TourAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(int position) {
				Intent intent = new Intent(getActivity(), OpenActivity.class);
				intent.putExtra("Item", museum.get(position));
				startActivity(intent);
			}
		});

		return rootView;
	}

}
