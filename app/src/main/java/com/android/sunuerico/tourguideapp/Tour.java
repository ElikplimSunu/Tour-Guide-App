package com.android.sunuerico.tourguideapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Tour implements Parcelable {
	//The name of the place
	private String mName;

	//The type in the category
	private String mCategory;

	//The name of the place
	private String mTimeOpened;

	//The summary about a place
	private String mSummary = null;

	//The first image of the place
	private int mImageResourceId1;

	//The second image of the place
	private int mImageResourceId2;

	//The location of the place
	private String mLocation;

	//The call contact of the place
	private String mContact = null;


	//Constructor to populate the list item
	public Tour(String name, String category, String timeOpened, int imageResourceId1,
	            int imageResourceId2, String location, String contact) {

		mName = name;

		mCategory = category;

		mTimeOpened = timeOpened;

		mImageResourceId1 = imageResourceId1;

		mImageResourceId2 = imageResourceId2;

		mLocation = location;

		mContact = contact;

	}

	//Constructor to populate the parks item
	public Tour(String name, String category, String timeOpened, int imageResourceId1,
	            int imageResourceId2, String location,
	            String contact, String summary) {

		mName = name;

		mCategory = category;

		mTimeOpened = timeOpened;

		mImageResourceId1 = imageResourceId1;

		mImageResourceId2 = imageResourceId2;


		mLocation = location;

		mContact = contact;

		mSummary = summary;

	}


	protected Tour(Parcel in) {
		mName = in.readString();
		mCategory = in.readString();
		mTimeOpened = in.readString();
		mSummary = in.readString();
		mImageResourceId1 = in.readInt();
		mImageResourceId2 = in.readInt();
		mLocation = in.readString();
		mContact = in.readString();
	}

	public static final Creator<Tour> CREATOR = new Creator<Tour>() {
		@Override
		public Tour createFromParcel(Parcel in) {
			return new Tour(in);
		}

		@Override
		public Tour[] newArray(int size) {
			return new Tour[size];
		}
	};

	/***
	 * Get the name
	 */
	public String getmName() {
		return mName;
	}


	/***
	 * Get the category
	 */
	public String getmCategory() {
		return mCategory;
	}


	/***
	 * Get the time opened
	 */
	public String getmTimeOpened() {
		return mTimeOpened;
	}

	/***
	 * Get the first image
	 */
	public int getmImageResourceId1() {
		return mImageResourceId1;
	}


	/***
	 * Get the second image
	 */
	public int getmImageResourceId2() {
		return mImageResourceId2;
	}


	/***
	 * Get the location
	 */
	public String getmLocation() {
		return mLocation;
	}

	/***
	 * Get the contact
	 */
	public String getmContact() {
		return mContact;
	}

	/***
	 * Get the summary
	 */
	public String getmSummary() {
		return mSummary;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(mName);
		dest.writeString(mCategory);
		dest.writeString(mTimeOpened);
		dest.writeString(mSummary);
		dest.writeInt(mImageResourceId1);
		dest.writeInt(mImageResourceId2);
		dest.writeString(mLocation);
		dest.writeString(mContact);
	}
}
