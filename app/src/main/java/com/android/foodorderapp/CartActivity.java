package com.android.foodorderapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.foodorderapp.adapters.PlaceYourOrderAdapter;
import com.android.foodorderapp.model.Menu;
import com.android.foodorderapp.model.RestaurantModel;

public class CartActivity extends AppCompatActivity {

    private RecyclerView cartItemsRecyclerView;
    private TextView tvSubtotalAmount;
    private TextView tvDeliveryChargeAmount;
    private TextView tvTotalAmount;
    private PlaceYourOrderAdapter placeYourOrderAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        tvSubtotalAmount = findViewById(R.id.tvSubtotalAmount);
        tvDeliveryChargeAmount = findViewById(R.id.tvDeliveryChargeAmount);

        tvTotalAmount = findViewById(R.id.tvTotalAmount);
        TextView buttonPlaceYourOrder = findViewById(R.id.buttonThanhToan);
        cartItemsRecyclerView = findViewById(R.id.hoadonView);



        RestaurantModel restaurantModel = getIntent().getParcelableExtra("RestaurantModel2");
        initRecyclerView(restaurantModel);
        calculateTotalAmount(restaurantModel);

    }

    private void calculateTotalAmount(RestaurantModel restaurantModel) {
        float subTotalAmount = 0f;

        for(Menu m : restaurantModel.getMenus()) {
            subTotalAmount += m.getPrice() * m.getTotalInCart();
        }

        tvSubtotalAmount.setText("$"+String.format("%.2f", subTotalAmount));

        tvDeliveryChargeAmount.setText("$"+String.format("%.2f", restaurantModel.getDelivery_charge()));
        subTotalAmount += restaurantModel.getDelivery_charge();

        tvTotalAmount.setText("$"+String.format("%.2f", subTotalAmount));
    }

    private void initRecyclerView(RestaurantModel restaurantModel) {
        cartItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        placeYourOrderAdapter = new PlaceYourOrderAdapter(restaurantModel.getMenus());
        cartItemsRecyclerView.setAdapter(placeYourOrderAdapter);
    }
}
