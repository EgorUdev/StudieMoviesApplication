package com.example.movies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewResponse {

    @SerializedName("docs")
    private List<Review> reviewList;

    public ReviewResponse(List<Review> reviews) {
        this.reviewList = reviews;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    @Override
    public String toString() {
        return "ReviewResponse{" +
                "reviewList=" + reviewList +
                '}';
    }
}
