package com.android.sunuerico.tourguideapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
	/**
	 * Context of the app
	 */
	private Context mContext;

	public CategoryAdapter(Context context, @NonNull FragmentManager fm) {
		super(fm);

		mContext = context;
	}

	@NonNull
	@Override
	public Fragment getItem(int position) {
		switch (position) {
			case 0:
				return new HomeFragment();
			case 1:
				return new RestaurantsFragment();
			case 2:
				return new SitesFragment();
			case 3:
				return new HotelsFragment();
			case 4:
				return new MuseumsFragment();
			case 5:
				return new ParksFragment();
			default:
				return null;
		}
	}

	@Nullable
	@Override
	public CharSequence getPageTitle(int position) {
		switch (position) {
			case 0:
				return mContext.getString(R.string.about_ho);
			case 1:
				return mContext.getString(R.string.restaurant_category) + "s";
			case 2:
				return mContext.getString(R.string.site_category) + "s";
			case 3:
				return mContext.getString(R.string.hotel_category) + "s";
			case 4:
				return mContext.getString(R.string.museum_category) + "s";
			case 5:
				return mContext.getString(R.string.park_category) + "s";
			default:
				return null;
		}
	}

	@Override
	public int getCount() {
		return 6;
	}
}
