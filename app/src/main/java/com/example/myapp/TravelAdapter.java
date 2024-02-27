package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TravelAdapter extends RecyclerView.Adapter<TravelAdapter.ViewHolder> {

    private List<TravelDestination> travelDestinations;
    private Context context;
    private OnDestinationClickListener listener; // Listener for handling clicks

    // Constructor updated to include the listener
    public TravelAdapter(List<TravelDestination> travelDestinations, Context context, OnDestinationClickListener listener) {
        this.travelDestinations = travelDestinations;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.travelitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TravelDestination destination = travelDestinations.get(position);
        holder.titleTextView.setText(destination.getTitle());
        holder.priceTextView.setText(String.format("$%.2f", destination.getPrice()));
        holder.descriptionTextView.setText(destination.getDescription());
        holder.imageView.setImageResource(destination.getImageResource());

        // Set a click listener for the entire row
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onDestinationClicked(travelDestinations.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return travelDestinations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView, priceTextView, descriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.titleButton); // Make sure ID matches your layout
            priceTextView = itemView.findViewById(R.id.priceTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }
    }

    // Interface for click events
    public interface OnDestinationClickListener {
        void onDestinationClicked(TravelDestination destination);
    }
}
