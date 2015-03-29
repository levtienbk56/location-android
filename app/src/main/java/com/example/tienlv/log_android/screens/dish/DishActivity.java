package com.example.tienlv.log_android.screens.dish;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.model.Dish;
import com.example.tienlv.log_android.screens.home.HomePresenter;

public class DishActivity extends Activity implements IDishActivity {
    private DishPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish);
        presenter = new DishPresenter(this);

        Bundle extra = getIntent().getExtras();
        int no = extra.getInt("EXTRA_DISH_ID");
        presenter.replaceDish(HomePresenter.getDishList().get(no));
        Log.d("DishActivity", "id: " + no);
    }

    public void loadView(){

    }

}
