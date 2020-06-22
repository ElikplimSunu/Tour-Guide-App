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
public class RestaurantsFragment extends Fragment {


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
		final ArrayList<Tour> restaurants = new ArrayList<Tour>();
		restaurants.add(new Tour(getString(R.string.restaurant1_name), getString(R.string.restaurant_category),
				getString(R.string.restaurant1_timeopen),
				R.drawable.kcs_image1,
				R.drawable.kcs_image2, getString(R.string.restaurant1_location),
				getString(R.string.restaurant1_contact)));

		restaurants.add(new Tour(getString(R.string.restaurant2_name), getString(R.string.restaurant_category),
				getString(R.string.restaurant2_timeopen),
				R.drawable.christain_garden_image1,
				R.drawable.christain_garden_image2, getString(R.string.restaurant2_location),
				getString(R.string.restaurant2_contact)));

		restaurants.add(new Tour(getString(R.string.restaurant3_name), getString(R.string.restaurant_category),
				getString(R.string.restaurant3_timeopen),
				R.drawable.roliz_image1,
				R.drawable.roliz_image2, getString(R.string.restaurant3_location),
				getString(R.string.restaurant3_contact)));


		mRecyclerView = rootView.findViewById(R.id.list_recyclerview);
		mRecyclerView.setHasFixedSize(true);

		mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

		mAdapter = new TourAdapter(restaurants);


		mRecyclerView.setLayoutManager(mLayoutManager);

		mRecyclerView.setAdapter(mAdapter);


		mAdapter.setOnItemClickListener(new TourAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(int position) {
				Intent intent = new Intent(getActivity(), OpenActivity.class);
				intent.putExtra("Item", restaurants.get(position));
				startActivity(intent);
			}
		});

		return rootView;
	}

}
