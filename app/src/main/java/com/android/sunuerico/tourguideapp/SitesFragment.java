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
public class SitesFragment extends Fragment {


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
		final ArrayList<Tour> sites = new ArrayList<Tour>();
		sites.add(new Tour(getString(R.string.site1_name), getString(R.string.site_category),
				getString(R.string.site1_timeopen),
				R.drawable.tafi_image1,
				R.drawable.tafi_image2, getString(R.string.site1_location),
				getString(R.string.site1_contact), getString(R.string.site1_summary)));

		sites.add(new Tour(getString(R.string.site2_name), getString(R.string.site_category),
				getString(R.string.site2_timeopen),
				R.drawable.wli_image1,
				R.drawable.wli_image2, getString(R.string.site2_location),
				getString(R.string.site2_contact), getString(R.string.site2_summary)));

		sites.add(new Tour(getString(R.string.site3_name), getString(R.string.site_category),
				getString(R.string.site3_timeopen),
				R.drawable.afadjato_image1,
				R.drawable.afadjato_image2, getString(R.string.site3_location),
				getString(R.string.site3_contact), getString(R.string.site3_summary)));


		mRecyclerView = rootView.findViewById(R.id.list_recyclerview);
		mRecyclerView.setHasFixedSize(true);

		mLayoutManager = new LinearLayoutManager(getActivity());

		mAdapter = new TourAdapter(sites);


		mRecyclerView.setLayoutManager(mLayoutManager);

		mRecyclerView.setAdapter(mAdapter);

		mAdapter.setOnItemClickListener(new TourAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(int position) {
				Intent intent = new Intent(getActivity(), OpenActivity.class);
				intent.putExtra("Item", sites.get(position));
				startActivity(intent);
			}
		});

		return rootView;
	}

}
