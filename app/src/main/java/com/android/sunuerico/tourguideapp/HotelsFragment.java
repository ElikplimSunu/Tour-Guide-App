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
public class HotelsFragment extends Fragment {
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
		final ArrayList<Tour> hotels = new ArrayList<Tour>();
		hotels.add(new Tour(getString(R.string.hotel1_name), getString(R.string.hotel_category),
				getString(R.string.hotel1_timeopen),
				R.drawable.freedom_hotel_image1,
				R.drawable.freedom_hotel_image2, getString(R.string.hotel1_location),
				getString(R.string.hotel1_contact)));

		hotels.add(new Tour(getString(R.string.hotel2_name), getString(R.string.hotel_category),
				getString(R.string.hotel2_timeopen),
				R.drawable.volta_serene_image1,
				R.drawable.volta_serene_image2, getString(R.string.hotel2_location),
				getString(R.string.hotel2_contact)));

		hotels.add(new Tour(getString(R.string.hotel3_name), getString(R.string.hotel_category),
				getString(R.string.hotel3_timeopen),
				R.drawable.skyplus_image1,
				R.drawable.skyplus_image2, getString(R.string.hotel3_location),
				getString(R.string.hotel3_contact)));

		//initializing RecyclerView
		mRecyclerView = rootView.findViewById(R.id.list_recyclerview);
		mRecyclerView.setHasFixedSize(true);

		mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

		mAdapter = new TourAdapter(hotels);


		mRecyclerView.setLayoutManager(mLayoutManager);

		mRecyclerView.setAdapter(mAdapter);

		mAdapter.setOnItemClickListener(new TourAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(int position) {
				Intent intent = new Intent(getActivity(), OpenActivity.class);
				intent.putExtra("Item", hotels.get(position));
				startActivity(intent);
			}
		});
		return rootView;
	}

}
