package com.example.tienlv.log_android.screens.search;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tienlv.log_android.R;

public class SearchActivity extends FragmentActivity implements ActionBar.TabListener {

    private TabsPagerAdapter tabsPagerAdapter;
    private ViewPager viewPager;
    private ActionBar actionBar;
    private String[] tabs = {"Dish", "Location", "Album"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //init
        SearchPresenter presenter = new SearchPresenter(this);

        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        tabsPagerAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        //setting tab pages
        viewPager.setAdapter(tabsPagerAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setCustomView(R.layout.actionbar_searchview);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);



        //adding tabs
        for (String tab : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab).setTabListener(this));
        }

        //response tabs when view page change
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {
                //when page change -> actionbar change
                actionBar.setSelectedNavigationItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        Button bt = (Button)findViewById(R.id.bt_actionbar_search);
        bt.setOnClickListener(onClickSearch);

    }

    private View.OnClickListener onClickSearch = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText et = (EditText) findViewById(R.id.et_clearable);
            SearchPresenter.loadData(et.getText().toString().trim());
        }
    };

    //when tab selected -> change view page
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

}
