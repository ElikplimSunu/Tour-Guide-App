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
public class ParksFragment extends Fragment {


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
		final ArrayList<Tour> parks = new ArrayList<Tour>();
		parks.add(new Tour(getString(R.string.park_name), getString(R.string.park_category),
				getString(R.string.park_timeopen),
				R.drawable.parks_image1,
				R.drawable.parks_image2, getString(R.string.park_location),
				getString(R.string.park_contact)));


		mRecyclerView = rootView.findViewById(R.id.list_recyclerview);
		mRecyclerView.setHasFixedSize(true);

		mLayoutManager = new LinearLayoutManager(getActivity());

		mAdapter = new TourAdapter(parks);


		mRecyclerView.setLayoutManager(mLayoutManager);

		mRecyclerView.setAdapter(mAdapter);

		mAdapter.setOnItemClickListener(new TourAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(int position) {
				Intent intent = new Intent(getActivity(), OpenActivity.class);
				intent.putExtra("Item", parks.get(position));
				startActivity(intent);
			}
		});

		return rootView;
	}

}
