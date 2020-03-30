package com.example.foodmood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class InfoFragment extends Fragment {
    public static final String name = "name";
    private Food restaurant;

    public InfoFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get the food object that contains string from argument and change activity title to restaurant name

        if(getArguments().containsKey(name)) {
            restaurant = Food.getFood(getArguments().getString(name));
            this.getActivity().setTitle(restaurant.getName());
        }
    }

    //populate restaurant fields in xml with info from food object

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.info_fragment, container, false);

        if(restaurant != null) {

            TextView name = v.findViewById(R.id.name);
            name.setText(restaurant.getName());

            TextView cuisine = v.findViewById(R.id.cuisineField);
            cuisine.setText(restaurant.getCuisine());

            TextView location = v.findViewById(R.id.locationField);
            location.setText(restaurant.getLocation());

            TextView price = v.findViewById(R.id.priceField);
            price.setText(restaurant.getPrice());

            TextView dish = v.findViewById(R.id.dishField);
            dish.setText(restaurant.getDish());

            TextView rating = v.findViewById(R.id.rating);
            rating.setText(String.valueOf(restaurant.getRating()));

            ImageView photo = v.findViewById(R.id.cardPhoto);
            photo.setImageResource(restaurant.getPhoto());

        }

        return v;
    }


}
