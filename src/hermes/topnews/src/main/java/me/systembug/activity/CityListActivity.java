package me.systembug.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import me.systembug.adapter.CityAdapter;
import me.systembug.constant.Citys;
import me.systembug.entity.CityEntity;

import me.systembug.view.HeadListView;
import me.systembug.view.topnews.R;

public class CityListActivity extends BaseActivity {
	private HeadListView mListView;
	private ArrayList<CityEntity> cityList;
	private CityAdapter mAdapter;

	Toolbar mToolbar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_city);
		initView();
		initData();
	}
	
	private void initView() {
		mListView = (HeadListView)findViewById(R.id.cityListView);
		mToolbar = (Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(mToolbar);
	}
	
	private void initData() {
		cityList = Citys.getCityList();
		mAdapter = new CityAdapter(this, cityList);
		mListView.setAdapter(mAdapter);
		mListView.setOnScrollListener(mAdapter);
		mListView.setPinnedHeaderView(LayoutInflater.from(this).inflate(R.layout.city_item_section, mListView, false));
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
//				Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
//				startActivity(intent);
				overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
			}
		});
	}
}
