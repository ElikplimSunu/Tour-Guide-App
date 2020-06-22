package com.android.sunuerico.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OpenActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.open_activity);


		Intent intent = getIntent();
		Tour tourItem = intent.getParcelableExtra("Item");

		int imageRes1 = tourItem.getmImageResourceId1();
		int imageRes2 = tourItem.getmImageResourceId2();

		final String name = tourItem.getmName();
		String category = tourItem.getmCategory();
		String timeOpened = tourItem.getmTimeOpened();
		final String location = tourItem.getmLocation();
		final String contact = tourItem.getmContact();
		String summary = tourItem.getmSummary();

		//referencing the views to set the items
		ImageView imageView1 = findViewById(R.id.tour_image1);
		imageView1.setImageResource(imageRes1);

		ImageView imageView2 = findViewById(R.id.tour_image2);
		imageView2.setImageResource(imageRes2);


		TextView nameText = findViewById(R.id.name_text);
		nameText.setText(name);

		TextView categoryText = findViewById(R.id.category_text);
		categoryText.setText(category);

		TextView time = findViewById(R.id.time_opened_text);
		time.setText(timeOpened);

		TextView contactNumber = findViewById(R.id.contact_text);
		contactNumber.setText(contact);


		TextView summaryText = findViewById(R.id.summary_text);


		//To check if there is value stored in summary
		if (summary != null) {
			summaryText.setText(summary);
			summaryText.setVisibility(View.VISIBLE);
		} else {
			summaryText.setVisibility(View.GONE);
		}

		//Intent to open map with marked location when locationIcon is clicked
		LinearLayout locationIcon = findViewById(R.id.location_icon);
		locationIcon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Uri mapIntentUri = Uri.parse(location + name);
				Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapIntentUri);
				Intent selectMap = Intent.createChooser(mapIntent, "Launch Maps");
				if (selectMap != null) {
					startActivity(selectMap);
				}
			}
		});

		//Intent to open dialer when callIcon is clicked
		LinearLayout callIcon = findViewById(R.id.call_icon);
		callIcon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent callIntent = new Intent(Intent.ACTION_DIAL);
				callIntent.setData(Uri.parse("tel:" + contact));
				startActivity(callIntent);
			}
		});
	}


}
