package com.android.sunuerico.tourguideapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.TourViewHolder> {
	//to contain the tourList
	private ArrayList<Tour> mTourList;

	//variable for the interface
	private OnItemClickListener mListener;

	//creating interface to handle click events on the tour list item
	public interface OnItemClickListener {
		void onItemClick(int position);

	}

	public void setOnItemClickListener(OnItemClickListener listener) {
		mListener = listener;
	}


	public static class TourViewHolder extends RecyclerView.ViewHolder {

		public TextView mName;

		public TextView mCategory;

		public ImageView mImageView1;

		public ImageView mImageView2;


		public TourViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
			super(itemView);

			//referencing the views
			mName = itemView.findViewById(R.id.name_text);

			mCategory = itemView.findViewById(R.id.category_text);

			mImageView1 = itemView.findViewById(R.id.tour_image1);

			mImageView2 = itemView.findViewById(R.id.tour_image2);

			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if (listener != null) {
						int position = getAdapterPosition();
						if (position != RecyclerView.NO_POSITION) {
							listener.onItemClick(position);
						}
					}
				}
			});


		}
	}

	public TourAdapter(ArrayList<Tour> tourList) {
		mTourList = tourList;
	}

	@NonNull
	@Override
	public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,
				parent, false);

		TourViewHolder tourViewHolder = new TourViewHolder(view, mListener);

		return tourViewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {

		Tour currentTour = mTourList.get(position);

		holder.mName.setText(currentTour.getmName());
		holder.mCategory.setText(currentTour.getmCategory());
		holder.mImageView1.setImageResource(currentTour.getmImageResourceId1());
		holder.mImageView2.setImageResource(currentTour.getmImageResourceId2());
	}

	@Override
	public int getItemCount() {
		return mTourList.size();
	}
}
