package com.example.foodmood;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private MainActivity mainActivity;
    private ArrayList<Food> myFood;
    private boolean mTwoPane;

    //onclicklistener for recyclerview - if there there are 2 panes (tablet) then use a bundle to pass restaurant name to fragment and begin
    //if there is only 1 pane (phone) then use intent to pass restaurant name to info activity class and start activity

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Food food = (Food) v.getTag();
            if(mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putString(InfoFragment.name, food.getName());
                InfoFragment fragment = new InfoFragment();
                fragment.setArguments(arguments);
                mainActivity.getSupportFragmentManager().beginTransaction().replace(R.id.info, fragment).commit();
            } else {
                Context context = v.getContext();
                Intent intent = new Intent(context, InfoActivity.class);
                intent.putExtra(InfoFragment.name, food.getName());
                context.startActivity(intent);
            }
        }
    };

    //constructor for food adapter

    public FoodAdapter(MainActivity parent, ArrayList<Food> food, boolean twoPane) {
        mainActivity = parent;
        myFood = food;
        mTwoPane = twoPane;
    }

    //create viewholder and initialise the textviews and imageview

    public static class FoodViewHolder extends RecyclerView.ViewHolder  {
        public TextView name, cuisine, rating, location;
        public ImageView photo;

        public FoodViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.cardName);
            cuisine = v.findViewById(R.id.cardCuisine);
            rating = v.findViewById(R.id.cardRating);
            location = v.findViewById(R.id.cardLocation);
            photo = v.findViewById(R.id.cardPhoto);
        }
    }

    //create new layout from food list row xml

    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list_row, parent, false);
        return new FoodViewHolder(v);
    }

    //replace contents of view with info from food object

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        Food food = myFood.get(position);
        holder.name.setText(food.getName());
        holder.cuisine.setText(food.getCuisine());
        holder.rating.setText(String.valueOf(food.getRating()));
        holder.location.setText(food.getLocation());
        holder.photo.setImageResource(food.getPhoto());

        holder.itemView.setTag(food);
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    //return the size of arraylist
    @Override
    public int getItemCount() {
        return myFood.size();
    }

}
