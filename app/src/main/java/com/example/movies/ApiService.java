package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    String TOKEN = "HRXGJKJ-Y084JDE-H75AFT9-N4TEE3E";

    @GET("movie?field=rating.kp=8-10&sortField=votes.kp&sortType=-1&limit=30")
    @Headers("X-API-KEY:" + TOKEN)
    Single<MovieResponse> loadMovies(@Query("page") int page);

    @GET("movie/{id}")
    @Headers("X-API-KEY:" + TOKEN)
    Single<TrailerResponse> loadTrailers(@Path("id") int id);

    @GET("review?page=1&limit=10&selectFields=author&selectFields=review&selectFields=type&type=")
    @Headers("X-API-KEY:" + TOKEN)
    Single<ReviewResponse> loadReviews(@Query("movieId") int movieId);
}
