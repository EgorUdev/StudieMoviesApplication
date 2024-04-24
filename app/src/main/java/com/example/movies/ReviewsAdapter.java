package com.example.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewViewHolder> {

    private List<Review> reviews = new ArrayList<>();

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.review_item,
                parent,
                false
        );
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Review review = reviews.get(position);
        String reviewer = review.getAuthor();
        String reviewText = review.getReview();

        String reviewType = review.getType();
        int backgroundColor;
        if (Objects.equals(reviewType, "Негативный")) {
            backgroundColor = android.R.color.holo_red_dark;
        } else if (Objects.equals(reviewType, "Позитивный")) {
            backgroundColor = android.R.color.holo_green_light;
        } else {
            backgroundColor = android.R.color.holo_blue_light;
        }
        int color = ContextCompat.getColor(holder.itemView.getContext(), backgroundColor);
        holder.cardViewReview.setCardBackgroundColor(color);

        holder.textViewReviewerName.setText(reviewer);
        holder.textViewReview.setText(reviewText);
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    static class ReviewViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewReviewerName;
        private final TextView textViewReview;
        private final CardView cardViewReview;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewReviewerName = itemView.findViewById(R.id.tvReviewerName);
            textViewReview = itemView.findViewById(R.id.tvReview);
            cardViewReview = itemView.findViewById(R.id.cvReviewCard);
        }
    }
}
