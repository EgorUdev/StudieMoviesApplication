package com.example.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.TrailersViewHolder> {

    private List<Trailer> trailers = new ArrayList<>();

    private onTrailerClickListener onTrailerClickListener;

    public void setTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
        notifyDataSetChanged();
    }

    public void setOnTrailerClickListener(TrailersAdapter.onTrailerClickListener onTrailerClickListener) {
        this.onTrailerClickListener = onTrailerClickListener;
    }

    @NonNull
    @Override
    public TrailersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.trailer_item,
                parent,
                false
        );
        return new TrailersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailersViewHolder holder, int position) {
        Trailer trailer = trailers.get(position);
        String trailerName = trailer.getName();
        holder.tvTrailerName.setText(trailerName);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onTrailerClickListener != null) {
                    onTrailerClickListener.onTrailerClick(trailer);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }

    interface onTrailerClickListener {
       void onTrailerClick(Trailer trailer);
    }

    static class TrailersViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTrailerName;

        public TrailersViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTrailerName = itemView.findViewById(R.id.tvTrailerName);
        }
    }
}
