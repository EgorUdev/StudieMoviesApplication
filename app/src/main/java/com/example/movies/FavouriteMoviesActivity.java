package com.example.movies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavouriteMoviesActivity extends AppCompatActivity {

    private RecyclerView fmRecyclerView;
    private FavouriteMovieViewModel favouriteMovieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_favourite_movies);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fmRecyclerView = findViewById(R.id.rvFavouriteMovies);
        MoviesAdapter moviesAdapter = new MoviesAdapter();
        fmRecyclerView.setAdapter(moviesAdapter);
        fmRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        favouriteMovieViewModel = new ViewModelProvider(this).get(
                FavouriteMovieViewModel.class
        );
        favouriteMovieViewModel.getFavouriteMovies().observe(this,
                new Observer<List<Movie>>() {
                    @Override
                    public void onChanged(List<Movie> movies) {
                        moviesAdapter.setMovies(movies);
                    }
                });

        moviesAdapter.setOnMovieClickListener(new MoviesAdapter.onMovieClickListener() {
            @Override
            public void onMovieClick(Movie movie) {
                Intent intent = MovieDetailActivity.newIntent(
                        FavouriteMoviesActivity.this,
                        movie
                );
                startActivity(intent);
            }
        });
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, FavouriteMoviesActivity.class);
    }
}